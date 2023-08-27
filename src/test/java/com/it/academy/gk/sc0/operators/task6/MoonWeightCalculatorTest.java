package com.it.academy.gk.sc0.operators.task6;

import com.it.academy.gk.sc0.operators.exception.NegativeWeightException;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * A test class for the MoonWeightCalculator class.
 */
@SuppressFBWarnings("NP_NONNULL_RETURN_VIOLATION")
class MoonWeightCalculatorTest {
    /**
     * The MoonWeightCalculator instance to be tested.
     */
    private MoonWeightCalculator calculator;

    /**
     * Provides a stream of valid Earth weights and their corresponding Moon weights for testing purposes.
     *
     * @return a stream of valid Earth weights and their corresponding Moon weights as arguments
     */
    static @NotNull Stream<Arguments> validWeightProvider() {
        return Stream.of(
                Arguments.of(0.0, 0.0),
                Arguments.of(100.0, 17.0),
                Arguments.of(50.5, 8.585)
        );
    }

    /**
     * Provides a stream of invalid Earth weights for testing purposes.
     *
     * @return a stream of invalid Earth weights as arguments
     */
    static @NotNull Stream<Arguments> invalidWeightProvider() {
        return Stream.of(
                Arguments.of(-0.1),
                Arguments.of(-100.0),
                Arguments.of(-1.0)
        );
    }

    /**
     * Sets up the MoonWeightCalculator instance before each test.
     */
    @BeforeEach
    public void setUp() {
        calculator = new MoonWeightCalculator();
    }

    /**
     * Tests the calculateMoonWeight method with valid Earth weights.
     *
     * @param earthWeight the Earth weight
     * @param expected    the expected Moon weight
     */
    @ParameterizedTest(name = "For Earth weight {0}, Moon weight should be {1}")
    @MethodSource("validWeightProvider")
    @DisplayName("Valid Earth weights")
    void testCalculateMoonWeight(final double earthWeight, final double expected) throws NegativeWeightException {
        double actual = calculator.calculateMoonWeight(earthWeight);

        assertEquals(expected, actual, 0.001);
    }

    /**
     * Tests the calculateMoonWeight method with invalid Earth weights.
     *
     * @param earthWeight an invalid Earth weight
     */
    @ParameterizedTest(name = "Invalid Earth weight {0} should throw NegativeWeightException")
    @MethodSource("invalidWeightProvider")
    @DisplayName("Invalid Earth weights")
    void testNegativeWeights(final double earthWeight) {
        assertThrows(NegativeWeightException.class, () -> calculator.calculateMoonWeight(earthWeight));
    }
}
