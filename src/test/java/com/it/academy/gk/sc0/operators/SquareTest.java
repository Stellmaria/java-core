package com.it.academy.gk.sc0.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Square.")
class SquareTest {
    private Square square;

    @BeforeEach
    void init() {
        square = new Square();
    }

    static @NotNull Stream<Arguments> squareProviderArguments() {
        return Stream.of(
                Arguments.arguments(4, 2, 4),
                Arguments.arguments(15, 5, 6.0),
                Arguments.arguments(0, 0, 0)
        );
    }

    @MethodSource("squareProviderArguments")
    @ParameterizedTest(name = "Expected: {0}")
    @DisplayName("Test for method square() from class Square.")
    void getSquare(double expected, double a, double b) {
        var actual = square.getSquare(a, b);

        assertEquals(expected, actual);
    }
}
