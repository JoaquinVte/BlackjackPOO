package blackjack.controller;

import blackjack.model.Color;

import java.util.Scanner;

public class Input {
    private static Scanner sc;

    public static int getInt(String message){
        message = Color.CYAN + message + Color.RESET;
        sc = new Scanner(System.in);
        System.out.println(message);
        while (!sc.hasNextInt()) {
            System.out.println("Error. You have to enter a integer number.");
            sc.next();
        }
        return sc.nextInt();
    }
    public static String getString(String message){
        message = Color.CYAN + message + Color.RESET;
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }
    public static char getYesNoOption(String message){
        message = Color.CYAN + message + Color.RESET;
        String option = getString(message).toUpperCase();

        while ( !option.equals("YES") && !option.equals("Y") && !option.equals("N") && !option.equals("NO"))
            option = getString(message).toUpperCase();

        return option.charAt(0);
    }

}
