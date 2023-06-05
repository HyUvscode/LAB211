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
public class S02SelectionSort {

    /**
     * The main method of the program.
     */
    public static void main(String[] args) {

        // create a scanner object to read input from the console
        Scanner scanner = new Scanner(System.in);

        // read the length of the array from the user
        int length = Validation.readPositiveInt(scanner, "Enter number of array:");

        // create an instance of the Algorithm class with the specified length
        Algorithm sortAlgorithm = new Algorithm(length);

        // display the Unsorted array
        System.out.println("Unsorted array: "  + sortAlgorithm.toString());

        // sort the array using the selection sort algorithm
        sortAlgorithm.selectionSort();
        
        // display the sorted array
        System.out.println("Sorted array: " + sortAlgorithm.toString());

        // close the scanner object to prevent resource leaks
        scanner.close();
    }

}
