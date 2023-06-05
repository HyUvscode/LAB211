public class InputValidator {
    /**
     * Checks if the input string can be parsed as a double.
     * 
     * @param input the string to be checked
     * @return the double value if the string can be parsed, null otherwise
     */
    public Double checkDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }
    
    /**
     * Checks if the input string represents a valid operator.
     * 
     * @param input the string to be checked
     * @return the corresponding operator enum if the string represents a valid operator, null otherwise
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
