
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        BMI bmi = new BMI();
        InputValidator validator = new InputValidator();
//        InputChecker checker = new InputChecker();

        while (true) {
            //print menu 
            System.out.println("==========Calculator Program===========");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");
            System.out.print("Please choose one option: ");
            String option = scanner.nextLine();

            /**
             * Reads the user input to choose an option.
             *
             * @return The option chosen by the user.
             */
            switch (option) {
                /**
                 * This method performs a basic arithmetic calculation between
                 * two numbers, as specified by the user input.
                 *
                 * @param scanner The scanner object used to read user input.
                 * @param calculator The calculator object used to perform
                 * calculations.
                 * @param validator The validate object used to validate the
                 * user input.
                 *
                 * @return result
                 */
                case "1":
                    System.out.println("-----Normal Calculator-----");
                    double a = 0,
                     b = 0;
                    Operator operator = null;
                    String input;

                    // Get the first number from the user input
                    while (true) {
                        System.out.print("Enter number: ");
                        input = scanner.nextLine();

                        // Validate the user input  
                        if (validator.checkDouble(input) != null) {
                            a = Double.parseDouble(input);
                            break;
                        } else {
                            System.out.println("Invalid input! Please enter a number.");
                        }
                    }

                    // Get the operator from the user input
                    while (true) {
                        System.out.print("Enter Operator: ");
                        input = scanner.nextLine();

                        if (validator.checkOperator(input) != null) {
                            operator = validator.checkOperator(input);
                            break;
                        } else {
                            System.out.println("Please input (+, -, *, /, ^)");
                        }
                    }

                    // Get the second number from the user input
                    while (true) {
                        System.out.print("Enter number: ");
                        input = scanner.nextLine();

                        // Validate the user input
                        if (validator.checkDouble(input) != null) {
                            b = Double.parseDouble(input);
                            break;
                        } else {
                            System.out.println("Invalid input! Please enter a number.");
                        }
                    }

                    // Calculate result and store in memory
                    double result = calculator.calculate(a, operator, b);
                    System.out.println("Memory: " + result);

                    // Allow user to perform additional calculations using result as first number
                    while (true) {
                        System.out.println("Current Memory: " + result);
                        System.out.print("Enter Operator: ");
                        input = scanner.nextLine();

                        // If user enters "=", exit loop and print final result
                        if (input.equals("=")) {
                            break;
                        } else if (validator.checkOperator(input) != null) {

                            // If user enters a valid operator, store it
                            operator = validator.checkOperator(input);
                        } else {

                            // If user enters an invalid operator, prompt again
                            System.out.println("Please input (+, -, *, /, ^)");
                            continue;
                        }

                        // Prompt user to enter second number
                        while (true) {
                            System.out.print("Enter number: ");
                            input = scanner.nextLine();
                            // Check if input is valid double
                            if (validator.checkDouble(input) != null) {
                                b = Double.parseDouble(input);
                                break;
                            } else {
                                System.out.println("Invalid input! Please enter a number.");
                            }
                        }
                        // Calculate result and update memory
                        result = calculator.calculate(result, operator, b);
                        System.out.println("Memory: " + result);
                    }
                    // Print final result
                    System.out.println("Result: " + result);
                    break;
                case "2":

                    /**
                     * Get user input for weight and height and calculate BMI
                     *
                     * @param scanner The scanner object used to read user input
                     * @param validator The validate object used to validate
                     * user input.
                     * @param bmi The BMI object used to calculate BMI
                     *
                     * @return BMI Number, BMI Status
                     */
                    System.out.println("-----BMI Calculator-----");
                    double weight = 0,
                     height = 0;

                    // Get the weight in kg
                    while (true) {
                        System.out.print("Enter Weight(kg): ");
                        input = scanner.nextLine();

                        // Validate the user input
                        if (validator.checkDouble(input) != null) {
                            weight = Double.parseDouble(input);
                            break;
                        } else {
                            System.out.println("Invalid input! Please enter a number.");
                        }
                    }

                    // Get the height in cm
                    while (true) {
                        System.out.print("Enter Height(cm): ");
                        input = scanner.nextLine();

                        // Validate the user input
                        if (validator.checkDouble(input) != null) {
                            height = Double.parseDouble(input);
                            break;
                        } else {
                            System.out.println("Invalid input! Please enter a number.");
                        }
                    }

                    double bmiResult;
                    try {

                        // Calculate the BMI and handle any exceptions that are thrown
                        bmiResult = bmi.calculateBMI(weight, height);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        // If an exception is caught, continue to the next iteration of the loop
                        continue;
                    }

                    // Determine the BMI status based on the calculated BMI
                    BMI.Status status = bmi.getStatus(bmiResult);

                    // Print the calculated BMI and status
                    System.out.println("BMI Number: " + String.format("%.2f", bmiResult));
                    System.out.println("BMI Status: " + status);
                    break;
                case "3":

                    // Exit the program. 
                    System.out.println("Thank you for using Calculator Program!");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid input! Please enter 1, 2, or 3.");
                    break;
            }
        }
    }
}
