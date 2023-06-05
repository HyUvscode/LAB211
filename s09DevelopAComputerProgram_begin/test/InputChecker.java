
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author khuakhanhhuy
 */
public class InputChecker {
    private Scanner scanner;

    public InputChecker() {
        scanner = new Scanner(System.in);
    }

    public int getIntegerInput() {
        int input = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print("Enter an integer: ");

            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                isValidInput = true;
            } else {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next(); // clear the invalid input from the scanner buffer
            }
        }

        return input;
    }

    public double getDoubleInput() {
        double input = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.print("Enter a number: ");

            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();
                isValidInput = true;
            } else {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // clear the invalid input from the scanner buffer
            }
        }

        return input;
    }

    public String getStringInput() {
        String input = "";

        while (input.isEmpty()) {
            System.out.print("Enter a string: ");
            input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Invalid input! Please enter a non-empty string.");
            }
        }

        return input;
    }
}
