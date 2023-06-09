/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import Entity.Fruit;
import Entity.Order;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * Manager class that contains methods related to managing the program's
 * functionality.
 *
 * @author khuakhanhhuy
 */
public class Manager {

    private ArrayList<Fruit> lf;
    private ArrayList<Order> lo;
    private Hashtable<String, ArrayList<Order>> ht;

    public Manager() {
        lf = new ArrayList<>();
        lo = new ArrayList<>();
        ht = new Hashtable<>();
    }

    /**
     * Displays the menu and gets the user's choice.
     *
     * @return the user's choice
     */
    public int menu() {
        //loop until user want to exit
        System.out.println("1. Create Fruit"); // Option 1: Allows the user to create a new fruit
        System.out.println("2. View orders"); // Option 2: Displays the orders
        System.out.println("3. Shopping (for buyer)"); // Option 3: Allows the user to perform shopping
        System.out.println("4. Auto add fruit"); //Option 4: Auto add fruit
        System.out.println("5. Exit"); // Option 5: Exits the program
        System.out.print("Enter your choice: ");
        int choice = Validation.checkInputIntLimit(1, 5); // Retrieves the user's choice and validates it within the range 1-5
        return choice;
    }

    /**
     * Allows the user to create a new fruit.
     *
     * @param lf the list of fruits
     */
    public void createFruit() {
        //loop until user doesn't want to create fruit
        while (true) {
            String fruitId = Validation.getStringWithNumbers("Enter fruit ID: ", "Error: The input address should only contain letters and numbers.");
            //check if the fruit ID already exists
            if (!Validation.checkIdExist(lf, fruitId)) {
                System.err.println("Id exists"); // Prints an error message if the ID already exists
                return;
            }
            String fruitName = Validation.getStringWithNumbers("Enter fruit name: ", "Error: The input address should only contain letters and numbers.");
            double price = Validation.getDouble("Enter price:"); // Prompt for the price of the fruit
            int quantity = Validation.getInt("Enter quantity: "); // Prompt for the quantity of the fruit

            System.out.println("Select origin type:");
            System.out.println("1. Domestic");
            System.out.println("2. International");
            System.out.print("Enter your choice: ");
            int optionOrigin = Validation.checkInputIntLimit(1, 2); // Validate and get the user's choice for the origin type

            String origin;
            if (optionOrigin == 1) {
                origin = Validation.getOriginInDomestic("Enter origin in domestic: ", "Error: The input origin should only contain letters and spaces.");
            } else {
                origin = Validation.getOriginInInternational("Enter origin in international: ", "Error: The input origin should only contain letters and spaces.");
            }

            lf.add(new Fruit(fruitId, fruitName, price, quantity, origin)); // Create a new Fruit object with the entered information and add it to the list of fruits

            //check if the user wants to continue creating more fruits or not
            if (!Validation.checkInputYN()) {
                System.out.println("Add successful");
                return;
            }

        }
    }

    /**
     * Allows the user to view the orders.
     *
     * @param lf the list of fruits
     * @param ht the hashtable to store orders by customer
     */
    public void viewOrder() {
        // Check if there are no customers
        if (ht.isEmpty()) {
            System.err.println("No customers found.");
            return;
        }

        // Iterate through each customer in the hashtable
        for (String name : ht.keySet()) {
            System.out.println("Customer: " + name); // Display the name of the customer
            lo = ht.get(name); // Get the list of orders for the current customer

            // Check if the customer has any orders
            if (lo.isEmpty()) {
                System.out.println("No orders found.");
            } else {
                displayListOrder(); // Display the list of orders for the current customer
            }
        }
    }

    /**
     * Allows the user to perform shopping.
     *
     * @param lf the list of fruits
     * @param ht the hashtable to store orders by customer
     */
    public void shopping() {
        //check if the list of fruits is empty, user can't buy
        if (lf.isEmpty()) {
            System.err.println("No items available. Please add items to the shop.");
            return;
        }
        // Check if all fruits are out of stock
        if (Validation.areAllItemsOutOfStock(lf)) {
            System.err.println("All items are out of stock. Thank you for shopping!");
            return;
        }
        //loop until user doesn't want to continue buying
       lo = new ArrayList<>();
        while (true) {
            displayListFruit(); // Display the list of available fruits
            System.out.print("Enter item: ");
            int item = Validation.checkInputIntLimit(1, Validation.getFruitListSize(lf)); // Get the selected item index
            Fruit fruit = getFruitByItem(item); // Get the selected fruit from the list
            System.out.print("Enter quantity: ");
            int quantity = Validation.checkInputIntLimit(1, fruit.getQuantity()); // Get the desired quantity
            fruit.setQuantity(fruit.getQuantity() - quantity); // Update the fruit's quantity

            //check if the item exists in the order list or not
            if (!Validation.checkItemExist(lo, fruit.getFruitId())) {
                updateOrder(fruit.getFruitId(), quantity); // Update the existing order with the new quantity
            } else {
                lo.add(new Order(fruit.getFruitId(), fruit.getFruitName(),
                        quantity, fruit.getPrice())); // Create a new order for the item
            }

            if (!Validation.checkInputYN()) {
                break; // Break the loop if the user doesn't want to continue buying
            } else {
                // Check if all fruits are out of stock
                if (Validation.areAllItemsOutOfStock(lf)) {
                    System.err.println("All items are out of stock. Thank you for shopping!");
                    break;
                }
            }
        }
        displayListOrder(); // Display the list of orders made by the user
        String name = Validation.getStringOrigin("Enter name: ", "Error: The input name should only contain letters and spaces.");
        String[] nameParts = name.split(" "); // Split the input name into an array of parts
        StringBuilder sb = new StringBuilder(); // Create a StringBuilder to build the capitalized name

        for (String part : nameParts) {
            if (!part.isEmpty()) {
                // Capitalize the first letter of each part and append it to the StringBuilder
                sb.append(Character.toUpperCase(part.charAt(0))).append(part.substring(1)).append(" ");
            }
        }

        name = sb.toString().trim(); // Convert the StringBuilder to a string and trim any leading/trailing spaces
        // Check if the customer's name already exists in the hashtable
        if (ht.containsKey(name)) {
            ArrayList<Order> exitOrders = ht.get(name); // Retrieve the existing list of orders
            exitOrders.addAll(lo); // Append the new orders to the existing list
        } else {
            ht.put(name, lo); // Add the list of orders to the hashtable with the given name
        }
        System.out.println("Add successful");
    }

    /**
     * Displays the list of fruits in the shop.
     *
     * @param lf the list of fruits
     */
    public void displayListFruit() {
        // Initialize a counter to keep track of the item number
        int countItem = 1;

        // Print the header of the list
        System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");

        // Iterate over each Fruit object in the ArrayList
        for (Fruit fruit : lf) {
            // Check if the shop has the item in stock or not
            if (fruit.getQuantity() != 0) {
                // Print the details of the fruit in a formatted manner
                System.out.printf("%-10d%-20s%-20s%-15.0f$\n", countItem++,
                        fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
            }
        }
    }

    /**
     * Gets the fruit selected by the user.
     *
     * @param lf the list of fruits
     * @param item the selected item
     * @return the fruit selected by the user
     */
    public Fruit getFruitByItem(int item) {
        // Initialize a counter to keep track of the item number
        int countItem = 1;

        // Iterate over each Fruit object in the ArrayList
        for (Fruit fruit : lf) {
            // Check if the shop has the item in stock or not
            if (fruit.getQuantity() != 0) {
                // Increment the counter if the item is available
                countItem++;
            }

            // Check if the current item's number matches the specified item
            if (countItem - 1 == item) {
                // Return the Fruit object if the item is found
                return fruit;
            }
        }

        // Return null if the item is not found
        return null;
    }

    /**
     * Displays the list of orders.
     *
     * @param lo the list of orders
     */
    public void displayListOrder() {
        // Initialize a variable to keep track of the total amount
        double total = 0;

        // Print the header of the list
        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");

        // Iterate over each Order object in the ArrayList
        for (Order order : lo) {
            // Print the details of the order in a formatted manner
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", order.getFruitName(),
                    order.getQuantity(), order.getPrice(),
                    order.getPrice() * order.getQuantity());

            // Update the total amount by adding the current order's amount
            total += order.getPrice() * order.getQuantity();
        }

        // Print the total amount
        System.out.println("Total: " + total);
    }

    /**
     * If the order exists, updates the order; otherwise, adds a new order.
     *
     * @param lo the list of orders
     * @param id the ID of the fruit
     * @param quantity the quantity of the fruit
     */
    public void updateOrder(String id, int quantity) {
        // Iterate over each Order object in the ArrayList
        for (Order order : lo) {
            // Check if the fruit ID of the current order matches the given ID
            if (order.getFruitId().equalsIgnoreCase(id)) {
                // Update the quantity of the order by adding the given quantity
                order.setQuantity(order.getQuantity() + quantity);
                return; // Exit the method after updating the order
            }
        }
    }

    /**
     * Automatically adds a specified number of fruits to the fruit list.
     *
     * @param lf the list of fruits
     * @param ht the hashtable of orders
     */
    public void autoAddFruit() {
        int numOfFruitsToAdd = Validation.getInt("Enter the number of fruits to add: ");

        for (int i = 1; i <= numOfFruitsToAdd; i++) {
            String fruitId = String.format("%03d", i); // Generate the fruit ID with leading zeros

            // Check if the ID already exists in the list
            if (Validation.checkIdExist(lf, fruitId)) {
                String fruitName = "Fruit " + i; // Create the fruit name
                double price = i * 0.5; // Calculate the fruit price
                int quantity = i * 5; // Calculate the fruit quantity
                String origin = "Origin " + i; // Create the fruit origin

                Fruit fruit = new Fruit(fruitId, fruitName, price, quantity, origin); // Create a new Fruit object
                lf.add(fruit); // Add the fruit to the list of fruits
            } else {
                System.out.println("ID already exists: " + fruitId + ". Skipping...");
            }
        }
    }

}
