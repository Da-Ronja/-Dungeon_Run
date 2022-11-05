package com.silvia.demo.display;

import com.silvia.demo.GameItem;

public class SwitchCaseDisplay {

    public static void fightDogeText(String fighter, int damage) {
        int nameLength = fighter.length();

        switch (nameLength) {
            case 19 -> System.out.printf("%s%s\t" + fighter + " throws a hit of " + damage +
                            " in damage!\t\t\t\t\t %s\n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET
            );
            case 18 -> {
                if (damage <10) {
                    System.out.printf("%s%s\t" + fighter + " throws a hit of " + damage +
                                    " in damage!\t\t\t\t\t\t %s\n",
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET
                    );
                } else {
                    System.out.printf("%s%s\t" + fighter + " throws a hit of " + damage +
                                    " in damage!\t\t\t\t\t %s\n",
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET
                    );
                }
            }

            case 15, 16, 17 -> System.out.printf("%s%s\t" + fighter + " throws a hit of " + damage +
                            " in damage!\t\t\t\t\t\t %s\n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET
            );

            case 14 -> {
                if (damage <10) {
                    System.out.printf("%s%s\t" + fighter + " throws a hit of " + damage +
                                    " in damage!\t\t\t\t\t\t\t %s\n",
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET
                    );
                } else {
                    System.out.printf("%s%s\t" + fighter + " throws a hit of " + damage +
                                    " in damage!\t\t\t\t\t\t %s\n",
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET
                    );
                }
            }

            case 11, 12, 13 -> System.out.printf("%s%s\t" + fighter + " throws a hit of " + damage +
                            " in damage!\t\t\t\t\t\t\t %s\n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET
            );

            case 10 -> {
                if (damage <10) {
                    System.out.printf("%s%s\t" + fighter + " throws a hit of " + damage +
                                    " in damage!\t\t\t\t\t\t\t\t %s\n",
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET
                    );
                } else {
                    System.out.printf("%s%s\t" + fighter + " throws a hit of " + damage +
                                    " in damage!\t\t\t\t\t\t\t %s\n",
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET
                    );
                }
            }
            case 7, 8, 9 ->  System.out.printf("%s%s\t" + fighter + " throws a hit of " + damage +
                            " in damage!\t\t\t\t\t\t\t\t %s\n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET
            );
            case 6 -> {
                if (damage <10) {
                    System.out.printf("%s%s\t" + fighter + " throws a hit of " + damage +
                                    " in damage!\t\t\t\t\t\t\t\t\t %s\n",
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET
                    );
                } else {
                    System.out.printf("%s%s\t" + fighter + " throws a hit of " + damage +
                                    " in damage!\t\t\t\t\t\t\t\t %s\n",
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET
                    );
                }
            }
            case 3, 4, 5 -> System.out.printf("%s%s\t" + fighter + " throws a hit of " + damage +
                            " in damage!\t\t\t\t\t\t\t\t\t %s\n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET
            );
            case 2 -> {
                if (damage <10) {
                    System.out.printf("%s%s\t" + fighter + " throws a hit of " + damage +
                                    " in damage!\t\t\t\t\t\t\t\t\t\t %s\n",
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET
                    );
                } else {
                    System.out.printf("%s%s\t" + fighter + " throws a hit of " + damage +
                                    " in damage!\t\t\t\t\t\t\t\t\t %s\n",
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET
                    );
                }
            }
            case 1 -> System.out.printf("%s%s\t" + fighter + " throws a hit of " + damage +
                            " in damage!\t\t\t\t\t\t\t\t\t\t %s\n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET
            );

            default -> System.out.println("Something went wrong! The name was to long.");
        }
    }



    public static void monsterHeader(String fighter, int getLevel) {
        int nameLength = fighter.length();

        switch (nameLength) {
            case 16, 17, 18, 19 -> System.out.printf("%s\t   \t\t\t\t\t\t %s%s\t" + fighter +
                            "\tLevel: " + getLevel +
                            "\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);

            case 12, 13, 14, 15 -> System.out.printf("%s\t   \t\t\t\t\t\t %s%s\t" + fighter +
                            "\t\tLevel: " + getLevel +
                            "\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);

            case 8, 9, 10, 11 -> System.out.printf("%s\t   \t\t\t\t\t\t %s%s\t" + fighter +
                            "\t\t\tLevel: " + getLevel +
                            "\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);

            case 4, 5, 6, 7 -> System.out.printf("%s\t   \t\t\t\t\t\t %s%s\t" + fighter +
                            "\t\t\t\tLevel: " + getLevel +
                            "\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);

            case 0, 1, 2, 3 -> System.out.printf("%s\t   \t\t\t\t\t\t %s%s\t" + fighter +
                            "\t\t\t\t\tLevel: " + getLevel +
                            "\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);

            default -> System.out.println("Something went wrong! The name was to long.");
        }
    }



    public static void statusBodyWeaponText(GameItem item, String ansiBg, int i) {
        int nameLength = item.getItemName().length();

        switch (nameLength) {
            case 12, 13 -> System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                            item.getItemName() +
                            ", Strength: " + item.getItemValue(),
                    PrintColor.ANSI_BRIGHT_BG_WHITE, ansiBg, PrintColor.ANSI_BLACK);

            case 8, 9, 10, 11 -> System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                            item.getItemName() +
                            ", \tStrength: " + item.getItemValue(),
                    PrintColor.ANSI_BRIGHT_BG_WHITE, ansiBg, PrintColor.ANSI_BLACK);

            case 5, 6, 7 -> System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                            item.getItemName() +
                            ", \t\tStrength: " + item.getItemValue(),
                    PrintColor.ANSI_BRIGHT_BG_WHITE, ansiBg, PrintColor.ANSI_BLACK);


            case 1, 2, 3, 4 -> System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                            item.getItemName() +
                            ", \t\t\tStrength: " + item.getItemValue(),
                    PrintColor.ANSI_BRIGHT_BG_WHITE, ansiBg, PrintColor.ANSI_BLACK);

            default -> System.out.println("Something went wrong! The name was to long.");
        }

        System.out.printf(",\t Amount: " + item.getAmount() +
                "  \t%s\t\t %s%n", PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
    }


    }
