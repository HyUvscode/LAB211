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
/**
 * This class demonstrates the generation of a Fibonacci sequence.
 */
public class S06Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an instance of FibonacciSequence with the specified length
        FibonacciSequence fibonacciSequence = new FibonacciSequence(45);

        // Print the Fibonacci sequence
        System.out.println("The 45 sequence Fibonacci:");
        fibonacciSequence.printSequence();
    }

}
