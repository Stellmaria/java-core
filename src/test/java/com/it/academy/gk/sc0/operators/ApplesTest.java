package com.it.academy.gk.sc0.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Apples.")
class ApplesTest {
    private Apples apples;

    @BeforeEach
    void init() {
        apples = new Apples();
    }

    static @NotNull Stream<Arguments> applesProviderArguments() {
        return Stream.of(
                Arguments.of(String.format("Students will receive: 3%nThe basket will contain: 5"), 15, 50),
                Arguments.of(String.format("Students will receive: 5%nThe basket will contain: 0"), 20, 100)
        );
    }

    @ParameterizedTest(name = "Student {1} and Apples {2}.")
    @MethodSource("applesProviderArguments")
    @DisplayName("Test for method getApples() from class Apples.")
    void getApples(String expected, Integer student, Integer apple) {
        var actual = apples.getApples(student, apple);

        assertEquals(expected, actual, "The lines must match.");
    }
}
