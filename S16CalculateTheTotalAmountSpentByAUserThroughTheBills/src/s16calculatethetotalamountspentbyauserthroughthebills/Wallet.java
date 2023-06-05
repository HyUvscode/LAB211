/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s16calculatethetotalamountspentbyauserthroughthebills;

/**
 * This class represents a Wallet that stores the amount of money.
 *
 * @author khuakhanhhuy
 */
public class Wallet {

    private int amount;  // Declare a private variable 'amount' to store the amount of money in the wallet

    /**
     * Constructor for Wallet class that takes 'amount' as input. Initializes
     * the 'amount' variable with the given 'amount'.
     *
     * @param amount the amount of money in the wallet
     */
    public Wallet(int amount) {  // Constructor for Wallet class that takes 'amount' as input
        this.amount = amount;  // Assign the value of 'amount' to the 'amount' variable of the wallet object
    }

    /**
     * Checks if the wallet has enough money to pay the given 'total' amount.
     *
     * @param total the total amount to be paid
     * @return true if the wallet has enough money, false otherwise
     */
    public boolean payMoney(int total) {  // Method to check if the wallet has enough money to pay the given 'total' amount
        return amount >= total;  // Return true if the 'amount' in the wallet is greater than or equal to the 'total' amount, otherwise return false
    }

}
