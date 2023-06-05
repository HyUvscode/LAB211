/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v08;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * A utility class for validating user input.
 * 
 * @author khuakhanhhuy
 */
public class Validation {

    private static Scanner scanner = new Scanner(System.in); // Create a Scanner object

    /**
     * Get an integer value from the user.
     *
     * @param prompt the prompt message
     * @return the validated integer value
     */
    public static int getInt(String prompt) { // Define a method to get an integer value
        while (true) { // Start an infinite loop
            System.out.print(prompt); // Print the prompt
            try { // Start a try-catch block to handle NumberFormatException
                return Integer.parseInt(scanner.nextLine()); // Read an integer value from the user and return it
            } catch (NumberFormatException e) { // Catch NumberFormatException
                System.out.println("Invalid input, please enter an integer."); // Print an error message for invalid input
            }
        }
    }

    /**
     * Get a double value from the user.
     *
     * @param prompt the prompt message
     * @return the validated double value
     */
    public static double getDouble(String prompt) { // Define a method to get a double value
        while (true) { // Start an infinite loop
            System.out.print(prompt); // Print the prompt
            try { // Start a try-catch block to handle NumberFormatException
                return Double.parseDouble(scanner.nextLine()); // Read a double value from the user and return it
            } catch (NumberFormatException e) { // Catch NumberFormatException
                System.out.println("Invalid input, please enter a number."); // Print an error message for invalid input
            }
        }
    }

    /**
     * Get a double value from the user.
     *
     * @param prompt the prompt message
     * @return the validated double value
     */
    public static String getString(String prompt, String errorMessage) { // Define a method to get a string value
        while (true) { // Start an infinite loop
            System.out.print(prompt); // Print the prompt
            String input = scanner.nextLine(); // Read a string value from the user

            if (!input.equals("") && !input.equals(null)) { // Check if the input is not empty or null
                return input; // Return the input
            } else {
                System.out.println(errorMessage); // Print an error message for empty input
                return null; // Return null
            }
        }
    }

    /**
     * Get a character value from the user.
     *
     * @param prompt the prompt message
     * @return the validated character value
     */
    public static char getChar(String prompt) { // Define a method to get a character value
        while (true) { // Start an infinite loop
            System.out.print(prompt); // Print the prompt
            String input = scanner.nextLine(); // Read a string value from the user
            if (input.length() != 1) { // Check if the input length is not 1
                System.out.println("Invalid input, please enter a single character."); // Print an error message for invalid input
            } else {
                return input.charAt(0); // Return the first character of the input string
            }
        }
    }

    /**
     * Get a boolean value from the user.
     *
     * @param prompt the prompt message
     * @return the validated boolean value
     */
    public static boolean getBoolean(String prompt) { // Define a method to get a boolean value
        while (true) { // Start an infinite loop
            System.out.print(prompt); // Print the prompt
            String input = scanner.nextLine().toLowerCase(); // Read a string value from the user and convert it to lowercase
            if (input.equals("true") || input.equals("yes") || input.equals("y")) { // Check if the input is true, yes, or y
                return true; // Return true
            } else if (input.equals("false") || input.equals("no") || input.equals("n")) { // Check if the input is false, no, or n
                return false; // Return false
            } else {
                System.out.println("Invalid input, please enter 'true' or 'false'."); // Print an error message for invalid input
            }
        }
    }

    /**
     * Read a positive integer value from the scanner.
     *
     * @param scanner the scanner object
     * @param prompt the prompt message
     * @return the validated positive integer value
     */
    public static int readPositiveInt(Scanner scanner, String prompt) { // Define a method to read a positive integer value
        int value = 0; // Initialize the value to 0
        while (value <= 0) { // Start a loop while the value is less than or equal to 0
            System.out.println(prompt); // Print the prompt
            if (scanner.hasNextInt()) { // Check if the scanner has a next integer
                value = scanner.nextInt(); // Read an integer value from the scanner
                if (value <= 0) { // Check if the value is less than or equal to 0
                    System.out.println("Value must be a positive integer!"); // Print an error message for invalid input
                }
            } else {
                System.out.println("Invalid input! Value must be a positive integer."); // Print an error message for invalid input
                scanner.next(); // Discard the invalid input
            }
        }
        return value; // Return the positive integer value
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
        String input;

        do {
            System.out.print(prompt); // Display the prompt to the user
            input = scanner.nextLine().trim(); // Read the user input and remove leading/trailing spaces

            // Check if the name is empty
            if (input.isEmpty()) {
                System.out.println(errorMessage); // Display the error message for empty input
                continue;
            }

            // Check if the name contains special characters or numbers
            if (!input.matches("^[a-zA-Z ]+$")) {
                System.out.println(errorMessage); // Display the error message for invalid characters
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
    public static String getStringWithPhoneFormat(String prompt, String errorMessage) {
        String input;
        do {
            System.out.print(prompt); // Display the prompt to the user
            input = scanner.nextLine().trim(); // Read the user input and remove leading/trailing spaces
            if (input.isEmpty() || !isValidPhoneNumber(input)) {
                System.out.println(errorMessage); // Display the error message for empty or invalid input
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
    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("(0[35789][0-9][0-9]{7})");
    }

    public static String getStringWithNumbers(String prompt, String errorMessage) {
        String input;

        do {
            System.out.print(prompt); // Display the prompt to the user
            input = scanner.nextLine().trim(); // Read the user input and remove leading/trailing spaces

            // Check if the input is empty
            if (input.isEmpty()) {
                System.out.println(errorMessage); // Display the error message for empty input
                continue;
            }

            // Check if the input contains special characters
            if (!input.matches("^[a-zA-Z0-9 ]+$")) {
                System.out.println(errorMessage); // Display the error message for invalid characters
                continue;
            }

            break;
        } while (true);
        return input;
    }

    /**
     * Check if a phone number is a duplicate in the list of contacts.
     *
     * @param phone the phone number to check
     * @param contacts the list of contacts
     * @return true if the phone number is a duplicate, false otherwise
     */
    public static boolean isDuplicatePhoneNumber(String phone, ArrayList<Contact> contacts) {
        for (Contact contact : contacts) {
            if (contact.getPhone().equals(phone)) {
                return true; // Phone number is a duplicate
            }
        }
        return false; // Phone number is not a duplicate
    }
}
