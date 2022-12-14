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

@DisplayName("Test for class Number.")
class NumberTest {
    private static Number number;

    @BeforeAll
    static void init() {
        number = new Number();
    }

    static @NotNull Stream<Arguments> sumProviderArguments() {
        return of(
                Arguments.arguments(6, 1, 2, 3),
                Arguments.arguments(0, 0, 0, 0),
                Arguments.arguments(-10, -10, 10, -10),
                Arguments.arguments(0, 1, 2, -3)
        );
    }

    @MethodSource("sumProviderArguments")
    @DisplayName("Test for method getSum() from class Number.")
    @ParameterizedTest(name = "Sum: {0}")
    void testSum(int expected, int first, int second, int third) {
        var actual = number.getSum(first, second, third);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> sumNumbersProviderArguments() {
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

    @MethodSource("sumNumbersProviderArguments")
    @DisplayName("Test for method getSumNumbers() from class Number.")
    @ParameterizedTest(name = "Sum: {0}")
    void testSumNumbers(int expected, int value) {
        var actual = number.getSumNumbers(value);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> multiplicationNumberProviderArguments() {
        return of(
                Arguments.of(1, 1),
                Arguments.of(1, 11),
                Arguments.of(0, 10),
                Arguments.of(56, 78),
                Arguments.of(0, 690),
                Arguments.of(0, 700),
                Arguments.of(343, 777),
                Arguments.of(0, 1000)
        );
    }

    @MethodSource("multiplicationNumberProviderArguments")
    @DisplayName("Test for method getMultiplicationNumber() from class Number.")
    @ParameterizedTest(name = "Sum: {0}")
    void testMultiplicationNumber(int expected, int value) {
        var actual = number.getMultiplicationNumber(value);

        assertEquals(expected, actual);
    }
}
