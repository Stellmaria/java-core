package com.it.academy.gk.sc0.operators.task1;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

/**
 * The SumNumbers class provides a method to calculate the sum of an arbitrary number of integers.
 */
public class SumNumbers {
    /**
     * Calculates the sum of the given numbers.
     *
     * @param numbers an arbitrary number of integers to be summed up
     * @return the sum of the given numbers
     */
    public int sum(final int @NotNull ... numbers) {
        return Arrays.stream(numbers).sum();
    }
}
