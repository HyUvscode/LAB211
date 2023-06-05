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
public class S10SortOneDimensionalArrayWithBubbleSortAlgorithm {

    /**
     * This method displays a menu and allows the user to choose what to do with
     * the array.
     */
    public static void main(String[] args) {
        // Initialize necessary objects
        ArrayUtils arrayUtils = new ArrayUtils();
        Scanner scanner = new Scanner(System.in);
        String choice;
        boolean arrayInitialized = false; // flag to check if array has been initialized
        while (true) {
            //print menu
            System.out.println("========= Bubble Sort program =========");
            System.out.println("1. Input items of the array");
            System.out.println("2. Sort the array in ascending order");
            System.out.println("3. Sort the array in descending order");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    // Input the array
                    System.out.println("----- Input Element -----");
                    arrayUtils.inputArray();
                    arrayInitialized = true;
                    break;
                case "2":
                    // Sort the array in ascending order
                    if (!arrayInitialized) {
                        System.out.println("No element in the array.");
                        break;
                    }
                    arrayUtils.sortAscending();
                    System.out.println("----- Ascending -----");
                    arrayUtils.printArrayAscending();
                    break;
                case "3":
                    // Sort the array in descending order
                    if (!arrayInitialized) {
                        System.out.println("No element in the array.");
                        break;
                    }
                    arrayUtils.sortDescending();
                    System.out.println("----- Descending -----");
                    arrayUtils.printArrayDescending();
                    break;
                case "4":
                    // Exit the program
                    System.out.println("Goodbye!");
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please Please enter 1, 2, 3, or 4.");
                    break;
            }
            if (choice.equals("4")) {
                // Exit the loop when the user chooses to exit
                break;
            }
        }
        scanner.close();
    }

}
