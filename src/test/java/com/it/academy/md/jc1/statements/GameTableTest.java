package com.it.academy.md.jc1.statements;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class GameTable.")
class GameTableTest {
    private GameTable gameTable;

    @BeforeEach
    void init() {
        gameTable = new GameTable();
    }

    static @NotNull Stream<Arguments> isTopPlayerPideArguments() {
        return Stream.of(
                Arguments.of(5, 1, true),
                Arguments.of(5, 5, true),
                Arguments.of(5, 6, false),
                Arguments.of(5, 13, false)
        );
    }

    @ParameterizedTest(name = "Top size: {0}. Position player bu damage: {1}")
    @MethodSource("isTopPlayerPideArguments")
    @DisplayName("Test for method isTopPlayer() from class GameTable.")
    void isTopPlayer(final int sizeTop, final int positionPlayerByDamage, final boolean expected) {
        assertEquals(expected, gameTable.isTopPlayer(sizeTop, positionPlayerByDamage));
    }
}
