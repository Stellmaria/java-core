package com.it.academy.gk.sc0.operators.task4;

/**
 * This interface represents a functional interface that performs an operation on two integers.
 * It is annotated with {@link FunctionalInterface} to ensure that it only contains a single abstract method.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@FunctionalInterface
public interface DigitOperation {
    /**
     * Applies the operation to the given arguments.
     *
     * @param a the first integer operand
     * @param b the second integer operand
     * @return the result of the operation
     */
    int apply(int a, int b);
}
