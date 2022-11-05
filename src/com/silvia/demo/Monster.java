package com.silvia.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Monster extends Fighter implements IFighter {
    static Random random = new Random();
    private static final List<String> monsterNameList = Arrays.asList(      //Partial Mutable collection
            "Skeleton", "Zombie", "Dragon",
            "Mummies", "Slime blob", "Witch"
    );

    protected Monster() {
        setBaseDamage(6);
    }

    @Override
    public String toString() {
        return "Monster{} " + super.toString();
    }

    public void generateFighter(Player player) {
        int index = (int)(Math.random() * monsterNameList.size());
        setFighterName(monsterNameList.get(index));

        if (2 < player.getLevel()) {
            int minLevel = player.getLevel() - 1;
            int maxLevel = player.getLevel() + 1;

            setLevel(random.nextInt(minLevel , maxLevel));
        } else {
            setLevel(player.getLevel());
        }

        int minStrength = player.getStrength() - 2;
        int maxStrength = player.getStrength() + 2;
        setStrength(random.nextInt(minStrength, maxStrength + 1));

        int minAgility = player.getAgility() - 2;
        int maxAgility = player.getAgility() + 2;
        setAgility(random.nextInt(minAgility, maxAgility + 1));

        int minHealth = 65;
        setHealth(random.nextInt(minHealth, getMaxHealth() + 1));

        // TODO intelligence
        // TODO weaponPicker(Item.weaponList, player.getLevel());
    }


}
