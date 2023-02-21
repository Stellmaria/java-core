package com.it.academy.md.jc1.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Weight.")
class WeightTest {
    private Weight weight;

    @BeforeEach
    void init() {
        weight = new Weight();
    }

    static @NotNull Stream<Arguments> calculateDeviationStandardWeightProvideArguments() {
        return Stream.of(
                Arguments.of(176, 90, 24),
                Arguments.of(158, 34, -14),
                Arguments.of(180, 70, 0)
        );
    }

    @DisplayName("Test for method calculateDeviationStandardWeight() from class Weight.")
    @MethodSource("calculateDeviationStandardWeightProvideArguments")
    @ParameterizedTest(name = "Cargo: {0}. Carrying capacity: {1}.")
    void testCalculateDeviationStandardWeight(final int height, final int weights, final int expected) {
        var actual = weight.calculateDeviationStandardWeight(height, weights);

        assertEquals(expected, actual);
    }
}
