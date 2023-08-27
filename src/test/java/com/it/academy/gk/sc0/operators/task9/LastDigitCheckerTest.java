package com.it.academy.gk.sc0.operators.task9;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A test class for the LastDigitChecker class.
 */
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LastDigitCheckerTest {
    /**
     * The LastDigitChecker instance to be tested.
     */
    private LastDigitChecker lastDigitChecker;

    /**
     * Provides a stream of valid numbers and their corresponding last digit validity for testing purposes.
     *
     * @return a stream of valid numbers and their corresponding last digit validity as arguments
     */
    static @NotNull Stream<Arguments> validLastDigitProvider() {
        return Stream.of(
                Arguments.of(1, "yes"),
                Arguments.of(21, "yes"),
                Arguments.of(123, "yes"),
                Arguments.of(1233, "yes")
        );
    }

    /**
     * Provides a stream of invalid numbers and their corresponding last digit validity for testing purposes.
     *
     * @return a stream of invalid numbers and their corresponding last digit validity as arguments
     */
    static @NotNull Stream<Arguments> invalidLastDigitProvider() {
        return Stream.of(
                Arguments.of(0, "no"),
                Arguments.of(10, "no"),
                Arguments.of(1234, "no"),
                Arguments.of(29, "no"),
                Arguments.of(-1, "no"),
                Arguments.of(-11, "no"),
                Arguments.of(-21, "yes")
        );
    }

    /**
     * Sets up the LastDigitChecker instance before each test.
     */
    @BeforeEach
    public void setUp() {
        lastDigitChecker = new LastDigitChecker();
    }

    /**
     * Tests the checkLastDigit method with valid numbers.
     *
     * @param number   the number to be checked
     * @param expected the expected result
     */
    @ParameterizedTest(name = "When the number is {0}, the last digit is valid: {1}")
    @MethodSource("validLastDigitProvider")
    @DisplayName("Valid Last Digit")
    void testValidLastDigits(final int number, final String expected) {
        var actual = lastDigitChecker.checkLastDigit(number);

        assertEquals(expected, actual);
    }

    /**
     * Tests the checkLastDigit method with invalid numbers.
     *
     * @param number   the number to be checked
     * @param expected the expected result
     */
    @ParameterizedTest(name = "When the number is {0}, the last digit is invalid: {1}")
    @MethodSource("invalidLastDigitProvider")
    @DisplayName("Invalid Last Digit")
    void testInvalidLastDigits(final int number, final String expected) {
        var actual = lastDigitChecker.checkLastDigit(number);

        assertEquals(expected, actual);
    }
}
