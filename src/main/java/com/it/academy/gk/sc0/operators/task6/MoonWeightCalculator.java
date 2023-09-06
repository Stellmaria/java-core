package com.it.academy.gk.sc0.operators.task6;

import com.it.academy.gk.sc0.operators.exception.NegativeWeightException;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

/**
 * MoonWeightCalculator is a utility class that provides a method
 * for calculating the equivalent weight of an object on the Moon based on its weight on Earth.
 *
 * <p>Example usage:</p>
 * <pre>
 *     double moonWeight = MoonWeightCalculator.calculateMoonWeight(70);  // moonWeight will be 11.9
 * </pre>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
@UtilityClass
public final class MoonWeightCalculator {
    /**
     * A constant for the percentage of Earth's gravity that is exerted by the Moon.
     */
    private static final double MOON_GRAVITY_PERCENTAGE = 0.17;

    /**
     * A constant holding the default message for negative weight.
     */
    private static final String NEGATIVE_WEIGHT_MESSAGE = "Weight cannot be negative.";

    /**
     * Calculates the equivalent weight of an object on the Moon based on its weight on Earth.
     *
     * @param earthWeight the weight of the object on Earth. Must be a positive number.
     * @return the calculated weight of the object on the Moon.
     */
    @SneakyThrows
    public static double calculateMoonWeight(final double earthWeight) {
        validateWeight(earthWeight);

        return earthWeight * MOON_GRAVITY_PERCENTAGE;
    }

    /**
     * Validates the given weight to ensure it is a positive number.
     *
     * @param weight the weight to validate.
     * @throws NegativeWeightException if the weight is negative.
     */
    @SneakyThrows
    private static void validateWeight(final double weight) {
        if (weight < 0) {
            throw new NegativeWeightException(NEGATIVE_WEIGHT_MESSAGE);
        }
    }
}
