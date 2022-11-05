package com.silvia.demo;

import java.util.Random;

public interface ICombat {
    int fight();
    int calculateDamage(int incomingDamage, boolean block);

    default boolean agility(Random random, int agility) {

        return random.nextInt(1, 101) <= agility;
    }

    boolean died();
}
