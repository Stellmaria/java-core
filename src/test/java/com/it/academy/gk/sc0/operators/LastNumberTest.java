package com.it.academy.gk.sc0.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class LastNumber.")
class LastNumberTest {
    private static LastNumber lastNumber;

    @BeforeAll
    static void init() {
        lastNumber = new LastNumber();
    }

    static @NotNull Stream<Arguments> lastNumberProviderArguments() {
        return Stream.of(
                Arguments.of("Yes.", 1),
                Arguments.of("Yes.", 3),
                Arguments.of("Yes.", 11),
                Arguments.of("Yes.", 112),
                Arguments.of("Yes.", 1113),
                Arguments.of("Yes.", 11111),
                Arguments.of("No.", 0),
                Arguments.of("No.", 4),
                Arguments.of("No.", 6),
                Arguments.of("No.", 9),
                Arguments.of("No.", 10),
                Arguments.of("No.", 14),
                Arguments.of("No.", 16),
                Arguments.of("No.", 114),
                Arguments.of("No.", 110),
                Arguments.of("No.", 116),
                Arguments.of("No.", 119),
                Arguments.of("Yes.", 1111111111),
                Arguments.of("Yes.", 2)
        );
    }

    @ParameterizedTest(name = "Expected: {0}, number: {1}.")
    @MethodSource("lastNumberProviderArguments")
    @DisplayName("Test for method checkNumber() from class LastNumber.")
    void checkNumber(String expected, int number) {
        var actual = lastNumber.checkNumber(number);

        assertEquals(expected, actual);
    }
}