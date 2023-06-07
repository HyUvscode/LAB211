/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package v08;

/**
 *
 * @author khuakhanhhuy
 */
public class Contact {

    private int id;
    private String name;
    private String group;
    private String address;
    private String phone;

    /**
     * Creates a new instance of the Contact class.
     *
     * @param id the ID of the contact
     * @param name the name of the contact
     * @param group the group of the contact
     * @param address the address of the contact
     * @param phone the phone number of the contact
     */
    public Contact(int id, String name, String group, String address, String phone) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.address = address;
        this.phone = phone;
    }

    /**
     * Get the ID of the contact.
     *
     * @return the ID
     */
    public int getId() {
        return id;
    }

    /**
     * Get the full name of the contact.
     *
     * @return the full name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the group of the contact.
     *
     * @return the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * Get the address of the contact.
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get the phone number of the contact.
     *
     * @return the phone number
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Convert the contact to a string representation.
     *
     * @return the string representation of the contact
     */
    public String toString() {
        String[] nameParts = this.name.split("\\s"); // Split the name into an array of strings using whitespace as the delimiter
        String firstName = nameParts[0]; // Get the first name from the nameParts array
        String lastName = nameParts[nameParts.length - 1]; // Get the last name from the nameParts array

        return String.format("+%-3d| %-20s | %-13s | %-13s | %-10s | %-15s | %-10s%n",
                this.id, this.name, firstName, lastName, this.group, this.address, this.phone);
    }
}
