package com.it.academy.gk.sc0.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for the MaxNumber class. It uses the JUnit 5 testing framework to define and run the tests.
 */
class MaxNumberTest {
    /**
     * The MaxNumber object used in the tests.
     */
    private MaxNumber maxNumber;

    /**
     * Provides the arguments for the testMaxOfThreeNumbers method.
     *
     * @return an array of arrays containing the first number, the second number, the third number,
     * and the expected result of the maxOfThreeNumbers method
     */
    private static Object[][] numberProvider() {
        return new Object[][]{
                {1, 2, 3, 3},
                {3, 2, 1, 3},
                {2, 3, 1, 3},
                {-1, -2, -3, -1},
                {-3, -2, -1, -1},
                {-2, -3, -1, -1},
                {0, 0, 0, 0}
        };
    }

    /**
     * Sets up a new MaxNumber object before each test.
     */
    @BeforeEach
    void setUp() {
        maxNumber = new MaxNumber();
    }

    /**
     * Tests the maxOfThreeNumbers method of the MaxNumber class with different sets of three numbers.
     *
     * @param firstNumber  the first number to compare
     * @param secondNumber the second number to compare
     * @param thirdNumber  the third number to compare
     * @param expected     the expected result of the maxOfThreeNumbers method
     */
    @ParameterizedTest(name = "First number: {0}, second number: {1}, third number: {2}, expected: {3}")
    @MethodSource("numberProvider")
    void testMaxOfThreeNumbers(double firstNumber, double secondNumber, double thirdNumber, double expected) {
        var actual = maxNumber.maxOfThreeNumbers(firstNumber, secondNumber, thirdNumber);

        assertEquals(expected, actual);
    }
}
