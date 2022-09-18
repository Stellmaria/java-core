package com.it.academy.md.jc1.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.Stream.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class SoundSpeed.")
class SoundSpeedTest {
    private static SoundSpeed soundSpeed;

    @BeforeAll
    static void init() {
        soundSpeed = new SoundSpeed();
    }

    static @NotNull Stream<Arguments> distanceProvideArguments() {
        return of(
                Arguments.of(2000, 662.0),
                Arguments.of(250, 82.75),
                Arguments.of(0, 0.0)
        );
    }

    @DisplayName("Test for method getDistance() from class SoundSpeed.")
    @MethodSource("distanceProvideArguments")
    @ParameterizedTest(name = "Cargo: {0}. Carrying capacity: {1}.")
    void testDistance(int milliseconds, double expected) {
        var actual = soundSpeed.getDistance(milliseconds);

        assertEquals(expected, actual);
    }
}
