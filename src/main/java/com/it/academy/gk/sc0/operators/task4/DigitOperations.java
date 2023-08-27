package com.it.academy.gk.sc0.operators.task4;

import com.it.academy.gk.sc0.operators.exception.InvalidDigitNumberException;

/**
 * The DigitOperations class provides methods to calculate the sum and product of the digits of a two-digit or three-digit number.
 */
public class DigitOperations {
    /**
     * The base used for the calculations.
     */
    private static final int BASE_10 = 10;
    /**
     * The minimum value for a two-digit number.
     */
    private static final int MIN_TWO_DIGIT = 10;
    /**
     * The maximum value for a three-digit number.
     */
    private static final int MAX_THREE_DIGIT = 999;
    /**
     * The error message used when an invalid number of digits is encountered.
     */
    private static final String INVALID_DIGIT_NUMBER_MESSAGE = "The number should be either a two-digit or a three-digit number.";

    /**
     * Calculates the sum of the digits of the given two-digit or three-digit number.
     *
     * @param number the two-digit or three-digit number
     * @return the sum of the digits of the given number
     * @throws InvalidDigitNumberException if the given number is not a two-digit or a three-digit number
     */
    public int calculateDigitSum(final int number) throws InvalidDigitNumberException {
        validateNumber(number);

        int sum = 0;
        int currentNumber = number;
        while (currentNumber > 0) {
            sum += currentNumber % BASE_10;
            currentNumber /= BASE_10;
        }

        return sum;
    }

    /**
     * Calculates the product of the digits of the given two-digit or three-digit number.
     *
     * @param number the two-digit or three-digit number
     * @return the product of the digits of the given number
     * @throws InvalidDigitNumberException if the given number is not a two-digit or a three-digit number
     */
    public int calculateDigitProduct(final int number) throws InvalidDigitNumberException {
        validateNumber(number);

        int product = 1;
        int currentNumber = number;
        while (currentNumber > 0) {
            product *= currentNumber % BASE_10;
            currentNumber /= BASE_10;
        }

        return product;
    }

    /**
     * Calculates the number of digits in the given two-digit or three-digit number.
     *
     * @param number the two-digit or three-digit number
     * @return the number of digits in the given number
     * @throws InvalidDigitNumberException if the given number is not a two-digit or a three-digit number
     */
    public int calculateNumberOfDigits(final int number) throws InvalidDigitNumberException {
        validateNumber(number);

        int numberOfDigits = 0;
        int currentNumber = number;
        while (currentNumber > 0) {
            numberOfDigits++;
            currentNumber /= BASE_10;
        }

        return numberOfDigits;
    }

    /**
     * Validates the given number to ensure that it is either a two-digit or a three-digit number.
     *
     * @param number the number to be validated
     * @throws InvalidDigitNumberException if the given number is not a two-digit or a three-digit number
     */
    private void validateNumber(final int number) throws InvalidDigitNumberException {
        if (number < MIN_TWO_DIGIT || number > MAX_THREE_DIGIT) {
            throw new InvalidDigitNumberException(INVALID_DIGIT_NUMBER_MESSAGE);
        }
    }
}
