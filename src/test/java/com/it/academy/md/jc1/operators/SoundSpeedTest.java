package com.it.academy.md.jc1.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class SoundSpeed.")
class SoundSpeedTest {
    private SoundSpeed soundSpeed;

    static @NotNull Stream<Arguments> distanceProvideArguments() {
        return Stream.of(
                Arguments.of(2000, 662.0),
                Arguments.of(250, 82.75),
                Arguments.of(0, 0.0)
        );
    }

    @BeforeEach
    void init() {
        soundSpeed = new SoundSpeed();
    }

    @DisplayName("Test for method getDistance() from class SoundSpeed.")
    @MethodSource("distanceProvideArguments")
    @ParameterizedTest(name = "Cargo: {0}. Carrying capacity: {1}.")
    void testDistance(final int milliseconds, final double expected) {
        var actual = soundSpeed.getDistance(milliseconds);

        assertEquals(expected, actual);
    }
}
