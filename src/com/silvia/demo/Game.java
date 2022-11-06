package com.silvia.demo;

import com.silvia.demo.display.DisplayHeaders;
import com.silvia.demo.display.DisplayText;

public class Game {
    public static Player player;
    public static boolean inGame = true;

    public static void game() {
        gameIntro();

        gameEnd();

        gameScene();
        gameEnd();
    }
    private static void gameIntro() {

        DisplayText.introText();

        Shop.initShopList();
         player = new Player(UserInput.playersName());

    }
    /* ***** S T A R T  M E N U ***** */
    private static void gameScene() {
        inGame = true;

        do {
            Menu.displayStartMenu();
            Menu.startMenu();

        } while (inGame);
    }
    public static void enterBattleMode() {

        Battle.battleScene(player);
    }
    public static void enterShopMode() {

        do {
            Menu.displayShopMenu();
            Shop.inShop = Menu.shopMenu();
        } while(Shop.inShop);
    }
    public static void startStatus () {

        do {
            DisplayHeaders.statusHeader();
            DisplayHeaders.playerHeaderStartStatus(player);
            DisplayText.statusBodyText(player);
            Menu.displayStatusMenu(Menu.statusMenuList);
            Menu.statusStartMenu();

        } while (Menu.chosenStatusMenu != (Menu.exitStatusStartMenu + 1));

    }
    // case 3 == Exit
    public static void exitGame() {
        Menu.displayYesNoMenu(Menu.getAreYouSureText());


        switch (UserInput.yesNo()) {
            case "Y" -> {
                System.out.println("You left the Game. Goodbye!");
                Menu.chosenStatusMenu = Menu.exitStatusStartMenu;
                inGame = false;
            }
            case "N" ->
                    System.out.println("You continue playing Game!");

            default -> System.out.println("Something went wrong!");
        }

    }

    // if playAgain
    private static boolean playAgain() {
        boolean restart = true;

        Menu.displayYesNoMenu(Menu.getPlayAgainText());

        switch (UserInput.yesNo()) {
            case "Y" -> {
                System.out.println("You restart Game!");
                player = new Player(player.getFighterName());
            }
            case "N" -> {
                System.out.println("You left the Game. Goodbye!");
                restart = false;
            }
            default -> System.out.println("Something went wrong!");
        }

        return restart;
    }

    private static void gameEnd() {
        Player.writeDeadFile();

        DisplayHeaders.youDiedHeader();
        DisplayText.deadPlayerText(Game.player);

        if (!inGame == playAgain()) {
            game();
        }

    }

}
