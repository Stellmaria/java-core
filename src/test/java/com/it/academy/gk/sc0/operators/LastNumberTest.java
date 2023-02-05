package com.it.academy.gk.sc0.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class LastNumber.")
class LastNumberTest {
    private LastNumber lastNumber;

    @BeforeEach
    void init() {
        lastNumber = new LastNumber();
    }

    static @NotNull Stream<Arguments> lastNumberProviderArguments() {
        return Stream.of(
                Arguments.of(true, 1),
                Arguments.of(true, 3),
                Arguments.of(true, 11),
                Arguments.of(true, 112),
                Arguments.of(true, 1113),
                Arguments.of(true, 11111),
                Arguments.of(false, 0),
                Arguments.of(false, 4),
                Arguments.of(false, 6),
                Arguments.of(false, 9),
                Arguments.of(false, 10),
                Arguments.of(false, 14),
                Arguments.of(false, 16),
                Arguments.of(false, 114),
                Arguments.of(false, 110),
                Arguments.of(false, 116),
                Arguments.of(false, 119),
                Arguments.of(true, 1111111111),
                Arguments.of(true, 2)
        );
    }

    @ParameterizedTest(name = "Expected: {0}, number: {1}.")
    @MethodSource("lastNumberProviderArguments")
    @DisplayName("Test for method checkNumber() from class LastNumber.")
    void checkNumber(boolean expected, int number) {
        var actual = lastNumber.checkNumber(number);

        assertEquals(expected, actual);
    }
}