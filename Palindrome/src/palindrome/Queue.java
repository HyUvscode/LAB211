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
 * Queue class implements a basic queue data structure.
 */
public class Queue {
    private int maxSize;
    private char[] queueArray;
    private int front;
    private int rear;
    private int nItems;

    /**
     * Constructor for Queue class.
     *
     * @param maxSize the maximum size of the queue.
     */
    public Queue(int maxSize) {
        this.maxSize = maxSize;
        queueArray = new char[maxSize];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    /**
     * Enqueues an item at the rear of the queue.
     *
     * @param c the item to be enqueued.
     */
    public void enqueue(char c) {
        if (rear == maxSize - 1) {
            rear = -1;
        }
        rear++;
        queueArray[rear] = c;
        nItems++;
    }

    /**
     * Dequeues an item from the front of the queue.
     *
     * @return the item dequeued from the front of the queue.
     */
    public char dequeue() {
        char c = queueArray[front];
        front++;
        if (front == maxSize) {
            front = 0;
        }
        nItems--;
        return c;
    }

    /**
     * Checks whether the queue is empty.
     *
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        return (nItems == 0);
    }

    /**
     * Checks whether the queue is full.
     *
     * @return true if the queue is full, false otherwise.
     */
    public boolean isFull() {
        return (nItems == maxSize);
    }
}
