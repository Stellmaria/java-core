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
     * A constant message for when the number of students is not greater than zero.
     */
    private static final String MSG_STUDENTS_GT_ZERO = "Number of students must be greater than zero";

    /**
     * A constant message for when the number of apples is not zero or greater.
     */
    private static final String MSG_APPLES_NOT_NEGATIVE = "Number of apples must be zero or greater";

    /**
     * Calculates the number of apples each student will receive.
     *
     * @param n the number of students
     * @param k the total number of apples
     * @return the number of apples per student
     * @throws IllegalArgumentException if the number of students is not greater than zero or
     *                                  if the number of apples is not zero or greater
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
     * @throws IllegalArgumentException if the number of students is not greater than zero or
     *                                  if the number of apples is not zero or greater
     */
    public static int calculateRemainingApples(final int n, final int k) {
        validate(n, k);

        return k % n;
    }

    /**
     * Validates the input parameters.
     *
     * @param n the number of students
     * @param k the total number of apples
     * @throws IllegalArgumentException if the number of students is not greater than zero or
     *                                  if the number of apples is not zero or greater
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
