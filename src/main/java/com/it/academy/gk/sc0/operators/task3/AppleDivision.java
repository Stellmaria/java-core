package com.it.academy.gk.sc0.operators.task3;

import lombok.experimental.UtilityClass;

/**
 * A utility class for dividing apples among students.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public final class AppleDivision {
    /**
     * Message for when the number of students is not greater than zero.
     */
    private static final String MSG_STUDENTS_GT_ZERO =
            "Number of students must be greater than zero or cannot be negative";

    /**
     * Message for when the number of apples is not greater than zero.
     */
    private static final String MSG_APPLES_NOT_NEGATIVE =
            "Number of apples cannot be negative or must be greater than zero";

    /**
     * Calculates the number of apples each student receives.
     *
     * @param n the number of students
     * @param k the total number of apples
     * @return the number of apples each student receives
     * @throws IllegalArgumentException if n is not greater than zero or k is not greater than zero
     */
    public static int calculateApplesPerStudent(final int n, final int k) {
        validate(n, k);

        return k / n;
    }

    /**
     * Calculates the remaining apples after dividing them among students.
     *
     * @param n the number of students
     * @param k the total number of apples
     * @return the remaining apples
     * @throws IllegalArgumentException if n is not greater than zero or k is not greater than zero
     */
    public static int calculateRemainingApples(final int n, final int k) {
        validate(n, k);

        return k % n;
    }

    /**
     * Calculates the total number of apples.
     *
     * @param n the number of students
     * @param k the total number of apples
     * @return the total number of apples
     * @throws IllegalArgumentException if n is not greater than zero or k is not greater than zero
     */
    public static int calculateTotalApples(final int n, final int k) {
        validate(n, k);

        var perStudent = calculateApplesPerStudent(n, k);

        return perStudent * n;
    }

    /**
     * Validates the input parameters.
     *
     * @param n the number of students
     * @param k the total number of apples
     * @throws IllegalArgumentException if n is not greater than zero or k is not greater than zero
     */
    private static void validate(int n, int k) {
        if (n <= 0) {
            throw new IllegalArgumentException(MSG_STUDENTS_GT_ZERO);
        }

        if (k <= 0) {
            throw new IllegalArgumentException(MSG_APPLES_NOT_NEGATIVE);
        }
    }
}
