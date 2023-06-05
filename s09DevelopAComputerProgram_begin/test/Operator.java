
/**
 * This enum represents mathematical operators for basic arithmetic operations.
 * Each operator has a symbol and can be converted to an operator using the fromSymbol method.
 *
 * @param symbol the symbol representing the operator
 *
 * @return the operator corresponding to the given symbol or null if no operator matches the symbol
 */
public enum Operator {
    ADDITION("+"),
    SUBTRACTION("-"),
    MULTIPLICATION("*"),
    DIVISION("/"),
    POWER("^");

    private String symbol;

    Operator(String symbol) {
        this.symbol = symbol;
    }

    /**
     * Returns the symbol for this operator.
     *
     * @return the symbol for this operator
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Converts a string symbol to the corresponding operator.
     *
     * @param symbol the symbol to convert
     *
     * @return the operator corresponding to the given symbol or null if no
     * operator matches the symbol
     */
    public static Operator fromSymbol(String symbol) {
        for (Operator operator : Operator.values()) {
            if (operator.symbol.equals(symbol)) {
                return operator;
            }
        }
        return null;
    }

    /**
     * Checks if the given input is a valid operator.
     *
     * @param input the input to check
     *
     * @return the operator corresponding to the given input or null if the
     * input is not a valid operator
     */
    public Operator checkOperator(String input) {
        switch (input) {
            case "+":
                return Operator.ADDITION;
            case "-":
                return Operator.SUBTRACTION;
            case "*":
                return Operator.MULTIPLICATION;
            case "/":
                return Operator.DIVISION;
            case "^":
                return Operator.POWER;
            default:
                return null;
        }
    }

}
