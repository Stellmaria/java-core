package com.it.academy.gk.sc0.statements.task1star;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Print Numbers Test")
class PrintNumbersTest {
    @Contract(pure = true)
    static @NotNull Stream<Arguments> generateNumbersInRangeProvider() {
        return Stream.of(
                Arguments.of(1, 7, "1 2 3 4 5 6 7"),
                Arguments.of(0, 0, "0"),
                Arguments.of(-3, 3, "-3 -2 -1 0 1 2 3"),
                Arguments.of(1000, 1005, "1000 1001 1002 1003 1004 1005"),
                Arguments.of(-5, -1, "-5 -4 -3 -2 -1"),
                Arguments.of(5, 5, "5")
        );
    }

    @ParameterizedTest(name = "generateNumbersInRange({0}, {1}) = {2}")
    @MethodSource("generateNumbersInRangeProvider")
    @DisplayName("Test generateNumbersInRange method")
    void testGenerateNumbersInRange(final int start, final int end, final String expected) {
        var actual = PrintNumbers.generateNumbersInRange(start, end);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test generateNumbersInRange with start greater than end")
    void testGenerateNumbersInRangeException() {
        assertThrows(IllegalArgumentException.class, () -> PrintNumbers.generateNumbersInRange(5, 1));
    }
}

