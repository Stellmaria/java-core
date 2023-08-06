package com.it.academy.gk.sc0.hw1;

import org.jetbrains.annotations.Contract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for the Calculator class. It uses the JUnit 5 testing framework
 * to define and run the tests.
 */
class CalculatorTest {
    /**
     * The Calculator object used in the tests.
     */
    private Calculator calculator;

    /**
     * Provides the arguments for the testCalculate method.
     *
     * @return an array of arrays containing the operation number, the first number, the second number,
     * and the expected result of the calculate method
     */
    @Contract(value = " -> new", pure = true)
    private static Object[][] calculatorProvider() {
        return new Object[][]{
                {1, 2, 3, "Enter the number of the operation: 1. Addition 2. Subtraction 3. Multiplication\n" +
                          "2.0 + 3.0 = 5.0"},
                {2, 3, 2, "Enter the number of the operation: 1. Addition 2. Subtraction 3. Multiplication\n" +
                          "3.0 - 2.0 = 1.0"},
                {3, 2, 3, "Enter the number of the operation: 1. Addition 2. Subtraction 3. Multiplication\n" +
                          "2.0 * 3.0 = 6.0"},
                {4, 2, 3, "Enter the number of the operation: 1. Addition 2. Subtraction 3. Multiplication\n" +
                          "The operation is not defined."},
                {-1, 2, 3, "Enter the number of the operation: 1. Addition 2. Subtraction 3. Multiplication\n" +
                           "The operation is not defined."},
                {0, 2, 3, "Enter the number of the operation: 1. Addition 2. Subtraction 3. Multiplication\n" +
                          "The operation is not defined."}
        };
    }

    /**
     * Sets up a new Calculator object before each test.
     */
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    /**
     * Tests the calculate method of the Calculator class with different operation numbers and pairs of numbers.
     *
     * @param operationNumber the operation number entered by the user
     * @param firstNumber     the first number entered by the user
     * @param secondNumber    the second number entered by the user
     * @param expected        the expected result of the calculate method
     */
    @ParameterizedTest(name = "Operation number: {0}, first number: {1}, second number: {2}, expected: {3}")
    @MethodSource("calculatorProvider")
    void testCalculate(int operationNumber, double firstNumber, double secondNumber, String expected) {
        var actual = calculator.calculate(operationNumber, firstNumber, secondNumber);

        assertEquals(expected, actual);
    }
}
