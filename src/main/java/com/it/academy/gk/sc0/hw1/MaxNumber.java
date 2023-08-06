package com.it.academy.gk.sc0.hw1;

/**
 * Determine which of the three inputs the user
 * numbers maximum and display it on the screen.
 */
public class MaxNumber {
    /**
     * Determines the maximum of three numbers.
     * <p>
     * This method takes three numbers as input and returns the maximum of these three numbers.
     *
     * @param firstNumber  the first number entered by the user
     * @param secondNumber the second number entered by the user
     * @param thirdNumber  the third number entered by the user
     * @return the maximum of the three numbers
     */
    public double maxOfThreeNumbers(double firstNumber, double secondNumber, double thirdNumber) {
        return Math.max(firstNumber, Math.max(secondNumber, thirdNumber));
    }
}
