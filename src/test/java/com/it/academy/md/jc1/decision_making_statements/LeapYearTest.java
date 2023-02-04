package com.it.academy.md.jc1.decision_making_statements;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class LeapYear.")
class LeapYearTest {
    private LeapYear leapYear;

    static @NotNull Stream<Arguments> isLeapYearProvideArguments() {
        return Stream.of(
                Arguments.of(1, false),
                Arguments.of(4, true),
                Arguments.of(100, false),
                Arguments.of(2400, true),
                Arguments.of(2019, false)
        );
    }

    @BeforeEach
    void init() {
        leapYear = new LeapYear();
    }

    @ParameterizedTest(name = "Year: {0}")
    @MethodSource("isLeapYearProvideArguments")
    @DisplayName("Test for method isLeapYear() from class LeapYear.")
    void isLeapYear(final int year, final boolean expected) {
        var actual = leapYear.isLeapYear(year);

        assertEquals(expected, actual);
    }
}
