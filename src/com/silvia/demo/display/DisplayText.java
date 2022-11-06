package com.silvia.demo.display;

import com.silvia.demo.*;

import java.util.List;
import java.util.Objects;

public class DisplayText {

    public static void introText() {
        System.out.printf("""
                        %s%s\t\t\t\tWelcome to the dungeon my faithful comrade!\t\t\t\t %s
                        %s%s    You have to be careful in the dungeon. There are monsters lurking    %s
                        %s%s  everywhere! They are possessed by the darkness and with a hunger for   %s
                        %s%s   corrupting all the code they can lay there hand on. Your mission is   %s
                        %s%s   to banish them from this realm by killing them of One by One, until   %s
                        %s%s\t\t\t there is no monsters left in this infinite loop. \t\t\t %s
                        %s%s\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t %s
                        %s%s   All that is needed is your wisdom of a keyboard, its layout and the   %s
                        %s%s\t\t\t\t\t\t\twill to carry on\t\t\t\t\t\t\t %s
                        %s%s\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t %s
                        """,
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_YELLOW, PrintColor.ANSI_RESET,
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_YELLOW, PrintColor.ANSI_RESET,
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_YELLOW, PrintColor.ANSI_RESET,
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_YELLOW, PrintColor.ANSI_RESET,
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_YELLOW, PrintColor.ANSI_RESET,
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_YELLOW, PrintColor.ANSI_RESET,
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_YELLOW, PrintColor.ANSI_RESET,
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_YELLOW, PrintColor.ANSI_RESET,
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_YELLOW, PrintColor.ANSI_RESET,
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_YELLOW, PrintColor.ANSI_RESET
        );
    }

    protected static void displayGameItemList(List<GameItem> list, boolean inStatus) {
        for (int i = 0; i < list.size(); i++) {

            if (i % 2 == 0) {
                if (Objects.equals(list.get(i).getItemName(), "Hands")) {
                    System.out.printf("%s\t   %s%s\t" + (i + 1) +
                                    ". Name: " + list.get(i).getItemName() + "\t\t\t\t\t\t\t\t\t\t\t%s\t\t %s%n",
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_PURPLE, PrintColor.ANSI_BLACK,
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
                } else {
                    displayGameItemListItemText(list.get(i),PrintColor.ANSI_BRIGHT_BG_PURPLE, i);
                }
            } else {
                displayGameItemListItemText(list.get(i),PrintColor.ANSI_BRIGHT_BG_CYAN, i);
            }
        }

        if (inStatus) {
            System.out.printf("%s%s\t   \t" + (list.size() + 1) + ". Back \t\t\t\t\t\t\t\t\t\t\t\t\t\t %s%n",
                    PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, PrintColor.ANSI_RESET);
        }

        DisplayHeaders.underLine();

    }

    private static void displayGameItemListItemText(GameItem item, String ansiBg, int i) {
        int nameLength = item.getItemName().length();

        switch (nameLength) {
            case 12, 13 -> System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                            item.getItemName() +
                            ", Strength: " + item.getItemValue(),
                    PrintColor.ANSI_BRIGHT_BG_WHITE, ansiBg, PrintColor.ANSI_BLACK);

            case 8, 9, 10, 11 -> System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                            item.getItemName() +
                            ", \tStrength: " + item.getItemValue(),
                    PrintColor.ANSI_BRIGHT_BG_WHITE, ansiBg, PrintColor.ANSI_BLACK);

            case 5, 6, 7 -> System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                            item.getItemName() +
                            ", \t\tStrength: " + item.getItemValue(),
                    PrintColor.ANSI_BRIGHT_BG_WHITE, ansiBg, PrintColor.ANSI_BLACK);


            case 1, 2, 3, 4 -> System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                            item.getItemName() +
                            ", \t\t\tStrength: " + item.getItemValue(),
                    PrintColor.ANSI_BRIGHT_BG_WHITE, ansiBg, PrintColor.ANSI_BLACK);

            default -> System.out.println("Something went wrong! The name was to long.");
        }

        System.out.printf(",\t Amount: " + item.getAmount() +
                "  \t%s\t\t %s%n", PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
    }

    public static void displayShopList(List<Shop> shopList) {
        DisplayHeaders.shopHeader();

        if (shopList == Shop.potionShopList){
            DisplayHeaders.itemHealthHeader();
        } else {
            DisplayHeaders.itemWeaponHeader();
        }

        if (Game.player.getGold() < 10) {
            System.out.printf("%s\t   %s%s\t\t\t\t\t\t\t\t\t\t\tGOLD: ",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

        } else if (Game.player.getGold() < 100000) {
            System.out.printf("%s\t   %s%s\t\t\t\t\t\t\t\t\t\tGOLD: ",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

        } else {
            System.out.printf("%s\t   %s%s\t\t\t\t\t\t\t\t\tGOLD: ",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);
        }

        System.out.printf(Game.player.getGold() + "\t\t\t%s\t\t %s%n",
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);

        for (int i = 0; i < shopList.size(); i++) {

            if (i % 2 == 0) {
                displayShopListItemText(shopList.get(i),PrintColor.ANSI_BRIGHT_BG_PURPLE, i);
            } else {
                displayShopListItemText(shopList.get(i),PrintColor.ANSI_BRIGHT_BG_CYAN, i);
            }

        }

        System.out.printf("%s%s\t   \t" + (shopList.size() + 1) + ". Back \t\t\t\t\t\t\t\t\t\t\t\t\t\t %s%n",
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, PrintColor.ANSI_RESET);

        DisplayHeaders.underLine();
    }

    private static void displayShopListItemText(Shop item, String ansiBg, int i) {
        int nameLength = item.getItemName().length();

        switch (nameLength) {
            case 12, 13 -> System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                            item.getItemName() +
                            ", Strength: " + item.getItemValue(),
                    PrintColor.ANSI_BRIGHT_BG_WHITE, ansiBg, PrintColor.ANSI_BLACK);

            case 9, 10, 11 -> System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                            item.getItemName() +
                            ", \tStrength: " + item.getItemValue(),
                    PrintColor.ANSI_BRIGHT_BG_WHITE, ansiBg, PrintColor.ANSI_BLACK);

            case 5, 6, 7, 8 -> System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                            item.getItemName() +
                            ", \t\tStrength: " + item.getItemValue(),
                    PrintColor.ANSI_BRIGHT_BG_WHITE, ansiBg, PrintColor.ANSI_BLACK);


            case 1, 2, 3, 4 -> System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                            item.getItemName() +
                            ", \t\t\tStrength: " + item.getItemValue(),
                    PrintColor.ANSI_BRIGHT_BG_WHITE, ansiBg, PrintColor.ANSI_BLACK);

            default -> System.out.println("Something went wrong! The name was to long.");
        }

        if (item.getItemPrice() > 9) {
            System.out.printf(",\t Price: " + item.getItemPrice() +
                    "  \t%s\t\t %s\n", PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else {

            System.out.printf(",\t Price: " + item.getItemPrice() +
                    "  \t\t%s\t\t %s\n", PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        }
    }

    public static void displayPlayerStatusList(List<GameItem> list, Player player) {
        DisplayHeaders.statusHeader();

        if (list == player.getPotionList()){
            DisplayHeaders.itemHealthHeader();
        } else {
            DisplayHeaders.itemWeaponHeader();
        }

        DisplayHeaders.playerHeaderBattle(Game.player);

        if (list.isEmpty()){
            System.out.println("\t   \t\t\t\t\t\t  EMPTY! \t\t\t\t\t\t\t");
        }
        DisplayText.displayGameItemList(list, true);
    }

    public static void displayPlayerPickList(List<GameItem> list) {

        DisplayHeaders.choseWeaponHeader();
        DisplayHeaders.playerHeaderBattle(Game.player);

        if (list.isEmpty()){
            System.out.println("\t\t\t\t\t\t  EMPTY! \t\t\t\t\t\t\t");
        }
        DisplayText.displayGameItemList(list, false);
    }

    public static void statusBodyBeside(Player player, Monster monster) {
        DisplayHeaders.statusHeaderBesideHealth(player, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);
        DisplayHeaders.statusHeaderBesideHealth(monster, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

        System.out.printf("%n%s%s\t" + "Level:\t\t\t\t\t\t" + player.getLevel() + "\t " +
                        "%s\t" + "Level:\t\t\t\t\t\t" + monster.getLevel() + "\t %s%n",
                PrintColor.ANSI_BG_PURPLE, PrintColor.ANSI_BLACK, PrintColor.ANSI_BRIGHT_BG_PURPLE, PrintColor.ANSI_RESET);

        System.out.printf("%s%s\t" + "Base damage:\t\t\t\t" + player.getBaseDamage() + "\t " +
                        "%s\t" + "Base damage:\t\t\t\t" + monster.getBaseDamage() + "\t %s%n",
                PrintColor.ANSI_BG_BLUE,  PrintColor.ANSI_BLACK, PrintColor.ANSI_BRIGHT_BG_BLUE, PrintColor.ANSI_RESET);

        System.out.printf("%s%s\t" + "Strength:\t\t\t\t\t" + player.getStrength() + "\t " +
                        "%s\t" + "Strength:\t\t\t\t\t" + monster.getStrength() + "\t %s%n",
                PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_BLACK, PrintColor.ANSI_BRIGHT_BG_CYAN, PrintColor.ANSI_RESET);

        System.out.printf("%s%s\t" + "Agility:\t\t\t\t\t" + player.getAgility() + "\t " +
                        "%s\t" + "Agility:\t\t\t\t\t" + monster.getAgility() + "\t %s%n",
                PrintColor.ANSI_BG_GREEN,  PrintColor.ANSI_BLACK, PrintColor.ANSI_BRIGHT_BG_GREEN, PrintColor.ANSI_RESET);

        System.out.printf("%s%s\t" + "Intelligence:\t\t\t\t" + player.getIntelligence() + "\t " +
                        "%s\t" + "Intelligence:\t\t\t\t" + monster.getIntelligence() + "\t %s%n",
                PrintColor.ANSI_BG_YELLOW, PrintColor.ANSI_BLACK, PrintColor.ANSI_BRIGHT_BG_YELLOW, PrintColor.ANSI_RESET);

        statusBodyBesideWeapon(player.getWeapon(), PrintColor.ANSI_BG_WHITE);
        statusBodyBesideWeapon(monster.getWeapon(), PrintColor.ANSI_BG_CYAN);
        System.out.printf("%n");

        statusBodyBesideWeaponStrength(player.getWeapon(), PrintColor.ANSI_BG_WHITE);
        statusBodyBesideWeaponStrength(monster.getWeapon(), PrintColor.ANSI_BG_CYAN);
        System.out.printf("%n");

    }

    private static void statusBodyBesideWeapon(GameItem Weapon, String ansiBg) {
        int nameLength = Weapon.getItemName().length();

        switch (nameLength) {
            case 16, 17, 18 -> System.out.printf("%s%s\t" + "Weapon:\t\t" + Weapon.getItemName() + "\t%s",
                    ansiBg, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);

            case 12, 13, 14, 15 -> System.out.printf("%s%s\t" + "Weapon:\t\t\t" + Weapon.getItemName() + "\t %s",
                    ansiBg, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);

            case 8, 9, 10, 11 -> System.out.printf("%s%s\t" + "Weapon:\t\t\t\t" + Weapon.getItemName() + "\t %s",
                    ansiBg, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);

            case 4, 5, 6, 7 -> System.out.printf("%s%s\t" + "Weapon:\t\t\t\t\t" + Weapon.getItemName() + "\t %s",
                    ansiBg, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);

            case 0, 1, 2, 3 -> System.out.printf("%s%s\t" + "Weapon: " + Weapon.getItemName() + "\t\t\t\t\t\t %s",
                    ansiBg, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);

            default -> System.out.println("Something went wrong! The name was to long.");
        }
    }

    private static void statusBodyBesideWeaponStrength(GameItem Weapon, String ansiBg) {

        if (!Objects.equals(Weapon.getItemName(), "Hands")) {
            System.out.printf("%s%s\t" + "Weapon Strength:\t\t\t" + Weapon.getItemValue() + "\t %s",
                    ansiBg, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
        } else {
            System.out.printf("%s%s\t\t\t\t\t\t\t\t\t %s",
                    ansiBg, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
        }
    }

    public static void statusBodyText(Fighter fighter) {

        if (fighter == Battle.monster) {
            statusSideMonsterText(Battle.monster);
        } else {
            statusSidePlayerText(Game.player);
        }

        if (fighter.getStrength() > 9 ) {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tStrength: " + fighter.getStrength() +
                            "\t\t\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_CYAN, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tStrength: " + fighter.getStrength() +
                            "\t\t\t\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_CYAN, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        }

        System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tAgility: " + fighter.getAgility() +
                        "\t\t\t\t\t\t%s\t\t %s%n",
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_GREEN, PrintColor.ANSI_BLACK,
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);

        if (fighter.getIntelligence() > 9) {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tIntelligence: " + fighter.getIntelligence() +
                            "\t\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_YELLOW, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tIntelligence: " + fighter.getIntelligence() +
                            "\t\t\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_YELLOW, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        }

        statusBodyWeaponText(fighter);

        if (!Objects.equals(fighter.getWeapon().getItemName(), "Hands")) {
            System.out.printf("%s\t  \t\t\t\t\t\t %s%s\tWeapon Strength: " + fighter.getWeapon().getItemValue() +
                            "\t\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else {
            DisplayHeaders.underLine();
        }
    }

    private static void statusBodyWeaponText(Fighter fighter) {
        int weaponNameLength = fighter.getWeapon().getItemName().length();

        switch (weaponNameLength) {
            case 16, 17, 18, 19 -> System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tWeapon: " + fighter.getWeapon().getItemName() +
                            "\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);

            case 12, 13, 14, 15 -> System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tWeapon: " + fighter.getWeapon().getItemName() +
                            "\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);

            case 8, 9, 10, 11 -> System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tWeapon: " + fighter.getWeapon().getItemName() +
                            "\t\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);

            case 4, 5, 6, 7 -> System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tWeapon: " + fighter.getWeapon().getItemName() +
                            "\t\t\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);


            case 0, 1, 2, 3 -> System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tWeapon: " + fighter.getWeapon().getItemName() +
                            "\t\t\t\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);

            default -> System.out.println("Something went wrong! The name was to long.");
        }
    }

    private static void statusSideMonsterText(Fighter fighter) {
        System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tHealth: " + fighter.getHealth() + "\t\t\t\t\t\t%s\t\t %s%n" +
                        "%s\t   \t  %sYour opponent\t\t %s%s\tBase damage: " + fighter.getBaseDamage() +
                        "\t\t\t\t\t%s\t\t %s%n",
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_PURPLE, PrintColor.ANSI_BLACK,
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET, PrintColor.ANSI_BRIGHT_BG_WHITE,
                PrintColor.ANSI_BRIGHT_RED, PrintColor.ANSI_BRIGHT_BG_BLUE, PrintColor.ANSI_BLACK,
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET
        );
    }

    private static void statusSidePlayerText(Fighter fighter) {
        System.out.printf(
                "%s\t   \t\t%s  Your kills: \t %s%s\tHealth: " + fighter.getHealth() + "\t\t\t\t\t\t%s\t\t %s%n" +
                        "%s\t   \t\t\t%s  "+ Game.player.getKilledMonsters() +
                        " \t\t %s%s\tBase damage: " + fighter.getBaseDamage() + "\t\t\t\t\t%s\t\t %s%n",
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_RED, PrintColor.ANSI_BRIGHT_BG_PURPLE,
                PrintColor.ANSI_BLACK, PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET,
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_RED, PrintColor.ANSI_BRIGHT_BG_BLUE,
                PrintColor.ANSI_BLACK, PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
    }

    public static void fightNoDoubleText(Fighter fighter, int damage) {
        int nameLength = fighter.getFighterName().length();

        System.out.printf("%s%s\t" + fighter.getFighterName() + " throws a hit of %s" + damage,
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RED);

        switch (nameLength) {
            case 19 -> System.out.printf(
                    "%s in damage!\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
            case 18 -> {
                if (damage <10) {
                    System.out.printf("%s in damage!\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
                } else {
                    System.out.printf("%s in damage!\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
                }
            }
            case 15, 16, 17 -> System.out.printf(
                    "%s in damage!\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
            case 14 -> {
                if (damage <10) {
                    System.out.printf(
                            "%s in damage!\t\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
                } else {
                    System.out.printf(
                            "%s in damage!\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
                }
            }
            case 11, 12, 13 -> System.out.printf(
                    "%s in damage!\t\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);

            case 10 -> {
                if (damage <10) {
                    System.out.printf(
                            "%s in damage!\t\t\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
                } else {
                    System.out.printf(
                            "%s in damage!\t\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
                }
            }
            case 7, 8, 9 ->  System.out.printf(
                    "%s in damage!\t\t\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
            case 6 -> {
                if (damage <10) {
                    System.out.printf(
                            "%s in damage!\t\t\t\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
                } else {
                    System.out.printf(
                            "%s in damage!\t\t\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
                }
            }
            case 3, 4, 5 -> System.out.printf(
                    "%s in damage!\t\t\t\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
            case 2 -> {
                if (damage <10) {
                    System.out.printf(
                            "%s in damage!\t\t\t\t\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
                } else {
                    System.out.printf(
                            "%s in damage!\t\t\t\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
                }
            }
            case 1 -> System.out.printf(
                    "%s in damage!\t\t\t\t\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET
            );

            default -> System.out.println("Something went wrong! The name was to long.");
        }
    }

    public static void fightDoubleText(Fighter fighter, int damage) {
        int nameLength = fighter.getFighterName().length();

        System.out.printf(
                "%s%s\t" + fighter.getFighterName() + " throw a%s double%s hit with a damage of %s",
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RED, PrintColor.ANSI_BLACK,
                PrintColor.ANSI_RED);

        switch (nameLength) {
            case 17, 18, 19 -> System.out.printf(
                    damage + "%s!\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
            case 16 -> {
                if (damage < 10) {
                    System.out.printf(
                            damage + "%s!\t\t\t\t %s\n",PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
                } else {
                    System.out.printf(
                            damage + "%s!\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
                }
            }
            case 13, 14, 15 -> System.out.printf(
                    damage + "%s!\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);

            case 12 -> {
                if (damage < 10) {
                    System.out.printf(
                            damage + "%s!\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
                } else {
                    System.out.printf(
                            damage + "%s!\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
                }
            }
            case 9, 10, 11 -> System.out.printf(
                    damage + "%s!\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
            case 8 -> {
                if (damage < 10) {
                    System.out.printf(
                            damage + "%s!\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
                }else {
                    System.out.printf(
                            damage + "%s!\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
                }
            }
            case 5, 6, 7 -> System.out.printf(
                    damage + "%s!\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);

            case 4 -> {
                if (damage < 10) {
                    System.out.printf(
                            damage + "%s!\t\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
                } else {
                    System.out.printf(
                            damage + "%s!\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);
                }
            }

            case 0, 1, 2, 3 -> System.out.printf(
                    damage + "%s!\t\t\t\t\t\t\t %s\n", PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);

            default -> System.out.println("Something went wrong! The name was to long.");
        }
    }

    public static void fightDogeText(Fighter fighter) {
        int nameLength = fighter.getFighterName().length();

        System.out.printf("%s%s\t\t" + fighter.getFighterName(),
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK);

        switch (nameLength) {
            case 16, 17, 18 -> System.out.printf(
                    "%s dodge the hit !\t\t\t\t\t\t\t\t %s\n", PrintColor.ANSI_GREEN, PrintColor.ANSI_RESET);

            case 12, 13, 14, 15 -> System.out.printf(
                    "%s dodge the hit !\t\t\t\t\t\t\t\t\t %s\n", PrintColor.ANSI_GREEN, PrintColor.ANSI_RESET);

            case 8, 9, 10, 11 -> System.out.printf(
                    "%s dodge the hit !\t\t\t\t\t\t\t\t\t\t %s\n", PrintColor.ANSI_GREEN, PrintColor.ANSI_RESET);

            case 4, 5, 6, 7 -> System.out.printf(
                    "%s dodge the hit !\t\t\t\t\t\t\t\t\t\t\t %s\n", PrintColor.ANSI_GREEN, PrintColor.ANSI_RESET);

            case 0, 1, 2, 3 -> System.out.printf(
                    "%s dodge the hit !\t\t\t\t\t\t\t\t\t\t\t\t %s\n", PrintColor.ANSI_GREEN, PrintColor.ANSI_RESET);

            default -> System.out.println("Something went wrong! The name was to long.");
        }
    }

    public static void playerDeadText() {
        DisplayHeaders.blankLine(PrintColor.ANSI_BRIGHT_BG_WHITE);

        System.out.printf("%s%s\t\t\t\t\t%s\t\tYou are dead!\t\t%s\t\t\t\t\t\t %s%n",
                PrintColor.ANSI_BRIGHT_BG_WHITE,  PrintColor.ANSI_YELLOW, PrintColor.ANSI_BG_BLACK,
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);

        DisplayHeaders.blankLine(PrintColor.ANSI_BRIGHT_BG_WHITE);
    }

    public static void monsterDeadText(String monsterName) {
        int nameLength = monsterName.length();

        switch (nameLength) {
            case 19 -> System.out.printf("%s%s\t\t\t\t\t  " + monsterName + " is dead!  \t\t\t\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RED, PrintColor.ANSI_RESET);

            case 15, 16, 17, 18 -> System.out.printf("%s%s\t\t\t\t\t\t" + monsterName + " is dead!\t\t\t\t\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RED, PrintColor.ANSI_RESET);

            case 11 ,12, 13, 14 -> System.out.printf("%s%s\t\t\t\t\t\t" + monsterName + " is dead!\t\t\t\t\t\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RED, PrintColor.ANSI_RESET);

            case 7, 8, 9, 10 -> System.out.printf("%s%s\t\t\t\t\t\t\t" + monsterName + " is dead!\t\t\t\t\t\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RED, PrintColor.ANSI_RESET);


            case 3, 4, 5, 6 -> System.out.printf("%s%s\t\t\t\t\t\t\t" + monsterName + " is dead!\t\t\t\t\t\t\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RED, PrintColor.ANSI_RESET);

            case 0, 1, 2 -> System.out.printf("%s%s\t\t\t\t\t\t\t  " + monsterName + " is dead!  \t\t\t\t\t\t\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RED, PrintColor.ANSI_RESET);

            default -> System.out.println("Something went wrong! The name was to long.");
        }
    }

    public static void monsterDropItemText(String itemName) {
        int nameLength = itemName.length();

        switch (nameLength) {
            case 16, 17, 18, 19 -> System.out.printf("%s%s\t\t\tBeside the dead body lies a " + itemName + "\t\t\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RED, PrintColor.ANSI_RESET);

            case 12, 13, 14, 15 -> System.out.printf("%s%s\t\t\t\tBeside the dead body lies a " + itemName + "\t\t\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RED, PrintColor.ANSI_RESET);

            case 8, 9, 10, 11 -> System.out.printf("%s%s\t\t\t\tBeside the dead body lies a " + itemName + "\t\t\t\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RED, PrintColor.ANSI_RESET);

            case 4, 5, 6, 7 ->  System.out.printf("%s%s\t\t\t\t\tBeside the dead body lies a " + itemName + "\t\t\t\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RED, PrintColor.ANSI_RESET);

            case 0, 1, 2, 3 -> System.out.printf("%s%s\t\t\t\t\tBeside the dead body lies a " + itemName + "\t\t\t\t\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RED, PrintColor.ANSI_RESET);

            default -> System.out.println("Something went wrong! The name was to long.");
        }
    }

    public static void playerWinText(int killedMonsters) {

        if (killedMonsters > 9) {
            System.out.printf("%s%s\t\t\t\t\tYou have killed " + killedMonsters + " monsters!\t\t\t\t\t\t %s%n" +
                            "%s%s\t\t\t\t\t  And gained 10 in health!  \t\t\t\t\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET            );
        } else {
            System.out.printf("%s%s\t\t\t\t\t  You have killed " + killedMonsters + " monsters!  \t\t\t\t\t\t %s%n" +
                            "%s%s\t\t\t\t\t    And gained 10 in health!\t\t\t\t\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET            );
        }
    }

    public static void battleUnderText(Monster monster, Player player) {
        DisplayHeaders.blankLine(PrintColor.ANSI_BRIGHT_BG_WHITE);
        DisplayHeaders.statusHeaderBesideHealth(player, PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK);
        DisplayHeaders.statusHeaderBesideHealth(monster, PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK);
        System.out.printf("%n");
    }

    public static void deadPlayerText(Player player) {
        System.out.printf("%s%s\t\tBefore you died in the wonders of the Dungeon you killed %s" +
                        player.getKilledMonsters() + "\t\t %s\n" +
                        "%s%s\t\tand reached level %s" + player.getLevel() + "\t\t\t\t\t\t\t\t\t\t\t\t %s\n",
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RED, PrintColor.ANSI_RESET,
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RED, PrintColor.ANSI_RESET);
    }

}
