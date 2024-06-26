package com.it.academy.gk.sc0.operators.task6;

import com.it.academy.gk.sc0.operators.task6.exception.NegativeWeightException;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

/**
 * A utility class for calculating the weight of an object on the moon.
 * This class provides a method to calculate the moon weight based on the earth weight.
 * It also includes a validation method to ensure that the earth weight is not negative.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public final class MoonWeightCalculator {
    /**
     * The percentage of the moon's gravity compared to Earth's gravity.
     */
    private static final double MOON_GRAVITY_PERCENTAGE = 0.17;

    /**
     * The error message to be thrown when a negative weight is provided.
     */
    private static final String NEGATIVE_WEIGHT_MESSAGE = "Weight cannot be negative.";

    /**
     * Calculates the moon weight based on the earth weight.
     *
     * @param earthWeight The weight of the object on Earth.
     * @return The calculated moon weight.
     * @throws NegativeWeightException If the earth weight is negative.
     */
    @SneakyThrows
    public static double calculateMoonWeight(final double earthWeight) {
        validateWeight(earthWeight);

        return earthWeight * MOON_GRAVITY_PERCENTAGE;
    }

    /**
     * Validates the earth weight to ensure it is not negative.
     *
     * @param weight The earth weight to be validated.
     * @throws NegativeWeightException If the weight is negative.
     */
    @SneakyThrows
    private static void validateWeight(final double weight) {
        if (weight < 0) {
            throw new NegativeWeightException(NEGATIVE_WEIGHT_MESSAGE);
        }
    }
}
