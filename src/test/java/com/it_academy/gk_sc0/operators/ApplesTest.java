package com.it_academy.gk_sc0.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplesTest {
    private static Apples apples;

    @BeforeAll
    static void init() {
        apples = new Apples();
    }

    static @NotNull Stream<Arguments> applesProviderArguments() {
        return Stream.of(
                Arguments.of("", 15, 50)
        );
    }

    @ParameterizedTest
    @MethodSource("applesProviderArguments")
    void testApples(String expected, int student, int apple) {
        var actual = apples.getApples(student, apple);

        assertEquals(expected, actual);
    }
}