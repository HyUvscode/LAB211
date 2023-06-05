/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s07linearsearch;

import java.util.Scanner;

/**
 * A class that demonstrates the linear search algorithm.
 *
 * @author khuakhanhhuy
 */
public class S07LinearSearch {

    /**
     * The main method of the program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a new Scanner object for user input

        int n = Validation.readPositiveInt(scanner, "Enter the number of elements in the array: "); // Read the number of elements in the array from the user

        Algorithm sortAlgorithm = new Algorithm(n); // Create an instance of Algorithm with the specified length

        int searchValue = Validation.readPositiveInt(scanner, "Enter the value to search for: "); // Read the value to search for from the user
        int resultIndex = sortAlgorithm.linearSearch(searchValue); // Perform linear search on the array

        System.out.println("The array: " + sortAlgorithm.toString()); // Display the array
        if (resultIndex == -1) {
            System.out.println("Searched value is absent"); // Display a message if the searched value is not found
        } else {
            System.out.println("Value " + searchValue + " at index: " + resultIndex); // Display the index of the searched value if found
        }

        scanner.close(); // Close the scanner object
    }
}
