package com.it.academy.gk.sc0.operators.task4;

import com.it.academy.gk.sc0.operators.task9.exception.InvalidDigitNumberException;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.it.academy.gk.sc0.operators.task4.DigitOperations.calculateDigitProduct;
import static com.it.academy.gk.sc0.operators.task4.DigitOperations.calculateDigitSum;
import static com.it.academy.gk.sc0.operators.task4.DigitOperations.calculateNumberOfDigits;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DigitOperationsTest {
    private static String INVALID_DIGIT_NUMBER_MESSAGE;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException, IllegalAccessException {
        var invalidDigitNumberMessageField = DigitOperations.class.getDeclaredField(
                "INVALID_DIGIT_NUMBER_MESSAGE"
        );
        invalidDigitNumberMessageField.setAccessible(true);
        INVALID_DIGIT_NUMBER_MESSAGE = (String) invalidDigitNumberMessageField.get(null);
    }

    static @NotNull Stream<Arguments> provideValidArgumentsForCalculateDigitSum() {
        return Stream.of(
                Arguments.of(12, 3),
                Arguments.of(111, 3),
                Arguments.of(321, 6),
                Arguments.of(105, 6),
                Arguments.of(999, 27),
                Arguments.of(10, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("provideValidArgumentsForCalculateDigitSum")
    @DisplayName("Valid cases for calculateDigitSum")
    void testValidCasesForCalculateDigitSum(final int number, final int expected) {
        var actual = calculateDigitSum(number);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideValidArgumentsForCalculateDigitProduct() {
        return Stream.of(
                Arguments.of(12, 2),
                Arguments.of(111, 1),
                Arguments.of(321, 6),
                Arguments.of(105, 0),
                Arguments.of(999, 729),
                Arguments.of(10, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideValidArgumentsForCalculateDigitProduct")
    @DisplayName("Valid cases for calculateDigitProduct")
    void testValidCasesForCalculateDigitProduct(final int number, final int expected) {
        var actual = calculateDigitProduct(number);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideValidArgumentsForCalculateNumberOfDigits() {
        return Stream.of(
                Arguments.of(12, 2),
                Arguments.of(111, 3),
                Arguments.of(321, 3),
                Arguments.of(105, 3),
                Arguments.of(999, 3),
                Arguments.of(10, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("provideValidArgumentsForCalculateNumberOfDigits")
    @DisplayName("Valid cases for calculateNumberOfDigits")
    void testValidCasesForCalculateNumberOfDigits(final int number, final int expected) {
        var actual = calculateNumberOfDigits(number);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideInvalidArgumentsAndMessage() {
        return Stream.of(
                Arguments.of((Executable) () -> calculateDigitSum(0), INVALID_DIGIT_NUMBER_MESSAGE),
                Arguments.of((Executable) () -> calculateDigitSum(9), INVALID_DIGIT_NUMBER_MESSAGE),
                Arguments.of((Executable) () -> calculateDigitSum(1000), INVALID_DIGIT_NUMBER_MESSAGE),
                Arguments.of((Executable) () -> calculateDigitProduct(0), INVALID_DIGIT_NUMBER_MESSAGE),
                Arguments.of((Executable) () -> calculateDigitProduct(9), INVALID_DIGIT_NUMBER_MESSAGE),
                Arguments.of((Executable) () -> calculateDigitProduct(1000), INVALID_DIGIT_NUMBER_MESSAGE),
                Arguments.of((Executable) () -> calculateNumberOfDigits(0), INVALID_DIGIT_NUMBER_MESSAGE),
                Arguments.of((Executable) () -> calculateNumberOfDigits(9), INVALID_DIGIT_NUMBER_MESSAGE),
                Arguments.of((Executable) () -> calculateNumberOfDigits(1000), INVALID_DIGIT_NUMBER_MESSAGE)
        );
    }

    @ParameterizedTest
    @MethodSource("provideInvalidArgumentsAndMessage")
    @DisplayName("Invalid cases for all methods with message")
    void testInvalidCasesForAllMethods(final Executable executable, final String expectedMessage) {
        var exception = assertThrows(InvalidDigitNumberException.class, executable);

        assertEquals(expectedMessage, exception.getMessage());
    }
}
