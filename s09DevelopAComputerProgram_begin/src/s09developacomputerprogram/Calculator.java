/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s09developacomputerprogram;

/**
 *
 * Calculates the result of applying the given operator to the two operands.
 *
 * @param a the first operand
 * @param operator the operator to apply
 * @param b the second operand
 * @return the result of applying the operator to the operands
 * @throws IllegalArgumentException if the operator is invalid or b is zero and
 * operator is DIVISION
 *
 * @author khuakhanhhuy
 */
public class Calculator {

    public double calculate(double a, Operator operator, double b) throws IllegalArgumentException {

        // Apply the operator to the operands
        switch (operator) {
            case ADDITION:
                return a + b;  // Perform addition
            case SUBTRACTION:
                return a - b;  // Perform subtraction
            case MULTIPLICATION:
                return a * b;  // Perform multiplication
            case DIVISION:
                if (b == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");  // Throw exception if division by zero occurs
                }
                return a / b;  // Perform division
            case POWER:
                return Math.pow(a, b);  // Perform exponentiation

            // If the operator is not one of the valid ones, throw an exception
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
