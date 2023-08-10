package com.it.academy.gk.sc0.hw1;

/**
 * The user enters two numbers.
 * One is assigned one variable and the other.
 * Necessary change the values of the variables so that the value the first turned out to be in the second,
 * and the second - in the first.
 */
public class VariableSwapper {
    /**
     * Format string for the message to be returned.
     */
    private static final String RESULT_MESSAGE = "First variable: %d, Second variable: %d";

    /**
     * Swaps the values of two variables.
     *
     * @param firstVariable  the first variable.
     * @param secondVariable the second variable.
     * @return a message indicating the new values of the variables.
     */
    public String swapVariables(final int firstVariable, final int secondVariable) {
        return String.format(RESULT_MESSAGE, secondVariable, firstVariable);
    }
}
