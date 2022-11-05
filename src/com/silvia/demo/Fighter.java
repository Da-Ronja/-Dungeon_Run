package com.silvia.demo;

public class Fighter {
    private String fighterName  = " ";
    private int level = 0;
    private int experience = 0;
    private int baseDamage;
    private int health = 100;
    private int strength = 4;
    private int agility = 4;
    private int intelligence = 4;
    private Weapon weapon;

    protected Fighter(String fighterName) {
        setFighterName(this.fighterName);
        setLevel(level);
        setExperience(experience);
        setBaseDamage(baseDamage);
        setHealth(health);
        setStrength(strength);
        setAgility(agility);
        setIntelligence(intelligence);
        setWeapon(weapon);
    }

    protected Fighter() {
        setFighterName(fighterName);
        setLevel(level);
        setExperience(experience);
        setBaseDamage(baseDamage);
        setHealth(health);
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getMaxExperience() {
        return 100;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
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

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Fighter{" +
                "fighterName='" + fighterName + '\'' +
                ", level=" + level +
                ", experience=" + experience +
                ", baseDamage=" + baseDamage +
                ", health=" + health +
                ", strength=" + strength +
                ", agility=" + agility +
                ", intelligence=" + intelligence +
                ", weapon=" + weapon +
                '}';
    }
}
