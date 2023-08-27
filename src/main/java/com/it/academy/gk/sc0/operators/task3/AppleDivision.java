package com.it.academy.gk.sc0.operators.task3;

import com.it.academy.gk.sc0.operators.exception.DivisionByZeroException;

/**
 * The AppleDivision class provides methods to calculate the number of apples each student will receive and the number of remaining apples.
 */
public class AppleDivision {
    /**
     * The error message used when the number of students is zero.
     */
    private static final String DIVISION_BY_ZERO_MESSAGE = "Number of students cannot be zero";

    /**
     * Calculates the number of apples each student will receive.
     *
     * @param n the number of students
     * @param k the total number of apples
     * @return the number of apples each student will receive
     * @throws DivisionByZeroException if the number of students is zero
     */
    public int calculateApplesPerStudent(final int n, final int k) throws DivisionByZeroException {
        validate(n);

        return k / n;
    }

    /**
     * Calculates the number of remaining apples after dividing them among the students.
     *
     * @param n the number of students
     * @param k the total number of apples
     * @return the number of remaining apples
     * @throws DivisionByZeroException if the number of students is zero
     */
    public int calculateRemainingApples(final int n, final int k) throws DivisionByZeroException {
        validate(n);

        return k % n;
    }

    /**
     * Calculates the total number of apples that all students will receive.
     *
     * @param n the number of students
     * @param k the total number of apples
     * @return the total number of apples that all students will receive
     * @throws DivisionByZeroException if the number of students is zero
     */
    public int calculateTotalApples(final int n, final int k) throws DivisionByZeroException {
        validate(n);

        return (k / n) * n;
    }

    /**
     * Validates the given integer value.
     *
     * @param n the integer value to be validated
     * @throws DivisionByZeroException if the given integer value is zero
     */
    private void validate(int n) {
        if (n == 0) {
            throw new DivisionByZeroException(DIVISION_BY_ZERO_MESSAGE);
        }
    }
}
