package com.it.academy.gk.sc0.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for the NumberComparator class. It uses the JUnit 5 testing framework
 * to define and run the tests.
 */
class NumberComparatorTest {
    /**
     * The NumberComparator object used in the tests.
     */
    private NumberComparator comparator;

    /**
     * Provides the arguments for the testCompareNumbers method.
     *
     * @return an array of arrays containing the first number, the second number, and the expected result
     * of the compareNumbers method
     */
    private static Object[][] numberProvider() {
        return new Object[][]{
                {1, 2, "The first number is less than the second number."},
                {2, 1, "The first number is greater than the second number."},
                {1, 1, "The two numbers are equal."},
                {-1, -2, "The first number is greater than the second number."},
                {-2, -1, "The first number is less than the second number."},
                {-1, -1, "The two numbers are equal."},
                {0, 0, "The two numbers are equal."}
        };
    }

    /**
     * Sets up a new NumberComparator object before each test.
     */
    @BeforeEach
    void setUp() {
        comparator = new NumberComparator();
    }

    /**
     * Tests the compareNumbers method of the NumberComparator class with different pairs of numbers.
     *
     * @param firstNumber  the first number to compare
     * @param secondNumber the second number to compare
     * @param expected     the expected result of the compareNumbers method
     */
    @ParameterizedTest(name = "First number: {0}, second number: {1}, expected: {2}")
    @MethodSource("numberProvider")
    void testCompareNumbers(double firstNumber, double secondNumber, String expected) {
        var actual = comparator.compareNumbers(firstNumber, secondNumber);

        assertEquals(expected, actual);
    }
}
