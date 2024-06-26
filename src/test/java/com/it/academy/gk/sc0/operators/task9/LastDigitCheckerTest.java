package com.it.academy.gk.sc0.operators.task9;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LastDigitCheckerTest {
    static @NotNull Stream<Arguments> validLastDigitArguments() {
        return Stream.of(
                Arguments.of(1, "yes"),
                Arguments.of(21, "yes"),
                Arguments.of(123, "yes"),
                Arguments.of(1233, "yes")
        );
    }

    @ParameterizedTest(name = "When the number is {0}, the last digit is valid: {1}")
    @MethodSource("validLastDigitArguments")
    @DisplayName("Valid Last Digit")
    void testValidLastDigits(final int number, final String expected) {
        var actual = LastDigitChecker.checkLastDigit(number);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> invalidLastDigitArguments() {
        return Stream.of(
                Arguments.of(0, "no"),
                Arguments.of(10, "no"),
                Arguments.of(1234, "no"),
                Arguments.of(29, "no"),
                Arguments.of(-1, "no"),
                Arguments.of(-11, "no"),
                Arguments.of(-21, "no")
        );
    }

    @ParameterizedTest(name = "When the number is {0}, the last digit is invalid: {1}")
    @MethodSource("invalidLastDigitArguments")
    @DisplayName("Invalid Last Digit")
    void testInvalidLastDigits(final int number, final String expected) {
        var actual = LastDigitChecker.checkLastDigit(number);

        assertEquals(expected, actual);
    }
}
