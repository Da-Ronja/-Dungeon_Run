package com.silvia.demo;

import com.silvia.demo.display.DisplayText;

import java.util.ArrayList;
import java.util.List;

public class Player extends Fighter implements ICombat {
    private final List<GameItem> weaponList = new ArrayList<>( List.of(
            new GameItem(Item.weaponList.get(0).getItemName(), Item.weaponList.get(0).getItemValue(), 1)
    ));

    private final List<GameItem> potionList = new ArrayList<>();
    private int experience = 0;
    private int gold = 0;
    private int killedMonsters = 0;

    public Player(String fighterName) {
        setFighterName(fighterName);
        setExperience(experience);
        setWeapon(weaponList.get(0));
        setBaseDamage(8);
        setGold(gold);

        setKilledMonsters(killedMonsters);
    }

    public List<GameItem> getWeaponList() {
        return weaponList;
    }

    public List<GameItem> getPotionList() {
        return potionList;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getMaxExperience() {
        return 100;
    }

    public int getKilledMonsters() {
        return killedMonsters;
    }

    public void setKilledMonsters(int killedMonsters) {
        this.killedMonsters = killedMonsters;
    }

    @Override
    public int fight() {
        int damage = getBaseDamage() + getStrength() + getWeapon().getItemValue() + getLevel() / 4 + 1;
        boolean intelli = random.nextInt(1, 101) <= getIntelligence();

        if (intelli) {
            damage = damage *2;

            DisplayText.fightDoubleText(Game.player, damage);
        } else {
            DisplayText.fightNoDoubleText(Game.player, damage);
        }

        return damage;
    }

    @Override
    public int calculateDamage(int incomingDamage, boolean block) {

        if (block) {
            DisplayText.fightDogeText(Game.player);
            setHealth(getHealth());
        } else {
            minHealthParam(incomingDamage);
        }

        return getHealth();
    }

    @Override
    public boolean died() {
        DisplayText.playerDeadText();

        return false;
    }

    public static void writeDeadFile() {
        WriteFileSystem writeFileSystem = new WriteFileSystem();

        writeFileSystem.createMyFile();
        writeFileSystem.writeMyFile(Game.player.getFighterName(), Game.player.getKilledMonsters(),
                Game.player.getLevel(), Game.player.getWeaponList());
    }

    public void playerWins(GameItem dropped) {
        setKilledMonsters(getKilledMonsters() + 1);
        setExperience(getExperience() + 10);
        int gainedHealth = 10;

        gainHealthParam(gainedHealth);
        GameItem.addToInventory(dropped);

        levelUp(getExperience());

        DisplayText.playerWinText(getKilledMonsters());

    }

    public void levelUp(int experience) {

        if (experience > getMaxExperience()) {
            int totalExperience = experience / getMaxExperience(); // If experience is over maxExperience
            int remainderExperience = experience % getMaxExperience(); // Get the remainder

            for (int i = 0; i < totalExperience; i++) {
                addedLevelUp(remainderExperience);
            }

            System.out.println("You leveled up! You are on level " + getLevel() );
            System.out.println(getExperience() + " experience");
        }
    }

    public void addedLevelUp(int remainderExperience) {
        setLevel(getLevel() + 1);
        setStrength(getStrength() + 2);
        setIntelligence(getIntelligence() + 2);
        setAgility(getAgility() + 2);
        setExperience(remainderExperience);
    }

}
