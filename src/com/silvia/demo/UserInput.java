package com.silvia.demo;

import com.silvia.demo.display.PrintColor;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UserInput {

    protected static String welcomeText = "Whats your name my faithful comrade?";
    protected static String toLongText = "Your name is to long! Please enter a name with max 19 characters";
    protected static String enterNameText = "Please enter your name";
    protected static String invalidNumberText = "Invalid input! Please enter a number";
    protected static String invalidInputText = "Invalid input! Please enter /'Y/' or /'N/'";
    protected static String continueKeyText = "Enter any key and Enter to continue";

    private static final Scanner scan = new Scanner(System.in, StandardCharsets.UTF_8);

    static String playersName() {
        System.out.printf("%s%s\t\t\t\t  %s  \t\t\t\t %s\n",
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_YELLOW, welcomeText, PrintColor.ANSI_RESET );
        String name = scan.nextLine();

        do {
            if (name.length() > 19) {
                System.out.printf("%s%s%s\t\t %s\n",
                        PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, toLongText, PrintColor.ANSI_RESET );

                name = scan.nextLine();
            }
            if (name.isEmpty()) {
                System.out.printf("%s%s%s\t\t\t\t\t\t\t\t\t\t\t\t\t %s\n",
                        PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, enterNameText, PrintColor.ANSI_RESET );

                name = scan.nextLine();
            }
            if (name.isBlank()) {
                System.out.printf("%s%s%s\t\t\t\t\t\t\t\t\t\t\t\t\t %s\n",
                        PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, enterNameText, PrintColor.ANSI_RESET );

                name = scan.nextLine();
            }

        } while (name.isEmpty() || name.length() > 19);

        return name;
    }

    static int chosenMenu() {

        int number;
        do {
            while (!scan.hasNextInt()) {
                System.out.printf("%s%s%s\t\t\t\t\t\t\t\t\t %s\n",
                        PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, invalidNumberText, PrintColor.ANSI_RESET );
                scan.next();
            }
            number = scan.nextInt();
        } while (number <= 0);

        return number;
    }

    static String yesNo() {
        String yesOrNoInput;
        String yesOrNo;
        boolean validInput  = false;

        do {
            yesOrNoInput = scan.next();
            yesOrNo = String.valueOf(yesOrNoInput.charAt(0));
            yesOrNo = yesOrNo.toUpperCase();

            if (yesOrNo.equalsIgnoreCase("Y")){
                validInput = true;

            }
            if (yesOrNo.equalsIgnoreCase("N")){
                validInput = true;

            } else if (!validInput) {
                System.out.printf("%s%s%s\t\t\t\t\t\t\t\t %s\n",
                        PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, invalidInputText, PrintColor.ANSI_RESET );
            }

        } while (!validInput);

        return yesOrNo;
    }

    static void continueGame() {

        System.out.printf("%s%s%s\t\t\t\t\t\t\t\t\t\t %s\n",
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_WHITE, continueKeyText, PrintColor.ANSI_RESET );

        scan.next();
    }
}
