package com.it.academy.gk.sc0.operators.task3;

import com.it.academy.gk.sc0.operators.exception.InvalidNumberOfApplesException;
import com.it.academy.gk.sc0.operators.exception.InvalidNumberOfStudentsException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.it.academy.gk.sc0.operators.task3.AppleDivision.calculateApplesPerStudent;
import static com.it.academy.gk.sc0.operators.task3.AppleDivision.calculateRemainingApples;
import static com.it.academy.gk.sc0.operators.task3.AppleDivision.calculateTotalApples;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * AppleDivisionTest is a test class
 * that performs unit tests for methods related to the division of apples among students.
 *
 * <p>This class uses JUnit 5 for parameterized testing
 * and exception testing to validate the behavior of methods for calculating apples per student, remaining apples,
 * and total apples.</p>
 *
 * @author Ansatsia Melnikova
 * @version 1.0
 * @since 2023-09-03
 */
class AppleDivisionTest {
    private static String NUMBER_OF_STUDENTS_MUST_BE_GREATER_THAN_ZERO;
    private static String NUMBER_OF_APPLES_CANNOT_BE_NEGATIVE;

    /**
     * Setup method executed before all tests in the class.
     */
    @SneakyThrows
    @BeforeAll
    public static void beforeAll() {
        var numberOfStudentsMustBeGreaterThanZeroField =
                AppleDivision.class.getDeclaredField("NUMBER_OF_STUDENTS_MUST_BE_GREATER_THAN_ZERO");
        numberOfStudentsMustBeGreaterThanZeroField.setAccessible(true);
        NUMBER_OF_STUDENTS_MUST_BE_GREATER_THAN_ZERO = (String) numberOfStudentsMustBeGreaterThanZeroField.get(null);

        var numberOfApplesCannotBeNegativeFiled =
                AppleDivision.class.getDeclaredField("NUMBER_OF_APPLES_CANNOT_BE_NEGATIVE");
        numberOfApplesCannotBeNegativeFiled.setAccessible(true);
        NUMBER_OF_APPLES_CANNOT_BE_NEGATIVE = (String) numberOfApplesCannotBeNegativeFiled.get(null);
    }

    /**
     * Provides valid numbers of apples and students for parameterized testing of the
     * {@link AppleDivision#calculateApplesPerStudent(int, int)} method.
     *
     * @return a {@link Stream} of {@link Arguments} containing numbers of apples,
     * numbers of students, and expected apples per student.
     */
    static @NotNull Stream<Arguments> provideValidArgumentsForCalculateApplesPerStudent() {
        return Stream.of(
                Arguments.of(5, 15, 3),
                Arguments.of(4, 10, 2),
                Arguments.of(3, 7, 2)
        );
    }

    /**
     * Provides valid arguments for parameterized testing of the
     * {@link AppleDivision#calculateRemainingApples(int, int)} method.
     *
     * @return a {@link Stream} of {@link Arguments} containing the number of students,
     * the number of apples, and the expected remaining apples.
     */
    static @NotNull Stream<Arguments> provideValidArgumentsForCalculateRemainingApples() {
        return Stream.of(
                Arguments.of(5, 15, 0),
                Arguments.of(4, 10, 2),
                Arguments.of(3, 7, 1)
        );
    }

    /**
     * Provides valid arguments for parameterized testing of the
     * {@link AppleDivision#calculateTotalApples(int, int)} method.
     *
     * @return a {@link Stream} of {@link Arguments} containing the number of students,
     * the number of apples, and the expected total apples.
     */
    static @NotNull Stream<Arguments> provideValidArgumentsForCalculateTotalApples() {
        return Stream.of(
                Arguments.of(5, 15, 15),
                Arguments.of(4, 10, 8),
                Arguments.of(3, 7, 6)
        );
    }

    /**
     * Provides invalid student numbers for parameterized testing of exceptions in
     * {@link AppleDivision#calculateApplesPerStudent(int, int)}.
     *
     * @return a {@link Stream} of {@link Arguments} containing invalid student numbers and the expected exception class.
     */
    static @NotNull Stream<Arguments> provideInvalidStudentNumbers() {
        return Stream.of(
                Arguments.of(0, 10, InvalidNumberOfStudentsException.class),
                Arguments.of(-1, 10, InvalidNumberOfStudentsException.class)
        );
    }

    /**
     * Provides invalid apple numbers for parameterized testing of exceptions in
     * {@link AppleDivision#calculateApplesPerStudent(int, int)}.
     *
     * @return a {@link Stream} of {@link Arguments} containing invalid apple numbers.
     */
    static @NotNull Stream<Arguments> provideInvalidAppleNumbers() {
        return Stream.of(
                Arguments.of(5, -1)
        );
    }

    /**
     * Provides invalid numbers for testing exception messages in
     * {@link AppleDivision#calculateApplesPerStudent(int, int)}.
     *
     * @return a {@link Stream} of {@link Arguments} containing invalid numbers and the expected exception message.
     */
    static @NotNull Stream<Arguments> provideInvalidNumbersForExceptionMessages() {
        return Stream.of(
                Arguments.of(0, 10, InvalidNumberOfStudentsException.class,
                        NUMBER_OF_STUDENTS_MUST_BE_GREATER_THAN_ZERO),
                Arguments.of(-1, 10, InvalidNumberOfStudentsException.class,
                        NUMBER_OF_STUDENTS_MUST_BE_GREATER_THAN_ZERO),
                Arguments.of(5, -1, InvalidNumberOfApplesException.class,
                        NUMBER_OF_APPLES_CANNOT_BE_NEGATIVE),
                Arguments.of(5, 0, InvalidNumberOfApplesException.class, NUMBER_OF_APPLES_CANNOT_BE_NEGATIVE)
        );
    }

    /**
     * Tests the {@link AppleDivision#calculateApplesPerStudent(int, int)} method with valid input parameters
     * for the number of students and apples, and expected apples per student.
     *
     * @param n        the number of students.
     * @param k        the number of apples.
     * @param expected the expected number of apples per student.
     */
    @SneakyThrows
    @ParameterizedTest(name = "With n = {0}, k = {1}, expected apples per student = {2}")
    @MethodSource("provideValidArgumentsForCalculateApplesPerStudent")
    @DisplayName("Valid cases for calculateApplesPerStudent")
    void testValidCasesForCalculateApplesPerStudent(final int n, final int k, final int expected) {
        var actual = calculateApplesPerStudent(n, k);

        assertEquals(expected, actual);
    }

    /**
     * Tests the {@link AppleDivision#calculateRemainingApples(int, int)} method with valid input parameters
     * for the number of students and apples, and expected remaining apples.
     *
     * @param n        the number of students.
     * @param k        the number of apples.
     * @param expected the expected remaining apples.
     */
    @SneakyThrows
    @ParameterizedTest(name = "With n = {0}, k = {1}, expected remaining apples = {2}")
    @MethodSource("provideValidArgumentsForCalculateRemainingApples")
    @DisplayName("Valid cases for calculateRemainingApples")
    void testValidCasesForCalculateRemainingApples(final int n, final int k, final int expected) {
        var actual = calculateRemainingApples(n, k);

        assertEquals(expected, actual);
    }

    /**
     * Tests the {@link AppleDivision#calculateTotalApples(int, int)} method with valid input parameters
     * for the number of students and apples, and expected total apples.
     *
     * @param n        the number of students.
     * @param k        the number of apples.
     * @param expected the expected total apples.
     */
    @SneakyThrows
    @ParameterizedTest(name = "With n = {0}, k = {1}, expected total apples = {2}")
    @MethodSource("provideValidArgumentsForCalculateTotalApples")
    @DisplayName("Valid cases for calculateTotalApples")
    void testValidCasesForCalculateTotalApples(final int n, final int k, final int expected) {
        var actual = calculateTotalApples(n, k);

        assertEquals(expected, actual);
    }

    /**
     * Tests for exceptions when invalid student numbers are provided to
     * {@link AppleDivision#calculateApplesPerStudent(int, int)}.
     *
     * @param n        the number of students.
     * @param k        the number of apples.
     * @param expected the expected exception class.
     */
    @ParameterizedTest(name = "Test for students = {0} and apples = {1}")
    @MethodSource("provideInvalidStudentNumbers")
    @DisplayName("Test for DivisionByZeroException and InvalidNumberOfStudentsException")
    void testInvalidNumberOfStudentsException(int n, int k, Class<? extends Exception> expected) {
        assertThrows(expected, () -> calculateApplesPerStudent(n, k));
    }

    /**
     * Tests for exceptions when invalid apple numbers are provided to
     * {@link AppleDivision#calculateApplesPerStudent(int, int)}.
     *
     * @param n the number of students.
     * @param k the number of apples.
     */
    @ParameterizedTest(name = "Test for students = {0} and apples = {1}")
    @MethodSource("provideInvalidAppleNumbers")
    @DisplayName("Test for InvalidNumberOfApplesException")
    void testInvalidNumberOfApplesException(int n, int k) {
        assertThrows(InvalidNumberOfApplesException.class, () -> calculateApplesPerStudent(n, k));
    }

    /**
     * Tests for exception messages when invalid numbers are provided to
     * {@link AppleDivision#calculateApplesPerStudent(int, int)}.
     *
     * @param n                 the number of students.
     * @param k                 the number of apples.
     * @param expectedException the expected exception class.
     * @param expectedMessage   the expected exception message.
     */
    @ParameterizedTest(name = "Test for students = {0}, apples = {1}, exception = {2}, message = {3}")
    @MethodSource("provideInvalidNumbersForExceptionMessages")
    @DisplayName("Test for exception messages")
    void testExceptionMessages(int n, int k, Class<? extends Exception> expectedException, String expectedMessage) {
        var actual = assertThrows(expectedException, () -> calculateApplesPerStudent(n, k)).getMessage();

        assertEquals(expectedMessage, actual);
    }
}
