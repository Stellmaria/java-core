package com.it.academy.gk.sc0.operators;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The LastDigitCheckerTest class is a test class for the LastDigitChecker class.
 * <p>
 * This class contains several methods to test the functionality of the LastDigitChecker class,
 * including a method
 * to provide test data and a method to test the checkLastDigit method of the LastDigitChecker class.
 */
class LastDigitCheckerTest {
    /**
     * Provides a stream of test data for the testCheckLastDigit method.
     * <p>
     * This method returns a stream of arrays, where each array represents a test case with
     * an input number and an expected output boolean value indicating whether the last digit
     * of the number is 1, 2, or 3.
     *
     * @return a stream of test data for the testCheckLastDigit method
     */
    @Contract(pure = true)
    static @NotNull Stream<Object[]> provideNumbers() {
        return Stream.of(
                new Object[]{12341, true},
                new Object[]{12342, true},
                new Object[]{12343, true},
                new Object[]{12344, false},
                new Object[]{12345, false},
                new Object[]{12346, false},
                new Object[]{12347, false},
                new Object[]{12348, false},
                new Object[]{12349, false}
        );
    }

    /**
     * Tests the checkLastDigit method of the LastDigitChecker class.
     * <p>
     * This method takes an integer representing a number and a boolean representing the expected output value
     * as arguments.
     * It creates a new instance of the LastDigitChecker class with the provided number and calls
     * its checkLastDigit method.
     * It then asserts that the result is equal to the expected output value.
     *
     * @param number         an integer representing a number
     * @param expectedResult a boolean representing the expected output value
     */
    @ParameterizedTest(name = "Check last digit of {0} is 1, 2, or 3")
    @DisplayName("Check last digit of number is 1, 2, or 3")
    @MethodSource("provideNumbers")
    void testCheckLastDigit(int number, boolean expectedResult) {
        var checker = new LastDigitChecker(number);

        var actual = checker.checkLastDigit();

        assertEquals(expectedResult, actual);
    }
}
