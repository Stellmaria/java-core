package com.it.academy.md.jc1.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class GameSessionTime.")
class GameSessionTimeTest {
    private GameSessionTime gameSessionTime;

    @BeforeEach
    void init() {
        gameSessionTime = new GameSessionTime();
    }

    static @NotNull Stream<Arguments> playingTimeProvideArguments() {
        return Stream.of(
                Arguments.of(1, "0 0:0:1"),
                Arguments.of(61, "0 0:1:1"),
                Arguments.of(3661, "0 1:1:1"),
                Arguments.of(86401, "1 0:0:1"),
                Arguments.of(914701, "10 14:5:1")
        );
    }

    @DisplayName("Test for method getPlayingTime() from class GameSessionTime.")
    @MethodSource("playingTimeProvideArguments")
    @ParameterizedTest(name = "Cargo: {0}. Carrying capacity: {1}.")
    void testPlayingTime(final int playingTimeInSeconds, final String expected) {
        var actual = gameSessionTime.getPlayingTime(playingTimeInSeconds);

        assertEquals(expected, actual);
    }
}
