package com.it.academy.gk.sc0.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.Stream.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class SumNumber.")
class SumNumberTest {
    private static SumNumbers sumNumbers;

    @BeforeAll
    static void init() {
        sumNumbers = new SumNumbers();
    }

    static @NotNull Stream<Arguments> getSumNumbersProviderArguments() {
        return of(
                Arguments.of(1, 1),
                Arguments.of(2, 11),
                Arguments.of(1, 10),
                Arguments.of(15, 78),
                Arguments.of(15, 690),
                Arguments.of(7, 700),
                Arguments.of(21, 777),
                Arguments.of(1, 1000)
        );
    }

    @MethodSource("getSumNumbersProviderArguments")
    @DisplayName("Test for method getSumNumbers() from class SumNumber.")
    @ParameterizedTest(name = "Sum: {0}")
    void testSumNumbers(int expected, int value) {
        var actual = sumNumbers.getSumNumbers(value);

        assertEquals(expected, actual);
    }
}
