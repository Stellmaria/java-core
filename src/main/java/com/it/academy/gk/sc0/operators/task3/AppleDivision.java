package com.it.academy.gk.sc0.operators.task3;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

/**
 * AppleDivision is a utility class that provides methods for dividing a certain number of apples among a given number of students.
 * It includes methods for calculating the number of apples per student, the remaining apples, and the total apples that will be distributed.
 *
 * <p>Example usage:</p>
 * <pre>
 *     int perStudent = AppleDivision.calculateApplesPerStudent(5, 22);  // perStudent will be 4
 *     int remaining = AppleDivision.calculateRemainingApples(5, 22);    // remaining will be 2
 *     int total = AppleDivision.calculateTotalApples(5, 22);            // total will be 20
 * </pre>
 *
 * <p>Example for invalid inputs (will throw IllegalArgumentException):</p>
 * <pre>
 *     try {
 *         int perStudent = AppleDivision.calculateApplesPerStudent(0, 22);  // will throw IllegalArgumentException
 *     } catch (IllegalArgumentException e) {
 *         System.out.println(e.getMessage());  // prints "Number of students must be greater than zero or cannot be negative"
 *     }
 *     try {
 *         int remaining = AppleDivision.calculateRemainingApples(5, -1);    // will throw IllegalArgumentException
 *     } catch (IllegalArgumentException e) {
 *         System.out.println(e.getMessage());  // prints "Number of apples cannot be negative or must be greater than zero"
 *     }
 * </pre>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
@UtilityClass
public final class AppleDivision {
    /**
     * Error message for invalid number of students.
     */
    private static final String MSG_STUDENTS_GT_ZERO = "Number of students must be greater than zero or cannot be negative";

    /**
     * Error message for negative number of apples.
     */
    private static final String MSG_APPLES_NOT_NEGATIVE = "Number of apples cannot be negative or must be greater than zero";

    /**
     * Calculates the remaining number of apples after distribution.
     *
     * <p>Example:</p>
     * <pre>
     *     int remaining = AppleDivision.calculateRemainingApples(5, 22);  // remaining will be 2
     * </pre>
     *
     * @param n the number of students. Must be greater than zero.
     * @param k the total number of apples.
     * @return the remaining number of apples.
     * @throws IllegalArgumentException if the number of students is not greater than zero or if the number of apples is negative.
     */
    public static int calculateApplesPerStudent(final int n, final int k) {
        validate(n, k);

        return k / n;
    }

    /**
     * Calculates the total number of apples that will be distributed among the students.
     *
     * <p>Example:</p>
     * <pre>
     *     int total = AppleDivision.calculateTotalApples(5, 22);  // total will be 20
     * </pre>
     *
     * @param n the number of students. Must be greater than zero.
     * @param k the total number of apples.
     * @return the total number of apples that will be distributed.
     * @throws IllegalArgumentException if the number of students is not greater than zero or if the number of apples is negative.
     */
    @SneakyThrows
    public static int calculateRemainingApples(final int n, final int k) {
        validate(n, k);

        return k % n;
    }

    /**
     * Calculates the total number of apples that will be distributed among the students.
     *
     * @param n the number of students. Must be greater than zero.
     * @param k the total number of apples.
     * @return the total number of apples that will be distributed.
     * @throws IllegalArgumentException if the number of students is not greater than zero or if the number of apples is negative.
     */
    @SneakyThrows
    public static int calculateTotalApples(final int n, final int k) {
        validate(n, k);
        var perStudent = calculateApplesPerStudent(n, k);

        return perStudent * n;
    }

    /**
     * Validates the number of students and the total number of apples.
     *
     * @param n the number of students.
     * @param k the total number of apples.
     * @throws IllegalArgumentException if the number of students is not greater than zero or if the number of apples is negative.
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
