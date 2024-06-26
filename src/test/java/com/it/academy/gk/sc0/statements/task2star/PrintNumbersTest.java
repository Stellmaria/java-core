package com.it.academy.gk.sc0.statements.task2star;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.it.academy.gk.sc0.statements.task2star.PrintNumbers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.*;

@DisplayName("Print Numbers Test")
class PrintNumbersTest {
    private static String INCREMENT_CANNOT_BE_ZERO;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException, IllegalAccessException {
        var invalidDigitNumberMessageField = PrintNumbers.class.getDeclaredField("INCREMENT_CANNOT_BE_ZERO");
        invalidDigitNumberMessageField.setAccessible(true);
        INCREMENT_CANNOT_BE_ZERO = (String) invalidDigitNumberMessageField.get(null);
    }

    @Contract(pure = true)
    static @NotNull Stream<Arguments> generateNumbersTask2StarProvider() {
        return Stream.of(
                of(100, 10, -10, "100 90 80 70 60 50 40 30 20 10"),
                of(100, 100, -10, "100"),
                of(-30, -70, -10, "-30 -40 -50 -60 -70"),
                of(-20, 50, 5, "-20 -15 -10 -5 0 5 10 15 20 25 30 35 40 45 50"),
                of(10, -30, -7, "10 3 -4 -11 -18 -25"),
                of(5, 5, 2, "5"),
                of(Integer.MAX_VALUE - 10, Integer.MAX_VALUE, 100, "2147483637")
        );
    }

    @ParameterizedTest(name = "generateNumbersTask2({0}, {1}, {2}) = {3}")
    @MethodSource("generateNumbersTask2StarProvider")
    @DisplayName("Test generateNumbersTask2 method")
    void testGenerateNumbersTask2Star(final int first, final int last, final int increment, final String expected) {
        var actual = generateNumbersTask2Star(first, last, increment);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test printNumbersTask2star with IllegalArgumentException")
    void testPrintNumbersTask2StarIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class,
                () -> generateNumbersTask2Star(-10, 10, 0)
        );
    }

    static @NotNull Stream<Arguments> provideInvalidSideArgumentsAndMessage() {
        return Stream.of(
                of((Executable) () -> generateNumbersTask2Star(-10, 10, 0), INCREMENT_CANNOT_BE_ZERO)
        );
    }

    @ParameterizedTest(name = "printNumbersTask2(begin={0}, finish={1}) = \"{2}\"")
    @MethodSource("provideInvalidSideArgumentsAndMessage")
    @DisplayName("Test printNumbersTask2star method get text exception")
    void testPrintNumbersTask2StarIllegalArgumentExceptionText(Executable executable, final String expected) {
        var actual = assertThrows(IllegalArgumentException.class, executable).getMessage();

        assertEquals(expected, actual);
    }
}
