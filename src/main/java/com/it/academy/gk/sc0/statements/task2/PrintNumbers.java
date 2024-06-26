package com.it.academy.gk.sc0.statements.task2;

import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This utility class contains a method to print numbers in reverse order.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public class PrintNumbers {
    /**
     * Error message for when the start of the range is less than the end.
     */
    public static final String GREATER_THAN_OR_EQUAL_TO_FINISH =
            "Start of range must be greater than or equal to end of range";

    /**
     * Prints numbers from the given 'start' to 'end' in reverse order, separated by a space.
     *
     * @param start The starting number of the range.
     * @param end   The ending number of the range.
     * @return A string containing the numbers in reverse order, separated by a space.
     */
    public static String printNumbersTask2(final int start, final int end) {
        if (start < end) {
            throw new IllegalArgumentException(GREATER_THAN_OR_EQUAL_TO_FINISH);
        }

        final var separator = " ";

        // Create a stream of integers from 'start' down to 'end' (inclusive), separated by spaces
        return IntStream.iterate(start, i -> i >= end, i -> i - 1)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(separator));
    }
}
