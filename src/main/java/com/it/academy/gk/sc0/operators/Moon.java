package com.it.academy.gk.sc0.operators;

import com.it.academy.gk.sc0.operators.exception.NegativeWeightException;

/**
 * Task 6: The force of gravity on the Moon is about 17% of Earth's.
 * Write a program that would calculate your weight on the Moon.
 */
public class Moon {
    /**
     * The gravitational constant of the Moon, as a fraction of Earth's gravity.
     */
    public static final double MOON_GRAVITY = 0.17;

    /**
     * Error message for when the weight on Earth is negative.
     */
    public static final String NEGATIVE_WEIGHT_ERROR = "Weight on Earth cannot be negative";

    /**
     * Calculates the weight on the Moon given the weight on Earth.
     * <p>
     * This method takes in a double value representing the weight on Earth in kilograms,
     * and returns a double value representing the weight on the Moon in kilograms.
     * The calculation is done by multiplying the weight on Earth by the gravitational constant
     * of the Moon (MOON_GRAVITY), which is 0.17.
     * <p>
     * If the weight on Earth is negative, this method throws a NegativeWeightException with
     * an error message indicating that the weight on Earth cannot be negative.
     *
     * @param weightOnEarth the weight on Earth in kg.
     * @return the weight on the Moon in kg.
     * @throws NegativeWeightException if the weight on Earth is negative.
     */
    public double getWeight(final double weightOnEarth) {
        if (weightOnEarth < 0) {
            throw new NegativeWeightException(NEGATIVE_WEIGHT_ERROR);
        }

        return weightOnEarth * MOON_GRAVITY;
    }
}
