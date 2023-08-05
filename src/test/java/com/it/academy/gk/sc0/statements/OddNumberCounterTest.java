package com.it.academy.gk.sc0.statements;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains unit tests for the OddNumberCounter class.
 */
class OddNumberCounterTest {
    /**
     * An instance of the OddNumberCounter class, used to test its methods.
     */
    private OddNumberCounter oddNumberCounter;

    /**
     * This method provides test cases for the testCountOddNumbers method.
     * Each test case consists of two arguments: the input value n and the expected result.
     * The expected result is the number of odd numbers between 1 and n (inclusive)
     * that should be returned by the countOddNumbers method.
     */
    @Contract(pure = true)
    private static @NotNull Stream<Object[]> countOddNumbersTestCases() {
        return Stream.of(
                new Object[]{-1, 0},
                new Object[]{0, 0},
                new Object[]{1, 1},
                new Object[]{2, 1},
                new Object[]{3, 2},
                new Object[]{4, 2},
                new Object[]{5, 3}
        );
    }

    /**
     * This method is run before each test method, ensuring that each test has a fresh instance
     * of the OddNumberCounter class to work with.
     */
    @BeforeEach
    public void setUp() {
        oddNumberCounter = new OddNumberCounter();
    }

    /**
     * This method tests the countOddNumbers method of the OddNumberCounter class.
     * It takes two arguments: the input value n and the expected result.
     * The expected result is the number of odd numbers between 1 and n (inclusive) that should
     * be returned by the countOddNumbers method. The method calls the countOddNumbers method
     * with the specified input value n and compares the result to the expected result.
     */
    @ParameterizedTest(name = "countOddNumbers({0}) = {1}")
    @DisplayName("Test countOddNumbers method")
    @MethodSource("countOddNumbersTestCases")
    void testCountOddNumbers(int n, int expected) {
        var actual = oddNumberCounter.countOddNumbers(n);

        assertEquals(expected, actual);
    }
}

