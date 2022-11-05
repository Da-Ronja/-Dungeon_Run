package com.silvia.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BattleTest {


    Player player;
    Monster monster = new Monster();

    @BeforeEach
    void setup() {
        Game.inGame = true;
        player = new Player("TestPlayer");
        monster.generateFighter(player);
        Game.player = player;
        Battle.monster = monster;

    }

    @RepeatedTest(100)
    @DisplayName("If player is not dead, inBattle == true, inGame == true")
    public void battlePlayerNotDead() {

        System.out.println("DEBUG playerHealth getHealth - " + Battle.playerHealth + " " + player.getHealth());
        System.out.println("DEBUG inBattle inGame- " + Battle.inBattle + " " + Game.inGame);

        Battle.battle(monster, player);

        assertTrue(Battle.playerHealth >= player.getMinHealth() && Battle.playerHealth <= player.getMaxHealth(),
                player.getMinHealth() + " is not in range " + player.getMaxHealth());

        assertEquals(Battle.inBattle, Battle.playerHealth != 0, "Is dead and left Fight");
        assertNotEquals(!Battle.inBattle, player.getHealth() != 0, "Is dead and left Fight");

        assertEquals(Game.inGame, Battle.playerHealth != 0, "Is dead and left game");
        assertNotEquals(!Game.inGame, player.getHealth() != 0, "Is dead and left game");

    }


    @RepeatedTest(100)
    @DisplayName("If player is dead, inBattle == false, inGame == false")
    public void battlePlayerDead() {

        player.setAgility(0);
        monster.setStrength(100);
        player.setHealth(30);

        Battle.battle(monster, player);

        assertEquals(0, Battle.playerHealth);
        assertEquals(Battle.inBattle, player.died());
        assertEquals(!Battle.inBattle, Battle.playerHealth == 0, "Is not dead and did not leave battle");
        assertNotEquals(Battle.inBattle, player.getHealth() == 0, "Is not dead and did not leave Battle");

        assertEquals(!Game.inGame, Battle.playerHealth == 0, "Is not dead and did not leave game");
        assertNotEquals(Game.inGame, player.getHealth() == 0, "Is not dead and did not leave game");

    }

    @RepeatedTest(100)
    @DisplayName("If monster is not dead, inBattle == true, inGame == true")
    public void battleMonsterNotDead() {

        Battle.battle(monster, player);

        assertTrue(Battle.monsterHealth >= monster.getMinHealth() && Battle.monsterHealth <= monster.getMaxHealth(),
                monster.getMinHealth() + " is not in range " + monster.getMaxHealth());
        assertEquals(!Battle.inBattle, monster.died());
        assertEquals(Battle.inBattle, Battle.monsterHealth != 0, "Is dead and left Battle");
        assertNotEquals(!Battle.inBattle, monster.getHealth() != 0, "Is dead and left Battle");

        assertEquals(Game.inGame, Battle.playerHealth != 0, "Is dead and left game");
        assertNotEquals(!Game.inGame, player.getHealth() != 0, "Is dead and left game");

    }

    @RepeatedTest(100)
    @DisplayName("If monster is dead, inBattle == false, inGame == true")
    public void battleMonsterDead() {

        monster.setAgility(0);
        player.setStrength(100);
        monster.setHealth(30);

        Battle.battle(monster, player);

        assertEquals(0, Battle.monsterHealth);
        assertEquals(Battle.inBattle, monster.died());
        assertEquals(!Battle.inBattle, Battle.monsterHealth == 0, "Is not dead and did not leave battle");
        assertNotEquals(Battle.inBattle, monster.getHealth() == 0, "Is not dead and did not leave battle");

        assertEquals(!Game.inGame, Battle.monsterHealth == 0, "Is not dead and did not leave game");
        assertNotEquals(Game.inGame, monster.getHealth() == 0, "Is not dead and did not leave game");

    }

    @RepeatedTest(100)
    @DisplayName("Calculate that the range always is in params for damage a fighter can give with no weapons at level 0")
    void fightRangeInLevel0() {
        assertTrue(player.fight() >= 13 && player.fight() <= 26);
        assertFalse(player.fight() < 13 && player.fight() > 26);

        assertTrue(monster.fight() >= 9 && monster.fight() <= 26);
        assertFalse(monster.fight() < 9 && monster.fight() > 26);

        assertEquals("Hands", player.getWeapon().getItemName());
        assertEquals("Hands", monster.getWeapon().getItemName());
    }

    int xDamage = 25;
    int maxDamage = 500;
    boolean blockTrue = true;

    @Test
    @DisplayName("Calculate of fighter with block")
    void calculateDamageTrue() {
        monster.setHealth(100);

        assertEquals(100, player.calculateDamage(xDamage, blockTrue));
        assertEquals(100, player.calculateDamage(maxDamage, blockTrue));
        assertEquals(player.calculateDamage(maxDamage, blockTrue), player.getMaxHealth(),
                " is out of range: " + player.getHealth());
        assertTrue(player.calculateDamage(maxDamage, blockTrue) >= player.getMinHealth(),
                " is out of range: " + player.getHealth());
        assertFalse(player.calculateDamage(maxDamage, blockTrue) <= player.getMinHealth(),
                " is out of range: " + player.getHealth());

        assertEquals(100, monster.calculateDamage(xDamage, blockTrue));
        assertEquals(100, monster.calculateDamage(maxDamage, blockTrue));
        assertEquals(monster.calculateDamage(maxDamage, blockTrue), monster.getMaxHealth(),
                " is out of range: " + monster.getHealth());
        assertTrue(monster.calculateDamage(maxDamage, blockTrue) >= monster.getMinHealth(),
                " is out of range: " + monster.getHealth());
        assertFalse(monster.calculateDamage(maxDamage, blockTrue) <= monster.getMinHealth(),
                " is out of range: " + monster.getHealth());
    }

    @Test
    @DisplayName("Calculate of fighter without block")
    void calculateDamageFalse() {
        monster.setHealth(100);

        assertEquals(75, player.calculateDamage(xDamage, !blockTrue));
        assertEquals(0, player.calculateDamage(maxDamage, !blockTrue));
        assertEquals(player.calculateDamage(maxDamage, !blockTrue), player.getHealth(),
                " is out of range: " + player.getHealth());
        assertTrue(player.calculateDamage(maxDamage, !blockTrue) >= player.getMinHealth(),
                " is out of range: " + player.getHealth());
        assertFalse(player.calculateDamage(maxDamage, !blockTrue) >= player.getMaxHealth(),
                " is out of range: " + player.getHealth());

        assertEquals(75, monster.calculateDamage(xDamage, !blockTrue));
        assertEquals(0, monster.calculateDamage(maxDamage, !blockTrue));
        assertEquals(monster.calculateDamage(maxDamage, !blockTrue), monster.getHealth(),
                " is out of range: " + monster.getHealth());
        assertTrue(monster.calculateDamage(maxDamage, !blockTrue) >= monster.getMinHealth(),
                " is out of range: " + player.getHealth());
        assertFalse(monster.calculateDamage(maxDamage, !blockTrue) >= monster.getMaxHealth(),
                " is out of range: " + monster.getHealth());
    }


}