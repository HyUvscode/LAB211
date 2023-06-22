package l03;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * The Manager class handles the management of fruits, including creating
 * fruits, displaying fruit lists, shopping, and viewing orders. It uses the
 * Validation class for input Validation. It maintains a list of fruits, a
 * hashtable of orders, and an instance of the Validation class.
 *
 * @author khuakhanhhuy
 */
public class Manager {

    List<Fruit> fruits = new ArrayList<>();
    Hashtable<String, ArrayList<Fruit>> orders = new Hashtable<>();

    /**
     * Prompts the user to create a new fruit by entering its details. The
     * created fruit is added to the fruit list.
     */
    public void createFruit() {
        while (true) {
            String fruitId = Validation.getStringWithNumbers("Enter fruit id:", "Error: The input fruit id should only contain letters and numbers.");

            if (getFruitById(fruitId) != null) {
                System.err.println("ID is already taken.");
                continue;
            }

            String fruitName = Validation.getStringWithNumbers("Enter name:", "Error: The input address should only contain letters and numbers.");
            double price = Validation.inputDouble("Enter price:", 1, Double.MAX_VALUE);
            int quantity = Validation.inputInt("Enter quantity:", 1, Integer.MAX_VALUE);

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
            fruits.add(new Fruit(fruitId, fruitName, price, quantity, origin));
            if (!Validation.checkInputYN("Do you want to continue? (Y/N)")) {
                break;
            }
        }
    }

    /**
     * Displays the list of available fruits to the user.
     *
     * @return the selected item number, or -1 if the list is empty
     */
    public int displayListFruit() {
        int countItem = 0;
        if (fruits.isEmpty()) {
            return -1;
        }
        for (Fruit fruit : fruits) {
            if (fruit.getQuantity() != 0) {
                countItem++;
                if (countItem == 1) {
                    System.out.printf("%-10s%-20s%-20s%-15s\n", "Item", "Fruit name", "Origin", "Price");
                }
                System.out.printf("%-10d%-20s%-20s%-15.0f$\n", countItem,
                        fruit.getFruitName(), fruit.getOrigin(),
                        fruit.getPrice());
            }
        }
        if (countItem == 0) {
            return -1;
        }
        int item = Validation.inputInt("Enter item:", 1, countItem);
        return item;
    }

    /**
     * Retrieves the fruit object based on the selected item number.
     *
     * @param item the selected item number
     * @return the Fruit object corresponding to the selected item, or null if
     * not found
     */
    public Fruit getFruit(int item) {
        int count = 0;
        for (Fruit fruit : fruits) {
            if (fruit.getQuantity() != 0) {
                count++;
            }
            if (item == count) {
                return fruit;
            }
        }
        return null;
    }

    /**
     * Checks if a fruit with the specified ID exists in the provided list of
     * orders.
     *
     * @param listOrder the list of orders to check
     * @param id the ID of the fruit to search for
     * @return the Fruit object with the specified ID, or null if not found
     */
    public Fruit checkFruitInOrder(ArrayList<Fruit> listOrder, String id) {
        for (Fruit fruit : listOrder) {
            if (fruit.getFruitId().equalsIgnoreCase(id)) {
                return fruit;
            }
        }
        return null;
    }

    /**
     * Handles the shopping process, allowing the user to select and order
     * fruits. The ordered fruits are added to the orders hashtable.
     */
    public void shopping() {
        ArrayList<Fruit> listOrder = new ArrayList<>();
        while (true) {
            int item = displayListFruit();
            if (item == -1) {
                System.out.println("Out of stock.");
                if (listOrder.isEmpty()) {
                    System.out.println("No orders.");
                } else {
                    displayListOrder(listOrder);
                    String name = setName();
                    orders.put(name, listOrder);
                }
                return;
            }
            Fruit fruit = getFruit(item);
            System.out.println("You selected: " + fruit.getFruitName());
            int quantity = Validation.inputInt("Enter quantity:", 0, fruit.getQuantity());
            fruit.setQuantity(fruit.getQuantity() - quantity);
            Fruit fruitInOrder = checkFruitInOrder(listOrder, fruit.getFruitId());
            if (fruitInOrder != null) {
                fruitInOrder.setQuantity(fruitInOrder.getQuantity() + quantity);
            } else {
                if (quantity != 0) {
                    listOrder.add(new Fruit(fruit.getFruitId(), fruit.getFruitName(), fruit.getPrice(), quantity, fruit.getOrigin()));
                }
            }
            if (!Validation.checkInputYN("Do you want to continue? (Y/N)")) {
                break;
            }
        }
        if (listOrder.isEmpty()) {
            System.out.println("No orders.");
        } else {
            displayListOrder(listOrder);
            String name = setName();
            orders.put(name, listOrder);
        }
    }

    /**
     * Sets a name for the customer's order. If a customer has multiple orders,
     * a count is added to the name to differentiate them.
     *
     * @return the name for the customer's order
     */
    public String setName() {
        String name = Validation.getStringOrigin("Enter name:", "Error: The input name should only contain letters and numbers.");
        int count = 0;
        for (String name_key : orders.keySet()) {
            String real_name = name_key.split("#")[0];
            if (name.equals(real_name)) {
                count++;
            }
        }
        return name + "#" + count;
    }

    /**
     * Displays the list of ordered fruits and calculates the total amount.
     *
     * @param listOrder the list of ordered fruits
     */
    public void displayListOrder(ArrayList<Fruit> listOrder) {
        double total = 0;

        System.out.printf("%15s%15s%15s%15s\n", "Product", "Quantity", "Price", "Amount");
        for (Fruit fruit : listOrder) {
            System.out.printf("%15s%15d%15.0f$%15.0f$\n", fruit.getFruitName(),
                    fruit.getQuantity(), fruit.getPrice(),
                    fruit.getPrice() * fruit.getQuantity());
            total += fruit.getPrice() * fruit.getQuantity();
        }
        System.out.println("Total: " + total);
    }

    /**
     * Displays the list of orders. If no orders exist, a message indicating so
     * is displayed.
     */
    public void viewOrder() {
        if (orders.isEmpty()) {
            System.out.println("No orders.");
            return;
        }
        for (String name : orders.keySet()) {
            System.out.println("Customer: " + name.split("#")[0]);
            ArrayList<Fruit> listOrder = orders.get(name);
            displayListOrder(listOrder);
        }
    }

    /**
     * Retrieves a fruit from the fruit list based on the provided ID.
     *
     * @param id the ID of the fruit to retrieve
     * @return the Fruit object with the specified ID, or null if not found
     */
    public Fruit getFruitById(String id) {
        for (Fruit fruit : fruits) {
            if (id.equals(fruit.getFruitId())) {
                return fruit;
            }
        }
        return null;
    }

    /**
     * Generates some initial fruit objects and adds them to the fruit list.
     * This is used for testing purposes.
     */
    public void generateFruit() {
        fruits.add(new Fruit("F1", "Chuoi", 2000, 3, "Can Tho"));
        fruits.add(new Fruit("F2", "Bo", 4000, 6, "KOREA"));
        fruits.add(new Fruit("F3", "Dua", 5000, 5, "Cao Bang"));
    }
}
