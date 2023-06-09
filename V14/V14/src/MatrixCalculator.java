/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author NGMINHAT
 */
public class MatrixCalculator {

    private int[][] matrix1;
    private int[][] matrix2;
    private int[][] result;
    private Scanner scanner = new Scanner(System.in);

    /**
     * Runs the matrix calculator program.
     */
    public void run() {
        System.out.println("--------Calculator---------");
        int choice = 0;
        while (true) {
            System.out.println("1. Addition matrix");
            System.out.println("2. Subtraction matrix");
            System.out.println("3. Multi matrix");
            System.out.println("4. Quit");
            try {
                System.out.print("Enter your choice (1-4): ");
                choice = scanner.nextInt();

                if (choice == 4) {
                    System.out.println("Exiting the program.");
                    break;
                } else if (choice < 1 || choice > 4) {
                    System.out.println("Invalid choice. Please enter an integer (1-4).");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Please enter an integer (1-4)");
                scanner.next();
                continue;
            }

            if (choice == 1 || choice == 2) {
                int rows, columns;

                System.out.print("Enter the number of rows    for 2 matrices: ");
                rows = checkPositiveIntegerInput();
                System.out.print("Enter the number of columns for 2 matrices: ");
                columns = checkPositiveIntegerInput();

                inputMatrix("Matrix 1", rows, columns);
                inputMatrix("Matrix 2", rows, columns);

                switch (choice) {
                    case 1:
                        additionMatrix();
                        System.out.println("Result:");
                        displayMatrix("Matrix 1");
                        System.out.println("+");
                        displayMatrix("Matrix 2");
                        System.out.println("=");
                        displayMatrix("Result");
                        break;
                    case 2:
                        subtractionMatrix();
                        System.out.println("Result:");
                        displayMatrix("Matrix 1");
                        System.out.println("-");
                        displayMatrix("Matrix 2");
                        System.out.println("=");
                        displayMatrix("Result");
                        break;
                }
            } else if (choice == 3) {
                int rows1, columns1, rows2 = 0, columns2;

                System.out.print("Enter the number of rows for the matrix 1: ");
                rows1 = checkPositiveIntegerInput();

                System.out.print("Enter the number of columns for the  matrix 1 and the number of rows for the matrix 2: ");
                columns1 = checkPositiveIntegerInput();
                rows2 = columns1;

                System.out.print("Enter the number of columns for the matrix 2: ");
                columns2 = checkPositiveIntegerInput();

                inputMatrix("Matrix 1", rows1, columns1);
                inputMatrix("Matrix 2", rows2, columns2);

                multiplicationMatrix();
                System.out.println("Result:");
                displayMatrix("Matrix 1");
                System.out.println("*");
                displayMatrix("Matrix 2");
                System.out.println("=");
                displayMatrix("Result");
            }
        }
    }

    /**
     * Checks if the user input is a positive integer.
     *
     * @return the positive integer input by the user
     */
    public int checkPositiveIntegerInput() {
        while (true) {
            String input = scanner.next();
            try {
                int value = Integer.parseInt(input);
                if (value <= 0) {
                    System.out.println("Invalid input. Please enter a positive integer.");
                } else {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a positive integer.");
            }
        }
    }

    /**
     * Checks if the user input is an integer.
     *
     * @return the integer input by the user
     */
    public int checkIntegerInput() {
        while (true) {
            String input = scanner.next();
            try {
                int value = Integer.parseInt(input);
                return value;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    /**
     * Prompts the user to input values for a matrix.
     *
     * @param matrixName the name of the matrix
     * @param rows the number of rows in the matrix
     * @param columns the number of columns in the matrix
     */
    public void inputMatrix(String matrixName, int rows, int columns) {
        System.out.println("Enter values for " + matrixName + ":");

        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrixName + "[" + (i + 1) + "][" + (j + 1) + "]: ");
                matrix[i][j] = checkIntegerInput();
            }
        }

        if (matrixName.equals("Matrix 1")) {
            matrix1 = matrix;
        } else {
            matrix2 = matrix;
        }
    }

    /**
     * Performs addition of two matrices.
     */
    public void additionMatrix() {
        int rows = matrix1.length;
        int columns = matrix1[0].length;

        result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
    }

    /**
     * Performs subtraction of two matrices.
     */
    public void subtractionMatrix() {
        int rows = matrix1.length;
        int columns = matrix1[0].length;

        result = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
    }

    /**
     * Performs multiplication of two matrices.
     */
    public void multiplicationMatrix() {
        int rows1 = matrix1.length;
        int columns1 = matrix1[0].length;
        int columns2 = matrix2[0].length;

        result = new int[rows1][columns2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < columns2; j++) {
                for (int k = 0; k < columns1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
    }

    /**
     * Displays the content of a matrix.
     *
     * @param matrixName the name of the matrix
     */
    public void displayMatrix(String matrixName) {
        int[][] matrix;

        if (matrixName.equals("Matrix 1")) {
            matrix = matrix1;
        } else if (matrixName.equals("Matrix 2")) {
            matrix = matrix2;
        } else {
            matrix = result;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
    }
}
