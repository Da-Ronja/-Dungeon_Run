package com.silvia.demo;

import com.silvia.demo.display.DisplayHeaders;
import com.silvia.demo.display.DisplayText;
import com.silvia.demo.display.PrintColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
    private static final List<String> startMenuList = new ArrayList<>(
            Arrays.asList("Battle", "Status", "Shop", "Exit")
    );
    private static final List<String> battleMenuList = new ArrayList<>(
            Arrays.asList("Fight", "Flee ", "Status")
    );
    static final List<String> statusMenuList = new ArrayList<>(
            Arrays.asList("Healing ", "Weapons", "Back")
    );
    static final List<String> statusBattleMenuList = new ArrayList<>(
            Arrays.asList("Healing ", "Back")
    );
    private static final List<String> shopMenuList = new ArrayList<>(
            Arrays.asList("Weapons", "Healing ", "Back")
    );
    private static final List<String> yesNoMenuList = new ArrayList<>(
            Arrays.asList("Y = Yes", "N = No ")
    );
    private static int chosenStartMenu;
    private static int chosenBattleMenu;
    protected static int chosenStatusMenu;
    private static int chosenShopMenu;
    protected static int exitStatusStartMenu = statusMenuList.size() -1;
    protected static int exitStatusBattleMenu = statusBattleMenuList.size() -1;

    protected static String getPlayAgainText() {
        return "\u001B[40m\t  Play again? \t\t\u001B[0m";
    }
    protected static String getAreYouSureText() {
        return "\u001B[40m\t Are you sure? \t\t\u001B[0m";
    }
    protected static String getWantToBuyText() {
        return "\u001B[40m\t Want to buy?  \t\t\u001B[0m";
    }

    protected static void displayStartMenu() {
        DisplayHeaders.gameHeader();

        System.out.printf(
                "%s%s\t\t  " + (1) + ". " + startMenuList.get(0) + "\t\t" + (2) + ". " + startMenuList.get(1) +
                        "\t\t" + (3) + ". " + startMenuList.get(2) + "\t\t" + (4) + ". " + startMenuList.get(3) + "\t\t\t\t %s%n",
                PrintColor.ANSI_BG_RED, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);

        DisplayHeaders.underLine();
    }

    protected static void displayStatusMenu(List<String> statusList) {

        if (statusList == statusMenuList) {
            System.out.print("\u001B[41m\u001B[30m\t\t\t" + (1) + ". " + statusList.get(0) +
                    "\t\t\t" + (2) + ". " + statusList.get(1) +
                    "\t\t\t" + (3) + ". " + statusList.get(2) + "\t\t\t\t \u001B[0m\n");
        } else {
            System.out.print("\u001B[41m\u001B[30m\t\t\t\t" + (1) + ". " + statusList.get(0) +
                    "\t\t\t\t\t\t\t" + (2) + ". " + statusList.get(1) + "\t\t\t\t \u001B[0m\n");
        }

        DisplayHeaders.underLine();
    }

    protected static void displayBattleMenu() {
        DisplayHeaders.battleHeader();
        DisplayHeaders.statusHeaderBesideHealth(Game.player, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);
        DisplayHeaders.statusHeaderBesideHealth(Battle.monster, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE);

        System.out.printf("%n%s%s\t\t\t" + (1) + ". " + battleMenuList.get(0) + "\t\t\t" + (2) + ". " +
                        battleMenuList.get(1) + "\t\t\t" + (3) + ". " + battleMenuList.get(2) + "\t\t\t %s\n",
                PrintColor.ANSI_BG_RED, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);

        DisplayHeaders.underLine();
    }

    protected static void displayShopMenu() {
        DisplayHeaders.shopHeader();

        System.out.printf("%s%s\t\t\t" + (1) + ". " + shopMenuList.get(0) + "\t\t\t " + (2) + ". " +
                        shopMenuList.get(1) + "\t\t\t" + (3) + ". " + shopMenuList.get(2) + "\t\t\t %s\n",
                PrintColor.ANSI_BG_RED, PrintColor.ANSI_BLACK, PrintColor.ANSI_RESET);

        DisplayHeaders.underLine();
    }

    protected static void  displayYesNoMenu(String question) {
        System.out.printf("%s\t\t\t\t\t\t%s%s\t\t\t\t\t\t %s\n",
                PrintColor.ANSI_BRIGHT_BG_WHITE, question, PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);
        System.out.printf("%s\t\t\t\t\t\t%s========================%s\t\t\t\t\t\t %s\n",
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_BRIGHT_BG_WHITE,
                PrintColor.ANSI_RESET);

        System.out.printf("%s\t\t\t\t\t\t",
                PrintColor.ANSI_BRIGHT_BG_WHITE);

        for (String s : yesNoMenuList) {
            System.out.printf("%s%s   " + s + "\t%s",
                    PrintColor.ANSI_BG_RED, PrintColor.ANSI_BLACK,PrintColor.ANSI_RESET);
        }

        System.out.printf("%s\t\t\t\t\t\t %s\n",
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_RESET);

        System.out.printf("%s\t\t\t\t\t\t%s========================%s\t\t\t\t\t\t %s\n",
                PrintColor.ANSI_BRIGHT_BG_WHITE, PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_BRIGHT_BG_WHITE,
                PrintColor.ANSI_RESET);
        DisplayHeaders.blankLine(PrintColor.ANSI_BRIGHT_BG_WHITE);
        DisplayHeaders.underLine();
    }

    public static void startMenu() {
        Menu.chosenStartMenu = UserInput.chosenMenu();

        switch (Menu.chosenStartMenu) {
            case 1 -> Game.enterBattleMode();
            case 2 -> Game.startStatus();
            case 3 -> Game.enterShopMode();
            case 4 -> {
                System.out.println("EXITING GAME");
                Game.exitGame();
            }
            default -> System.out.println("Not an existing input! Please enter a number between 1 and "
                    + startMenuList.size()
            );
        }
    }

    public static void statusStartMenu() {

        Menu.chosenStatusMenu = UserInput.chosenMenu();

        switch (Menu.chosenStatusMenu) {

            case 1 -> statusPlayerDisplay(Game.player.getPotionList());
            case 2 -> statusPlayerDisplay(Game.player.getWeaponList());
            case 3 -> System.out.println("BACK!");
            default -> System.out.println(
                    "Not an existing input! Please enter a number between 1 and " + statusMenuList.size()
            );
        }

    }

    public static void battleMenu() {

        Menu.chosenBattleMenu = UserInput.chosenMenu();

        switch (Menu.chosenBattleMenu) {
            case 1 -> {
                Battle.inBattle();

                UserInput.continueGame();
            }
            case 2 -> {
                Battle.fleeBattle();

                UserInput.continueGame();
            }
            case 3 -> Battle.battleStatus();
            default -> System.out.println(
                    "Not an existing input! Please enter a number between 1 and " + battleMenuList.size()
            );
        }

    }

    public static void statusBattleMenu() {
        Menu.chosenStatusMenu = UserInput.chosenMenu();

        switch (Menu.chosenStatusMenu) {
            case 1 ->
                    statusPlayerDisplay(Game.player.getPotionList());

            case 2 ->
                    System.out.println("BACK!");

            default -> System.out.println(
                    "Not an existing input! Please enter a number between 1 and " + statusBattleMenuList.size()
            );
        }
    }

    public static boolean shopMenu() {
        Menu.chosenShopMenu = UserInput.chosenMenu();
        boolean inShop = true;

        switch (Menu.chosenShopMenu) {
            case 1 -> statusShopDisplay(Shop.weaponShopList);
            case 2 -> statusShopDisplay(Shop.potionShopList);
            case 3 -> {
                System.out.println("LEAVE SHOP!");

                inShop = false;
            }

            default -> System.out.println(
                    "Not an existing input! Please enter a number between 1 and " + shopMenuList.size()
            );
        }

        return inShop;
    }

    public static void statusShopDisplay(List<Shop> shopList) {
        int choice;
        int lastItemIndex = shopList.size() + 1;

        do {
            DisplayText.displayShopList(shopList);
            choice = UserInput.chosenMenu();

            if (choice == lastItemIndex) {

                System.out.println("Back to menu!");

            } else if ( choice > lastItemIndex ) {

                System.out.println("Enter a number between 1 and " + lastItemIndex);

            } else {
                Shop.selectItem((choice - 1), shopList);
            }

        } while (choice != lastItemIndex);

        System.out.println("You picked: " + choice);
    }

    public static void statusPlayerDisplay(List<GameItem> list) {
        int itemIndex;
        int lastItemIndex;

        do {
            GameItem.sortItemByValue(list);
            lastItemIndex = list.size() + 1;

            DisplayText.displayPlayerStatusList(list, Game.player);
            itemIndex = UserInput.chosenMenu();

            if (itemIndex == lastItemIndex) {

                System.out.println("Back to menu!");

            } else if ( itemIndex > lastItemIndex ) {

                System.out.println("Enter a number between 1 and " + lastItemIndex);

            } else {

                GameItem.selectItem(itemIndex, list);
            }

        } while (itemIndex != lastItemIndex);

        System.out.println("You picked: " + itemIndex);
    }

    public static void pickForBattleDisplay(List<GameItem> list) {
        boolean selected = false;
        int itemIndex;
        int lastItemIndex = list.size();

        do {
            GameItem.sortItemByValue(list);
            DisplayText.displayPlayerPickList(list);
            itemIndex = UserInput.chosenMenu();

            if ( itemIndex > lastItemIndex ) {

                System.out.println("Enter a number between 1 and " + lastItemIndex);
            } else {

                GameItem.selectItem(itemIndex, list);
                selected = true;
            }

        } while (!selected);

    }

}
