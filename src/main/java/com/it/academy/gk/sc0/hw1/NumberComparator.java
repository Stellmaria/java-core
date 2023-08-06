package com.it.academy.gk.sc0.hw1;

/**
 * Write a console program in which the user
 * keyboard enters two numbers. And the program compares two
 * entered numbers and prints the result to the console
 * comparisons (two numbers are equal, the first number is greater
 * second or the first number is less than the second).
 */
public class NumberComparator {
    /**
     * The result when the first number is greater than the second number.
     */
    private static final String FIRST_GREATER = "The first number is greater than the second number.";
    /**
     * The result when the first number is less than the second number.
     */
    private static final String FIRST_LESS = "The first number is less than the second number.";
    /**
     * The result when the first number is equal to the second number.
     */
    private static final String EQUAL = "The two numbers are equal.";

    /**
     * Compares two numbers and returns the result of the comparison.
     * <p>
     * This method compares two numbers entered by the user and returns a string that describes
     * the result of the comparison. If the first number is greater than the second number,
     * it returns "The first number is greater than the second number." If the first number is less than
     * the second number, it returns "The first number is less than the second number."
     * If the two numbers are equal, it returns "The two numbers are equal."
     *
     * @param firstNumber  the first number entered by the user
     * @param secondNumber the second number entered by the user
     * @return a string that describes the result of the comparison
     */
    public String compareNumbers(double firstNumber, double secondNumber) {
        if (firstNumber > secondNumber) {
            return FIRST_GREATER;
        } else if (firstNumber < secondNumber) {
            return FIRST_LESS;
        } else {
            return EQUAL;
        }
    }
}
