package l03;

/**
 * The Fruit class represents a fruit object with properties such as fruit ID, name, price, quantity, and origin.
 * This class provides getters and setters for accessing and modifying the fruit's attributes.
 *
 * @author khuakhanhhuy
 */
public class Fruit {
    private String fruitId; // The unique ID of the fruit.
    private String fruitName; // The name of the fruit.
    private double price; // The price of the fruit.
    private int quantity; // The quantity of the fruit.
    private String origin; // The origin of the fruit.

    /**
     * Constructs a default Fruit object.
     */
    public Fruit() {
    }

    /**
     * Constructs a Fruit object with the specified attributes.
     *
     * @param fruitId    the ID of the fruit
     * @param fruitName  the name of the fruit
     * @param price      the price of the fruit
     * @param quantity   the quantity of the fruit
     * @param origin     the origin of the fruit
     */
    public Fruit(String fruitId, String fruitName, double price, int quantity, String origin) {
        this.fruitId = fruitId;
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    /**
     * Retrieves the fruit ID.
     *
     * @return the fruit ID
     */
    public String getFruitId() {
        return fruitId;
    }

    /**
     * Sets the fruit ID.
     *
     * @param fruitId the fruit ID to set
     */
    public void setFruitId(String fruitId) {
        this.fruitId = fruitId;
    }

    /**
     * Retrieves the fruit name.
     *
     * @return the fruit name
     */
    public String getFruitName() {
        return fruitName;
    }

    /**
     * Sets the fruit name.
     *
     * @param fruitName the fruit name to set
     */
    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    /**
     * Retrieves the price of the fruit.
     *
     * @return the fruit price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the price of the fruit.
     *
     * @param price the fruit price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Retrieves the quantity of the fruit.
     *
     * @return the fruit quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the fruit.
     *
     * @param quantity the fruit quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Retrieves the origin of the fruit.
     *
     * @return the fruit origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Sets the origin of the fruit.
     *
     * @param origin the fruit origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

}
