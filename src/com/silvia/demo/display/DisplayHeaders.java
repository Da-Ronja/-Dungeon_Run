package com.silvia.demo;

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

        if (nameLength > 15) {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\t" + fighter.getFighterName() +
                            "\tLevel: " + fighter.getLevel() +
                            "\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else if (nameLength > 11) {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\t" + fighter.getFighterName() +
                            "\t\tLevel: " + fighter.getLevel() +
                            "\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else if (nameLength > 7) {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\t" + fighter.getFighterName() +
                            "\t\t\tLevel: " + fighter.getLevel() +
                            "\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else if (nameLength > 3) {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\t" + fighter.getFighterName() +
                            "\t\t\t\tLevel: " + fighter.getLevel() +
                            "\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\t" + fighter.getFighterName() +
                            "\t\t\t\t\tLevel: " + fighter.getLevel() +
                            "\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        }
    }
    public static void playerHeaderStartStatus(Fighter fighter) {
        int nameLength = fighter.getFighterName().length();

        if (nameLength > 15) {
            System.out.printf("%s\t\t   %s%s\t" + fighter.getFighterName() +
                            "\tExperience: " + Game.player.getExperience() +
                            "\tLevel: " + fighter.getLevel() +
                            "\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else if (nameLength > 11) {
            System.out.printf("%s\t\t   %s%s\t" + fighter.getFighterName() +
                            "\t\tExperience: " + Game.player.getExperience() +
                            "\tLevel: " + fighter.getLevel() +
                            "\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else if (nameLength > 7) {
            System.out.printf("%s\t\t   %s%s\t" + fighter.getFighterName() +
                            "\t\t\tExperience: " + Game.player.getExperience() +
                            "\tLevel: " + fighter.getLevel() +
                            "\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else if (nameLength > 3) {
            System.out.printf("%s\t\t   %s%s\t" + fighter.getFighterName() +
                            "\t\t\t\tExperience: " + Game.player.getExperience() +
                            "\tLevel: " + fighter.getLevel() +
                            "\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else {
            System.out.printf("%s\t\t   %s%s\t" + fighter.getFighterName() +
                            "\t\t\t\t\tExperience: " + Game.player.getExperience() +
                            "\tLevel: " + fighter.getLevel() +
                            "\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        }
    }

    public static void statusHeaderBeside(Fighter player, Fighter monster) {
        int playerLength = player.getFighterName().length();
        int monsterLength = monster.getFighterName().length();



        if (playerLength > 15) {
            System.out.printf("%s%s\t" + player.getFighterName() +
                            "\tHealth: " + player.getHealth() +
                            "\t %s",
                    PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, PrintColor.ANSI_RESET);
        } else if (playerLength > 11) {
            System.out.printf("%s%s\t" + player.getFighterName() +
                            "\t\tHealth: " + player.getHealth() +
                            "\t %s",
                    PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, PrintColor.ANSI_RESET);
        } else if (playerLength > 7) {
            System.out.printf("%s%s\t" + player.getFighterName() +
                            "\t\t\tHealth: " + player.getHealth() +
                            "\t %s",
                    PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, PrintColor.ANSI_RESET);
        } else if (playerLength > 3) {
            System.out.printf("%s%s\t" + player.getFighterName() +
                            "\t\t\t\tHealth: " + player.getHealth() +
                            "\t %s",
                    PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, PrintColor.ANSI_RESET);
        } else {
            System.out.printf("%s%s\t" + player.getFighterName() +
                            "\t\t\t\t\tHealth: " + player.getHealth() +
                            "\t %s",
                    PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, PrintColor.ANSI_RESET);
        }

        if (monsterLength > 15) {
            System.out.printf("%s%s\t" + monster.getFighterName() +
                            "\tHealth: " + monster.getHealth() +
                            "\t %s%n",
                    PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, PrintColor.ANSI_RESET);
        } else if (monsterLength > 11) {
            System.out.printf("%s%s\t" + monster.getFighterName() +
                            "\t\tHealth: " + monster.getHealth() +
                            "\t %s%n",
                    PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, PrintColor.ANSI_RESET);
        } else if (monsterLength > 7) {
            System.out.printf("%s%s\t" + monster.getFighterName() +
                            "\t\t\tHealth: " + monster.getHealth() +
                            "\t %s%n",
                    PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, PrintColor.ANSI_RESET);
        } else if (monsterLength > 3) {
            System.out.printf("%s%s\t" + monster.getFighterName() +
                            "\t\t\t\tHealth: " + monster.getHealth() +
                            "\t %s%n",
                    PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, PrintColor.ANSI_RESET);
        } else {
            System.out.printf("%s%s\t" + monster.getFighterName() +
                            "\t\t\t\t\tHealth: " + monster.getHealth() +
                            "\t %s%n",
                    PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, PrintColor.ANSI_RESET);
        }
    }

    public static void playerHeaderBattle(Player player) {
        int nameLength = player.getFighterName().length();

        if (nameLength > 15) {
            System.out.printf("%s\t   %s%s\t" + player.getFighterName() + "\t\tLevel: " + player.getLevel() +
                            "\t\tHealth: " + player.getHealth() + "\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else if (nameLength > 11) {
            System.out.printf("%s\t   %s%s\t" + player.getFighterName() + "\t\t\tLevel: " + player.getLevel() +
                            "\t\tHealth: " + player.getHealth() + "\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else if (nameLength > 7) {
            System.out.printf("%s\t   %s%s\t" + player.getFighterName() + "\t\t\t\tLevel: " + player.getLevel() +
                            "\t\tHealth: " + player.getHealth() + "\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else if (nameLength > 3) {
            System.out.printf("%s\t   %s%s\t" + player.getFighterName() + "\t\t\t\t\tLevel: " + player.getLevel() +
                            "\t\tHealth: " + player.getHealth() + "\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else {
            System.out.printf("%s\t   %s%s\t" + player.getFighterName() + "\t\t\t\t\t\tLevel: " + player.getLevel() +
                            "\t\tHealth: " + player.getHealth() + "\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        }
    }

    public static void underLine() {
        System.out.printf("%s=========================================================================%s\n", PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_RESET);
    }


}
