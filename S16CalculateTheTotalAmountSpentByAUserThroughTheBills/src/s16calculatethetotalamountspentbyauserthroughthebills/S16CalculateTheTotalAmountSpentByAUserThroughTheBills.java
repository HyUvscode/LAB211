/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s16calculatethetotalamountspentbyauserthroughthebills;

import java.util.Scanner;

/**
 * This class represents the main program to calculate the total amount spent by
 * a user through the bills. It prompts the user to input the number of bills,
 * the values of each bill, and the value of the wallet. It then calculates the
 * total amount of bills and checks if the user can pay the total amount with
 * the wallet balance.
 *
 * @author khuakhanhhuy
 */
public class S16CalculateTheTotalAmountSpentByAUserThroughTheBills {

    public static void main(String[] args) {
        // Create a new Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Display the program title
        System.out.println("======= Shopping program ==========");

        // Prompt the user to input the number of bills
        int numberOfBills = Validation.readPositiveInt(scanner, "Input number of bills: ");

        // Create an array to store the values of the bills
        int[] bills = new int[numberOfBills];
        for (int i = 0; i < numberOfBills; i++) {
            // Prompt the user to input the value of each bill
            bills[i] = Validation.readPositiveInt(scanner, "Input value of bill " + (i + 1) + ": ");
        }

        // Prompt the user to input the value of the wallet
        int walletAmount = Validation.readPositiveInt(scanner, "Input value of wallet: ");

        // Create a Person object with the wallet amount
        Person person = new Person(walletAmount);

        // Calculate the total amount of bills
        int total = person.calcTotal(bills);

        System.out.println("======= Shopping program ==========");

        // Display the total amount of bills
        System.out.println("This is the total of bills: " + total);

        // Check if the user can pay the total amount with the wallet balance
        if (person.payMoney(total)) {
            System.out.println("You can buy it.");
        } else {
            System.out.println("You can't buy it.");
        }
    }

}
