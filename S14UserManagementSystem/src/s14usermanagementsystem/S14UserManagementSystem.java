/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s14usermanagementsystem;

/**
 * The main class of the User Management System application.
 *
 * @author khuakhanhhuy
 */
public class S14UserManagementSystem {

    public static void main(String[] args) {
        UserManagementSystem userManagementSystem = new UserManagementSystem();

        while (true) {
            System.out.println("USER MANAGEMENT SYSTEM");
            System.out.println("1. Create a new account");
            System.out.println("2. Login System");
            System.out.println("3. Exit the program");

            int option = Validation.getInt("> Choose: "); // Prompt user for option

            switch (option) {
                case 1:
                    userManagementSystem.createNewAccount(); // Create a new account
                    break;
                case 2:
                    userManagementSystem.loginSystem(); // Login to the system
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    System.exit(0); // Exit the program
                default:
                    System.out.println("Invalid option. Please enter 1, 2, or 3");
                    break;
            }
        }
    }
}
