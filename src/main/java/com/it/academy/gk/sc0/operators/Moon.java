package com.it.academy.gk.sc0.operators;

import com.it.academy.gk.sc0.operators.exception.NegativeWeightException;

/**
 * Task 6: The force of gravity on the Moon is about 17% of Earth's.
 * Write a program that would calculate your weight on the Moon.
 *
 * @author Anastasia Melnikova.
 */
public class Moon {
    /**
     * The gravitational constant of the Moon, as a fraction of Earth's gravity.
     */
    private static final double MOON_GRAVITY = 0.17;

    /**
     * Error message for when the weight on Earth is negative.
     */
    private static final String NEGATIVE_WEIGHT_ERROR = "Weight on Earth cannot be negative";

    /**
     * Calculates the weight of an object on the Moon given its weight on Earth.
     * <p/>
     * This method takes the weight of an object on Earth as an argument and calculates its weight on the Moon
     * by multiplying it by the gravitational constant of the Moon.
     * If the weight on Earth is negative,
     * this method throws a NegativeWeightException with an appropriate error message.
     *
     * @param weightOnEarth the weight of the object on Earth.
     * @return the weight of the object on the Moon.
     * @throws NegativeWeightException if the weight on Earth is negative.
     */
    public double getWeight(final double weightOnEarth) {
        if (weightOnEarth < 0) {
            throw new NegativeWeightException(NEGATIVE_WEIGHT_ERROR);
        }

        return weightOnEarth * MOON_GRAVITY;
    }
}
