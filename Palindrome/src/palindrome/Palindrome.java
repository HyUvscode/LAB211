/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

import java.util.Scanner;

/**
 *
 * @author khuakhanhhuy
 */

/**
 * Palindrome class for running the palindrome checker.
 */

public class Palindrome {

    /**
     * Runs the palindrome checker program.
     *
     * @param args command line arguments (not used).
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        boolean isPalindrome = PalindromeChecker.isPalindrome(str);
        if (isPalindrome) {
            System.out.println(str + " is a palindrome!");
        } else {
            System.out.println(str + " is not a palindrome.");
        }
    }

}
