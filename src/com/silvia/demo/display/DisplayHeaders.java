package com.silvia.demo.display;

import com.silvia.demo.Fighter;
import com.silvia.demo.Game;
import com.silvia.demo.Player;

import java.util.Objects;

public class DisplayHeaders {

    public static void gameHeader() {
        System.out.printf("%s\t\t\t\t\t\t\t\t  G A M E  \t\t\t\t\t\t\t\t %s%n",
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_RESET);

        DisplayHeaders.underLine();
    }

    public static void battleHeader() {
        System.out.printf("%s\t\t\t\t\t\t\t\tB A T T L E\t\t\t\t\t\t\t\t %s%n",
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_RESET);

        DisplayHeaders.underLine();
    }

    public static void fightHeader() {
        System.out.printf("%s\t\t\t\t\t\t\t\t F I G H T \t\t\t\t\t\t\t\t %s%n",
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_RESET);

        DisplayHeaders.underLine();
    }

    public static void statusHeader() {
        System.out.printf("%s\t\t\t\t\t\t  S T A T U S  M E N U   \t\t\t\t\t\t %s%n",
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_RESET);

        DisplayHeaders.underLine();
    }

    public static void shopHeader() {
        System.out.printf("%s\t\t\t\t\t\t\t\t  S H O P  \t\t\t\t\t\t\t\t %s%n",
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_RESET);

        DisplayHeaders.underLine();
    }

    public static void itemWeaponHeader() {

        System.out.printf("%s\t   %s%s\t\t\t\t\t\t\tWEAPONS \t\t\t\t\t\t%s\t\t %s%n",
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET
        );
    }

    public static void itemHealthHeader() {

        System.out.printf("%s\t   %s%s\t\t\t\t\t\t\tHEALING \t\t\t\t\t\t%s\t\t %s%n",
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET
        );
    }

    public static void choseWeaponHeader() {

        System.out.printf("%s\t   %s%s\t\t\t\t\t\tCHOSE A WEAPON \t\t\t\t\t\t%s\t\t %s%n",
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET
        );
    }

    public static void monsterHeader(Fighter fighter) {
        int nameLength = fighter.getFighterName().length();

        switch (nameLength) {
            case 16, 17, 18, 19 -> System.out.printf("%s\t   \t\t\t\t\t\t %s%s\t" + fighter.getFighterName() + "\t",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

            case 12, 13, 14, 15 -> System.out.printf("%s\t   \t\t\t\t\t\t %s%s\t" + fighter.getFighterName() + "\t\t",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

            case 8, 9, 10, 11 -> System.out.printf("%s\t   \t\t\t\t\t\t %s%s\t" + fighter.getFighterName() + "\t\t\t",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

            case 4, 5, 6, 7 -> System.out.printf("%s\t   \t\t\t\t\t\t %s%s\t" + fighter.getFighterName() + "\t\t\t\t",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

            case 0, 1, 2, 3 -> System.out.printf("%s\t   \t\t\t\t\t\t %s%s\t" + fighter.getFighterName() + "\t\t\t\t\t",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

            default -> System.out.println("Something went wrong! The name was to long.");
        }

        System.out.printf("Level: " + fighter.getLevel() +
                        "\t%s\t\t %s%n", PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);

    }

    public static void playerHeaderStartStatus(Fighter fighter) {
        int nameLength = fighter.getFighterName().length();

        switch (nameLength) {
            case 16, 17, 18, 19 -> System.out.printf("%s\t\t   %s%s\t" + fighter.getFighterName() + "\t",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

            case 12, 13, 14, 15 -> System.out.printf("%s\t\t   %s%s\t" + fighter.getFighterName() + "\t\t",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

            case 8, 9, 10, 11 -> System.out.printf("%s\t\t   %s%s\t" + fighter.getFighterName() + "\t\t\t",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

            case 4, 5, 6, 7 -> System.out.printf("%s\t\t   %s%s\t" + fighter.getFighterName() + "\t\t\t\t",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

            case 0, 1, 2, 3 -> System.out.printf("%s\t\t   %s%s\t" + fighter.getFighterName() + "\t\t\t\t\t",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

            default -> System.out.println("Something went wrong!");
        }

        System.out.printf("Experience: " + Game.player.getExperience() +
                        "\tLevel: " + fighter.getLevel() + "\t\t%s\t\t %s%n",
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
    }

    public static void statusHeaderBesideHealth(Fighter fighter, String ansiBg, String ansiText) {
        int nameLength = fighter.getFighterName().length();

        switch (nameLength) {
            case 16, 17, 18, 19 -> System.out.printf("%s%s\t" + fighter.getFighterName() + "\t",
                    ansiBg, ansiText);

            case 12, 13, 14, 15 -> System.out.printf("%s%s\t" + fighter.getFighterName() + "\t\t",
                    ansiBg, ansiText);

            case 8, 9, 10, 11 -> System.out.printf("%s%s\t" + fighter.getFighterName() + "\t\t\t",
                    ansiBg, ansiText);

            case 4, 5, 6, 7 -> System.out.printf("%s%s\t" + fighter.getFighterName() + "\t\t\t\t",
                    ansiBg, ansiText);

            case 0, 1, 2, 3 -> System.out.printf("%s%s\t" + fighter.getFighterName() + "\t\t\t\t\t",
                    ansiBg, ansiText);

            default -> System.out.println("Something went wrong! The name was to long.");
        }

        if (Objects.equals(ansiBg, PrintColor.ANSI_BRIGHT_BG_WHITE)){
            System.out.printf("%sHealth: " + fighter.getHealth() +
                    "\t %s", PrintColor.ANSI_RED, PrintColor.ANSI_RESET);
        } else {
            System.out.printf("Health: " + fighter.getHealth() +
                    "\t %s", PrintColor.ANSI_RESET);
        }

    }

    public static void playerHeaderBattle(Player player) {
        int nameLength = player.getFighterName().length();

        switch (nameLength) {
            case 16, 17, 18, 19 -> System.out.printf("%s\t   %s%s\t" + player.getFighterName() + "\t\t",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

            case 12, 13, 14, 15 -> System.out.printf("%s\t   %s%s\t" + player.getFighterName() + "\t\t\t",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

            case 8, 9, 10, 11 -> System.out.printf("%s\t   %s%s\t" + player.getFighterName() + "\t\t\t\t",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

            case 4, 5, 6, 7 -> System.out.printf("%s\t   %s%s\t" + player.getFighterName() + "\t\t\t\t\t",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

            case 0, 1, 2, 3 -> System.out.printf("%s\t   %s%s\t" + player.getFighterName() + "\t\t\t\t\t\t",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

            default -> System.out.println("Something went wrong! The name was to long.");
        }

        System.out.printf("Level: " + player.getLevel() +
                        "\t\tHealth: " + player.getHealth() + "\t\t%s\t\t %s%n",
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
    }

    public static void underLine() {
        System.out.printf("%s=========================================================================%s\n",
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_RESET);
    }

    public static void blankLine(String ansiBg) {
        System.out.printf("%s\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t %s%n",
                ansiBg, PrintColor.ANSI_RESET);
    }


}
