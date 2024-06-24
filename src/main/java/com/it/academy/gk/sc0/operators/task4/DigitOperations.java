package com.it.academy.gk.sc0.operators.task4;

import com.it.academy.gk.sc0.operators.exception.InvalidDigitNumberException;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

/**
 * DigitOperations is a utility class that provides methods for performing
 * operations on the digits of a two-digit or three-digit integer number.
 * It includes methods for calculating the sum, product, and number of digits.
 *
 * <p>Example usage:</p>
 * <pre>
 *     int number = 123;
 *     int sum = DigitOperations.calculateDigitSum(number);  // sum will be 6
 *     int product = DigitOperations.calculateDigitProduct(number);  // product will be 6
 *     int numberOfDigits = DigitOperations.calculateNumberOfDigits(number);  // numberOfDigits will be 3
 * </pre>
 *
 * <p>Example usage with exception handling:</p>
 * <pre>
 *     try {
 *         DigitOperations.calculateDigitSum(9);  // throws InvalidDigitNumberException
 *     } catch (InvalidDigitNumberException e) {
 *         System.out.println(e.getMessage());  // prints "The number should be either a two-digit or a three-digit number."
 *     }
 * </pre>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
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
     * Calculates the sum of the digits of the given number.
     *
     * @param number the integer number.
     * @return the sum of the digits.
     * @throws InvalidDigitNumberException if the number is not a valid two-digit or three-digit number.
     */
    @SneakyThrows
    public static int calculateDigitSum(final int number) {
        validateNumber(number);

        return performDigitOperation(number, Integer::sum, 0);
    }

    /**
     * Calculates the product of the digits of the given number.
     *
     * @param number the integer number.
     * @return the product of the digits.
     * @throws InvalidDigitNumberException if the number is not a valid two-digit or three-digit number.
     */
    @SneakyThrows
    public static int calculateDigitProduct(final int number) {
        validateNumber(number);

        return performDigitOperation(number, (a, b) -> a * b, 1);
    }

    /**
     * Calculates the number of digits in the given number.
     *
     * @param number the integer number.
     * @return the number of digits.
     * @throws InvalidDigitNumberException if the number is not a valid two-digit or three-digit number.
     */
    @SneakyThrows
    public static int calculateNumberOfDigits(final int number) {
        validateNumber(number);

        return performDigitOperation(number, (a, b) -> a + 1, 0);
    }

    /**
     * Performs a digit operation on the given number using the provided DigitOperation functional interface.
     * The operation is applied to each digit of the number.
     *
     * @param number       the integer number on which the operation will be performed.
     * @param operation    the DigitOperation functional interface representing the operation.
     * @param initialValue the initial value for the operation.
     * @return the result of performing the operation on the digits of the number.
     */
    private static int performDigitOperation(final int number, final DigitOperation operation, final int initialValue) {
        var result = initialValue;
        var temp = number;

        while (temp > 0) {
            result = operation.apply(result, temp % BASE_10);
            temp /= BASE_10;
        }

        return result;
    }

    /**
     * Validates if the given number is a two-digit or a three-digit number.
     * Throws an exception if the validation fails.
     *
     * @param number the integer number to validate.
     * @throws InvalidDigitNumberException if the number is not a valid two-digit or three-digit number.
     */
    @SneakyThrows
    private static void validateNumber(final int number) {
        if (number < MIN_TWO_DIGIT || number > MAX_THREE_DIGIT) {
            throw new InvalidDigitNumberException(INVALID_DIGIT_NUMBER_MESSAGE);
        }
    }
}
