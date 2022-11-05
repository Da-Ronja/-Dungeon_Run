package com.silvia.demo;

import com.silvia.demo.display.DisplayText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Monster extends Fighter implements ICombat {
    private final List<GameItem> dropList = new ArrayList<>(
            List.of( new GameItem("Monster Drop", 0))
    );
    private final List<String> monsterNameList = Arrays.asList(      //Partial Mutable collection
            "Skeleton", "Zombie", "Dragon",
            "Mummies", "Slime blob", "Witch"
    );
    GameItem dropItem;
    public Monster() {
        setBaseDamage(6);
    }

    public GameItem monsterDropItem() {
        GameItem.generateDropList(getWeapon(), dropList);
        dropItem = GameItem.monsterDropItem(dropList);

        DisplayText.monsterDropItemText(dropItem.getItemName());


        return dropItem;
    }

    public void generateFighter(Player player) {
        int index = (int)(Math.random() * monsterNameList.size());
        setFighterName(monsterNameList.get(index));

        levelSetter(player.getLevel());
        weaponSetter(player.getLevel());

        int minStrength = player.getStrength() - 2;
        int maxStrength = player.getStrength() + 2;
        setStrength(random.nextInt(minStrength, maxStrength + 1));

        int minAgility = player.getAgility() - 2;
        int maxAgility = player.getAgility() + 2;
        setAgility(random.nextInt(minAgility, maxAgility + 1));

        int monsterHealth = healthSetter(player.getLevel());
        setHealth(monsterHealth);

        int minIntelligence = player.getIntelligence() - 2;
        int maxIntelligence = player.getIntelligence() + 1;
        setIntelligence(random.nextInt(minIntelligence, maxIntelligence + 1));

    }
    private int healthSetter(int level) {
        int minHealth;
        int maxHealth;
        int monsterHealth;

        if (level == 0) {
            minHealth = 35;
            maxHealth = 60;

        } else if (level == 1) {
            minHealth = 45;
            maxHealth = 80;

        } else {
            minHealth = 65;
            maxHealth = getMaxHealth();

        }

        monsterHealth = random.nextInt(minHealth, maxHealth + 1);

        return monsterHealth;
    }
    private void levelSetter(int level) {

        if (2 < level) {
            int minLevel = level - 1;
            int maxLevel = level + 1;

            setLevel(random.nextInt(minLevel , maxLevel));
        } else {
            setLevel(level);
        }
    }

    private void weaponSetter(int playerLevel) {

        if (2 < playerLevel) {
            int index = (int)(Math.random() * Item.weaponList.size());

            setWeapon(new GameItem(
                    Item.weaponList.get(index).getItemName(),
                    Item.weaponList.get(index).getItemValue()
            ));

        } else {
            for (Item weapon : Item.weaponList) {
                if (weapon.getItemName().equals("Hands")) {
                    setWeapon( new GameItem(weapon.getItemName(),weapon.getItemValue()));
                }
            }
        }
    }

    @Override
    public int fight() {
        int damage = getBaseDamage() + getStrength() + getWeapon().getItemValue() + getLevel() / 4 + 1;
        boolean intelli = random.nextInt(1, 101) <= getIntelligence();

        if (intelli) {
            damage = damage *2;

            DisplayText.fightDoubleText(Battle.monster, damage);

        } else {
            DisplayText.fightNoDoubleText(Battle.monster, damage);
        }

        return damage;
    }

    @Override
    public int calculateDamage(int incomingDamage, boolean block) {

        if (block) {
            DisplayText.fightDogeText(Battle.monster);
            setHealth(getHealth());
        } else {
            minHealthParam(incomingDamage);
        }

        return getHealth();
    }


    @Override
    public boolean died() {
        DisplayText.monsterDeadText(getFighterName());

        return false;
    }
}
