/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s11developthecontactmanagementprogram;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * This class manages the contacts.
 *
 * @author khuakhanhhuy
 */
public class ContactManager {

    /**
     * Add a new contact to the list of contacts.
     *
     * @param contacts the list of contacts
     */
    public void addContact(ArrayList<Contact> contacts) {
        // Get the contact details from the user
        String name = Validation.getStringContact("Enter Name: ", "Error: The input name should only contain letters and spaces.");
        String group = Validation.getStringWithNumbers("Enter Group: ", "Error: The input group should only contain letters and number.");
        String address = Validation.getStringWithNumbers("Enter Address: ", "Error: The input address should only contain letters and number.");
        String phone;
        // Check if the phone number is a duplicate
        do {
            phone = Validation.getStringWithPhoneFormat("Enter Phone: ", "Note: Mobile phone numbers follow the format 09x-xxxxxxx or new prefixes: 03x, 05x, 07x, 08x.");

            // Check if the phone number is a duplicate
            if (Validation.isDuplicatePhoneNumber(phone, contacts)) {
                System.out.println("Error: Duplicate phone number. Please enter a different phone number.");
            }
        } while (Validation.isDuplicatePhoneNumber(phone, contacts));
        int id;
        if (contacts.isEmpty()) {
            id = 1; // If the contacts list is empty, set the ID as 1
        } else {
            // Generate a new ID for the contact by incrementing the ID of the last contact in the list
            id = contacts.get(contacts.size() - 1).getId() + 1;
        }

        // Check if the phone number is a duplicate
        if (Validation.isDuplicatePhoneNumber(phone, contacts)) {
            System.out.println("Error: Duplicate phone number. Please enter a different phone number.");
            return; // Exit the method if the phone number is a duplicate
        }

        // Create a new Contact object with the provided details
        Contact newContact = new Contact(id, name, group, address, phone);

        // Add the new contact to the list of contacts
        contacts.add(newContact);

        System.out.println("Contact added successfully!"); // Print a success message

    }

    /**
     * Display all contacts in a formatted table.
     *
     * @param contacts the list of contacts
     */
    public void displayContacts(ArrayList<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available."); // Print a message if the contacts list is empty
            return; // Exit the method if there are no contacts available
        }

        // Print the table header
        System.out.println("+---+----------------------+---------------+---------------+------------+-----------------+------------+");
        System.out.printf("%-3s| %-20s | %-13s | %-13s | %-10s | %-15s | %-10s%n",
                "+" + "ID ", "Name", "First Name", "Last Name", "Group", "Address", "Phone");
        System.out.println("+---+----------------------+---------------+---------------+------------+-----------------+------------+");

        // Print each contact's details in a row
        for (Contact contact : contacts) {
            System.out.print(contact.toString()); // Print the string representation of each contact
        }

        // Print the table footer
        System.out.println("+---+----------------------+---------------+---------------+------------+-----------------+------------+\n");
    }

    /**
     * Delete a contact from the list of contacts.
     *
     * @param contacts the list of contacts
     */
    public void deleteContact(ArrayList<Contact> contacts) {

        if (contacts.isEmpty()) {
            System.out.println("No contacts available."); // Print a message if the contacts list is empty
            return; // Exit the method if there are no contacts available
        }

        // Get the contact ID to delete from the user
        while (true) {
            displayContacts(contacts);
            // Get the contact ID to delete from the user
            int idFind = Validation.getInt("Enter the ID of the contact you want to delete: "); // Prompt the user for the ID of the contact to delete
            boolean contactFound = false; // Flag to indicate if the contact with the specified ID is found

            // Iterate over the contacts and remove the contact with the specified ID
            for (Iterator<Contact> iterator = contacts.iterator(); iterator.hasNext();) {
                Contact contact = iterator.next();
                if (contact.getId() == idFind) { // Check if the contact's ID matches the specified ID
                    iterator.remove(); // Remove the contact from the list
                    System.out.println("Contact " + idFind + " deleted successfully!"); // Print a success message
                    contactFound = true; // Set the flag to indicate that the contact was found
                    break; // Exit the loop since the contact has been found and removed
                }
            }

            if (!contactFound) {
                System.out.println("No contact found with ID " + idFind); // Print a message if no contact was found with the specified ID

                if (!Validation.checkInputYN()) {
                    break; // Exit the loop if the user doesn't want to continue searching
                }
            } else {
                break; // Exit the loop if the contact was found and deleted
            }
        }
    }
}
