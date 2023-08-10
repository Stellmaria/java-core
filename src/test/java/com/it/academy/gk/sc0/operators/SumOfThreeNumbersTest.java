package com.it.academy.gk.sc0.operators;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class tests the SumOfThreeNumbers class.
 */
@DisplayName("Sum Of Three Numbers Test")
class SumOfThreeNumbersTest {
    /**
     * An instance of the SumOfThreeNumbers class used for testing.
     */
    private SumOfThreeNumbers sumOfThreeNumbers;

    /**
     * Provides a stream of three numbers and their expected sum.
     *
     * @return a stream of three numbers and their expected sum
     */
    @Contract(pure = true)
    private static @NotNull Stream<Arguments> provideThreeNumbers() {
        return Stream.of(
                Arguments.of(1, 2, 3, 6),
                Arguments.of(10, 20, 30, 60),
                Arguments.of(100, 200, 300, 600)
        );
    }

    /**
     * Provides a stream of two-digit numbers and their expected sum of digits.
     *
     * @return a stream of two-digit numbers and their expected sum of digits
     */
    @Contract(pure = true)
    private static @NotNull Stream<Arguments> provideTwoDigitNumbers() {
        return Stream.of(
                Arguments.of(10, 1),
                Arguments.of(42, 6),
                Arguments.of(99, 18)
        );
    }

    /**
     * Provides a stream of three-digit numbers and their expected sum of digits.
     *
     * @return a stream of three-digit numbers and their expected sum of digits
     */
    @Contract(pure = true)
    private static @NotNull Stream<Arguments> provideThreeDigitNumbers() {
        return Stream.of(
                Arguments.of(100, 1),
                Arguments.of(123, 6),
                Arguments.of(999, 27)
        );
    }

    /**
     * Sets up the test by creating a new instance of SumOfThreeNumbers.
     */
    @BeforeEach
    void setUp() {
        sumOfThreeNumbers = new SumOfThreeNumbers();
    }

    /**
     * Tests the sum method of SumOfThreeNumbers.
     *
     * @param a        the first number.
     * @param b        the second number.
     * @param c        the third number.
     * @param expected the expected sum.
     */
    @ParameterizedTest(name = "Sum of numbers {0}, {1}, and {2} should be {3}")
    @DisplayName("Test sum method")
    @MethodSource("provideThreeNumbers")
    void testSum(final int a, final int b, final int c, final int expected) {
        int actual = sumOfThreeNumbers.sum(a, b, c);

        assertEquals(expected, actual);
    }

    /**
     * Tests the sumOfTwoDigitNumber method of SumOfThreeNumbers.
     *
     * @param num      the two-digit number.
     * @param expected the expected sum of digits.
     */
    @ParameterizedTest(name = "Sum of two-digit number {0} should be {1}")
    @DisplayName("Test sumOfTwoDigitNumber method")
    @MethodSource("provideTwoDigitNumbers")
    void testSumOfTwoDigitNumber(final int num, final int expected) {
        int actual = sumOfThreeNumbers.sumOfTwoDigitNumber(num);

        assertEquals(expected, actual);
    }

    /**
     * Tests the sumOfThreeDigitNumber method of SumOfThreeNumbers.
     *
     * @param num      the three-digit number.
     * @param expected the expected sum of digits.
     */
    @ParameterizedTest(name = "Sum of three-digit number {0} should be {1}")
    @DisplayName("Test sumOfThreeDigitNumber method")
    @MethodSource("provideThreeDigitNumbers")
    void testSumOfThreeDigitNumber(final int num, final int expected) {
        int actual = sumOfThreeNumbers.sumOfThreeDigitNumber(num);

        assertEquals(expected, actual);
    }
}
