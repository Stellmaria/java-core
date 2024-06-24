package com.it.academy.gk.sc0.operators.task6;

import com.it.academy.gk.sc0.operators.exception.NegativeWeightException;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MoonWeightCalculatorTest {
    private static String NEGATIVE_WEIGHT_MESSAGE = "Weight cannot be negative.";

    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException {
        var negativeWeightMessageField = MoonWeightCalculator.class.getDeclaredField("NEGATIVE_WEIGHT_MESSAGE");
        negativeWeightMessageField.setAccessible(true);
        NEGATIVE_WEIGHT_MESSAGE = (String) negativeWeightMessageField.get(null);
    }

    static @NotNull Stream<Arguments> validWeightProvider() {
        return Stream.of(
                arguments(0.0, 0.0),
                arguments(100.0, 17.0),
                arguments(50.5, 8.585)
        );
    }

    @ParameterizedTest(name = "For Earth weight {0}, Moon weight should be {1}")
    @MethodSource("validWeightProvider")
    @DisplayName("Valid Earth weights")
    void testCalculateMoonWeight(final double earthWeight, final double expected) throws NegativeWeightException {
        var actual = MoonWeightCalculator.calculateMoonWeight(earthWeight);

        assertEquals(expected, actual, 0.001);
    }

    static @NotNull Stream<Arguments> invalidWeightProvider() {
        return Stream.of(
                arguments(-0.1),
                arguments(-100.0),
                arguments(-1.0)
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
                arguments(
                        (Executable) () -> MoonWeightCalculator.calculateMoonWeight(-0.1),
                        NegativeWeightException.class, NEGATIVE_WEIGHT_MESSAGE
                ),
                arguments(
                        (Executable) () -> MoonWeightCalculator.calculateMoonWeight(-100.0),
                        NegativeWeightException.class, NEGATIVE_WEIGHT_MESSAGE
                ),
                arguments(
                        (Executable) () -> MoonWeightCalculator.calculateMoonWeight(-1.0),
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
