/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s07linearsearch;

import java.util.Random;
import java.util.Arrays;

/**
 *
 * @author khuakhanhhuy
 */
public class Algorithm {

    private int[] array;

    /**
     * Constructs a new Algorithm object with the specified length. The array is
     * initialized with random integers between 1 and 2*length, and then sorted
     * in ascending order.
     *
     * @param length the length of the array to be created
     */
    public Algorithm(int length) {
        // Create a new array of the specified length
        this.array = new int[length];
        // Generate random integers and populate the array
        generateRandomArray();
        // Sort the array in ascending order
        Arrays.sort(array);
    }

    /**
     * Generates an array of random integers between 1 and 2*length.
     */
    private void generateRandomArray() {
        // Create a new Random object
        Random random = new Random();
        // Iterate over the array
        for (int i = 0; i < array.length; i++) {
            // Generate a random integer between 1 and 2*length and assign it to the current element of the array
            array[i] = random.nextInt(array.length * 2) + 1;
        }
    }

    /**
     * Performs a linear search on the array to find the specified value.
     * Returns the index of the first occurrence of the value in the array, or
     * -1 if the value is not found.
     *
     * @param value the value to search for in the array
     * @return the index of the first occurrence of the value in the array, or
     * -1 if the value is not found
     */
    public int linearSearch(int value) {
        // Iterate over the array
        for (int i = 0; i < array.length; i++) {
            // Check if the current element is equal to the specified value
            if (array[i] == value) {
                // Return the index of the first occurrence of the value
                return i;
            }
        }
        // Value not found in the array, return -1
        return -1;
    }

    /**
     * Returns a string representation of the array.
     *
     * @return a string representation of the array
     */
    public String toString() {
        // Use the Arrays.toString() method to convert the array to a string representation
        return Arrays.toString(array);
    }
}
