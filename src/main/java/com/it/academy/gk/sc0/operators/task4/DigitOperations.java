package com.it.academy.gk.sc0.operators.task4;

import com.it.academy.gk.sc0.operators.task9.exception.InvalidDigitNumberException;
import lombok.experimental.UtilityClass;

/**
 * A utility class for performing operations on digits of a number.
 * The number should be either a two-digit or a three-digit number.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public final class DigitOperations {
    /**
     * A constant representing the base for decimal numbers.
     */
    private static final int BASE_10 = 10;

    /**
     * A constant representing the minimum value for a two-digit number.
     */
    private static final int MIN_TWO_DIGIT = 10;

    /**
     * A constant representing the maximum value for a three-digit number.
     */
    private static final int MAX_THREE_DIGIT = 999;

    /**
     * A constant holding the message for an invalid number.
     */
    private static final String INVALID_DIGIT_NUMBER_MESSAGE =
            "The number should be either a two-digit or a three-digit number.";

    /**
     * Calculates the sum of digits in a given number.
     * The number should be either a two-digit or a three-digit number.
     *
     * @param number The number to calculate the sum of digits for.
     * @return The sum of digits in the given number.
     * @throws InvalidDigitNumberException If the number is not a two-digit or a three-digit number.
     */
    public static int calculateDigitSum(final int number) {
        validateNumber(number);

        return performDigitOperation(number, Integer::sum, 0);
    }

    /**
     * Calculates the product of digits in a given number.
     * The number should be either a two-digit or a three-digit number.
     *
     * @param number The number to calculate the product of digits for.
     * @return The product of digits in the given number.
     * @throws InvalidDigitNumberException If the number is not a two-digit or a three-digit number.
     */
    public static int calculateDigitProduct(final int number) {
        validateNumber(number);

        return performDigitOperation(number, (a, b) -> a * b, 1);
    }

    /**
     * Calculates the number of digits in a given number.
     * The number should be either a two-digit or a three-digit number.
     *
     * @param number The number to calculate the number of digits for.
     * @return The number of digits in the given number.
     * @throws InvalidDigitNumberException If the number is not a two-digit or a three-digit number.
     */
    public static int calculateNumberOfDigits(final int number) {
        validateNumber(number);

        return performDigitOperation(number, (a, b) -> a + 1, 0);
    }

    /**
     * Performs a specific operation on each digit of a given number.
     *
     * @param number       The number to perform the operation on.
     * @param operation    The operation to apply to each digit.
     * @param initialValue The initial value to start the operation with.
     * @return The result of the operation on all digits.
     * @throws InvalidDigitNumberException If the number is not a two-digit or a three-digit number.
     */
    private static int performDigitOperation(final int number,
                                             final DigitOperation operation,
                                             final int initialValue) {
        var result = initialValue;
        var temp = number;

        while (temp > 0) {
            // Apply the operation to the result and the current digit
            result = operation.apply(result, temp % BASE_10);
            // Remove the last digit from the temporary number
            temp /= BASE_10;
        }

        return result;
    }

    /**
     * Validates the given number to ensure it is a two-digit or a three-digit number.
     *
     * @param number The number to validate.
     * @throws InvalidDigitNumberException If the number is not a two-digit or a three-digit number.
     */
    private static void validateNumber(final int number) {
        if (number < MIN_TWO_DIGIT || number > MAX_THREE_DIGIT) {
            throw new InvalidDigitNumberException(INVALID_DIGIT_NUMBER_MESSAGE);
        }
    }
}
