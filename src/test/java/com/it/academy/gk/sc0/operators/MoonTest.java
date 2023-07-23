package com.it.academy.gk.sc0.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Moon.")
class MoonTest {
    private Moon moon;

    @BeforeEach
    void init() {
        moon = new Moon();
    }

    static @NotNull Stream<Arguments> weightProviderArguments() {
        return Stream.of(
                Arguments.of(88.5, 73.455),
                Arguments.of(90.1, 74.783)
        );
    }

    @ParameterizedTest(name = "Weight: {1}.")
    @MethodSource("weightProviderArguments")
    @DisplayName("Test for method getWeight() from class Moon.")
    void getWeight(double weight, double expected) {
        var actual = moon.getWeight(weight);

        assertEquals(expected, actual);
    }
}