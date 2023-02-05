package com.it.academy.gk.sc0.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Age.")
class AgeTest {
    private Age age;

    @BeforeEach
    void init() {
        age = new Age();
    }

    static @NotNull Stream<Arguments> ageProviderArguments() {
        return Stream.of(
                Arguments.of("Child.", 1),
                Arguments.of(null, -7),
                Arguments.of("Adult.", 18),
                Arguments.of("Adult.", 69),
                Arguments.of("Older.", 70),
                Arguments.of("Older.", 100),
                Arguments.of("Older.\nLong-liver.", 120),
                Arguments.of("Older.\nLong-liver.", 121),
                Arguments.of("Child.", 17),
                Arguments.of(null, 0)
        );
    }

    @ParameterizedTest(name = "Age {1}. Result = {0}")
    @MethodSource("ageProviderArguments")
    @DisplayName("Test for method checkAge() from class Age.")
    void checkAge(String expected, int ages) {
        var actual = age.checkAge(ages);

        assertEquals(expected, actual);
    }
}