/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package s09developacomputerprogram;

/**
 * This enum represents mathematical operators for basic arithmetic operations.
 * Each operator has a symbol and can be converted to an operator using the
 * fromSymbol method.
 *
 * @param symbol the symbol representing the operator
 *
 * @return the operator corresponding to the given symbol or null if no operator
 * matches the symbol
 *
 * @author khuakhanhhuy
 */
public enum Operator {
    ADDITION("+"), // Define the ADDITION operator with the symbol "+"
    SUBTRACTION("-"), // Define the SUBTRACTION operator with the symbol "-"
    MULTIPLICATION("*"), // Define the MULTIPLICATION operator with the symbol "*"
    DIVISION("/"), // Define the DIVISION operator with the symbol "/"
    POWER("^");  // Define the POWER operator with the symbol "^"

    private String symbol;  // Declare the private symbol variable

    Operator(String symbol) {  // Define the constructor with the symbol parameter
        this.symbol = symbol;  // Assign the symbol parameter to the symbol variable
    }

    /**
     * Returns the symbol for this operator.
     *
     * @return the symbol for this operator
     */
    public String getSymbol() {
        return symbol; // Return the symbol for this operator
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
        for (Operator operator : Operator.values()) {  // Iterate over all operators in the enum
            if (operator.symbol.equals(symbol)) {  // Check if the symbol of the current operator matches the input symbol
                return operator;  // Return the operator if the symbol matches
            }
        }
        return null;  // Return null if no operator matches the symbol
    }
}
