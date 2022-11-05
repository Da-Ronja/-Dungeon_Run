package com.silvia.demo;

import java.util.Random;

public class Fighter {
    public Random random = new Random();
    private final int maxNumber = 50;
    private  String fighterName;
    private int level = 0;
    private int baseDamage;
    private int health = 100;
    private int strength = 4;
    private int agility = 4;
    private int intelligence = 4;
    private GameItem weapon;

    protected Fighter() {
        setFighterName(fighterName);
        setHealth(health);
        setLevel(level);
        setBaseDamage(baseDamage);
        setStrength(strength);
        setAgility(agility);
        setIntelligence(intelligence);
        setWeapon(weapon);
    }

    public String getFighterName() {
        return fighterName;
    }

    public void setFighterName(String fighterName) {
        this.fighterName = fighterName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        int maxBD = 15;
        baseDamage = Math.min(baseDamage, maxBD);

        if (baseDamage == maxBD) {
            System.out.println("You have max baseDamage");
        }

        this.baseDamage = baseDamage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return 100;
    }

    public int getMinHealth() {
        return 0;
    }

    public void minHealthParam(int incomingDamage) {
        int calculateHealth = getHealth() - incomingDamage;

        setHealth(Math.max(calculateHealth, getMinHealth()));        // Math to hinder health to pass 0
    }
    public void gainHealthParam(int addHealth) {
        int calculateHealth = getHealth() + addHealth;

        setHealth(Math.min(calculateHealth, getMaxHealth()));
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        strength = Math.min(strength, maxNumber);

        if (strength == maxNumber) {
            System.out.println("" +
                    "You reached max strength");
        }

        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        agility = Math.min(agility, maxNumber);

        if (agility == maxNumber) {
            System.out.println("You reached max agility");
        }

        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        intelligence = Math.min(intelligence, maxNumber);

        if (intelligence == maxNumber) {
            System.out.println("You reached max intelligence");
        }

        this.intelligence = intelligence;
    }

    public GameItem getWeapon() {
        return weapon;
    }

    public void setWeapon(GameItem weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Fighter{" +
                "fighterName='" + fighterName +
                ", health=" + health +
                ", level=" + level + '\n' +
                ", baseDamage=" + baseDamage + '\n' +
                ", strength=" + strength + '\n' +
                ", agility=" + agility + '\n' +
                ", intelligence=" + intelligence + '\n' +
                ", weapon=" + weapon + '\n' +
                '}';
    }
}
