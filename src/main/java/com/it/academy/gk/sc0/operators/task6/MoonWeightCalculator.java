package com.it.academy.gk.sc0.operators.task6;

import com.it.academy.gk.sc0.operators.exception.NegativeWeightException;

/**
 * The MoonWeightCalculator class provides a method to calculate the weight of an object on the Moon given its weight on Earth.
 */
public class MoonWeightCalculator {
    /**
     * The percentage of Earth's gravity that is present on the Moon.
     */
    private static final double MOON_GRAVITY_PERCENTAGE = 0.17;
    /**
     * The error message used when a negative weight is encountered.
     */
    private static final String NEGATIVE_WEIGHT_MESSAGE = "Weight cannot be negative.";

    /**
     * Calculates the weight of an object on the Moon given its weight on Earth.
     *
     * @param earthWeight the weight of the object on Earth
     * @return the weight of the object on the Moon
     * @throws NegativeWeightException if the given weight is negative
     */
    public double calculateMoonWeight(final double earthWeight) throws NegativeWeightException {
        validateWeight(earthWeight);

        return earthWeight * MOON_GRAVITY_PERCENTAGE;
    }

    /**
     * Validates the given weight to ensure that it is not negative.
     *
     * @param weight the weight to be validated
     * @throws NegativeWeightException if the given weight is negative
     */
    private void validateWeight(final double weight) throws NegativeWeightException {
        if (weight < 0) {
            throw new NegativeWeightException(NEGATIVE_WEIGHT_MESSAGE);
        }
    }
}
