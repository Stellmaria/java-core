package com.it.academy.gk.sc0.operators;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for the SumOfThreeNumbers class.
 */
class SumOfThreeNumbersTest {
    private SumOfThreeNumbers sumOfThreeNumbers;

    /**
     * This method provides positive test cases for the testSum method.
     *
     * @return A stream of test cases, where each test case is an array of objects.
     */
    @Contract(pure = true)
    private static @NotNull Stream<Object[]> provideThreeNumbers() {
        return Stream.of(
                new Object[]{1, 2, 3, 6},
                new Object[]{10, 20, 30, 60},
                new Object[]{100, 200, 300, 600}
        );
    }

    /**
     * This method provides positive test cases for the testSumOfTwoDigitNumber method.
     *
     * @return A stream of test cases where each case is an array of objects
     */
    @Contract(pure = true)
    private static @NotNull Stream<Object[]> provideTwoDigitNumbers() {
        return Stream.of(
                new Object[]{10, 1},
                new Object[]{42, 6},
                new Object[]{99, 18}
        );
    }

    /**
     * This method provides positive test cases for the testSumOfThreeDigitNumber method.
     *
     * @return A stream of test cases where each case is an array of objects
     */
    @Contract(pure = true)
    private static @NotNull Stream<Object[]> provideThreeDigitNumbers() {
        return Stream.of(
                new Object[]{100, 1},
                new Object[]{123, 6},
                new Object[]{999, 27}
        );
    }

    /**
     * This method sets up the test environment before each test.
     * It creates a new instance of the SumOfThreeNumbers class.
     */
    @BeforeEach
    void setUp() {
        sumOfThreeNumbers = new SumOfThreeNumbers();
    }

    /**
     * This method tests the sum method of the SumOfThreeNumbers class using positive test cases.
     * The test cases are provided by the provideThreeNumbers method.
     *
     * @param a        The first number to add
     * @param b        The second number to add
     * @param c        The third number to add
     * @param expected The expected sum of the three numbers
     */
    @ParameterizedTest(name = "Sum of numbers {0}, {1}, and {2} should be {3}")
    @DisplayName("Test sum method")
    @MethodSource("provideThreeNumbers")
    void testSum(int a, int b, int c, int expected) {
        assertEquals(expected, sumOfThreeNumbers.sum(a, b, c));
    }

    /**
     * This method tests the sumOfTwoDigitNumber method of the SumOfThreeNumbers class using positive test cases.
     * The test cases are provided by the provideTwoDigitNumbers method.
     *
     * @param num      The two-digit number to sum
     * @param expected The expected total of the digits in a two-digit number
     */
    @ParameterizedTest(name = "Sum of two-digit number {0} should be {1}")
    @DisplayName("Test sumOfTwoDigitNumber method")
    @MethodSource("provideTwoDigitNumbers")
    void testSumOfTwoDigitNumber(int num, int expected) {
        assertEquals(expected, sumOfThreeNumbers.sumOfTwoDigitNumber(num));
    }

    /**
     * This method tests the sumOfThreeDigitNumber method of the SumOfThreeNumbers class using positive test cases.
     * The test cases are provided by the provideThreeDigitNumbers method.
     *
     * @param num      The three-digit number to sum
     * @param expected The expected total of the digits in a two-digit number
     */
    @ParameterizedTest(name = "Sum of three-digit number {0} should be {1}")
    @DisplayName("Test sumOfThreeDigitNumber method")
    @MethodSource("provideThreeDigitNumbers")
    void testSumOfThreeDigitNumber(int num, int expected) {
        assertEquals(expected, sumOfThreeNumbers.sumOfThreeDigitNumber(num));
    }
}
