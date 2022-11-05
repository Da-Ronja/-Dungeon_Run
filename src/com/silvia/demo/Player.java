package com.silvia.demo;

import java.util.Random;

public class Player extends Fighter implements IFighter {
    static Random random = new Random();
    private int gold = 0;
    private int killedMonsters = 0;

    protected Player(String fighterName) {
        super(fighterName);
        setBaseDamage(8);
        setGold(gold);
        setKilledMonsters(killedMonsters);
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getKilledMonsters() {
        return killedMonsters;
    }

    public void setKilledMonsters(int killedMonsters) {
        this.killedMonsters = killedMonsters;
    }

    @Override
    public String toString() {
        return "Player{" +
                "gold=" + gold +
                ", killedMonsters=" + killedMonsters +
                "} " + super.toString();
    }
}
