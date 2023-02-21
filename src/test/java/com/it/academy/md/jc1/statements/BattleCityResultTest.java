package com.it.academy.md.jc1.statements;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class BattleCityResult.")
class BattleCityResultTest {
    private BattleCityResult battleCityResult;

    @BeforeEach
    void init() {
        battleCityResult = new BattleCityResult();
    }

    static @NotNull Stream<Arguments> getResultProvideArguments() {
        return Stream.of(
                Arguments.of(new int[]{2, 1}, "Player 1: 700. Player 2: 100"),
                Arguments.of(new int[]{2, 10}, "Player 1: 200. Player 2: 1500"),
                Arguments.of(new int[]{0, 0}, "Player 1: 0. Player 2: 0"),
                Arguments.of(new int[]{10, 10}, "Player 1: 1000. Player 2: 1000")
        );
    }

    @ParameterizedTest(name = "Killed tanks: {0}")
    @MethodSource("getResultProvideArguments")
    @DisplayName("Test for method getResult() from class BattleCityResult.")
    void getResult(final int @NotNull [] killedTanks, final String expected) {
        var actual = battleCityResult.getResult(killedTanks[0], killedTanks[1]);

        assertEquals(expected, actual);
    }
}
