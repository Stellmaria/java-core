package com.it_academy.gk_sc0.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.Stream.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Square.")
class SquareTest {
    private static Square square;

    @BeforeAll
    static void init() {
        square = new Square();
    }

    static @NotNull Stream<Arguments> squareProviderArguments() {
        return of(
                Arguments.arguments(4, 2, 4),
                Arguments.arguments(15, 5, 6.0),
                Arguments.arguments(0, 0, 0));
    }

    @MethodSource("squareProviderArguments")
    @ParameterizedTest(name = "Expected: {0}")
    @DisplayName("Test for method square() from class Square.")
    void testSquare(double expected, double a, double b) {
        var actual = square.getSquare(a, b);

        assertEquals(expected, actual);
    }
}
