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

/**
 * Main class that contains the main method to run the program.
 *
 * @author khuakhanhhuy
 */
public class Main {

    public static void main(String[] args) {
        Manager manager = new Manager();
        ArrayList<Fruit> lf = new ArrayList<>();
        Hashtable<String, ArrayList<Order>> ht = new Hashtable<>();
        //loop until user want to exit
        while (true) {
            int choice = manager.menu();
            switch (choice) {
                case 1:
                    manager.createFruit(lf);
                    break;
                case 2:
                    manager.viewOrder(lf, ht);
                    break;
                case 3:
                    manager.shopping(lf, ht);
                    break;
                case 4:
                    manager.autoAddFruit(lf, ht);
                    break;
                case 5:
                    return;
            }
        }
    }

}
