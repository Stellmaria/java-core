package com.it.academy.gk.sc0.statements.task6;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("First Divisible Number Test")
class FirstDivisibleNumberTest {
    private static @NotNull Stream<Arguments> findFirstDivisibleNumberProvider() {
        return Stream.of(
                Arguments.of(19, 97, 17, 34),
                Arguments.of(1, 10, 2, 2),
                Arguments.of(1, 10, 11, -1),
                Arguments.of(-10, -1, 2, -10),
                Arguments.of(-10, -1, 11, -1)
        );
    }

    @ParameterizedTest(name = "{index} => lowerBound={0}, upperBound={1}, divisor={2}, expectedResult={3}")
    @MethodSource("findFirstDivisibleNumberProvider")
    void testFindFirstDivisibleNumber(final int lowerBound, final int upperBound,
                                      final int divisor, final int expectedResult) {
        var actual = FirstDivisibleNumber.findFirstDivisibleNumber(lowerBound, upperBound, divisor);

        assertEquals(expectedResult, actual);
    }
}
