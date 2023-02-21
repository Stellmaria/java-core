package com.it.academy.md.jc1.statements;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class NameDay.")
class NameDayTest {
    private NameDay nameDay;

    @BeforeEach
    void init() {
        nameDay = new NameDay();
    }

    static @NotNull Stream<Arguments> getDayOfWeekNumberProvideArguments() {
        return Stream.of(
                Arguments.of(0, null),
                Arguments.of(1, "MONDAY"),
                Arguments.of(2, "TUESDAY"),
                Arguments.of(3, "WEDNESDAY"),
                Arguments.of(4, "THURSDAY"),
                Arguments.of(5, "FRIDAY"),
                Arguments.of(6, "SATURDAY"),
                Arguments.of(7, "SUNDAY"),
                Arguments.of(8, null)
        );
    }

    @ParameterizedTest(name = "Day of week number: {0}")
    @MethodSource("getDayOfWeekNumberProvideArguments")
    @DisplayName("Test for method getDayOfWeekNumber() from class NameDay.")
    void getDayOfWeekNumber(final int dayOfWeek, final String expected) {
        assertEquals(expected, nameDay.getDayOfWeekNumber((byte) dayOfWeek));
    }
}
