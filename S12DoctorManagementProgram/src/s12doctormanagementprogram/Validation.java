/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s12doctormanagementprogram;

import java.util.Scanner;

/**
 *
 * @author khuakhanhhuy
 */
/**
 * A utility class for validating user input.
 */
public class Validation {

    private Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the user for an integer value and returns the value entered. If
     * the user enters an invalid input, an error message is displayed and the
     * user is prompted to enter a new value.
     *
     * @param prompt the prompt to display to the user
     * @return the integer value entered by the user
     */
    public int getInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
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
    public double getDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
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
    public String getString(String prompt, String errorMessage) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();

            if (!input.equals("") && !input.equals(null)) {
                return input;
            } else {
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
    public char getChar(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (input.length() != 1) {
                System.out.println("Invalid input, please enter a single character.");
            } else {
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
    public boolean getBoolean(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("true") || input.equals("yes") || input.equals("y")) {
                return true;
            } else if (input.equals("false") || input.equals("no") || input.equals("n")) {
                return false;
            } else {
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
    public int readPositiveInt(Scanner scanner, String prompt) {
        int value = 0;
        while (value <= 0) {
            System.out.println(prompt);
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value <= 0) {
                    System.out.println("Value must be a positive integer!");
                }
            } else {
                System.out.println("Invalid input! Value must be a positive integer.");
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
    public String getStringContact(String prompt, String errorMessage) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            // Check if the name is empty
            if (input.isEmpty()) {
                System.out.println(errorMessage);
                continue;
            }

            // Check if the name contains special characters or numbers
            if (!input.matches("^[a-zA-Z ]+$")) {
                System.out.println(errorMessage);
                continue;
            }

            break;
        } while (true);

        return input;
    }

    /**
     * Prompts the user for a non-empty string value that matches a specific
     * phone number format and returns the value entered. If the user enters an
     * empty input or an invalid phone number format, an error message is
     * displayed and the user is prompted to enter a valid value.
     *
     * @param prompt the prompt to display to the user
     * @param errorMessage the error message to display for invalid input
     * @return the non-empty string value entered by the user with a valid phone
     * number format
     */
    public String getStringWithPhoneFormat(String prompt, String errorMessage) {
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty() || !isValidPhoneNumber(input)) {
                System.out.println(errorMessage);
            }
        } while (input.isEmpty() || !isValidPhoneNumber(input));

        return input;
    }

    /**
     * Validates if the given phone number has a valid format.
     *
     * @param phoneNumber the phone number to validate
     * @return true if the phone number has a valid format, false otherwise
     */
    private boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("(\\d{10}|\\d{3}-\\d{3}-\\d{4}|\\(\\d{3}\\)-\\d{3}-\\d{4}|\\d{3}\\.\\d{3}\\.\\d{4}|\\d{3} \\d{3} \\d{4})( x\\d+| ext\\d+)?");
    }

    public String getStringWithNumbers(String prompt, String errorMessage) {
        Scanner scanner = new Scanner(System.in);
        String input;

        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            // Check if the input is empty
            if (input.isEmpty()) {
                System.out.println(errorMessage);
                continue;
            }

            // Check if the input contains special characters
            if (!input.matches("^[a-zA-Z0-9 ]+$")) {
                System.out.println(errorMessage);
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
     * @param allowWhitespace a flag indicating whether spaces are allowed in the
     * input string
     * @param existingUsernames a list of existing usernames in the database
     * @return the string value entered by the user, or null if invalid
     */
    public String getStringWhitespace(
            String prompt, String errorMessage, boolean allowWhitespace
    ) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            // Check if the input meets the minimum length requirement
//            if (input.length() < minLength) {
//                System.out.println(errorMessage);
//                continue;
//            }

            // Check if the input contains whitespace when not allowed
            if (!allowWhitespace && containsWhitespace(input)) {
                System.out.println(errorMessage);
                continue;
            }

            return input;
        }
    }

    private boolean containsWhitespace(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isWhitespace(c)) {
                return true;
            }
        }
        return false;
    }
    
}
