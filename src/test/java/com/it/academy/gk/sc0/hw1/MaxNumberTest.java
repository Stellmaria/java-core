package com.it.academy.gk.sc0.hw1;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for the MaxNumber class.
 * It uses the JUnit 5 testing framework to define and run the tests.
 */
@DisplayName("Max Number Test")
class MaxNumberTest {
    /**
     * The MaxNumber object used in the tests.
     */
    private MaxNumber maxNumber;

    /**
     * Sets up a new MaxNumber object before each test.
     */
    @BeforeEach
    void setUp() {
        maxNumber = new MaxNumber();
    }

    /**
     * Provides the arguments for the testMaxOfThreeNumbers method.
     *
     * @return a stream of arguments for the testMaxOfThreeNumbers method.
     */
    private static @NotNull Stream<Arguments> numberProvider() {
        return Stream.of(
                Arguments.of(1, 2, 3, 3),
                Arguments.of(3, 2, 1, 3),
                Arguments.of(2, 3, 1, 3),
                Arguments.of(-1, -2, -3, -1),
                Arguments.of(-3, -2, -1, -1),
                Arguments.of(-2, -3, -1, -1),
                Arguments.of(0, 0, 0, 0)
        );
    }

    /**
     * Tests the maxOfThreeNumbers method of the MaxNumber class with different sets of three numbers.
     *
     * @param firstNumber  the first number to compare.
     * @param secondNumber the second number to compare.
     * @param thirdNumber  the third number to compare.
     * @param expected     the expected result of the maxOfThreeNumbers method.
     */
    @ParameterizedTest(name = "First number: {0}, second number: {1}, third number: {2}, expected: {3}")
    @MethodSource("numberProvider")
    @DisplayName("Test maxOfThreeNumbers method with different sets of three numbers")
    void testMaxOfThreeNumbers(final double firstNumber, final double secondNumber,
                               final double thirdNumber, final double expected) {
        double actual = maxNumber.maxOfThreeNumbers(firstNumber, secondNumber, thirdNumber);

        assertEquals(expected, actual);
    }
}
