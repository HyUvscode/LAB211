/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s09developacomputerprogram;

import java.util.Scanner;

/**
 *
 * @author khuakhanhhuy
 */
public class S09DevelopAComputerProgram {

    /**
     * This class represents the main program for a Calculator and BMI
     * Calculator.
     *
     * The main method that runs the program.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        BMI bmi = new BMI();

        while (true) {
            // Print menu
            System.out.println("==========Calculator Program===========");
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");
            System.out.print("Please choose one option: ");
            String option = scanner.nextLine();

            // Reads the user input to choose an option.
            switch (option) {
                case "1":
                    System.out.println("-----Normal Calculator-----");

                    // Get the first number from the user
                    double a = Validation.getValidatedDoubleInput(scanner, "Enter number: ");
                    Operator operator = null;

                    while (true) {
                        System.out.print("Enter Operator: ");
                        String input = scanner.nextLine();
                        if (input.equals("=")) {
                            // If the user enters "=", exit the loop and print the result
                            System.out.println("Result: " + a);
                            break;
                        }
                        // Validate and get the operator from the user input
                        operator = Validation.checkOperator(input);
                        if (operator == null) {
                            System.out.println("Please input (+, -, *, /, ^), Please enter '=' to exit");
                        } else {
                            break;
                        }
                    }

                    if (operator == null) {
                        // If the user inputted "=", the operator will be null, exit the current operation
                        break;
                    }

                    double b = 0;
                    while (true) {
                        // Get the second number from the user
                        b = Validation.getValidatedDoubleInput(scanner, "Enter number: ");
                        // Check if the operator is division and the second number is zero
                        if (operator == Operator.DIVISION && b == 0) {
                            System.out.println("Error: division by zero");
                            continue;
                        } else {
                            break;
                        }
                    }

                    // Calculate the result and store it in memory
                    double result = calculator.calculate(a, operator, b);
                    System.out.println("Memory: " + result);

                    // Allow the user to perform additional calculations using the result as the first number
                    while (true) {
                        System.out.print("Enter Operator: ");
                        String input = scanner.nextLine();

                        // If the user enters "=", exit the loop and print the final result
                        if (input.equals("=")) {
                            break;
                        }
                        // Validate and get the operator from the user input
                        operator = Validation.checkOperator(input);
                        if (operator == null) {
                            System.out.println("Please input (+, -, *, /, ^), Please enter '=' to exit");
                            continue;
                        }

                        // Prompt the user to enter the second number
                        b = Validation.getValidatedDoubleInput(scanner, "Enter number: ");

                        // Calculate the result and update the memory
                        result = calculator.calculate(result, operator, b);
                        System.out.println("Memory: " + result);
                    }

                    // Print the final result
                    System.out.println("Result: " + result);
                    break;

                case "2":
                    System.out.println("-----BMI Calculator-----");

                    // Get the weight and height from the user
                    double weight = Validation.getValidatedDoubleInputGreaterThanZero(scanner, "Enter Weight(kg): ");
                    double height = Validation.getValidatedDoubleInputGreaterThanZero(scanner, "Enter Height(cm): ");

                    double bmiResult;
                    try {
                        // Calculate the BMI
                        bmiResult = bmi.calculateBMI(weight, height);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        return;
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
