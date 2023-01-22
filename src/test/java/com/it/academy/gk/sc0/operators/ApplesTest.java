package com.it.academy.gk.sc0.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Apples.")
class ApplesTest {
    private final Apples apples = new Apples();

    static @NotNull Stream<Arguments> applesProviderArguments() {
        return Stream.of(
                Arguments.of(String.format("Students will receive: 3%nThe basket will contain: 5"), 15, 50)
        );
    }

    @ParameterizedTest
    @MethodSource("applesProviderArguments")
    void getApples(String expected, Integer student, Integer apple) {
        var actual = apples.getApples(student, apple);

        assertEquals(expected, actual, "The lines must match.");
    }
}
