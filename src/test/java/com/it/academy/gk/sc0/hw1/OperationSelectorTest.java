package com.it.academy.gk.sc0.hw1;

import lombok.SneakyThrows;
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
 * This class contains tests for the OperationSelector class. It uses the JUnit 5 testing framework
 * to define and run the tests.
 */
@DisplayName("Operation Selector Test")
class OperationSelectorTest {
    /**
     * The value of the private static field PROMPT_MESSAGE in the OperationSelector class.
     */
    private static String PROMPT_MESSAGE;
    /**
     * The value of the private static field INVALID_OPERATION_MESSAGE in the OperationSelector class.
     */
    private static String INVALID_OPERATION_MESSAGE;
    /**
     * The value of the private static field ADDITION in the OperationSelector class.
     */
    private static String ADDITION;
    /**
     * The value of the private static field SUBTRACTION in the OperationSelector class.
     */
    private static String SUBTRACTION;
    /**
     * The value of the private static field MULTIPLICATION in the OperationSelector class.
     */
    private static String MULTIPLICATION;
    /**
     * The value of the private static field SEPARATOR in the OperationSelector class.
     */
    private static String SEPARATOR;
    /**
     * An instance of the OperationSelector class used for testing.
     */
    private OperationSelector selector;

    /**
     * Sets up the test class by using reflection to access the private static fields in the OperationSelector class
     * and storing their values in the corresponding fields in this test class.
     */
    @SneakyThrows
    @BeforeAll
    static void setAll() {
        var promptMessageField = OperationSelector.class.getDeclaredField("PROMPT_MESSAGE");
        promptMessageField.setAccessible(true);
        PROMPT_MESSAGE = (String) promptMessageField.get(null);

        var invalidOperationMessageField = OperationSelector.class.getDeclaredField(
                "INVALID_OPERATION_MESSAGE");
        invalidOperationMessageField.setAccessible(true);
        INVALID_OPERATION_MESSAGE = (String) invalidOperationMessageField.get(null);

        var additionField = OperationSelector.class.getDeclaredField("ADDITION");
        additionField.setAccessible(true);
        ADDITION = (String) additionField.get(null);

        var subtractionField = OperationSelector.class.getDeclaredField("SUBTRACTION");
        subtractionField.setAccessible(true);
        SUBTRACTION = (String) subtractionField.get(null);

        var multiplicationField = OperationSelector.class.getDeclaredField("MULTIPLICATION");
        multiplicationField.setAccessible(true);
        MULTIPLICATION = (String) multiplicationField.get(null);

        var separatorField = OperationSelector.class.getDeclaredField("SEPARATOR");
        separatorField.setAccessible(true);
        SEPARATOR = (String) separatorField.get(null);
    }

    /**
     * Provides a stream of arguments for testing the selectOperation method in the OperationSelector class.
     *
     * @return a stream of arguments for testing the selectOperation method in the OperationSelector class.
     */
    private static @NotNull Stream<Arguments> operationProvider() {
        return Stream.of(
                Arguments.of(1, PROMPT_MESSAGE + SEPARATOR + ADDITION),
                Arguments.of(2, PROMPT_MESSAGE + SEPARATOR + SUBTRACTION),
                Arguments.of(3, PROMPT_MESSAGE + SEPARATOR + MULTIPLICATION),
                Arguments.of(4, PROMPT_MESSAGE + SEPARATOR + INVALID_OPERATION_MESSAGE),
                Arguments.of(-1, PROMPT_MESSAGE + SEPARATOR + INVALID_OPERATION_MESSAGE),
                Arguments.of(0, PROMPT_MESSAGE + SEPARATOR + INVALID_OPERATION_MESSAGE)
        );
    }

    /**
     * Sets up each test by creating a new instance of the OperationSelector class.
     */
    @BeforeEach
    void setUp() {
        selector = new OperationSelector();
    }

    /**
     * Tests the selectOperation method of the OperationSelector class with different operation numbers.
     *
     * @param operationNumber the operation number entered by the user.
     * @param expected        the expected result of the selectOperation method.
     */
    @ParameterizedTest(name = "Operation number: {0}, expected: {1}")
    @MethodSource("operationProvider")
    @DisplayName("Test selectOperation method with different operation numbers")
    void testSelectOperation(final int operationNumber, final String expected) {
        String actual = selector.selectOperation(operationNumber);

        assertEquals(expected, actual);
    }
}
