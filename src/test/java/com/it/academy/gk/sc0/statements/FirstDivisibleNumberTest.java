package com.it.academy.gk.sc0.statements;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the FirstDivisibleNumber class.
 */
class FirstDivisibleNumberTest {
    /**
     * An instance of the FirstDivisibleNumber class used for testing the findFirstDivisibleNumber method.
     */
    private FirstDivisibleNumber firstDivisibleNumber;

    /**
     * Provides test cases for the findFirstDivisibleNumber method.
     *
     * @return A stream of test cases.
     */
    private static @NotNull Stream<Arguments> findFirstDivisibleNumberProvider() {
        return Stream.of(
                Arguments.of(19, 97, 17, 34),
                Arguments.of(1, 10, 2, 2),
                Arguments.of(1, 10, 11, -1),
                Arguments.of(-10, -1, 2, -10),
                Arguments.of(-10, -1, 11, -1)
        );
    }

    /**
     * Initializes a new instance of the FirstDivisibleNumber class before each test.
     */
    @BeforeEach
    void setUp() {
        firstDivisibleNumber = new FirstDivisibleNumber();
    }

    /**
     * Tests the findFirstDivisibleNumber method with the provided test cases.
     *
     * @param lowerBound     The lower bound of the range to search.
     * @param upperBound     The upper bound of the range to search.
     * @param divisor        The divisor to use when searching for a divisible number.
     * @param expectedResult The expected result of calling the findFirstDivisibleNumber method with these values.
     */
    @ParameterizedTest(name = "{index} => lowerBound={0}, upperBound={1}, divisor={2}, expectedResult={3}")
    @MethodSource("findFirstDivisibleNumberProvider")
    void testFindFirstDivisibleNumber(int lowerBound, int upperBound, int divisor, int expectedResult) {
        var actual = firstDivisibleNumber.findFirstDivisibleNumber(lowerBound, upperBound, divisor);

        assertEquals(expectedResult, actual);
    }
}
