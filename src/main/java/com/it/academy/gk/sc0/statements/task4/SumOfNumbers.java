package com.it.academy.gk.sc0.statements.task4;

import lombok.experimental.UtilityClass;

import java.util.stream.IntStream;

/**
 * A utility class to calculate the sum of numbers from 1 to n.
 * This class uses Java 8's IntStream to efficiently calculate the sum.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public class SumOfNumbers {
    /**
     * Error message constant indicating that the parameter 'n' must be greater than or equal to 1
     * in order to calculate the sum of numbers from 1 to 'n'.
     */
    public static final String THAN_OR_EQUAL_TO_1 = "n must be greater than or equal to 1";

    /**
     * Calculates the sum of numbers from 1 to n.
     *
     * @param n the upper limit of the range (inclusive)
     * @return the sum of numbers from 1 to n
     * @throws IllegalArgumentException if n is less than 1
     */
    public static int calculateSum(final int n) {
        if (n < 1) {
            throw new IllegalArgumentException(THAN_OR_EQUAL_TO_1);
        }

        return IntStream.rangeClosed(1, n).sum();
    }
}
