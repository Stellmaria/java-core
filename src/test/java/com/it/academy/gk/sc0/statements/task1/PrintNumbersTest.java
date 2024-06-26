package com.it.academy.gk.sc0.statements.task1;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.it.academy.gk.sc0.statements.task1.PrintNumbers.generateNumberString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Print Numbers Test for task 1")
class PrintNumbersTest {
    private static String ERROR_MESSAGE_MIN_GREATER_THAN_MAX;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException, IllegalAccessException {
        var invalidDigitNumberMessageField = PrintNumbers.class.getDeclaredField(
                "ERROR_MESSAGE_MIN_GREATER_THAN_MAX"
        );
        invalidDigitNumberMessageField.setAccessible(true);
        ERROR_MESSAGE_MIN_GREATER_THAN_MAX = (String) invalidDigitNumberMessageField.get(null);
    }

    private static @NotNull Stream<Arguments> printNumbersTask1Provider() {
        return Stream.of(
                Arguments.of(1, 5, "1 2 3 4 5"),
                Arguments.of(5, 5, "5"),
                Arguments.of(-5, -1, "-5 -4 -3 -2 -1"),
                Arguments.of(0, 0, "0"),
                Arguments.of(1, 1, "1"),
                Arguments.of(-1, 1, "-1 0 1")
        );
    }

    @ParameterizedTest(name = "generateNumberString({0}, {1}) should return \"{2}\"")
    @MethodSource("printNumbersTask1Provider")
    @DisplayName("Test generateNumberString method")
    void testGenerateNumberString(final int minValue, final int maxValue, final String expected) {
        var actual = generateNumberString(minValue, maxValue);

        assertEquals(expected, actual);
    }

    private static @NotNull Stream<Arguments> printGenerateNumberStringWithInvalidRange() {
        return Stream.of(
                Arguments.of(5, 1, ERROR_MESSAGE_MIN_GREATER_THAN_MAX),
                Arguments.of(0, -1, ERROR_MESSAGE_MIN_GREATER_THAN_MAX)
        );
    }

    @ParameterizedTest
    @MethodSource("printGenerateNumberStringWithInvalidRange")
    @DisplayName("Test generateNumberString with invalid range")
    void testGenerateNumberStringWithInvalidRange(int minValue, int maxValue, String expectedMessage) {
        var actual = assertThrows(IllegalArgumentException.class, () -> generateNumberString(minValue, maxValue))
                .getMessage();

        assertEquals(expectedMessage, actual);
    }
}
