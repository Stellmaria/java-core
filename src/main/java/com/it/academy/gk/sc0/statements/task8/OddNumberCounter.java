package com.it.academy.gk.sc0.statements.task8;

import lombok.experimental.UtilityClass;

/**
 * A utility class for counting odd numbers in a given range.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public class OddNumberCounter {
    /**
     * A constant string to be used in IllegalArgumentException when n is negative.
     */
    private static final String BE_NON_NEGATIVE = "n must be non-negative";

    /**
     * Counts the number of odd numbers in the range from 0 to n (inclusive).
     *
     * @param n the upper limit of the range
     * @return the count of odd numbers in the range from 0 to n
     * @throws IllegalArgumentException if n is negative
     */
    public static int countOddNumbers(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(BE_NON_NEGATIVE);
        }

        var count = 0;

        for (int i = 0; i <= n; i++) {
            if (i % 2 != 0) {
                count++;
            }
        }

        return count;
    }
}
