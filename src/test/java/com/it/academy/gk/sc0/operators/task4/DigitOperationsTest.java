package com.it.academy.gk.sc0.operators.task4;

import com.it.academy.gk.sc0.operators.exception.InvalidDigitNumberException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.it.academy.gk.sc0.operators.task4.DigitOperations.calculateDigitProduct;
import static com.it.academy.gk.sc0.operators.task4.DigitOperations.calculateDigitSum;
import static com.it.academy.gk.sc0.operators.task4.DigitOperations.calculateNumberOfDigits;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * DigitOperationsTest is a test class that performs unit tests for methods related to the operations on digits.
 *
 * <p>This class uses JUnit 5 for unit testing and exception testing to validate the behavior of methods
 * for various digit operations.</p>
 *
 * @author Ansatsia Melnikova
 * @version 1.0
 * @since 2023-09-03
 */
class DigitOperationsTest {
    private static String INVALID_DIGIT_NUMBER_MESSAGE;

    /**
     * Setup method executed before all tests in the class.
     */
    @SneakyThrows
    @BeforeAll
    public static void beforeAll() {
        var invalidDigitNumberMessageField =
                DigitOperations.class.getDeclaredField("INVALID_DIGIT_NUMBER_MESSAGE");
        invalidDigitNumberMessageField.setAccessible(true);
        INVALID_DIGIT_NUMBER_MESSAGE = (String) invalidDigitNumberMessageField.get(null);
    }

    /**
     * Provides valid arguments for parameterized testing of the
     * {@link DigitOperations#calculateDigitSum(int)} method.
     *
     * @return a {@link Stream} of {@link Arguments} containing numbers,
     * and their expected sum of digits.
     */
    static @NotNull Stream<Arguments> provideValidArgumentsForCalculateDigitSum() {
        return Stream.of(
                Arguments.of(12, 3),
                Arguments.of(111, 3),
                Arguments.of(321, 6)
        );
    }

    /**
     * Tests the {@link DigitOperations#calculateDigitSum(int)} method with valid input parameters
     * for the number and expected sum of digits.
     *
     * @param number   the input number.
     * @param expected the expected sum of digits.
     */
    @SneakyThrows
    @ParameterizedTest(name = "With number = {0}, expected sum = {1}")
    @MethodSource("provideValidArgumentsForCalculateDigitSum")
    @DisplayName("Valid cases for calculateDigitSum")
    void testValidCasesForCalculateDigitSum(final int number, final int expected) {
        var actual = calculateDigitSum(number);

        assertEquals(expected, actual);
    }

    /**
     * Provides valid arguments for parameterized testing of the
     * {@link DigitOperations#calculateDigitProduct(int)} method.
     *
     * @return a {@link Stream} of {@link Arguments} containing numbers,
     * and their expected product of digits.
     */
    static @NotNull Stream<Arguments> provideValidArgumentsForCalculateDigitProduct() {
        return Stream.of(
                Arguments.of(12, 2),
                Arguments.of(111, 1),
                Arguments.of(321, 6)
        );
    }

    /**
     * Tests the {@link DigitOperations#calculateDigitProduct(int)} method with valid input parameters
     * for the number and expected product of digits.
     *
     * @param number   the input number.
     * @param expected the expected product of digits.
     */
    @ParameterizedTest(name = "With number = {0}, expected product = {1}")
    @MethodSource("provideValidArgumentsForCalculateDigitProduct")
    @DisplayName("Valid cases for calculateDigitProduct")
    @SneakyThrows
    void testValidCasesForCalculateDigitProduct(final int number, final int expected) {
        var actual = calculateDigitProduct(number);

        assertEquals(expected, actual);
    }

    /**
     * Provides valid arguments for parameterized testing of the
     * {@link DigitOperations#calculateNumberOfDigits(int)} method.
     *
     * @return a {@link Stream} of {@link Arguments} containing numbers,
     * and their expected number of digits.
     */
    static @NotNull Stream<Arguments> provideValidArgumentsForCalculateNumberOfDigits() {
        return Stream.of(
                Arguments.of(12, 2),
                Arguments.of(111, 3),
                Arguments.of(321, 3)
        );
    }

    /**
     * Tests the {@link DigitOperations#calculateNumberOfDigits(int)} method with valid input parameters
     * for the number and expected number of digits.
     *
     * @param number   the input number.
     * @param expected the expected number of digits.
     */
    @ParameterizedTest(name = "With number = {0}, expected numberOfDigits = {1}")
    @MethodSource("provideValidArgumentsForCalculateNumberOfDigits")
    @DisplayName("Valid cases for calculateNumberOfDigits")
    @SneakyThrows
    void testValidCasesForCalculateNumberOfDigits(final int number, final int expected) {
        var actual = calculateNumberOfDigits(number);

        assertEquals(expected, actual);
    }

    /**
     * Provides invalid arguments for parameterized testing of digit operation methods.
     *
     * @return a {@link Stream} of {@link Arguments} containing executable blocks and
     * expected exception messages.
     */
    static @NotNull Stream<Arguments> provideInvalidArgumentsAndMessage() {
        return Stream.of(
                Arguments.of((Executable) () -> calculateDigitSum(0), INVALID_DIGIT_NUMBER_MESSAGE),
                Arguments.of((Executable) () -> calculateDigitSum(9), INVALID_DIGIT_NUMBER_MESSAGE),
                Arguments.of((Executable) () -> calculateDigitProduct(0), INVALID_DIGIT_NUMBER_MESSAGE),
                Arguments.of((Executable) () -> calculateDigitProduct(9), INVALID_DIGIT_NUMBER_MESSAGE),
                Arguments.of((Executable) () -> calculateNumberOfDigits(0), INVALID_DIGIT_NUMBER_MESSAGE),
                Arguments.of((Executable) () -> calculateNumberOfDigits(9), INVALID_DIGIT_NUMBER_MESSAGE)
        );
    }

    /**
     * Tests invalid cases for all digit operation methods and expects a specific exception message.
     *
     * @param executable the executable code block that should throw an exception.
     * @param expected   the expected exception message.
     */
    @ParameterizedTest(name = "With invalid number, method = {0}")
    @MethodSource("provideInvalidArgumentsAndMessage")
    @DisplayName("Invalid cases for all methods with message")
    void testInvalidCasesForAllMethods(final Executable executable, final String expected) {
        var actual = assertThrows(InvalidDigitNumberException.class, executable).getMessage();

        assertEquals(expected, actual);
    }

    /**
     * Tests the performDigitOperation method using Reflection to invoke the method dynamically.
     */
    @SneakyThrows
    @Test
    @DisplayName("Test performDigitOperation method using Reflection")
    void testPerformDigitOperation() {
        var method = DigitOperations.class.getDeclaredMethod("performDigitOperation", int.class,
                DigitOperation.class, int.class);
        method.setAccessible(true);

        DigitOperation addition = Integer::sum;
        int resultForSum = (int) method.invoke(null, 123, addition, 0);

        DigitOperation multiplication = (a, b) -> a * b;
        int resultForProduct = (int) method.invoke(null, 123, multiplication, 1);

        assertEquals(6, resultForProduct);
        assertEquals(6, resultForSum);
    }
}
