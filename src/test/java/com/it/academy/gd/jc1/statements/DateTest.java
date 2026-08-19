package com.it.academy.gd.jc1.statements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test for class Date.")
class DateTest {
    private Date date;

    @BeforeEach
    void setUp() {
        date = new Date();
    }

    static Stream<Arguments> nextDayCases() {
        return Stream.of(
                Arguments.of(28, 7, 2024, "29:7:2024"),
                Arguments.of(31, 1, 2004, "1:2:2004"),
                Arguments.of(28, 2, 2023, "1:3:2023"),
                Arguments.of(28, 2, 2024, "29:2:2024"),
                Arguments.of(29, 2, 2024, "1:3:2024"),
                Arguments.of(30, 4, 2024, "1:5:2024"),
                Arguments.of(31, 12, 2024, "1:1:2025")
        );
    }

    @ParameterizedTest(name = "{0}:{1}:{2} -> {3}")
    @MethodSource("nextDayCases")
    @DisplayName("Calculate the next calendar day")
    void getNextDay(final int day, final int month, final int year, final String expected) {
        assertEquals(expected, date.getNextDay(day, month, year));
    }

    @Test
    @DisplayName("Keep the original getNextMonth API compatible")
    void getNextMonthCompatibility() {
        assertEquals("1:2:2004", date.getNextMonth(31, 1, 2004));
    }

    @Test
    @DisplayName("Reject invalid dates")
    void rejectInvalidDates() {
        assertThrows(IllegalArgumentException.class, () -> date.getNextDay(29, 2, 2023));
        assertThrows(IllegalArgumentException.class, () -> date.getNextDay(1, 13, 2024));
        assertThrows(IllegalArgumentException.class, () -> date.getNextDay(0, 1, 2024));
        assertThrows(IllegalArgumentException.class, () -> date.getNextDay(1, 1, 0));
    }
}
