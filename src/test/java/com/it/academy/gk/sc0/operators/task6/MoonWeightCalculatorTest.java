package com.it.academy.gk.sc0.operators.task6;

import com.it.academy.gk.sc0.operators.task6.exception.NegativeWeightException;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.it.academy.gk.sc0.operators.task6.MoonWeightCalculator.calculateMoonWeight;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MoonWeightCalculatorTest {
    private static String NEGATIVE_WEIGHT_MESSAGE;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException, IllegalAccessException {
        var invalidDigitNumberMessageField = MoonWeightCalculator.class.getDeclaredField(
                "NEGATIVE_WEIGHT_MESSAGE"
        );
        invalidDigitNumberMessageField.setAccessible(true);
        NEGATIVE_WEIGHT_MESSAGE = (String) invalidDigitNumberMessageField.get(null);
    }

    static @NotNull Stream<Arguments> validWeightProvider() {
        return Stream.of(
                Arguments.of(0.0, 0.0),
                Arguments.of(100.0, 17.0),
                Arguments.of(50.5, 8.585),
                Arguments.of(Double.MAX_VALUE, Double.MAX_VALUE * 0.17)
        );
    }

    @ParameterizedTest(name = "For Earth weight {0}, Moon weight should be {1}")
    @MethodSource("validWeightProvider")
    @DisplayName("Valid Earth weights")
    void testCalculateMoonWeight(final double earthWeight, final double expected) {
        var actual = MoonWeightCalculator.calculateMoonWeight(earthWeight);

        assertEquals(expected, actual, 0.001);
    }

    static @NotNull Stream<Arguments> invalidWeightProvider() {
        return Stream.of(
                Arguments.of(-0.1),
                Arguments.of(-100.0),
                Arguments.of(-1.0)
        );
    }

    @ParameterizedTest(name = "Invalid Earth weight {0} should throw NegativeWeightException")
    @MethodSource("invalidWeightProvider")
    @DisplayName("Invalid Earth weights")
    void testNegativeWeights(final double earthWeight) {
        assertThrows(NegativeWeightException.class, () -> MoonWeightCalculator.calculateMoonWeight(earthWeight));
    }

    static @NotNull Stream<Arguments> provideInvalidWeightsAndExceptionMessage() {
        return Stream.of(
                Arguments.of(
                        (Executable) () -> calculateMoonWeight(-0.1),
                        NegativeWeightException.class, NEGATIVE_WEIGHT_MESSAGE
                ),
                Arguments.of(
                        (Executable) () -> calculateMoonWeight(-100.0),
                        NegativeWeightException.class, NEGATIVE_WEIGHT_MESSAGE
                ),
                Arguments.of(
                        (Executable) () -> calculateMoonWeight(-1.0),
                        NegativeWeightException.class, NEGATIVE_WEIGHT_MESSAGE
                )
        );
    }

    @ParameterizedTest(name = "With invalid Earth weight, method = {0}")
    @MethodSource("provideInvalidWeightsAndExceptionMessage")
    @DisplayName("Invalid Earth weights with exception message")
    void testInvalidEarthWeightsWithMessage(final Executable executable,
                                            final Class<? extends Exception> expectedExceptionType,
                                            final String expectedMessage) {
        var actualMessage = assertThrows(expectedExceptionType, executable).getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}
