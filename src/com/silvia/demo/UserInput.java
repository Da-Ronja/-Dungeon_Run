package com.silvia.demo;

import com.silvia.demo.display.PrintColor;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UserInput {

    private static final Scanner scan = new Scanner(System.in, StandardCharsets.UTF_8);

    static String playersName() {
        System.out.printf("%s%s\t\t\t\t  Whats your name my faithful comrade?  \t\t\t\t %s\n",
                PrintColor.ANSI_BG_BLACK, PrintColor.ANSI_YELLOW, PrintColor.ANSI_RESET );
        String name = scan.nextLine();

        do {
            if (name.length() > 19) {
                System.out.println("Your name is to long! Please enter a name with max 19 characters");
                name = scan.nextLine();
            }
            if (name.isEmpty()) {
                System.out.println("Please enter your name");
                name = scan.nextLine();
            }
            if (name.isBlank()) {
                System.out.println("Please enter your name");
                name = scan.nextLine();
            }

        } while (name.isEmpty() || name.length() > 19);

        return name;
    }

    static int chosenMenu() {

        int number;
        do {
            while (!scan.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number");
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
                System.out.println("Invalid input! Please enter /'Y/' or /'N/'");
            }

        } while (!validInput);

        return yesOrNo;
    }

    static void continueGame() {
        System.out.println("Enter any key and Enter to continue");

        scan.next();
    }
}
