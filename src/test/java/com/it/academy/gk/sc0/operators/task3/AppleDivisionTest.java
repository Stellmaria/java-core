package com.it.academy.gk.sc0.operators.task3;

import com.it.academy.gk.sc0.operators.exception.DivisionByZeroException;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * The AppleDivisionTest class is a test class for the AppleDivision class.
 * It contains tests for the calculateApplesPerStudent, calculateRemainingApples, and calculateTotalApples methods of the AppleDivision class.
 */
@SuppressFBWarnings("NP_NONNULL_RETURN_VIOLATION")
class AppleDivisionTest {

    /**
     * The appleDivision field is an instance of the AppleDivision class.
     */
    private AppleDivision appleDivision;

    /**
     * The provideValidArgumentsForCalculateApplesPerStudent method provides valid test data for the testValidCasesForCalculateApplesPerStudent method.
     * It returns a Stream of Arguments, where each Argument contains the number of students, the number of apples, and the expected number of apples per student.
     *
     * @return a Stream of Arguments for the testValidCasesForCalculateApplesPerStudent method
     */
    static @NotNull Stream<Arguments> provideValidArgumentsForCalculateApplesPerStudent() {
        return Stream.of(
                Arguments.of(5, 15, 3),
                Arguments.of(4, 10, 2),
                Arguments.of(3, 7, 2)
        );
    }

    /**
     * The provideValidArgumentsForCalculateRemainingApples method provides valid test data for the testValidCasesForCalculateRemainingApples method.
     * It returns a Stream of Arguments, where each Argument contains the number of students, the number of apples, and the expected number of remaining apples.
     *
     * @return a Stream of Arguments for the testValidCasesForCalculateRemainingApples method
     */
    static @NotNull Stream<Arguments> provideValidArgumentsForCalculateRemainingApples() {
        return Stream.of(
                Arguments.of(5, 15, 0),
                Arguments.of(4, 10, 2),
                Arguments.of(3, 7, 1)
        );
    }

    /**
     * The provideValidArgumentsForCalculateTotalApples method provides valid test data for the testValidCasesForCalculateTotalApples method.
     * It returns a Stream of Arguments, where each Argument contains the number of students, the number of apples, and the expected total number of apples.
     *
     * @return a Stream of Arguments for the testValidCasesForCalculateTotalApples method
     */
    static @NotNull Stream<Arguments> provideValidArgumentsForCalculateTotalApples() {
        return Stream.of(
                Arguments.of(5, 15, 15),
                Arguments.of(4, 10, 8),
                Arguments.of(3, 7, 6)
        );
    }

    /**
     * The provideInvalidArguments method provides invalid test data for all testInvalidCases methods.
     * It returns a Stream of Arguments, where each Argument contains an invalid number of students and an invalid number of apples.
     *
     * @return a Stream of Arguments for all testInvalidCases methods
     */
    static @NotNull Stream<Arguments> provideInvalidArguments() {
        return Stream.of(
                Arguments.of(0, 15),
                Arguments.of(0, 0)
        );
    }

    /**
     * The setUp method is called before each test method.
     * It initializes the appleDivision field with a new instance of the AppleDivision class.
     */
    @BeforeEach
    void setUp() {
        appleDivision = new AppleDivision();
    }

    /**
     * The testValidCasesForCalculateApplesPerStudent method tests the calculateApplesPerStudent method of the AppleDivision class with various valid inputs.
     * It is a parameterized test that uses the data provided by the provideValidArgumentsForCalculateApplesPerStudent method.
     *
     * @param n        the number of students
     * @param k        the number of apples
     * @param expected the expected number of apples per student
     */
    @ParameterizedTest(name = "With n = {0}, k = {1}, expected apples per student = {2}")
    @MethodSource("provideValidArgumentsForCalculateApplesPerStudent")
    @DisplayName("Valid cases for calculateApplesPerStudent")
    void testValidCasesForCalculateApplesPerStudent(final int n, final int k,
                                                    final int expected) throws DivisionByZeroException {
        var actual = appleDivision.calculateApplesPerStudent(n, k);

        assertEquals(expected, actual);
    }

    /**
     * The testValidCasesForCalculateRemainingApples method tests the calculateRemainingApples method of the AppleDivision class with various valid inputs.
     * It is a parameterized test that uses the data provided by the provideValidArgumentsForCalculateRemainingApples method.
     *
     * @param n        the number of students
     * @param k        the number of apples
     * @param expected the expected number of remaining apples
     */
    @ParameterizedTest(name = "With n = {0}, k = {1}, expected remaining apples = {2}")
    @MethodSource("provideValidArgumentsForCalculateRemainingApples")
    @DisplayName("Valid cases for calculateRemainingApples")
    void testValidCasesForCalculateRemainingApples(final int n, final int k,
                                                   final int expected) throws DivisionByZeroException {
        var actual = appleDivision.calculateRemainingApples(n, k);

        assertEquals(expected, actual);
    }

    /**
     * The testValidCasesForCalculateTotalApples method tests the calculateTotalApples method of the AppleDivision class with various valid inputs.
     * It is a parameterized test that uses the data provided by the provideValidArgumentsForCalculateTotalApples method.
     *
     * @param n        the number of students
     * @param k        the number of apples
     * @param expected the expected total number of apples
     */
    @ParameterizedTest(name = "With n = {0}, k = {1}, expected total apples = {2}")
    @MethodSource("provideValidArgumentsForCalculateTotalApples")
    @DisplayName("Valid cases for calculateTotalApples")
    void testValidCasesForCalculateTotalApples(final int n, final int k,
                                               final int expected) throws DivisionByZeroException {
        var actual = appleDivision.calculateTotalApples(n, k);

        assertEquals(expected, actual);
    }

    /**
     * The testInvalidCasesForCalculateApplesPerStudent method tests the calculateApplesPerStudent method of the AppleDivision class with various invalid inputs.
     * It is a parameterized test that uses the data provided by the provideInvalidArguments method.
     *
     * @param n an invalid number of students
     * @param k an invalid number of apples
     */
    @ParameterizedTest(name = "With n = {0}, k = {1}, expect DivisionByZeroException")
    @MethodSource("provideInvalidArguments")
    @DisplayName("Invalid case for calculateApplesPerStudent")
    void testInvalidCasesForCalculateApplesPerStudent(final int n, final int k) {
        assertThrows(DivisionByZeroException.class, () -> appleDivision.calculateApplesPerStudent(n, k));
    }

    /**
     * The testInvalidCasesForCalculateRemainingApples method tests the calculateRemainingApples method of the AppleDivision class with various invalid inputs.
     * It is a parameterized test that uses the data provided by the provideInvalidArguments method.
     *
     * @param n an invalid number of students
     * @param k an invalid number of apples
     */
    @ParameterizedTest(name = "With n = {0}, k = {1}, expect DivisionByZeroException")
    @MethodSource("provideInvalidArguments")
    @DisplayName("Invalid case for calculateRemainingApples")
    void testInvalidCasesForCalculateRemainingApples(final int n, final int k) {
        assertThrows(DivisionByZeroException.class, () -> appleDivision.calculateRemainingApples(n, k));
    }

    /**
     * The testInvalidCasesForCalculateTotalApples method tests the calculateTotalApples method of the AppleDivision class with various invalid inputs.
     * It is a parameterized test that uses the data provided by the provideInvalidArguments method.
     *
     * @param n an invalid number of students
     * @param k an invalid number of apples
     */
    @ParameterizedTest(name = "With n = {0}, k = {1}, expect DivisionByZeroException")
    @MethodSource("provideInvalidArguments")
    @DisplayName("Invalid case for calculateTotalApples")
    void testInvalidCasesForCalculateTotalApples(final int n, final int k) {
        assertThrows(DivisionByZeroException.class, () -> appleDivision.calculateTotalApples(n, k));
    }
}
