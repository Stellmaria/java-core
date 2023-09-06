package com.it.academy.gk.sc0.operators.task1;

import com.it.academy.gk.sc0.operators.exception.EmptyArrayException;
import lombok.SneakyThrows;
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
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
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
     * @param numbers the array of integers to sum. Must not be empty.
     * @return the sum of the integers in the array.
     */
    @SneakyThrows
    public static int sum(final int... numbers) {
        validate(numbers);

        return Arrays.stream(numbers).sum();
    }

    /**
     * Validates the array of integers to ensure it is not empty.
     *
     * @param numbers the array of integers to validate.
     * @throws EmptyArrayException  if the provided array is empty.
     * @throws NullPointerException if the provided array is null.
     */
    private static void validate(final int[] numbers) {
        if (numbers == null) {
            throw new EmptyArrayException(EXPECTED_NON_NULL_ARGUMENT);
        }

        if (numbers.length == 0) {
            throw new EmptyArrayException(ARRAY_MUST_NOT_BE_EMPTY);
        }
    }
}
