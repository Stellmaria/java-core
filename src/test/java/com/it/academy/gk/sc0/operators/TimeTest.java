package com.it.academy.gk.sc0.operators;

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

    static @NotNull Stream<Arguments> hourProviderArguments() {
        return Stream.of(
                Arguments.of(0, 59),
                Arguments.of(1, 61),
                Arguments.of(2, 125),
                Arguments.of(3, 189),
                Arguments.of(0, 0),
                Arguments.of(0, -4)
        );
    }

    @ParameterizedTest(name = "Expected: {0}")
    @MethodSource("hourProviderArguments")
    @DisplayName("Test for method getHour() from class Time.")
    void getHour(Integer expected, Integer value) {
        var actual = time.getHour(value);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> minuteProviderArguments() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 61),
                Arguments.of(59, 59),
                Arguments.of(0, 60),
                Arguments.of(0, 120),
                Arguments.of(10, 70)
        );
    }

    @ParameterizedTest(name = "Expected: {0}")
    @MethodSource("minuteProviderArguments")
    @DisplayName("Test for method getMinute() from class Time.")
    void getMinute(Integer expected, Integer value) {
        var actual = time.getMinute(value);

        assertEquals(expected, actual);
    }
}
