/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s16calculatethetotalamountspentbyauserthroughthebills;

/**
 * This class represents a Person who has a Wallet to store their money.
 * 
 * @author khuakhanhhuy
 */
public class Person {

    private Wallet wallet;  // Declare a private variable 'wallet' of type Wallet

    /**
     * Constructor for Person class that takes 'walletAmount' as input.
     * Initializes the 'wallet' variable with a new Wallet object using the
     * given 'walletAmount'.
     *
     * @param walletAmount the amount of money in the wallet
     */
    public Person(int walletAmount) {  // Constructor for Person class that takes 'walletAmount' as input
        wallet = new Wallet(walletAmount);  // Create a new Wallet object with the given 'walletAmount' and assign it to the 'wallet' variable
    }

    /**
     * Calculates the total amount of bills from the given array.
     *
     * @param bills an array of bill amounts
     * @return the total amount of bills
     */
    public int calcTotal(int[] bills) {  // Method to calculate the total amount of bills
        int total = 0;  // Initialize the 'total' variable to 0
        for (int bill : bills) {  // Iterate through each element 'bill' in the 'bills' array
            total += bill;  // Add the value of 'bill' to the 'total' variable
        }
        return total;  // Return the calculated total amount of bills
    }

    /**
     * Checks if the wallet has enough money to pay the given 'total' amount.
     *
     * @param total the total amount to be paid
     * @return true if the wallet has enough money, false otherwise
     */
    public boolean payMoney(int total) {  // Method to check if the wallet has enough money to pay the given 'total' amount
        return wallet.payMoney(total);  // Call the 'payMoney' method of the 'wallet' object and return its result
    }

}
