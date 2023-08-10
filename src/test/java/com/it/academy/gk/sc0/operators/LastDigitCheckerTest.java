package com.it.academy.gk.sc0.operators;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The LastDigitCheckerTest class is a test class for the LastDigitChecker class.
 */
@DisplayName("Last Digit Checker Test")
class LastDigitCheckerTest {
    /**
     * Provides a stream of test data for a method that checks if a number of meets certain criteria.
     *
     * @return a stream of test data for a method that checks if a number of meets certain criteria
     */
    @SuppressFBWarnings("NP_NONNULL_RETURN_VIOLATION")
    @Contract(pure = true)
    static @NotNull Stream<Arguments> provideNumbers() {
        return Stream.of(
                Arguments.of(12341, true),
                Arguments.of(12342, true),
                Arguments.of(12343, true),
                Arguments.of(12344, false),
                Arguments.of(12345, false),
                Arguments.of(12346, false),
                Arguments.of(12347, false),
                Arguments.of(12348, false),
                Arguments.of(12349, false)
        );
    }

    /**
     * Tests the checkLastDigit method of the LastDigitChecker class.
     *
     * @param number         an integer representing a number.
     * @param expectedResult a boolean representing the expected output value.
     */
    @ParameterizedTest(name = "Check last digit of {0} is 1, 2, or 3")
    @DisplayName("Check last digit of number is 1, 2, or 3")
    @MethodSource("provideNumbers")
    void testCheckLastDigit(final int number, final boolean expectedResult) {
        LastDigitChecker checker = new LastDigitChecker(number);

        boolean actual = checker.checkLastDigit();

        assertEquals(expectedResult, actual);
    }
}
