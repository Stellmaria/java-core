package com.it.academy.gk.sc0.operators.task6;

import com.it.academy.gk.sc0.operators.exception.NegativeWeightException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * MoonWeightCalculatorTest is a test class
 * that performs unit tests for methods related to the calculation of weight on the Moon.
 *
 * <p>This class uses JUnit 5 for parameterized testing and exception testing to validate the behavior of methods
 * for various weight calculations.</p>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
class MoonWeightCalculatorTest {
    private static String NEGATIVE_WEIGHT_MESSAGE;

    /**
     * Setup method executed before all tests in the class to initialize the static fields.
     */
    @SneakyThrows
    @BeforeAll
    public static void beforeAll() {
        var negativeWeightMessageField =
                MoonWeightCalculator.class.getDeclaredField("NEGATIVE_WEIGHT_MESSAGE");
        negativeWeightMessageField.setAccessible(true);
        NEGATIVE_WEIGHT_MESSAGE = (String) negativeWeightMessageField.get(null);
    }

    /**
     * Provides valid Earth weights and their corresponding Moon weights for parameterized testing.
     *
     * @return a {@link Stream} of {@link Arguments} containing valid Earth weights and expected Moon weights.
     */
    static @NotNull Stream<Arguments> validWeightProvider() {
        return Stream.of(
                Arguments.of(0.0, 0.0),
                Arguments.of(100.0, 17.0),
                Arguments.of(50.5, 8.585)
        );
    }

    /**
     * Provides invalid Earth weights for parameterized testing.
     *
     * @return a {@link Stream} of {@link Arguments} containing invalid Earth weights.
     */
    static @NotNull Stream<Arguments> invalidWeightProvider() {
        return Stream.of(
                Arguments.of(-0.1),
                Arguments.of(-100.0),
                Arguments.of(-1.0)
        );
    }

    /**
     * Provides invalid Earth weights, expected exception types, and messages for parameterized testing.
     *
     * @return a {@link Stream} of {@link Arguments} containing invalid Earth weights, expected exception types,
     * and messages.
     */
    static @NotNull Stream<Arguments> provideInvalidWeightsAndExceptionMessage() {
        return Stream.of(
                Arguments.of((Executable) () -> MoonWeightCalculator.calculateMoonWeight(-0.1),
                        NegativeWeightException.class, NEGATIVE_WEIGHT_MESSAGE),
                Arguments.of((Executable) () -> MoonWeightCalculator.calculateMoonWeight(-100.0),
                        NegativeWeightException.class, NEGATIVE_WEIGHT_MESSAGE),
                Arguments.of((Executable) () -> MoonWeightCalculator.calculateMoonWeight(-1.0),
                        NegativeWeightException.class, NEGATIVE_WEIGHT_MESSAGE)
        );
    }

    /**
     * Tests the {@link MoonWeightCalculator#calculateMoonWeight(double)} method with valid Earth weights.
     *
     * @param earthWeight the weight on Earth.
     * @param expected    the expected weight on the Moon.
     * @throws NegativeWeightException if the weight is negative.
     */
    @ParameterizedTest(name = "For Earth weight {0}, Moon weight should be {1}")
    @MethodSource("validWeightProvider")
    @DisplayName("Valid Earth weights")
    void testCalculateMoonWeight(final double earthWeight, final double expected) throws NegativeWeightException {
        var actual = MoonWeightCalculator.calculateMoonWeight(earthWeight);

        assertEquals(expected, actual, 0.001);
    }

    /**
     * Tests the {@link MoonWeightCalculator#calculateMoonWeight(double)} method with invalid Earth weights,
     * expecting a NegativeWeightException.
     *
     * @param earthWeight the invalid weight on Earth.
     */
    @ParameterizedTest(name = "Invalid Earth weight {0} should throw NegativeWeightException")
    @MethodSource("invalidWeightProvider")
    @DisplayName("Invalid Earth weights")
    void testNegativeWeights(final double earthWeight) {
        assertThrows(NegativeWeightException.class, () -> MoonWeightCalculator.calculateMoonWeight(earthWeight));
    }

    /**
     * Tests the {@link MoonWeightCalculator#calculateMoonWeight(double)} method with invalid Earth weights
     * and expects a specific exception message.
     *
     * @param executable            the executable code block that should throw an exception.
     * @param expectedExceptionType the expected exception class.
     * @param expected              the expected exception message.
     */
    @DisplayName("Invalid Earth weights with exception message")
    @ParameterizedTest(name = "With invalid Earth weight, method = {0}")
    @MethodSource("provideInvalidWeightsAndExceptionMessage")
    void testInvalidEarthWeightsWithMessage(final Executable executable,
                                            final Class<? extends Exception> expectedExceptionType,
                                            final String expected) {
        var actual = assertThrows(expectedExceptionType, executable).getMessage();

        assertEquals(expected, actual);
    }
}
