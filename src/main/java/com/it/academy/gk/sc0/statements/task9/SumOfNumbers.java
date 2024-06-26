package com.it.academy.gk.sc0.statements.task9;

import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

/**
 * A utility class for calculating the sum of numbers up to a given limit.
 * The class provides a method to print the intermediate sums of consecutive numbers up to a given limit.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public class SumOfNumbers {
    /**
     * Error message for non-negative parameters.
     */
    private static final String BE_NON_NEGATIVE = "Parameters n and limit must be non-negative";

    /**
     * Prints the intermediate sums of consecutive numbers up to a given limit.
     *
     * @param n     the number of consecutive numbers to consider
     * @param limit the maximum sum allowed
     * @return a string containing the intermediate sums, separated by commas
     * @throws IllegalArgumentException if either n or limit is negative
     */
    public static @NotNull String printIntermediateSums(final int n, final int limit) {
        if (n < 0 || limit < 0) {
            throw new IllegalArgumentException(BE_NON_NEGATIVE);
        }

        final var separator = ",";

        var result = new StringBuilder();
        var sum = 0;

        for (var i = 1; i <= n; i++) {
            sum += i;

            if (sum <= limit) {
                if (!result.isEmpty()) {
                    result.append(separator);
                }
                result.append(sum);
            } else {
                break;
            }
        }

        return result.toString();
    }
}
