package com.it.academy.gk.sc0.operators.task4;

import com.it.academy.gk.sc0.operators.exception.InvalidDigitNumberException;
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
 * The DigitOperationsTest class is a test class for the DigitOperations class.
 * It contains tests for the calculateDigitSum, calculateDigitProduct, and calculateNumberOfDigits methods of the DigitOperations class.
 */
@SuppressFBWarnings("NP_NONNULL_RETURN_VIOLATION")
class DigitOperationsTest {
    /**
     * The digitOperations field is an instance of the DigitOperations class.
     */
    private DigitOperations digitOperations;

    /**
     * The provideValidArgumentsForCalculateDigitSum method provides valid test data for the testValidCasesForCalculateDigitSum method.
     * It returns a Stream of Arguments, where each Argument contains a number and its expected digit sum.
     *
     * @return a Stream of Arguments for the testValidCasesForCalculateDigitSum method
     */
    static @NotNull Stream<Arguments> provideValidArgumentsForCalculateDigitSum() {
        return Stream.of(
                Arguments.of(12, 3),
                Arguments.of(111, 3),
                Arguments.of(321, 6)
        );
    }

    /**
     * The provideValidArgumentsForCalculateDigitProduct method provides valid test data for the testValidCasesForCalculateDigitProduct method.
     * It returns a Stream of Arguments, where each Argument contains a number and its expected digit product.
     *
     * @return a Stream of Arguments for the testValidCasesForCalculateDigitProduct method
     */
    static @NotNull Stream<Arguments> provideValidArgumentsForCalculateDigitProduct() {
        return Stream.of(
                Arguments.of(12, 2),
                Arguments.of(111, 1),
                Arguments.of(321, 6)
        );
    }

    /**
     * The provideValidArgumentsForCalculateNumberOfDigits method provides valid test data for the testValidCasesForCalculateNumberOfDigits method.
     * It returns a Stream of Arguments, where each Argument contains a number and its expected number of digits.
     *
     * @return a Stream of Arguments for the testValidCasesForCalculateNumberOfDigits method
     */
    static @NotNull Stream<Arguments> provideValidArgumentsForCalculateNumberOfDigits() {
        return Stream.of(
                Arguments.of(12, 2),
                Arguments.of(111, 3),
                Arguments.of(321, 3)
        );
    }

    /**
     * The provideInvalidArguments method provides invalid test data for all testInvalidCases methods.
     * It returns a Stream of Arguments, where each Argument contains an invalid number.
     *
     * @return a Stream of Arguments for all testInvalidCases methods
     */
    static @NotNull Stream<Arguments> provideInvalidArguments() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(9),
                Arguments.of(1000)
        );
    }

    /**
     * The setUp method is called before each test method.
     * It initializes the digitOperations field with a new instance of the DigitOperations class.
     */
    @BeforeEach
    void setUp() {
        digitOperations = new DigitOperations();
    }

    /**
     * The testValidCasesForCalculateDigitSum method tests the calculateDigitSum method of the DigitOperations class with various valid inputs.
     * It is a parameterized test that uses the data provided by the provideValidArgumentsForCalculateDigitSum method.
     *
     * @param number   a number
     * @param expected its expected digit sum
     */
    @ParameterizedTest(name = "With number = {0}, expected sum = {1}")
    @MethodSource("provideValidArgumentsForCalculateDigitSum")
    @DisplayName("Valid cases for calculateDigitSum")
    void testValidCasesForCalculateDigitSum(int number, int expected) throws InvalidDigitNumberException {
        var actual = digitOperations.calculateDigitSum(number);

        assertEquals(expected, actual);
    }

    /**
     * The testValidCasesForCalculateDigitProduct method tests the calculateDigitProduct method of the DigitOperations class with various valid inputs.
     * It is a parameterized test that uses the data provided by the provideValidArgumentsForCalculateDigitProduct method.
     *
     * @param number   a number
     * @param expected its expected digit product
     */
    @ParameterizedTest(name = "With number = {0}, expected product = {1}")
    @MethodSource("provideValidArgumentsForCalculateDigitProduct")
    @DisplayName("Valid cases for calculateDigitProduct")
    void testValidCasesForCalculateDigitProduct(int number, int expected) throws InvalidDigitNumberException {
        var actual = digitOperations.calculateDigitProduct(number);

        assertEquals(expected, actual);
    }

    /**
     * The testValidCasesForCalculateNumberOfDigits method tests the calculateNumberOfDigits method of the DigitOperations class with various valid inputs.
     * It is a parameterized test that uses the data provided by the provideValidArgumentsForCalculateNumberOfDigits method.
     *
     * @param number   a number
     * @param expected its expected number of digits
     */
    @ParameterizedTest(name = "With number = {0}, expected numberOfDigits = {1}")
    @MethodSource("provideValidArgumentsForCalculateNumberOfDigits")
    @DisplayName("Valid cases for calculateNumberOfDigits")
    void testValidCasesForCalculateNumberOfDigits(int number, int expected) throws InvalidDigitNumberException {
        var actual = digitOperations.calculateNumberOfDigits(number);

        assertEquals(expected, actual);
    }

    /**
     * The testInvalidCasesForCalculateDigitSum method tests the calculateDigitSum method of the DigitOperations class with various invalid inputs.
     * It is a parameterized test that uses the data provided by the provideInvalidArguments method.
     *
     * @param number an invalid number
     */
    @ParameterizedTest(name = "With invalid number = {0}")
    @MethodSource("provideInvalidArguments")
    @DisplayName("Invalid cases for calculateDigitSum")
    void testInvalidCasesForCalculateDigitSum(int number) {
        assertThrows(InvalidDigitNumberException.class, () -> digitOperations.calculateDigitSum(number));
    }

    /**
     * The testInvalidCasesForCalculateDigitProduct method tests the calculateDigitProduct method of the DigitOperations class with various invalid inputs.
     * It is a parameterized test that uses the data provided by the provideInvalidArguments method.
     *
     * @param number an invalid number
     */
    @ParameterizedTest(name = "With invalid number = {0}")
    @MethodSource("provideInvalidArguments")
    @DisplayName("Invalid cases for calculateDigitProduct")
    void testInvalidCasesForCalculateDigitProduct(int number) {
        assertThrows(InvalidDigitNumberException.class, () -> digitOperations.calculateDigitProduct(number));
    }

    /**
     * The testInvalidCasesForCalculateNumberOfDigits method tests the calculateNumberOfDigits method of the DigitOperations class with various invalid inputs.
     * It is a parameterized test that uses the data provided by the provideInvalidArguments method.
     *
     * @param number an invalid number
     */
    @ParameterizedTest(name = "With invalid number = {0}")
    @MethodSource("provideInvalidArguments")
    @DisplayName("Invalid cases for calculateNumberOfDigits")
    void testInvalidCasesForCalculateNumberOfDigits(int number) {
        assertThrows(InvalidDigitNumberException.class, () -> digitOperations.calculateNumberOfDigits(number));
    }
}
