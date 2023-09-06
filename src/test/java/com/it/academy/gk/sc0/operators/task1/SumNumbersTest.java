package com.it.academy.gk.sc0.operators.task1;

import com.it.academy.gk.sc0.operators.exception.EmptyArrayException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.it.academy.gk.sc0.operators.task1.SumNumbers.sum;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * SumNumbersTest is a test class that performs unit tests for the {@link SumNumbers} class.
 *
 * <p>This class uses JUnit 5 for parameterized and exception testing to validate the behavior
 * of the {@link SumNumbers} class methods.</p>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
class SumNumbersTest {
    private static String ARRAY_MUST_NOT_BE_EMPTY;
    private static String EXPECTED_NON_NULL_ARGUMENT;

    /**
     * Setup method executed before all tests in the class.
     */
    @SneakyThrows
    @BeforeAll
    public static void beforeAll() {
        var arrayMustNotBeEmptyField = SumNumbers.class.getDeclaredField("ARRAY_MUST_NOT_BE_EMPTY");
        arrayMustNotBeEmptyField.setAccessible(true);
        ARRAY_MUST_NOT_BE_EMPTY = (String) arrayMustNotBeEmptyField.get(null);

        var expectedNonNullArgumentField = SumNumbers.class.getDeclaredField("EXPECTED_NON_NULL_ARGUMENT");
        expectedNonNullArgumentField.setAccessible(true);
        EXPECTED_NON_NULL_ARGUMENT = (String) expectedNonNullArgumentField.get(null);
    }

    /**
     * Provides valid arguments for testing the {@link SumNumbers#sum(int...)} method.
     *
     * @return a {@link Stream} of {@link Arguments} containing arrays of numbers and their corresponding expected sums.
     */
    static @NotNull Stream<Arguments> provideNumbersForSum() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 6),
                Arguments.of(new int[]{0, 0, 0}, 0),
                Arguments.of(new int[]{-1, 1}, 0),
                Arguments.of(new int[]{-1, -1, -1}, -3)
        );
    }

    /**
     * Provides valid arguments for testing array validation exceptions and their messages.
     *
     * @return a {@link Stream} of {@link Arguments} containing exception class, expected message, and executable.
     */
    static @NotNull Stream<Arguments> provideInvalidArraysForExceptionMessages() {
        return Stream.of(
                Arguments.of(EmptyArrayException.class, ARRAY_MUST_NOT_BE_EMPTY, (Executable) () -> sum(new int[]{})),
                Arguments.of(EmptyArrayException.class, EXPECTED_NON_NULL_ARGUMENT,
                        (Executable) () -> sum((int[]) null))
        );
    }

    /**
     * Provides invalid arrays and their corresponding expected exception classes for testing exceptions.
     *
     * @return a {@link Stream} of {@link Arguments} containing expected exception class and executable.
     */
    static @NotNull Stream<Arguments> provideInvalidArraysForExceptions() {
        return Stream.of(
                Arguments.of(EmptyArrayException.class, (Executable) () -> sum(new int[]{})),
                Arguments.of(EmptyArrayException.class, (Executable) () -> sum((int[]) null))
        );
    }

    /**
     * Tests the {@link SumNumbers#sum(int...)} method with various input arrays and their corresponding expected sums.
     *
     * @param numbers  the array of numbers.
     * @param expected the expected sum of the numbers in the array.
     */
    @ParameterizedTest(name = "Test with input numbers {0}, expecting sum {1}")
    @MethodSource("provideNumbersForSum")
    @DisplayName("Test sum method with various inputs.")
    void testSum(final int[] numbers, final int expected) {
        var actual = sum(numbers);

        assertEquals(expected, actual);
    }

    /**
     * Tests exceptions and their messages
     * when invalid arrays are provided to the {@link SumNumbers#sum(int...)} method.
     *
     * @param exception  the actual exception class.
     * @param expected   the expected exception message.
     * @param executable the executable representing the method call that throws the exception.
     */
    @ParameterizedTest(name = "Test for exception = {0} with message = {1}")
    @MethodSource("provideInvalidArraysForExceptionMessages")
    @DisplayName("Test for array validation exceptions and their messages.")
    void testArrayValidationExceptionsAndMessages(final Class<? extends Exception> exception, final String expected,
                                                  final Executable executable) {
        var actual = assertThrows(exception, executable).getMessage();

        assertEquals(expected, actual);
    }

    /**
     * Tests exceptions when invalid arrays are provided to the {@link SumNumbers#sum(int...)} method.
     *
     * @param expected the expected exception class.
     * @param actual   the executable representing the method call that throws the exception.
     */
    @ParameterizedTest(name = "Test for exception = {0}")
    @MethodSource("provideInvalidArraysForExceptions")
    @DisplayName("Test for array validation exceptions.")
    void testArrayValidationExceptions(final Class<? extends Exception> expected, final Executable actual) {
        assertThrows(expected, actual);
    }
}
