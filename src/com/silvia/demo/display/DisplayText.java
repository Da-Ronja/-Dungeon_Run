package com.silvia.demo;

import java.util.List;
import java.util.Objects;

public class DisplayText {
    // Only methods for displaying text no other functionality

    protected static void gameItemListDisplay(List<GameItem> list, boolean inStatus) {
        for (int i = 0; i < list.size(); i++) {

            if (i % 2 == 0) {
                if (Objects.equals(list.get(i).getItemName(), "Hands")) {
                    System.out.printf("%s\t   %s%s\t" + (i + 1) +
                                    ". Name: " + list.get(i).getItemName() + "\t\t\t\t\t\t\t\t\t\t\t%s\t\t %s%n",
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_PURPLE, PrintColor.ANSI_BLACK,
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
                } else {
                    if (list.get(i).getItemName().length() < 13) {
                        System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                                list.get(i).getItemName() +
                                ", \t\tStrength: " + list.get(i).getItemValue() +
                                ",\t Amount: " + list.get(i).getAmount() +

                                "  \t%s\t\t %s%n", PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_PURPLE,
                                PrintColor.ANSI_BLACK, PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
                    } else {
                        System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                                list.get(i).getItemName() +
                                ", Strength: " + list.get(i).getItemValue() +
                                ",\t Amount: " + list.get(i).getAmount() +

                                "  \t%s\t\t %s%n", PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_PURPLE,
                                PrintColor.ANSI_BLACK, PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
                    }
                }
            } else {
                if (list.get(i).getItemName().length() < 13) {
                    System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                            list.get(i).getItemName() +
                            ", \t\tStrength: " + list.get(i).getItemValue() +
                            ",\t Amount: " + list.get(i).getAmount() +

                            "  \t%s\t\t %s%n", PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_CYAN,
                            PrintColor.ANSI_BLACK, PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
                } else {
                    System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                            list.get(i).getItemName() +
                            ", Strength: " + list.get(i).getItemValue() +
                            ",\t Amount: " + list.get(i).getAmount() +

                            "  \t%s\t\t %s%n", PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_CYAN,
                            PrintColor.ANSI_BLACK, PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
                }
            }
        }

        if (inStatus) {
            System.out.printf("%s%s\t   \t" + (list.size() + 1) + ". Back \t\t\t\t\t\t\t\t\t\t\t\t\t\t %s%n",
                    PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, PrintColor.ANSI_RESET);
        }

        DisplayHeaders.underLine();

    }

    protected static void displayShopList(List<Shop> shopList) {
        DisplayHeaders.shopHeader();

        if (shopList == Shop.potionShopList){
            DisplayHeaders.itemHealthHeader();
        } else {
            DisplayHeaders.itemWeaponHeader();
        }

        if (Game.player.getGold() < 10) {
            System.out.printf("%s\t   %s%s\t\t\t\t\t\t\t\t\t\t\tGOLD: " + Game.player.getGold() + "\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE,  PrintColor.ANSI_RESET);
        } else if (Game.player.getGold() < 100000) {
            System.out.printf("%s\t   %s%s\t\t\t\t\t\t\t\t\t\tGOLD: " + Game.player.getGold() + "\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else {
            System.out.printf("%s\t   %s%s\t\t\t\t\t\t\t\t\tGOLD: " + Game.player.getGold() + "\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);

        }

        for (int i = 0; i < shopList.size(); i++) {

            if (i % 2 == 0) {
                if (shopList.get(i).getItemName().length() < 8) {
                    System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                            shopList.get(i).getItemName() +
                            ", \t\tStrength: " + shopList.get(i).getItemValue(),
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_PURPLE, PrintColor.ANSI_BLACK);

                } else if (shopList.get(i).getItemName().length() < 12) {
                    System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                                    shopList.get(i).getItemName() +
                                    ", \tStrength: " + shopList.get(i).getItemValue(),
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_PURPLE, PrintColor.ANSI_BLACK);

                } else {
                    System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                            shopList.get(i).getItemName() +
                            ", Strength: " + shopList.get(i).getItemValue(),
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_PURPLE, PrintColor.ANSI_BLACK);
                }

            } else {
                if (shopList.get(i).getItemName().length() < 13) {

                    System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                            shopList.get(i).getItemName() +
                            ", \t\tStrength: " + shopList.get(i).getItemValue(),
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_CYAN, PrintColor.ANSI_BLACK);
                } else {
                    System.out.printf("%s\t   %s%s\t" + (i + 1) + ". Name: " +
                            shopList.get(i).getItemName() +
                            ", Strength: " + shopList.get(i).getItemValue(),
                            PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_CYAN, PrintColor.ANSI_BLACK);
                }

            }
            if (shopList.get(i).getItemPrice() > 9) {
                System.out.printf(",\t Price: " + shopList.get(i).getItemPrice() +
                        "  \t%s\t\t %s\n", PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
            } else {

                System.out.printf(",\t Price: " + shopList.get(i).getItemPrice() +
                        "  \t\t%s\t\t %s\n", PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
            }
        }

        System.out.printf("%s%s\t   \t" + (shopList.size() + 1) + ". Back \t\t\t\t\t\t\t\t\t\t\t\t\t\t %s%n",
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, PrintColor.ANSI_RESET);

        DisplayHeaders.underLine();
    }

    protected static void displayPlayerStatusList(List<GameItem> list) {
        DisplayHeaders.statusHeader();

        if (list == Game.player.potionList){
            DisplayHeaders.itemHealthHeader();
        } else {
            DisplayHeaders.itemWeaponHeader();
        }

        DisplayHeaders.playerHeaderBattle(Game.player);

        if (list.isEmpty()){    // TODO EMPTY
            System.out.println("\t   \t\t\t\t\t\t  EMPTY! \t\t\t\t\t\t\t");
        }
        DisplayText.gameItemListDisplay(list, true);
    }

    protected static void displayPlayerPickList(List<GameItem> list) {

        DisplayHeaders.choseWeaponHeader();
        DisplayHeaders.playerHeaderBattle(Game.player);

        if (list.isEmpty()){
            System.out.println("\t\t\t\t\t\t  EMPTY! \t\t\t\t\t\t\t");
        }
        DisplayText.gameItemListDisplay(list, false);
    }

    protected static void statusBodyBeside(Player player, Monster monster) {
        DisplayHeaders.statusHeaderBeside(player, monster);

        System.out.printf("%s%s\t" + "Level:\t\t\t\t\t\t" + player.getLevel() + "\t" +
                        "%s\t" + "Level:\t\t\t\t\t\t" + monster.getLevel() + "\t %s%n",
                PrintColor.ANSI_BG_PURPLE, PrintColor.ANSI_BLACK, PrintColor.ANSI_BRIGHT_BG_PURPLE, PrintColor.ANSI_RESET);

        System.out.printf("%s%s\t" + "Base damage:\t\t\t\t" + player.getBaseDamage() + "\t" +
                        "%s\t" + "Base damage:\t\t\t\t" + monster.getBaseDamage() + "\t %s%n",
                PrintColor.ANSI_BG_BLUE,  PrintColor.ANSI_BLACK, PrintColor.ANSI_BRIGHT_BG_BLUE, PrintColor.ANSI_RESET);

        System.out.printf("%s%s\t" + "Strength:\t\t\t\t\t" + player.getStrength() + "\t" +
                        "%s\t" + "Strength:\t\t\t\t\t" + monster.getStrength() + "\t %s%n",
                PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_BLACK, PrintColor.ANSI_BRIGHT_BG_CYAN, PrintColor.ANSI_RESET);

        System.out.printf("%s%s\t" + "Agility:\t\t\t\t\t" + player.getAgility() + "\t" +
                        "%s\t" + "Agility:\t\t\t\t\t" + monster.getAgility() + "\t %s%n",
                PrintColor.ANSI_BG_GREEN,  PrintColor.ANSI_BLACK, PrintColor.ANSI_BRIGHT_BG_GREEN, PrintColor.ANSI_RESET);

        System.out.printf("%s%s\t" + "Intelligence:\t\t\t\t" + player.getIntelligence() + "\t" +
                        "%s\t" + "Intelligence:\t\t\t\t" + monster.getIntelligence() + "\t %s%n",
                PrintColor.ANSI_BG_YELLOW, PrintColor.ANSI_BLACK, PrintColor.ANSI_BRIGHT_BG_YELLOW, PrintColor.ANSI_RESET);


        if (player.getWeapon().getItemName().length() > 15) {
            System.out.printf("%s%s\t" + "Weapon:\t\t" + player.getWeapon().getItemName() + "\t",
                    PrintColor.ANSI_BG_WHITE, PrintColor.ANSI_BLACK);
        } else if (player.getWeapon().getItemName().length() > 11) {
            System.out.printf("%s%s\t" + "Weapon:\t\t\t" + player.getWeapon().getItemName() + "\t",
                    PrintColor.ANSI_BG_WHITE, PrintColor.ANSI_BLACK);
        } else if (player.getWeapon().getItemName().length() > 7) {
            System.out.printf("%s%s\t" + "Weapon:\t\t\t\t" + player.getWeapon().getItemName() + "\t",
                    PrintColor.ANSI_BG_WHITE, PrintColor.ANSI_BLACK);
        } else if (player.getWeapon().getItemName().length() > 3) {
            System.out.printf("%s%s\t" + "Weapon:\t\t\t\t\t" + player.getWeapon().getItemName() + "\t",
                    PrintColor.ANSI_BG_WHITE, PrintColor.ANSI_BLACK);
        } else {
            System.out.printf("%s%s\t" + "Weapon: " + player.getWeapon().getItemName() + "\t\t\t\t\t\t",
                    PrintColor.ANSI_BG_WHITE, PrintColor.ANSI_BLACK);
        }

        if (monster.getWeapon().getItemName().length() > 15) {
            System.out.printf("%s\t" + "Weapon:\t\t" + monster.getWeapon().getItemName() + "\t %s%n",
                    PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_RESET);
        } else if (monster.getWeapon().getItemName().length() > 11) {
            System.out.printf("%s\t" + "Weapon:\t\t\t" + monster.getWeapon().getItemName() + "\t %s%n",
                    PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_RESET);
        } else if (monster.getWeapon().getItemName().length() > 7) {
            System.out.printf("%s\t" + "Weapon:\t\t\t\t" + monster.getWeapon().getItemName() + "\t %s%n",
                    PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_RESET);
        } else if (monster.getWeapon().getItemName().length() > 3) {
            System.out.printf("%s\t" + "Weapon:\t\t\t\t\t" + monster.getWeapon().getItemName() + "\t %s%n",
                    PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_RESET);
        } else {
            System.out.printf("%s\t" + "Weapon:\t\t\t\t\t" + monster.getWeapon().getItemName() + "\t %s%n",
                    PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_RESET);
        }

        if (!Objects.equals(player.getWeapon().getItemName(), "Hands")) {
            System.out.printf("%s%s\t" + "Weapon Strength:\t\t\t" + player.getWeapon().getItemValue() + "\t",
                    PrintColor.ANSI_BG_WHITE, PrintColor.ANSI_BLACK);
        } else {
            System.out.printf("%s%s\t\t\t\t\t\t\t\t\t",
                    PrintColor.ANSI_BG_WHITE, PrintColor.ANSI_BLACK);
        }
        if (!Objects.equals(monster.getWeapon().getItemName(), "Hands")) {
            System.out.printf("%s\t" + "Weapon Strength:\t\t\t" + monster.getWeapon().getItemValue() + "\t %s%n",
                    PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_RESET);
        } else {
            System.out.printf("%s\t\t\t\t\t\t\t\t\t %s%n",
                    PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_RESET);
        }
    }

    protected static void statusBody(Fighter fighter) {

        if (fighter == Battle.monster) {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tHealth: " + fighter.getHealth() + "\t\t\t\t\t\t%s\t\t %s%n" +
                            "%s\t   \t  %sYour opponent\t\t %s%s\tBase damage: " + fighter.getBaseDamage() +
                            "\t\t\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_PURPLE, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET, PrintColor.ANSI_BRIGHT_BG_WHITE,
                    PrintColor.ANSI_BRIGHT_RED, PrintColor.ANSI_BRIGHT_BG_BLUE, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET
            );
        } else {
            System.out.printf("%s\t   \t\t%s  Your kills: \t %s%s\tHealth: " + fighter.getHealth() +
                            "\t\t\t\t\t\t%s\t\t %s%n" +
                            "%s\t   \t\t\t%s  "+ Game.player.getKilledMonsters() +" \t\t %s%s\tBase damage: " + fighter.getBaseDamage() +
                            "\t\t\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_RED, PrintColor.ANSI_BRIGHT_BG_PURPLE,
                    PrintColor.ANSI_BLACK, PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_RED, PrintColor.ANSI_BRIGHT_BG_BLUE,
                    PrintColor.ANSI_BLACK, PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        }



        if (fighter.getStrength() > 9 ) {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tStrength: " + fighter.getStrength() +
                            "\t\t\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_CYAN, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tStrength: " + fighter.getStrength() +
                            "\t\t\t\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_CYAN, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        }


        System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tAgility: " + fighter.getAgility() +
                        "\t\t\t\t\t\t%s\t\t %s%n",
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_GREEN, PrintColor.ANSI_BLACK,
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);


        if (fighter.getIntelligence() > 9) {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tIntelligence: " + fighter.getIntelligence() +
                            "\t\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_YELLOW, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tIntelligence: " + fighter.getIntelligence() +
                            "\t\t\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BRIGHT_BG_YELLOW, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        }

        if (fighter.getWeapon().getItemName().length() > 15) {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tWeapon: " + fighter.getWeapon().getItemName() +
                            "\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else if (fighter.getWeapon().getItemName().length() > 11) {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tWeapon: " + fighter.getWeapon().getItemName() +
                            "\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else if (fighter.getWeapon().getItemName().length() > 7) {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tWeapon: " + fighter.getWeapon().getItemName() +
                            "\t\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else if (fighter.getWeapon().getItemName().length() > 3) {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tWeapon: " + fighter.getWeapon().getItemName() +
                            "\t\t\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else {
            System.out.printf("%s\t   \t\t\t\t\t\t %s%s\tWeapon: " + fighter.getWeapon().getItemName() +
                            "\t\t\t\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        }

        if (!Objects.equals(fighter.getWeapon().getItemName(), "Hands")) {
            System.out.printf("%s\t  \t\t\t\t\t\t %s%s\tWeapon Strength: " + fighter.getWeapon().getItemValue() +
                            "\t\t\t\t%s\t\t %s%n",
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_CYAN, PrintColor.ANSI_BLACK,
                    PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        } else {
            DisplayHeaders.underLine();
        }
    }

}
