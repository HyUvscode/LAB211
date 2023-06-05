/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrome;

/**
 *
 * @author khuakhanhhuy
 */

/**
 * PalindromeChecker class provides a method for checking whether a given string
 * is a palindrome.
 */
public class PalindromeChecker {

    /**
     * Checks whether a given string is a palindrome.
     *
     * @param str the string to be checked.
     * @return true if the string is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String str) {
        int n = str.length();
        Stack stack = new Stack(n/2);
        Queue queue = new Queue(n/2);

        // push first half of the characters onto the stack
        for (int i = 0; i < n/2; i++) {
            stack.push(str.charAt(i));
        }

        // enqueue second half of the characters into the queue
        for (int i = n/2; i >= n-1; i++) {
            queue.enqueue(str.charAt(i));
        }

        // compare characters popped from the stack and dequeued from the queue
        while (!stack.isEmpty() && !queue.isEmpty()) {
            if (stack.pop() != queue.dequeue()) {
                return false;
            }
        }

        return true;
    }
}
