/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s10sortonedimensionalarraywithbubblesortalgorithm;

/**
 * Constructs a new ArrayUtils object.
 *
 * @author khuakhanhhuy
 */
public class ArrayUtils {

    private int[] arr;

    /**
     * Prompts the user to enter the number of elements in the array, and then
     * prompts the user to enter each element one-by-one. Each element entered
     * must be an integer. Invalid inputs will be rejected and the user will be
     * prompted to enter a valid input.
     */
    public void inputArray() {
        // Ask user to input the number of elements in the array
        int n = Validation.getInt("Enter the number of elements: ");

        // Create a new array of size n
        arr = new int[n];

        // Loop through the array and prompt user to enter each element
        for (int i = 0; i < n; i++) {
            arr[i] = Validation.getInt("Enter element ");

        }
    }

    /**
     * Sorts the array in ascending order using the bubble sort algorithm.
     */
    public void sortAscending() {
        int n = arr.length;

        // Perform bubble sort
        for (int i = 0; i < n - 1; i++) {
            // Check if the current element arr[i] is greater than the next element arr[j]
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    // Swap the positions of arr[i] and arr[j]
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * Sorts the array in descending order using the bubble sort algorithm.
     */
    public void sortDescending() {
        int n = arr.length;

        // Perform bubble sort
        for (int i = 0; i < n - 1; i++) {
            // Check if the current element arr[i] is less than the next element arr[j]
            for (int j = i + 1; j < n; j++) {
                // Swap the positions of arr[i] and arr[j]
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * Prints the given array to the console, with each element separated by a
     * space.
     */
    public void printArrayAscending() {
        // Check if the array is null or empty
        if (arr == null || arr.length == 0) {
            System.out.println("No element in the array.");
        } else {
            // Create a string to hold the formatted array representation
            String arrayString = "[" + arr[0];

            // Iterate through the array starting from the second element
            for (int i = 1; i < arr.length; i++) {
                // Append each element to the string separated by "->"
                arrayString += "] -> [" + arr[i];
            }

            // Add closing bracket to the string
            arrayString += "]";

            // Print the array representation to the console
            System.out.println(arrayString);
        }
    }

    /**
     * Prints the given array to the console, with each element separated by a
     * space, and an arrow pointing in the reverse direction.
     */
    public void printArrayDescending() {
        // Check if the array is null or empty
        if (arr == null || arr.length == 0) {
            System.out.println("No element in the array.");
        } else {
            // Create a string to hold the formatted array representation
            String arrayString = "[" + arr[0];

            // Iterate through the array starting from the second element
            for (int i = 1; i < arr.length; i++) {
                // Append each element to the string separated by "<-"
                arrayString += "] <- [" + arr[i];
            }

            // Add closing bracket to the string
            arrayString += "]";

            // Print the array representation to the console
            System.out.println(arrayString);
        }
    }
}
