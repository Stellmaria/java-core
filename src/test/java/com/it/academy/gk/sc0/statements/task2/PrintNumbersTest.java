package com.it.academy.gk.sc0.statements.task2;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Print Numbers Test for task 2")
class PrintNumbersTest {
    private static String GREATER_THAN_OR_EQUAL_TO_FINISH;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException, IllegalAccessException {
        var invalidDigitNumberMessageField = PrintNumbers.class.getDeclaredField(
                "GREATER_THAN_OR_EQUAL_TO_FINISH"
        );
        invalidDigitNumberMessageField.setAccessible(true);
        GREATER_THAN_OR_EQUAL_TO_FINISH = (String) invalidDigitNumberMessageField.get(null);
    }

    @Contract(pure = true)
    static @NotNull Stream<Arguments> printNumbersTask2Provider() {
        return Stream.of(
                Arguments.of(5, 1, "5 4 3 2 1"),
                Arguments.of(5, 5, "5"),
                Arguments.of(-5, -9, "-5 -6 -7 -8 -9"),
                Arguments.of(0, 0, "0"),
                Arguments.of(10, 3, "10 9 8 7 6 5 4 3"),
                Arguments.of(Integer.MAX_VALUE, Integer.MAX_VALUE - 3, Integer.MAX_VALUE + " " + (
                        Integer.MAX_VALUE - 1) + " " + (Integer.MAX_VALUE - 2
                ) + " " + (Integer.MAX_VALUE - 3))
        );
    }

    @ParameterizedTest(name = "printNumbersTask2({0}, {1}) = {2}")
    @MethodSource("printNumbersTask2Provider")
    @DisplayName("Test printNumbersTask2 method")
    void testPrintNumbersTask2(final int begin, final int finish, final String expected) {
        var actual = PrintNumbers.printNumbersTask2(begin, finish);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test printNumbersTask2 with IllegalArgumentException")
    void testPrintNumbersTask2IllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> PrintNumbers.printNumbersTask2(3, 5));
    }

    static @NotNull Stream<Arguments> provideInvalidSideArgumentsAndMessage() {
        return Stream.of(
                Arguments.of((Executable) () -> PrintNumbers.printNumbersTask2(1, 5), GREATER_THAN_OR_EQUAL_TO_FINISH)
        );
    }

    @ParameterizedTest(name = "printNumbersTask2(begin={0}, finish={1}) = \"{2}\"")
    @MethodSource("provideInvalidSideArgumentsAndMessage")
    @DisplayName("Test printNumbersTask2 method get text exception")
    void testPrintNumbersTask2IllegalArgumentExceptionText(Executable executable, final String expected) {
        var actual = assertThrows(IllegalArgumentException.class, executable).getMessage();

        assertEquals(expected, actual);
    }
}
