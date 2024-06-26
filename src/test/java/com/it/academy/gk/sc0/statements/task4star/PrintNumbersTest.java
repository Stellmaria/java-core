package com.it.academy.gk.sc0.statements.task4star;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.it.academy.gk.sc0.statements.task4star.PrintNumbers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.*;

@DisplayName("Print Numbers Test")
class PrintNumbersTest {
    @Contract(pure = true)
    static @NotNull Stream<Arguments> printNumbersTask4StarProvider() {
        return Stream.of(
                of(3, -3, "3 2 1 0 -1 -2 -3"),
                of(0, 0, "0"),
                of(5, 5, "5"),
                of(-5, -5, "-5")
        );
    }

    @ParameterizedTest(name = "PrintNumbersTask4({0}, {1}) = {2}")
    @MethodSource("printNumbersTask4StarProvider")
    @DisplayName("Test printNumbersTask4 method")
    void testPrintNumbersTask4Star(final int upperBound, final int lowerBound, final String expected) {
        var actual = printNumbersTask4Star(upperBound, lowerBound);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test printNumbersTask4Star with IllegalArgumentException")
    void testPrintNumbersTask4StarIllegalArgumentException() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class,
                        () -> printNumbersTask4Star(0, 1)
                ),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> printNumbersTask4Star(-1, 1)
                )
        );
    }

    @ParameterizedTest(name = "Test printNumbersTask4Star exception message")
    @MethodSource("provideInvalidArgumentsAndMessage")
    @DisplayName("Test printNumbersTask4Star exception message")
    void testPrintNumbersTask4StarExceptionMessage(Executable executable, String expected) {
        var exception = assertThrows(IllegalArgumentException.class, executable);

        var actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideInvalidArgumentsAndMessage() {
        return Stream.of(
                of((Executable) () -> printNumbersTask4Star(0, 1), IS_LESS_THAN_LOWER_BOUND),
                of((Executable) () -> printNumbersTask4Star(-1, 1), IS_LESS_THAN_LOWER_BOUND)
        );
    }
}
