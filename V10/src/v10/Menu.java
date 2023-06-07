
package v10;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;

    public Menu() {
        scanner = new Scanner(System.in);
    }

    public int getIntInput(String prompt) {
        int value = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                value = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }

        return value;
    }

    public double getDoubleInput(String prompt) {
        double value = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print(prompt);
                value = Double.parseDouble(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return value;
    }
}
