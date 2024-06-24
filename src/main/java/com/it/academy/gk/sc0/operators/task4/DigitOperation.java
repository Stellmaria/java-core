package com.it.academy.gk.sc0.operators.task4;

/**
 * DigitOperation is a functional interface that represents operations on two integer digits.
 * It defines a single abstract method {@code apply} that takes two integers as arguments and returns an integer.
 *
 * <p>Example usage:</p>
 * <pre>
 *     DigitOperation addition = (a, b) -> a + b;
 *     int result = addition.apply(5, 3);  // result will be 8
 * </pre>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
@FunctionalInterface
public interface DigitOperation {
    /**
     * Applies an operation on two integer digits.
     *
     * @param a the first integer
     * @param b the second integer
     * @return the result of applying the operation on the two integers
     */
    int apply(int a, int b);
}
