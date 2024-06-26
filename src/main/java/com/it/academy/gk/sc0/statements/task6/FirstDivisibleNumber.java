package com.it.academy.gk.sc0.statements.task6;

import lombok.experimental.UtilityClass;

import java.util.stream.IntStream;

/**
 * A utility class to find the first divisible number within a given range.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public class FirstDivisibleNumber {
    /**
     * Finds the first divisible number within the specified range.
     *
     * @param lowerBound The lower bound of the range (inclusive).
     * @param upperBound The upper bound of the range (inclusive).
     * @param divisor The divisor to check for divisibility.
     * @return The first divisible number within the range, or -1 if no such number exists.
     */
    public static int findFirstDivisibleNumber(final int lowerBound, final int upperBound, final int divisor) {
        return IntStream.rangeClosed(lowerBound, upperBound)
                .filter(i -> i % divisor == 0)
                .findFirst()
                .orElse(-1);
    }
}
