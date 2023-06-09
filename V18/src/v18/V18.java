/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v18;

import java.util.HashMap;

/**
 *
 * @author khuakhanhhuy
 */
public class V18 {

    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();
        Manager manager = new Manager();
        manager.loadData(hm);

        // Loop until the user wants to exit
        while (true) {
            int choice = manager.menu();
            switch (choice) {
                case 1:
                    manager.addNewWord(hm);
                    break;
                case 2:
                    manager.deleteWord(hm);
                    break;
                case 3:
                    manager.translate(hm);
                    break;
                case 4:
                    // Save the data to the file before exiting
                    manager.updateDatabase(hm);
                    System.out.println("Data saved successfully.");
                    return;
            }
        }
    }

}
