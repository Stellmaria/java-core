package com.it.academy.md.jc1.decision_making_statements;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class PlayerHealth.")
class PlayerHealthTest {
    private PlayerHealth playerHealth;

    static @NotNull Stream<Arguments> getColorHealthPointProvideArguments() {
        return Stream.of(
                Arguments.of(0, 346, null),
                Arguments.of(1, 6432, "RED"),
                Arguments.of(99, 400, "RED"),
                Arguments.of(50, 200, "ORANGE"),
                Arguments.of(99, 200, "ORANGE"),
                Arguments.of(50, 100, "YELLOW"),
                Arguments.of(149, 200, "YELLOW"),
                Arguments.of(75, 100, "GREEN"),
                Arguments.of(1001, 1001, "GREEN"),
                Arguments.of(101, 100, null)
        );
    }

    @BeforeEach
    void init() {
        playerHealth = new PlayerHealth();
    }

    @ParameterizedTest(name = "Current HP: {0}")
    @MethodSource("getColorHealthPointProvideArguments")
    @DisplayName("Test for method getColorHealthPoint() from class PlayerHealth.")
    void getColorHealthPoint(final int currentHealthPoint, final int maxHealthPoint, final String expected) {
        assertEquals(expected, playerHealth.getColorHealthPoint(currentHealthPoint, maxHealthPoint));
    }
}
