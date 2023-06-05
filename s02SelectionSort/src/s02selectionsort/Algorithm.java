package s02selectionsort;

import java.util.Arrays;
import java.util.Random;

/**
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates and open the template
 * in the editor.
 *
 * @author khuakhanhhuy
 */
public class Algorithm {

    private int[] array;

    /**
     * Constructs a new instance of the SortAlgorithm class with a randomly
     * generated array of the given length.
     *
     * @param length the length of the array to generate
     */
    public Algorithm(int length) {
        this.array = new int[length];
        generateRandomArray();
    }

    /**
     * Generates a new random array of the given length.
     *
     */
    private void generateRandomArray() {
        Random random = new Random();

        for (int i = 0; i < this.array.length; i++) {
            // Generate a random integer between 1 and 2 times the length
            array[i] = random.nextInt(this.array.length * 2) + 1;
        }
    }

    /**
     * Sorts the array in ascending order using the selection sort algorithm.
     */
    public void selectionSort() {
        int n = this.array.length;

        // Traverse through the array elements
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the minimum element in the unsorted part of the array
            for (int j = i + 1; j < n; j++) {
                if (this.array[j] < this.array[minIndex]) {
                    // Found a smaller element, update the index of the minimum element
                    minIndex = j;
                }
            }

            // Swap the minimum element with the first element of the unsorted part of the array
            int temp = this.array[i];
            this.array[i] = this.array[minIndex];
            this.array[minIndex] = temp;
        }
    }

    /**
     * Returns a string representation of the array.
     *
     * @return a string representation of the array
     */
    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
