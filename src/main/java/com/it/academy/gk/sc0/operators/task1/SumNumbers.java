package com.it.academy.gk.sc0.operators.task1;

import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Objects;

/**
 * A utility class for summing up an array of integers.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public final class SumNumbers {
    /**
     * Constant for error message when the input array is null.
     */
    private static final String EXPECTED_NON_NULL_ARGUMENT = "Expected non-null argument";

    /**
     * Constant for error message when the input array is empty.
     */
    private static final String ARRAY_MUST_NOT_BE_EMPTY = "Array must not be empty";

    /**
     * Calculates the sum of all the integers in the given array.
     *
     * @param numbers the array of integers to sum
     * @return the sum of all the integers in the array
     * @throws NullPointerException     if the input array is null
     * @throws IllegalArgumentException if the input array is empty
     */
    public static long sum(final int... numbers) {
        validate(numbers);

        return Arrays.stream(numbers).asLongStream().sum();
    }

    /**
     * Validates the input array.
     *
     * @param numbers the array of integers to validate
     * @throws NullPointerException     if the input array is null
     * @throws IllegalArgumentException if the input array is empty
     */
    private static void validate(final int[] numbers) {
        Objects.requireNonNull(numbers, EXPECTED_NON_NULL_ARGUMENT);

        if (numbers.length == 0) {
            throw new IllegalArgumentException(ARRAY_MUST_NOT_BE_EMPTY);
        }
    }
}
