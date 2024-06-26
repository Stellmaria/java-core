package com.it.academy.gk.sc0.statements.task1;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

/**
 * A utility class for generating a string of numbers within a specified range.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public class PrintNumbers {
    /**
     * Error message for when the minimum value is greater than the maximum value.
     */
    private static final String ERROR_MESSAGE_MIN_GREATER_THAN_MAX =
            "Min value must be less than or equal to max value";

    /**
     * Separator for numbers in the generated string.
     */
    private static final String SEPARATOR = " ";

    /**
     * Generates a string of numbers within the specified range, inclusive.
     *
     * @param minValue The minimum value of the range.
     * @param maxValue The maximum value of the range.
     * @return A string of numbers separated by spaces.
     * @throws IllegalArgumentException If the minimum value is greater than the maximum value.
     */
    public static @NotNull String generateNumberString(final int minValue, final int maxValue) {
        validateRange(minValue, maxValue);

        var numberStringBuilder = new StringBuilder();

        for (int i = minValue; i <= maxValue; i++) {
            if (i > minValue) {
                numberStringBuilder.append(SEPARATOR);
            }
            numberStringBuilder.append(i);
        }

        return numberStringBuilder.toString();
    }

    /**
     * Validates that the minimum value is less than or equal to the maximum value.
     *
     * @param minValue The minimum value of the range.
     * @param maxValue The maximum value of the range.
     * @throws IllegalArgumentException If the minimum value is greater than the maximum value.
     */
    private static void validateRange(int minValue, int maxValue) {
        if (minValue > maxValue) {
            throw new IllegalArgumentException(ERROR_MESSAGE_MIN_GREATER_THAN_MAX);
        }
    }
}
