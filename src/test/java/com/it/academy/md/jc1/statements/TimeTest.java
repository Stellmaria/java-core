package com.it.academy.md.jc1.statements;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Time.")
class TimeTest {
    private Time time;

    @BeforeEach
    void init() {
        time = new Time();
    }

    static @NotNull Stream<Arguments> getGreetingByHourProvideArguments() {
        return Stream.of(
                Arguments.of(0, "Good night"),
                Arguments.of(1, "Good night"),
                Arguments.of(6, "Good morning"),
                Arguments.of(7, "Good morning"),
                Arguments.of(12, "Good day"),
                Arguments.of(13, "Good day"),
                Arguments.of(18, "Good evening"),
                Arguments.of(19, "Good evening"),
                Arguments.of(-1, null),
                Arguments.of(25, null)
        );
    }

    @ParameterizedTest(name = "Hour: {0}")
    @MethodSource("getGreetingByHourProvideArguments")
    @DisplayName("Test for method getGreetingByHour() from class Time.")
    void getGreetingByHour(final int hour, final String expected) {
        assertEquals(expected, time.getGreetingByHour(hour));
    }
}