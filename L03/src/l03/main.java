/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package l03;

/**
 * Main class that contains the main method to run the program.
 *
 * @author khuakhanhhuy
 */
public class main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        //loop until user want to exit
        while (true) {
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Auto add fruit");
            System.out.println("5. Exit");
            int choice = Validation.inputInt("Enter choice:", 1, 5);
            switch (choice) {
                case 1:
                    manager.createFruit();
                    break;
                case 2:
                    manager.viewOrder();
                    break;
                case 3:
                    manager.shopping();
                    break;
                case 4:
                    manager.generateFruit();
                    break;
                case 5:
                    return;
            }
        }
    }

}
