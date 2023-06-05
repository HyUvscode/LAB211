/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s06fibonacci;

/**
 *
 * @author khuakhanhhuy
 */
public class FibonacciSequence {

    private int[] sequence;

    /**
     *
     * Constructs a new Fibonacci sequence with the specified number of terms.
     *
     * @param n the number of terms in the sequence to generate
     */
    public FibonacciSequence(int n) {
        sequence = new int[n];
        for (int i = 0; i < n; i++) {
            sequence[i] = FibonacciSequence(i);
        }
    }

    /**
     *
     * Recursively generates the nth term in the Fibonacci sequence.
     *
     * @param n the term to generate
     * @return the nth term in the Fibonacci sequence
     */
    private int FibonacciSequence(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return FibonacciSequence(n - 1) + FibonacciSequence(n - 2);
        }
    }

    /**
     *
     * Prints the generated Fibonacci sequence to the console.
     */
    public void printSequence() {
        for (int i = 0; i < sequence.length; i++) {
            System.out.print(sequence[i] + " ");
        }
        System.out.println();
    }
}
