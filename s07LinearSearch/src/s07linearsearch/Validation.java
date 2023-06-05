/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s07linearsearch;

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
     * Validate an integer input within a specified range.
     *
     * @param input the scanner object
     * @param prompt the prompt message
     * @param min the minimum value of the range
     * @param max the maximum value of the range
     * @return the validated integer value within the specified range
     */
    public static int validateIntRange(Scanner input, String prompt, int min, int max) { // Define a method to validate an integer input within a specified range
        int value = 0; // Initialize the value to 0
        boolean valid = false; // Initialize the valid flag to false

        while (!valid) { // Start a loop while the valid flag is false
            System.out.print(prompt); // Print the prompt
            if (input.hasNextInt()) { // Check if the input has a next integer
                value = input.nextInt(); // Read an integer value from the input
                if (value >= min && value <= max) { // Check if the value is between the specified range
                    valid = true; // Set the valid flag to true
                } else {
                    System.out.println("Error: value must be between " + min + " and " + max); // Print an error message for invalid input
                }
            } else {
                input.next(); // Discard the invalid input
                System.out.println("Error: invalid input"); // Print an error message for invalid input
            }
        }

        return value; // Return the validated integer value
    }

    /**
     * Validate a string input that is not empty.
     *
     * @param input the scanner object
     * @param prompt the prompt message
     * @return the validated non-empty string value
     */
    public static String validateStringNotEmpty(Scanner input, String prompt) { // Define a method to validate a string input that is not empty
        String value = ""; // Initialize the value to an empty string
        boolean valid = false; // Initialize the valid flag to false

        while (!valid) { // Start a loop while the valid flag is false
            System.out.print(prompt); // Print the prompt
            value = input.nextLine().trim(); // Read a line of input and remove leading/trailing whitespace
            if (!value.isEmpty()) { // Check if the value is not empty
                valid = true; // Set the valid flag to true
            } else {
                System.out.println("Error: value cannot be empty"); // Print an error message for empty input
            }
        }

        return value; // Return the validated string value
    }

    /**
     * Validate an option input within a specified list of options.
     *
     * @param input the scanner object
     * @param prompt the prompt message
     * @param options the list of valid options
     * @return the validated option value
     */
    public static String validateOptionInput(Scanner input, String prompt, String[] options) { // Define a method to validate an option input within a specified list of options
        String value = ""; // Initialize the value to an empty string
        boolean valid = false; // Initialize the valid flag to false

        while (!valid) { // Start a loop while the valid flag is false
            System.out.print(prompt); // Print the prompt
            value = input.nextLine().trim(); // Read a line of input and remove leading/trailing whitespace
            for (String option : options) { // Iterate over the options
                if (option.equalsIgnoreCase(value)) { // Check if the option matches the value (case-insensitive)
                    valid = true; // Set the valid flag to true
                    break; // Exit the loop
                }
            }
            if (!valid) {
                System.out.println("Error: invalid input"); // Print an error message for invalid input
            }
        }

        return value; // Return the validated option value
    }
}
