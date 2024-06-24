package com.it.academy.gk.sc0.operators.task4;

import com.it.academy.gk.sc0.operators.exception.InvalidDigitNumberException;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DigitOperationsTest {
    private static String INVALID_DIGIT_NUMBER_MESSAGE;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException, IllegalAccessException {
        var invalidDigitNumberMessageField = DigitOperations.class.getDeclaredField("INVALID_DIGIT_NUMBER_MESSAGE");
        invalidDigitNumberMessageField.setAccessible(true);
        INVALID_DIGIT_NUMBER_MESSAGE = (String) invalidDigitNumberMessageField.get(null);
    }

    static @NotNull Stream<Arguments> provideValidArgumentsForCalculateDigitSum() {
        return Stream.of(
                Arguments.of(12, 3),
                Arguments.of(111, 3),
                Arguments.of(321, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("provideValidArgumentsForCalculateDigitSum")
    @DisplayName("Valid cases for calculateDigitSum")
    void testValidCasesForCalculateDigitSum(final int number, final int expected) {
        var actual = DigitOperations.calculateDigitSum(number);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideValidArgumentsForCalculateDigitProduct() {
        return Stream.of(
                Arguments.of(12, 2),
                Arguments.of(111, 1),
                Arguments.of(321, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("provideValidArgumentsForCalculateDigitProduct")
    @DisplayName("Valid cases for calculateDigitProduct")
    void testValidCasesForCalculateDigitProduct(final int number, final int expected) {
        var actual = DigitOperations.calculateDigitProduct(number);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideValidArgumentsForCalculateNumberOfDigits() {
        return Stream.of(
                Arguments.of(12, 2),
                Arguments.of(111, 3),
                Arguments.of(321, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("provideValidArgumentsForCalculateNumberOfDigits")
    @DisplayName("Valid cases for calculateNumberOfDigits")
    void testValidCasesForCalculateNumberOfDigits(final int number, final int expected) {
        var actual = DigitOperations.calculateNumberOfDigits(number);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideInvalidArgumentsAndMessage() {
        return Stream.of(
                Arguments.of(
                        (Executable) () -> DigitOperations.calculateDigitSum(0),
                        INVALID_DIGIT_NUMBER_MESSAGE
                ),
                Arguments.of(
                        (Executable) () -> DigitOperations.calculateDigitSum(9),
                        INVALID_DIGIT_NUMBER_MESSAGE
                ),
                Arguments.of(
                        (Executable) () -> DigitOperations.calculateDigitProduct(0),
                        INVALID_DIGIT_NUMBER_MESSAGE
                ),
                Arguments.of(
                        (Executable) () -> DigitOperations.calculateDigitProduct(9),
                        INVALID_DIGIT_NUMBER_MESSAGE
                ),
                Arguments.of(
                        (Executable) () -> DigitOperations.calculateNumberOfDigits(0),
                        INVALID_DIGIT_NUMBER_MESSAGE
                ),
                Arguments.of(
                        (Executable) () -> DigitOperations.calculateNumberOfDigits(9),
                        INVALID_DIGIT_NUMBER_MESSAGE
                )
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidArgumentsAndMessage")
    @DisplayName("Invalid cases for all methods with message")
    void testInvalidCasesForAllMethods(final Executable executable, final String expectedMessage) {
        var exception = assertThrows(InvalidDigitNumberException.class, executable);

        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    @DisplayName("Test performDigitOperation method using Reflection")
    void testPerformDigitOperation() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        var method = DigitOperations.class.getDeclaredMethod(
                "performDigitOperation", int.class, DigitOperation.class, int.class
        );
        method.setAccessible(true);

        DigitOperation addition = Integer::sum;
        var resultForSum = (int) method.invoke(null, 123, addition, 0);

        DigitOperation multiplication = (a, b) -> a * b;
        var resultForProduct = (int) method.invoke(null, 123, multiplication, 1);

        assertEquals(6, resultForSum);
        assertEquals(6, resultForProduct);
    }
}
