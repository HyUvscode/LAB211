/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s14usermanagementsystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * UserManagementSystem class handles user account creation and login.
 *
 * @author khuakhanhhuy
 */
public class UserManagementSystem {

    private static final String FILE_NAME = "user.dat";
    private List<User> users;
    private Validation validation;

    /**
     * Constructs a UserManagementSystem object and initializes the users list
     * and validation object.
     */
    public UserManagementSystem() {
        users = new ArrayList<>(); // Initialize an empty list of users
        loadUsersFromFile(); // Load users from a file
        validation = new Validation(); // Create a Validation object
    }

    /**
     * Creates a new user account by prompting the user for username and
     * password.
     */
    public void createNewAccount() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a valid username
        String username = validation.getStringUser(
                "Enter username: ", // Prompt message
                "Invalid username. Username must be at least 5 characters and have no spaces.", // Error message
                5, // Minimum length
                false // Disallow spaces
        );

        // Check if the username already exists
        if (isUsernameTaken(username)) {
            System.out.println("Username already exists. Please choose a different username."); // Print error message
            return;
        }

        // Prompt the user for a valid password
        String password = validation.getStringUser(
                "Enter password: ", // Prompt message
                "Invalid password. Password must be at least 6 characters and have no spaces. ", // Error message
                6, // Minimum length
                false // Disallow spaces
        );

        // Create a new User object with the provided username and password
        User newUser = new User(username, password);

        // Add the new user to the list of users
        users.add(newUser);

        // Save the updated list of users to a file
        saveUsersToFile();

        // Display a success message
        System.out.println("Account created successfully!");
    }

    /**
     * Logs in a user by prompting for username and password and verifying the
     * credentials.
     */
    public void loginSystem() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for a valid username
        String username = validation.getStringUser(
                "Enter username: ", // Prompt message
                "Invalid username. Username must be at least 5 characters and have no spaces.", // Error message
                5, // Minimum length
                false // Disallow spaces
        );

        // Prompt the user for a valid password
        String password = validation.getStringUser(
                "Enter password: ", // Prompt message
                "Invalid password. Password must be at least 6 characters and have no spaces. ", // Error message
                6, // Minimum length
                false // Disallow spaces
        );

        // Check if the entered username and password match any user in the list
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful!"); // Print success message
                return;
            }
        }

        // Display an error message if the entered credentials are invalid
        System.out.println("Invalid username or password.");
    }

    /**
     * Checks if a username is already taken.
     *
     * @param username the username to check
     * @return true if the username is taken, false otherwise
     */
    private boolean isUsernameTaken(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Loads the list of users from a file.
     */
    private void loadUsersFromFile() {
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            users = (List<User>) input.readObject(); // Read the list of users from the file
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No existing user data found."); // Print error message
        }
    }

    /**
     * Saves the list of users to a file.
     */
    private void saveUsersToFile() {
        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            output.writeObject(users); // Write the list of users to the file
        } catch (IOException e) {
            System.out.println("Error saving user data."); // Print error message
        }
    }
}
