package com.it.academy.gk.sc0.statements;

import java.util.stream.IntStream;

/**
 * Task 8.
 * Find on the interval [19; 97] the first number is a multiple of 17.
 */
public class OddNumberCounter {
    /**
     * The lower bound for the input integer n.
     */
    private static final int LOWER_BOUND = 0;
    /**
     * The constant value for zero.
     */
    private static final int ZERO = 0;

    /**
     * Counts the number of odd numbers from 0 to a given integer n.
     * <p>
     * This method counts the number of odd numbers from 0 to a given integer n using the Stream API.
     * If it is less than the lower bound, it returns zero. Otherwise, it generates a stream of integers from 0 to n,
     * inclusive, and filters the stream to include only odd numbers. It then returns the count
     * of elements in the filtered stream, which is equal to the number of odd numbers from 0 to n.
     *
     * @param n the upper bound for counting odd numbers
     * @return the number of odd numbers from 0 to n
     */
    public int countOddNumbers(final int n) {
        if (n < LOWER_BOUND) {
            return ZERO;
        }

        return (int) IntStream.rangeClosed(0, n)
                .filter(i -> i % 2 != 0)
                .count();
    }
}
