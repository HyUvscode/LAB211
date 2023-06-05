/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s10sortonedimensionalarraywithbubblesortalgorithm;

import java.util.Scanner;

/**
 *
 * @author khuakhanhhuy
 */
/**
 * A utility class for validating user input.
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
}
