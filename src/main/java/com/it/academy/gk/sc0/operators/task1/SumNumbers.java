package com.it.academy.gk.sc0.operators.task1;

import lombok.experimental.UtilityClass;

import java.util.Arrays;

/**
 * SumNumbers is a utility class that provides a method for summing an array of integers.
 * The array must not be empty.
 *
 * <p>Example usage:</p>
 * <pre>
 *     int total = SumNumbers.sum(1, 2, 3);  // total will be 6
 * </pre>
 *
 * <p>Example for empty array (will throw IllegalArgumentException):</p>
 * <pre>
 *     try {
 *         int total = SumNumbers.sum();  // will throw IllegalArgumentException
 *     } catch (IllegalArgumentException e) {
 *         System.out.println(e.getMessage());  // prints "Array must not be empty"
 *     }
 * </pre>
 *
 * <p>Example for null array (will throw NullPointerException):</p>
 * <pre>
 *     try {
 *         int total = SumNumbers.sum(null);  // will throw NullPointerException
 *     } catch (NullPointerException e) {
 *         System.out.println(e.getMessage());  // prints "Expected non-null argument"
 *     }
 * </pre>
 *
 * <p>Example for utility class instantiation (will throw UnsupportedOperationException):</p>
 * <pre>
 *     try {
 *         SumNumbers instance = new SumNumbers();  // will throw UnsupportedOperationException
 *     } catch (UnsupportedOperationException e) {
 *         System.out.println(e.getMessage());  // prints "Utility class"
 *     }
 * </pre>
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-24
 */
@UtilityClass
public final class SumNumbers {
    /**
     * Error message displayed when an empty array is passed.
     */
    private static final String ARRAY_MUST_NOT_BE_EMPTY = "Array must not be empty";

    /**
     * Error message displayed when a null argument is passed.
     */
    private static final String EXPECTED_NON_NULL_ARGUMENT = "Expected non-null argument";

    /**
     * Sums an array of integers.
     *
     * <p>Example usage:</p>
     * <pre>
     *     int total = SumNumbers.sum(1, 2, 3);  // total will be 6
     * </pre>
     *
     * @param numbers the array of integers to sum. Must not be empty.
     * @return the sum of the integers in the array.
     * @throws NullPointerException     if the provided array is null.
     * @throws IllegalArgumentException if the provided array is empty.
     */
    public static long sum(final int... numbers) {
        validate(numbers);

        return Arrays.stream(numbers).asLongStream().sum();
    }

    /**
     * Validates the array of integers to ensure it is not null or empty.
     *
     * <p>Example usage:</p>
     * <pre>
     *     SumNumbers.validate(new int[]{1, 2, 3});  // No exception thrown
     * </pre>
     *
     * <p>Example for empty array (will throw IllegalArgumentException):</p>
     * <pre>
     *     try {
     *         SumNumbers.validate(new int[]{});  // will throw IllegalArgumentException
     *     } catch (IllegalArgumentException e) {
     *         System.out.println(e.getMessage());  // prints "Array must not be empty"
     *     }
     * </pre>
     *
     * <p>Example for null array (will throw NullPointerException):</p>
     * <pre>
     *     try {
     *         SumNumbers.validate(null);  // will throw NullPointerException
     *     } catch (NullPointerException e) {
     *         System.out.println(e.getMessage());  // prints "Expected non-null argument"
     *     }
     * </pre>
     *
     * @param numbers the array of integers to validate.
     * @throws NullPointerException     if the provided array is null.
     * @throws IllegalArgumentException if the provided array is empty.
     */
    private static void validate(final int[] numbers) {
        if (numbers == null) {
            throw new NullPointerException(EXPECTED_NON_NULL_ARGUMENT);
        }

        if (numbers.length == 0) {
            throw new IllegalArgumentException(ARRAY_MUST_NOT_BE_EMPTY);
        }
    }
}
