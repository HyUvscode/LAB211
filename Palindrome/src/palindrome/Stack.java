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
 * Stack class implements a basic stack data structure.
 */
public class Stack {
    private int maxSize;
    private char[] stackArray;
    private int top;

    /**
     * Constructor for Stack class.
     *
     * @param maxSize the maximum size of the stack.
     */
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        stackArray = new char[maxSize];
        top = -1;
    }

    /**
     * Pushes an item onto the top of the stack.
     *
     * @param c the item to be pushed onto the stack.
     */
    public void push(char c) {
        if (top == maxSize - 1) {
            System.out.println("Stack overflow!");
            return;
        }
        top++;
        stackArray[top] = c;
    }

    /**
     * Pops an item from the top of the stack.
     *
     * @return the item popped from the top of the stack.
     */
    public char pop() {
        if (top == -1) {
            System.out.println("Stack underflow!");
            return '\0';
        }
        char c = stackArray[top];
        top--;
        return c;
    }

    /**
     * Checks whether the stack is empty.
     *
     * @return true if the stack is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * Checks whether the stack is full.
     *
     * @return true if the stack is full, false otherwise.
     */
    public boolean isFull() {
        return (top == maxSize - 1);
    }
}
