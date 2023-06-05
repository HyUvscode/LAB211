/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 * Class representing an order for a fruit.
 *
 * @author khuakhanhhuy
 */
public class Order {

    private String fruitId; // ID of the fruit in the order
    private String fruitName; // Name of the fruit in the order
    private int quantity; // Quantity of the fruit in the order
    private double price; // Price of the fruit in the order

    /**
     * Constructs a new Order object.
     *
     * @param fruitId the ID of the fruit in the order
     * @param fruitName the name of the fruit in the order
     * @param quantity the quantity of the fruit in the order
     * @param price the price of the fruit in the order
     */
    public Order(String fruitId, String fruitName, int quantity, double price) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.quantity = quantity;
        this.price = price;
    }

    /**
     * Returns the ID of the fruit in the order.
     *
     * @return the ID of the fruit in the order
     */
    public String getFruitId() {
        return fruitId;
    }

    /**
     * Sets the ID of the fruit in the order.
     *
     * @param fruitId the ID of the fruit in the order
     */
    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    /**
     * Returns the name of the fruit in the order.
     *
     * @return the name of the fruit in the order
     */
    public String getFruitName() {
        return fruitName;
    }

    /**
     * Sets the name of the fruit in the order.
     *
     * @param fruitName the name of the fruit in the order
     */
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    /**
     * Returns the quantity of the fruit in the order.
     *
     * @return the quantity of the fruit in the order
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the fruit in the order.
     *
     * @param quantity the quantity of the fruit in the order
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the price of the fruit in the order.
     *
     * @return the price of the fruit in the order
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the fruit in the order.
     *
     * @param price the price of the fruit in the order
     */
    public void setPrice(double price) {
        this.price = price;
    }

}
