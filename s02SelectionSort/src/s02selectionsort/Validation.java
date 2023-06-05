/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s02selectionsort;

import java.util.Scanner;

/**
 *
 * @author khuakhanhhuy
 */
/**
 * A utility class for validating user input.
 */
public class Validation {

    
    private static Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user for an integer value and returns the value entered. If
     * the user enters an invalid input, an error message is displayed and the
     * user is prompted to enter a new value.
     *
     * @param prompt the prompt to display to the user
     * @return the integer value entered by the user
     */
    public static int getInt(String prompt) {
        // Prompt the user for an integer value
        while (true) {
            // Display the prompt
            System.out.print(prompt);
            try {
                // Parse the user input as an integer and return the value
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Display an error message for invalid input
                System.out.println("Invalid input, please enter an integer.");
            }
        }
    }

    /**
     * Prompts the user for a double value and returns the value entered. If the
     * user enters an invalid input, an error message is displayed and the user
     * is prompted to enter a new value.
     *
     * @param prompt the prompt to display to the user
     * @return the double value entered by the user
     */
    public static double getDouble(String prompt) {
        // Prompt the user for a double value
        while (true) {
            // Display the prompt
            System.out.print(prompt);
            try {
                // Parse the user input as a double and return the value
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                // Display an error message for invalid input
                System.out.println("Invalid input, please enter a number.");
            }
        }
    }

    /**
     * Prompts the user for a string value and returns the value entered.
     *
     * @param prompt the prompt to display to the user
     * @return the string value entered by the user
     */
    public static String getString(String prompt, String errorMessage) {
        // Prompt the user for a string value
        while (true) {
            // Display the prompt
            System.out.print(prompt);
            // Read the user input
            String input = scanner.nextLine();

            // Check if the input is not empty or null
            if (!input.equals("") && !input.equals(null)) {
                // Return the input value
                return input;
            } else {
                // Display an error message for empty or null input
                System.out.println(errorMessage);
                return null;
            }
        }
    }

    /**
     * Prompts the user for a character value and returns the value entered. If
     * the user enters an invalid input, an error message is displayed and the
     * user is prompted to enter a new value.
     *
     * @param prompt the prompt to display to the user
     * @return the character value entered by the user
     */
    public static char getChar(String prompt) {
        // Prompt the user for a character value
        while (true) {
            // Display the prompt
            System.out.print(prompt);
            // Read the user input
            String input = scanner.nextLine();
            // Check if the input is a single character
            if (input.length() != 1) {
                // Display an error message for invalid input
                System.out.println("Invalid input, please enter a single character.");
            } else {
                // Return the first character of the input string
                return input.charAt(0);
            }
        }
    }

    /**
     * Prompts the user for a boolean value and returns the value entered. If
     * the user enters an invalid input, an error message is displayed and the
     * user is prompted to enter a new value.
     *
     * @param prompt the prompt to display to the user
     * @return the boolean value entered by the user
     */
    public static boolean getBoolean(String prompt) {
        // Prompt the user for a boolean value
        while (true) {
            // Display the prompt
            System.out.print(prompt);
            // Read the user input
            String input = scanner.nextLine().toLowerCase();
            // Check if the input is "true", "yes", or "y"
            if (input.equals("true") || input.equals("yes") || input.equals("y")) {
                // Return true
                return true;
            } else if (input.equals("false") || input.equals("no") || input.equals("n")) {
                // Return false
                return false;
            } else {
                // Display an error message for invalid input
                System.out.println("Invalid input, please enter 'true' or 'false'.");
            }
        }
    }

    /**
     * Reads a positive integer value from the user using the specified Scanner
     * and prompt.
     *
     * @param scanner the Scanner to use for input
     * @param prompt the prompt to display to the user
     * @return the positive integer value entered by the user
     */
    public static int readPositiveInt(Scanner scanner, String prompt) {
        // Read a positive integer value from the user
        int value = 0;
        while (value <= 0) {
            // Display the prompt
            System.out.println(prompt);
            if (scanner.hasNextInt()) {
                // Read the user input as an integer
                value = scanner.nextInt();
                if (value <= 0) {
                    // Display an error message for non-positive input
                    System.out.println("Value must be a positive integer!");
                }
            } else {
                // Display an error message for invalid input
                System.out.println("Invalid input! Value must be a positive integer.");
                scanner.next(); // discard the invalid input
            }
        }
        return value;
    }
}
