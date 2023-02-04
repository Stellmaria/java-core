package com.it.academy.md.jc1.decision_making_statements;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Month.")
class MonthTest {
    private Month month;

    static @NotNull Stream<Arguments> getMonthNameProvideArguments() {
        return Stream.of(
                Arguments.of(0, null),
                Arguments.of(1, "JANUARY"),
                Arguments.of(2, "FEBRUARY"),
                Arguments.of(3, "MARCH"),
                Arguments.of(4, "APRIL"),
                Arguments.of(5, "MAY"),
                Arguments.of(6, "JUNE"),
                Arguments.of(7, "JULY"),
                Arguments.of(8, "AUGUST"),
                Arguments.of(9, "SEPTEMBER"),
                Arguments.of(10, "OCTOBER"),
                Arguments.of(11, "NOVEMBER"),
                Arguments.of(12, "DECEMBER"),
                Arguments.of(13, null)
        );
    }

    @BeforeEach
    void init() {
        month = new Month();
    }

    @ParameterizedTest(name = "Month number: {0}")
    @MethodSource("getMonthNameProvideArguments")
    @DisplayName("Test for method getMonthName() from class Month.")
    void getMonthName(final int monthNumber, final String expected) {
        assertEquals(expected, month.getMonthName(monthNumber));
    }
}
