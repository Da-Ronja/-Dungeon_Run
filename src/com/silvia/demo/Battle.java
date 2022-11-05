package com.silvia.demo;

import com.silvia.demo.display.DisplayHeaders;
import com.silvia.demo.display.DisplayText;
import com.silvia.demo.display.PrintColor;

public class Battle {
    public static Monster monster;
    public static int playerHealth;
    public static int monsterHealth;
    public static boolean inBattle = true;
    public static int damage;

    /* ***** B A T T L E  M E N U ***** */
    protected static void battleScene(Player player) {
        inBattle = true;

        initBattleMode(player);

        do {
            Menu.displayBattleMenu();
            Menu.battleMenu();

        } while (inBattle);
    }

    private static void initBattleMode(Player player) {
        monster = new Monster();                    // initializing new monster every battle
        monster.generateFighter(player);

        GameItem.selectItem(1, Game.player.getWeaponList());

        DisplayHeaders.battleHeader();
        DisplayHeaders.monsterHeader(monster);
        DisplayText.statusBodyText(monster);

        if (player.getWeaponList().size() > 1) {
            Menu.pickForBattleDisplay(player.getWeaponList());
        } else {
            player.setWeapon(player.getWeaponList().get(0));
        }
        System.out.println("You will fight with " + player.getWeapon().getItemName());
    }

    // case 1 == inBattle
    public static void inBattle() {
        DisplayHeaders.fightHeader();

        inBattle = battle(monster, Game.player);

        DisplayHeaders.underLine();
    }

    public static boolean battle(Monster monster, Player player) {
        inBattle = true;
        GameItem dropped;

        DisplayHeaders.blankLine(PrintColor.ANSI_BRIGHT_BG_WHITE);
        monsterHealth = playersTurn(player, monster);

        if (monsterHealth == 0) {

            inBattle = monster.died();
            dropped = monster.monsterDropItem();
            player.playerWins(dropped);

            player.setWeapon(player.getWeaponList().get(0));
        } else {
            playerHealth = monstersTurn(monster, player);
        }

        if (playerHealth == player.getMinHealth()) {
            inBattle = player.died();
            Game.inGame = false;
        } else {

            DisplayText.battleUnderText(monster,player);

        }

        return inBattle;
    }

    public static int playersTurn(Player player, Monster monster) {
        damage = player.fight();
        boolean isBlocking = monster.agility(monster.random, monster.getAgility());
        monsterHealth = monster.calculateDamage(damage, isBlocking);
        DisplayHeaders.blankLine(PrintColor.ANSI_BRIGHT_BG_WHITE);

        return monsterHealth;
    }

    public static int monstersTurn(Monster monster, Player player) {
        damage = monster.fight();
        boolean isBlocking = player.agility(player.random, player.getAgility());
        playerHealth = player.calculateDamage(damage, isBlocking);

        return playerHealth;
    }

    // case 2 == Flee
    public static void fleeBattle() {
        Menu.displayYesNoMenu(Menu.getAreYouSureText());

        switch (UserInput.yesNo()) {
            case "Y" -> {
                System.out.println(
                        "You are a disappointment! By fleeing you let the monster corrupt another computer!");
                GameItem.selectItem(1, Game.player.getWeaponList());
                inBattle = false;
            }
            case "N" ->
                    System.out.println("You are brave for continuing the fight, my faithful comrade!");
            default -> System.out.println("Something went wrong!");
        }
    }

    // case 3 == Status
    public static void battleStatus() {

        do {
            DisplayHeaders.statusHeader();
            DisplayText.statusBodyBeside(Game.player, Battle.monster);
            Menu.displayStatusMenu(Menu.statusBattleMenuList);
            Menu.statusBattleMenu();

        } while (Menu.chosenStatusMenu != (Menu.exitStatusBattleMenu + 1));
    }
}
