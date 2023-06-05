
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
 */
public class Calculator {

    public double calculate(double a, Operator operator, double b) throws IllegalArgumentException {

        // Apply the operator to the operands
        switch (operator) {
            case ADDITION:
                return a + b;
            case SUBTRACTION:
                return a - b;
            case MULTIPLICATION:
                return a * b;
            case DIVISION:
                if (b == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                return a / b;
            case POWER:
                return Math.pow(a, b);
                
            // If the operator is not one of the valid ones, throw an exception
            default:
                throw new IllegalArgumentException("Invalid operator");
        }
    }
}
