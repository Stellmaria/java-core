package com.it.academy.gk.sc0.hw1;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the VariableSwapper class.
 */
class VariableSwapperTest {
    private VariableSwapper swapper;

    /**
     * Provides test cases for the swapVariables method.
     *
     * @return a stream of test cases, where each case is an array containing
     * the input variables and the expected result
     */
    @Contract(pure = true)
    private static @NotNull Stream<Object[]> swapVariablesTestCases() {
        return Stream.of(
                new Object[]{1, 2, "First variable: 2, Second variable: 1"},
                new Object[]{0, 0, "First variable: 0, Second variable: 0"},
                new Object[]{-1, 1, "First variable: 1, Second variable: -1"}
        );
    }

    /**
     * Initializes the VariableSwapper instance before each test.
     */
    @BeforeEach
    public void setUp() {
        swapper = new VariableSwapper();
    }

    /**
     * Tests the swapVariables method using parameterized tests.
     *
     * @param firstVariable  the first variable
     * @param secondVariable the second variable
     * @param expectedResult the expected result of the swap
     */
    @ParameterizedTest(name = "{index} => firstVariable={0}, secondVariable={1}, expectedResult={2}")
    @DisplayName("swapVariables method test")
    @MethodSource("swapVariablesTestCases")
    void testSwapVariables(int firstVariable, int secondVariable, String expectedResult) {
        var actual = swapper.swapVariables(firstVariable, secondVariable);

        assertEquals(expectedResult, actual);
    }
}
