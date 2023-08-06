package com.it.academy.gk.sc0.hw1;

import org.jetbrains.annotations.Contract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for the OperationSelector class. It uses the JUnit 5 testing framework
 * to define and run the tests.
 */
class OperationSelectorTest {
    /**
     * The OperationSelector object used in the tests.
     */
    private OperationSelector selector;

    /**
     * Provides the arguments for the testSelectOperation method.
     *
     * @return an array of arrays containing the operation number and the expected result of the selectOperation method
     */
    @Contract(value = " -> new", pure = true)
    private static Object[][] operationNumberProvider() {
        return new Object[][]{
                {1, "Enter the number of the operation: 1. Addition 2. Subtraction 3. Multiplication\nAddition"},
                {2, "Enter the number of the operation: 1. Addition 2. Subtraction 3. Multiplication\nSubtraction"},
                {3, "Enter the number of the operation: 1. Addition 2. Subtraction 3. Multiplication\nMultiplication"},
                {4, "Enter the number of the operation: 1. Addition 2. Subtraction 3. Multiplication\n" +
                    "The operation is not defined."},
                {-1, "Enter the number of the operation: 1. Addition 2. Subtraction 3. Multiplication\n" +
                     "The operation is not defined."},
                {0, "Enter the number of the operation: 1. Addition 2. Subtraction 3. Multiplication\n" +
                    "The operation is not defined."}
        };
    }

    /**
     * Sets up a new OperationSelector object before each test.
     */
    @BeforeEach
    void setUp() {
        selector = new OperationSelector();
    }

    /**
     * Tests the selectOperation method of the OperationSelector class with different operation numbers.
     *
     * @param operationNumber the operation number entered by the user
     * @param expected        the expected result of the selectOperation method
     */
    @ParameterizedTest(name = "Operation number: {0}, expected: {1}")
    @MethodSource("operationNumberProvider")
    void testSelectOperation(int operationNumber, String expected) {
        var actual = selector.selectOperation(operationNumber);

        assertEquals(expected, actual);
    }
}
