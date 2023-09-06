package com.it.academy.gk.sc0.operators.task3;

import com.it.academy.gk.sc0.operators.exception.InvalidNumberOfApplesException;
import com.it.academy.gk.sc0.operators.exception.InvalidNumberOfStudentsException;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

/**
 * AppleDivision is a utility class
 * that provides methods for dividing a certain number of apples among a given number of students.
 * It includes methods for calculating the number of apples per student,
 * the remaining apples, and the total apples that will be distributed.
 *
 * <p>Example usage:</p>
 * <pre>
 *     int perStudent = AppleDivision.calculateApplesPerStudent(5, 22);  // perStudent will be 4
 *     int remaining = AppleDivision.calculateRemainingApples(5, 22);    // remaining will be 2
 *     int total = AppleDivision.calculateTotalApples(5, 22);            // total will be 20
 * </pre>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
@UtilityClass
public final class AppleDivision {
    /**
     * A constant holding the message for an invalid number of students.
     */
    private static final String NUMBER_OF_STUDENTS_MUST_BE_GREATER_THAN_ZERO =
            "Number of students must be greater than zero or cannot be negative";

    /**
     * A constant holding the message for invalid number of apples.
     */
    private static final String NUMBER_OF_APPLES_CANNOT_BE_NEGATIVE =
            "Number of apples cannot be negative or must be greater than zero";

    /**
     * Calculates the number of apples each student will get.
     *
     * @param n the number of students. Must be greater than zero.
     * @param k the total number of apples.
     * @return the number of apples per student.
     */
    @SneakyThrows
    public static int calculateApplesPerStudent(final int n, final int k) {
        validate(n, k);

        return k / n;
    }

    /**
     * Calculates the remaining number of apples after distribution.
     *
     * @param n the number of students. Must be greater than zero.
     * @param k the total number of apples.
     * @return the remaining number of apples.
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
     */
    @SneakyThrows
    public static int calculateTotalApples(final int n, final int k) {
        validate(n, k);

        return calculateApplesPerStudent(n, k) * n;
    }

    /**
     * Validates the number of students and the total number of apples.
     *
     * @param n the number of students.
     * @param k the total number of apples.
     * @throws InvalidNumberOfStudentsException if the number of students is not greater than zero.
     * @throws InvalidNumberOfApplesException   if the number of apples is negative.
     */
    private static void validate(int n, int k) {
        if (n <= 0) {
            throw new InvalidNumberOfStudentsException(NUMBER_OF_STUDENTS_MUST_BE_GREATER_THAN_ZERO);
        }

        if (k <= 0) {
            throw new InvalidNumberOfApplesException(NUMBER_OF_APPLES_CANNOT_BE_NEGATIVE);
        }
    }
}
