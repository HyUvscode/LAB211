/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v10;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author khuakhanhhuy
 */
public class Main {

    private List<Person> personList;
    private Menu menu;

    public Main() {
        personList = new ArrayList<>();
        menu = new Menu();
    }

    public void run() {
        displayAndInputData();
        displayMenu();
    }

    private void displayAndInputData() {
        System.out.println("Function 1: Display GUI And Input Data");

        int numPeople = menu.getIntInput("Enter the number of people: ");
        for (int i = 0; i < numPeople; i++) {
            String id = menu.getInput("Enter the ID for person " + (i + 1) + ": ");
            String name = menu.getInput("Enter the name for person " + (i + 1) + ": ");
            String birthday = menu.getInput("Enter the birthday for person " + (i + 1) + ": ");
            String address = menu.getInput("Enter the address for person " + (i + 1) + ": ");

            Person person = new Person(id, name, birthday, address);
            personList.add(person);
        }
    }

    private void displayMenu() {
        boolean exit = false;

        while (!exit) {
            System.out.println("Function 2: Display Menu");
            System.out.println("1. Select a person's profile and view details");
            System.out.println("2. Input person's height, weight, and date");
            System.out.println("3. Compare information between two persons");
            System.out.println("4. Exit");

            int choice = menu.getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    selectPersonProfile();
                    break;
                case 2:
                    inputPersonInfo();
                    break;
                case 3:
                    comparePersons();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void selectPersonProfile() {
        System.out.println("Function 2.1: Select a person's profile and view details");
        // Add your code here
    }

    private void inputPersonInfo() {
        System.out.println("Function 2.2: Input person's height, weight, and date");
        // Add your code here
    }

    private void comparePersons() {
        System.out.println("Function 2.3: Compare information between two persons");
        // Add your code here
    }

    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }
}
