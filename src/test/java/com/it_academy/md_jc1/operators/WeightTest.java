package com.it_academy.md_jc1.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.Stream.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Weight.")
class WeightTest {
    private static Weight w;

    @BeforeAll
    static void init() {
        w = new Weight();
    }

    static @NotNull Stream<Arguments> calculateDeviationStandardWeightProvideArguments() {
        return of(
                Arguments.of(176, 90, 24),
                Arguments.of(158, 34, -14),
                Arguments.of(180, 70, 0)
        );
    }

    @DisplayName("Test for method calculateDeviationStandardWeight() from class Weight.")
    @MethodSource("calculateDeviationStandardWeightProvideArguments")
    @ParameterizedTest(name = "Cargo: {0}. Carrying capacity: {1}.")
    void testCalculateDeviationStandardWeight(int height, int weight, int expected) {
        var actual = w.calculateDeviationStandardWeight(height, weight);

        assertEquals(expected, actual);
    }
}
