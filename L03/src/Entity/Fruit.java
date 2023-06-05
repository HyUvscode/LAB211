/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 * Class representing a fruit.
 *
 * @author khuakhanhhuy
 */
public class Fruit {

    private String fruitId; // ID of the fruit
    private String fruitName; // Name of the fruit
    private double price; // Price of the fruit
    private int quantity; // Quantity of the fruit
    private String origin; // Origin of the fruit

    /**
     * Constructs a new Fruit object.
     *
     * @param fruitId the ID of the fruit
     * @param fruitName the name of the fruit
     * @param price the price of the fruit
     * @param quantity the quantity of the fruit
     * @param origin the origin of the fruit
     */
    public Fruit(String fruitId, String fruitName, double price, int quantity, String origin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    /**
     * Returns the ID of the fruit.
     *
     * @return the ID of the fruit
     */
    public String getFruitId() {
        return fruitId;
    }

    /**
     * Sets the ID of the fruit.
     *
     * @param fruitId the ID of the fruit
     */
    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    /**
     * Returns the name of the fruit.
     *
     * @return the name of the fruit
     */
    public String getFruitName() {
        return fruitName;
    }

    /**
     * Sets the name of the fruit.
     *
     * @param fruitName the name of the fruit
     */
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    /**
     * Returns the price of the fruit.
     *
     * @return the price of the fruit
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the fruit.
     *
     * @param price the price of the fruit
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the quantity of the fruit.
     *
     * @return the quantity of the fruit
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the fruit.
     *
     * @param quantity the quantity of the fruit
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the origin of the fruit.
     *
     * @return the origin of the fruit
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the origin of the fruit.
     *
     * @param origin the origin of the fruit
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

}
