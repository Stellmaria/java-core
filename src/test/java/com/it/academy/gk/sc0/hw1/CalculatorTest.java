package com.it.academy.gk.sc0.hw1;

import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for the Calculator class.
 * It uses the JUnit 5 testing framework to define and run the tests.
 */
@DisplayName("Calculator Test")
class CalculatorTest {
    /**
     * The message to display when prompting the user to enter the number of an operation.
     */
    private static String PROMPT_MESSAGE;

    /**
     * The separator used to insert a line break in a string.
     */
    private static String LINE_SEPARATOR;

    /**
     * The message to display when the entered number does not correspond to any operation.
     */
    private static String INVALID_OPERATION_MESSAGE;

    /**
     * The Calculator object used in the tests.
     */
    private Calculator calculator;

    /**
     * Initializes the constants
     * used in the test by retrieving their values from the Calculator class using Java Reflection API.
     */
    @SneakyThrows
    @BeforeAll
    static void setAll() {
        var promptMessageField = Calculator.class.getDeclaredField("PROMPT_MESSAGE");
        promptMessageField.setAccessible(true);
        PROMPT_MESSAGE = (String) promptMessageField.get(null);

        var lineSeparatorField = Calculator.class.getDeclaredField("LINE_SEPARATOR");
        lineSeparatorField.setAccessible(true);
        LINE_SEPARATOR = (String) lineSeparatorField.get(null);

        var invalidOperationMessageField = Calculator.class.getDeclaredField("INVALID_OPERATION_MESSAGE");
        invalidOperationMessageField.setAccessible(true);
        INVALID_OPERATION_MESSAGE = (String) invalidOperationMessageField.get(null);
    }

    /**
     * Sets up a new Calculator object before each test.
     */
    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    /**
     * Provides a stream of arguments for parameterized tests of the Calculator class.
     *
     * @return a stream of arguments for parameterized tests of the Calculator class.
     */
    @Contract(value = " -> new", pure = true)
    private static @NotNull Stream<Arguments> calculatorProvider() {
        return Stream.of(
                Arguments.of(1, 2, 3, PROMPT_MESSAGE + LINE_SEPARATOR + "2.0 + 3.0 = 5.0"),
                Arguments.of(2, 3, 2, PROMPT_MESSAGE + LINE_SEPARATOR + "3.0 - 2.0 = 1.0"),
                Arguments.of(3, 2, 3, PROMPT_MESSAGE + LINE_SEPARATOR + "2.0 * 3.0 = 6.0"),
                Arguments.of(4, 2, 3, PROMPT_MESSAGE + LINE_SEPARATOR + INVALID_OPERATION_MESSAGE),
                Arguments.of(-1, 2, 3, PROMPT_MESSAGE + LINE_SEPARATOR + INVALID_OPERATION_MESSAGE),
                Arguments.of(0, 2, 3, PROMPT_MESSAGE + LINE_SEPARATOR + INVALID_OPERATION_MESSAGE)
        );
    }

    /**
     * Tests the calculate method of the Calculator class with different operation numbers and pairs of numbers.
     *
     * @param operationNumber the operation number entered by the user.
     * @param firstNumber     the first number entered by the user.
     * @param secondNumber    the second number entered by the user.
     * @param expected        the expected result of the calculate method.
     */
    @ParameterizedTest(name = "Operation number: {0}, first number: {1}, second number: {2}, expected: {3}")
    @MethodSource("calculatorProvider")
    @DisplayName("Test calculate method with different operation numbers and pairs of numbers")
    void testCalculate(final int operationNumber, final double firstNumber,
                       final double secondNumber, final String expected) {
        String actual = calculator.calculate(operationNumber, firstNumber, secondNumber);

        assertEquals(expected, actual);
    }
}
