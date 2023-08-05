package com.it.academy.gk.sc0.statements;

import java.util.stream.IntStream;

/**
 * This class finds the first number divisible by a given divisor on a given interval.
 */
public class FirstDivisibleNumber {
    /**
     * Finds the first number divisible by the given divisor on the given interval.
     * <p>
     * This method finds the first number divisible by the given divisor on the interval [lowerBound; upperBound]
     * using the Stream API. It generates a stream of integers from lowerBound to upperBound, inclusive,
     * and filters the stream to include only numbers that are divisible by divisor. It then returns
     * the first number in the filtered stream, or -1 if no such number is found.
     *
     * @param lowerBound the lower bound of the interval
     * @param upperBound the upper bound of the interval
     * @param divisor    the divisor to use when checking for divisibility
     * @return the first number divisible by divisor on the interval [lowerBound; upperBound],
     * or -1 if no such number is found
     */
    public int findFirstDivisibleNumber(final int lowerBound, final int upperBound, final int divisor) {
        return IntStream.rangeClosed(lowerBound, upperBound)
                .filter(i -> i % divisor == 0)
                .findFirst()
                .orElse(-1);
    }
}
