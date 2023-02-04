package com.it.academy.md.jc1.decision_making_statements;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class ZodiacSign.")
class ZodiacSignTest {
    private ZodiacSign zodiacSign;

    static @NotNull Stream<Arguments> getZodiacSignProvideArguments() {
        return Stream.of(
                Arguments.of(20, 1, "Goat"),
                Arguments.of(19, 2, "Water-bearer"),
                Arguments.of(20, 3, "Pisces"),
                Arguments.of(20, 4, "Ram"),
                Arguments.of(20, 5, "Bull"),
                Arguments.of(21, 6, "Twins"),
                Arguments.of(22, 7, "Crab"),
                Arguments.of(22, 8, "Lion"),
                Arguments.of(21, 9, "Maiden"),
                Arguments.of(22, 10, "Scales"),
                Arguments.of(22, 11, "Scorpion"),
                Arguments.of(21, 12, "Archer"),
                Arguments.of(21, 1, "Water-bearer"),
                Arguments.of(20, 2, "Pisces"),
                Arguments.of(21, 3, "Ram"),
                Arguments.of(21, 4, "Bull"),
                Arguments.of(21, 5, "Twins"),
                Arguments.of(22, 6, "Crab"),
                Arguments.of(23, 7, "Lion"),
                Arguments.of(23, 8, "Maiden"),
                Arguments.of(22, 9, "Scales"),
                Arguments.of(23, 10, "Scorpion"),
                Arguments.of(23, 11, "Archer"),
                Arguments.of(22, 12, "Goat")
        );
    }

    @BeforeEach
    void init() {
        zodiacSign = new ZodiacSign();
    }

    @ParameterizedTest(name = "Birthday: {0}")
    @MethodSource("getZodiacSignProvideArguments")
    @DisplayName("Test for method getZodiacSign() from class ZodiacSign.")
    void getZodiacSign(final int day, final int month, final String expected) {
        var actual = zodiacSign.getZodiacSign(day, month);

        assertEquals(expected, actual);
    }
}
