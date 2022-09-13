package com.it_academy.gk_sc0.operators;

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
}
