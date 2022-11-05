package com.silvia.demo.test;

import com.silvia.demo.GameItem;
import com.silvia.demo.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    Player player;

    GameItem gameItem =  new GameItem("Monster Drop", 10);

    @BeforeEach
    void setup() {
        player = new Player("TestPlayer");
        player.setExperience(95);

    }

    @Test
    @DisplayName("Calculate range of damage player can give with no weapons at level 0")
    void fightInFirstLevel() {
        assertNotNull(player);
        assertEquals(13, player.getBaseDamage() + player.getStrength() +
                player.getWeapon().getItemValue() + player.getLevel() / 4 + 1
        );

        int intelli = 2; // if true
        assertEquals(26, (player.getBaseDamage() + player.getStrength() +
                player.getWeapon().getItemValue() + player.getLevel() / 4 + 1) * intelli
        );
    }

    @Test
    @DisplayName("Adding 10 experience for first win")
    public void playerWins() {
        System.out.println(player.getExperience());

        player.playerWins(gameItem);
        assertNotNull(player);
        assertEquals(5, player.getExperience());
        assertEquals(1, player.getLevel());

        assertTrue(
                player.getExperience() < 100 &&
                        player.getExperience() >= 0,
                "Value was not between 0...100"
        );
        assertEquals(6, player.getStrength());
        assertEquals(6, player.getIntelligence());
        assertEquals(6, player.getAgility());
    }

    @Test
    @DisplayName("Adding 200 experience")
    public void levelUp2() {
        player.levelUp(200);

        System.out.println(player.getExperience());

        player.playerWins(gameItem);
        assertNotNull(player);
        assertEquals(10, player.getExperience());
        assertEquals(2, player.getLevel());

        assertTrue(
                player.getExperience() < 100 &&
                        player.getExperience() >= 0,
                "Value was not between 0...100"
        );
        assertEquals(8, player.getStrength());
        assertEquals(8, player.getIntelligence());
        assertEquals(8, player.getAgility());
    }

    @Test
    @DisplayName("Adding 500 experience")
    public void levelUp5() {
        player.levelUp(500);

        System.out.println(player.getExperience());

        player.playerWins(gameItem);
        assertNotNull(player);
        assertEquals(10, player.getExperience());
        assertEquals(5, player.getLevel());

        assertTrue(
                player.getExperience() < 100 &&
                        player.getExperience() >= 0,
                "Value was not between 0...100"
        );
        assertEquals(14, player.getStrength());
        assertEquals(14, player.getIntelligence());
        assertEquals(14, player.getAgility());
    }

    @Test
    @DisplayName("Adding 1000 experience")
    public void levelUp10() {
        player.levelUp(1000);

        System.out.println(player.getExperience());

        player.playerWins(gameItem);
        assertNotNull(player);
        assertEquals(10, player.getExperience());
        assertEquals(10, player.getLevel());

        assertTrue(
                player.getExperience() < 100 &&
                        player.getExperience() >= 0,
                "Value was not between 0...100"
        );
        assertEquals(24, player.getStrength());
        assertEquals(24, player.getIntelligence());
        assertEquals(24, player.getAgility());
    }

    @Test
    @DisplayName("Adding 10000 experience")
    public void levelUp100() {
        player.levelUp(10000);

        System.out.println(player.getExperience());

        player.playerWins(gameItem);
        assertNotNull(player);
        assertEquals(10, player.getExperience());
        assertEquals(100, player.getLevel());

        assertTrue(
                player.getExperience() < 100 &&
                        player.getExperience() >= 0,
                "Value was not between 0...100"
        );
        assertEquals(50, player.getStrength());
        assertEquals(50, player.getIntelligence());
        assertEquals(50, player.getAgility());
    }


    @Test
    @DisplayName("Adding 100 in agility")
    public void playerSetAgility100() {
        player.setAgility(100);

        assertEquals(50, player.getAgility());

        assertTrue(
                player.getAgility() < 51 &&
                        player.getAgility() >= 0,
                "Value was not between 0...50"
        );

    }

    @Test
    @DisplayName("Adding 100 in strength")
    public void playerSetStrength() {
        player.setStrength(100);

        assertEquals(50, player.getStrength());

        assertTrue(
                player.getStrength() < 51 &&
                        player.getStrength() >= 0,
                "Value was not between 0...50"
        );

    }

    @Test
    @DisplayName("Adding 100 in strength")
    public void playerSetIntelligence() {
        player.setIntelligence(100);

        assertEquals(50, player.getIntelligence());

        assertTrue(
                player.getIntelligence() < 51 &&
                        player.getIntelligence() >= 0,
                "Value was not between 0...50"
        );

    }

    @Test
    @DisplayName("Adding 100 in strength")
    public void playerDied() {
        player.died();

        assertFalse(player.died());
    }

}