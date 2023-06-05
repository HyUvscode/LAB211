/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s11developthecontactmanagementprogram;

import java.util.ArrayList;

/**
 *
 * @author khuakhanhhuy
 */
/**
 * This class represents the main program for managing contacts.
 */
public class S11DevelopTheContactManagementProgram {

    /**
     * The main method of the program.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create an ArrayList to store contacts
        ArrayList<Contact> contacts = new ArrayList<>();
        // Create an instance of the ContactManager class
        ContactManager contactManager = new ContactManager();

        // Start an infinite loop for the menu-driven program
        while (true) {
            // Display the menu options
            System.out.println("CONTACT MANAGEMENT");
            System.out.println("1. Add a contact");
            System.out.println("2. Display all contacts");
            System.out.println("3. Delete a contact");
            System.out.println("4. Exit");

            // Get the user's choice using the getInt() method from the Validation class
            int choice = Validation.getInt("Please Choose: ");

            // Perform actions based on the user's choice
            switch (choice) {
                case 1:
                    // Call the addContact() method of ContactManager to add a new contact
                    contactManager.addContact(contacts);
                    break;

                case 2:
                    // Call the displayContacts() method of ContactManager to display all contacts
                    contactManager.displayContacts(contacts);
                    break;

                case 3:
                    // Call the deleteContact() method of ContactManager to delete a contact
                    contactManager.deleteContact(contacts);
                    break;

                case 4:
                    // Exit the program
                    System.out.println("Goodbye!");
                    System.exit(0);

                default:
                    // Display an error message for invalid choices
                    System.out.println("Invalid choice. Please try again (1-4).\n");
                    break;
            }
        }
    }
}
