/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s14usermanagementsystem;

import java.util.Scanner;

/**
 * A utility class for validating user input.
 *
 * @author khuakhanhhuy
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
        while (true) {
            System.out.print(prompt); // Prompt message
            try {
                return Integer.parseInt(scanner.nextLine()); // Read the input value as an integer
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter an integer."); // Print error message
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
        while (true) {
            System.out.print(prompt); // Prompt message
            try {
                return Double.parseDouble(scanner.nextLine()); // Read the input value as a double
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number."); // Print error message
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
        while (true) {
            System.out.print(prompt); // Prompt message
            String input = scanner.nextLine();

            if (!input.equals("") && !input.equals(null)) {
                return input; // Return the input value
            } else {
                System.out.println(errorMessage); // Print error message
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
        while (true) {
            System.out.print(prompt); // Prompt message
            String input = scanner.nextLine();
            if (input.length() != 1) {
                System.out.println("Invalid input, please enter a single character."); // Print error message
            } else {
                return input.charAt(0); // Return the first character of the input
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
        while (true) {
            System.out.print(prompt); // Prompt message
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("true") || input.equals("yes") || input.equals("y")) {
                return true; // Return true if the input is "true", "yes", or "y"
            } else if (input.equals("false") || input.equals("no") || input.equals("n")) {
                return false; // Return false if the input is "false", "no", or "n"
            } else {
                System.out.println("Invalid input, please enter 'true' or 'false'."); // Print error message
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
        int value = 0;
        while (value <= 0) {
            System.out.println(prompt); // Prompt message
            if (scanner.hasNextInt()) {
                value = scanner.nextInt(); // Read the input value as an integer
                if (value <= 0) {
                    System.out.println("Value must be a positive integer!"); // Print error message
                }
            } else {
                System.out.println("Invalid input! Value must be a positive integer."); // Print error message
                scanner.next(); // discard the invalid input
            }
        }
        return value;
    }

    /**
     * Prompts the user for a non-empty string value and returns the value
     * entered. If the user enters an empty input, an error message is displayed
     * and the user is prompted to enter a valid value.
     *
     * @param prompt the prompt to display to the user
     * @param errorMessage the error message to display for invalid input
     * @return the non-empty string value entered by the user
     */
    public static String getStringContact(String prompt, String errorMessage) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print(prompt); // Prompt message
            input = scanner.nextLine().trim();

            // Check if the name is empty
            if (input.isEmpty()) {
                System.out.println(errorMessage); // Print error message
                continue;
            }

            // Check if the name contains special characters or numbers
            if (!input.matches("^[a-zA-Z ]+$")) {
                System.out.println(errorMessage); // Print error message
                continue;
            }

            break;
        } while (true);

        return input;
    }

    public static String getStringWithNumbers(String prompt, String errorMessage) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print(prompt); // Prompt message
            input = scanner.nextLine().trim();

            // Check if the input is empty
            if (input.isEmpty()) {
                System.out.println(errorMessage); // Print error message
                continue;
            }

            // Check if the input contains special characters
            if (!input.matches("^[a-zA-Z0-9 ]+$")) {
                System.out.println(errorMessage); // Print error message
                continue;
            }

            break;
        } while (true);

        return input;
    }

    /**
     * Prompts the user for a string value and returns the value entered.
     * Additionally, validates the input based on the provided conditions.
     *
     * @param prompt the prompt to display to the user
     * @param errorMessage the error message to display for invalid input
     * @param minLength the minimum length required for the input string
     * @param allowWhitespace a flag indicating whether spaces are allowed in
     * the input string
     * @param existingUsernames a list of existing usernames in the database
     * @return the string value entered by the user, or null if invalid
     */
    public static String getStringUser(
            String prompt, String errorMessage, int minLength, boolean allowWhitespace
    ) {
        while (true) {
            System.out.print(prompt); // Prompt message
            String input = scanner.nextLine().trim();

            // Check if the input meets the minimum length requirement
            if (input.length() < minLength) {
                System.out.println(errorMessage); // Print error message
                continue;
            }

            // Check if the input contains whitespace when not allowed
            if (!allowWhitespace && containsWhitespace(input)) {
                System.out.println(errorMessage); // Print error message
                continue;
            }

            return input;
        }
    }

    /**
     * Check if a given string contains any whitespace characters. If it does,
     * the method will return true; otherwise, it will return false.
     *
     *
     */
    private static boolean containsWhitespace(String input) {
        for (char c : input.toCharArray()) { // Iterate through each character in the input string
            if (Character.isWhitespace(c)) { // Check if the character is a whitespace
                return true; // Return true if a whitespace is found
            }
        }
        return false; // Return false if no whitespace is found
    }

}
