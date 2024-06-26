package com.it.academy.gk.sc0.statements.task4star;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A utility class for printing numbers in a specific range.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public class PrintNumbers {
    /**
     * Error message for when the upper bound is less than the lower bound.
     */
    public static final String IS_LESS_THAN_LOWER_BOUND =
            "No numbers to print because upperBound is less than lowerBound";

    /**
     * Prints numbers from the upper bound to the lower bound in descending order, separated by a space.
     *
     * @param upperBound The upper bound of the range.
     * @param lowerBound The lower bound of the range.
     * @return A string of numbers separated by a space.
     * @throws IllegalArgumentException If the upper bound is less than the lower bound.
     */
    public static @NotNull String printNumbersTask4Star(final int upperBound, final int lowerBound) {
        if (upperBound < lowerBound) {
            throw new IllegalArgumentException(IS_LESS_THAN_LOWER_BOUND);
        }

        final var separator = " ";

        return IntStream.iterate(upperBound, i -> i >= lowerBound, i -> i - 1)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(separator))
                .trim(); // Trim to remove any trailing whitespace
    }
}
