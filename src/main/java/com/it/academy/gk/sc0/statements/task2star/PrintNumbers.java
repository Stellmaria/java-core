package com.it.academy.gk.sc0.statements.task2star;

import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This utility class provides a method to generate a string of numbers within a given range,
 * incrementing by a specified amount.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public class PrintNumbers {
    /**
     * Error message for when the increment is zero.
     */
    public static final String INCREMENT_CANNOT_BE_ZERO = "Increment cannot be zero.";

    /**
     * Generates a string of numbers within the specified range, incrementing by the given amount.
     *
     * @param first     The first number in the range.
     * @param last      The last number in the range.
     * @param increment The amount by which to increment each number.
     * @return A string of numbers separated by spaces, inclusive of the first and last numbers.
     * @throws IllegalArgumentException If the increment is zero.
     */
    public static String generateNumbersTask2Star(final int first, final int last, final int increment) {
        if (increment == 0) {
            throw new IllegalArgumentException(INCREMENT_CANNOT_BE_ZERO);
        }

        final var separator = " ";

        return IntStream.iterate(first, i -> i + increment)
                .limit((long) (last - first) / increment + 1)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(separator));
    }
}
