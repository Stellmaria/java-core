package com.it.academy.gk.sc0.operators.exception;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * InvalidPlanetNumberException is a custom exception class that extends the standard Exception class.
 * This exception is thrown to indicate that an invalid planet number has been used.
 *
 * <p>For example, you can throw this exception when a given planet number
 * is out of a valid range.</p>
 *
 * <pre>
 *     if (planetNumber < 1 || planetNumber > totalPlanets) {
 *         throw InvalidPlanetNumberException.createWith(planetNumber, totalPlanets);
 *     }
 * </pre>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
public class InvalidPlanetNumberException extends Exception {
    /**
     * A constant holding the default invalid planet number message.
     */
    private static final String INVALID_PLANET_NUMBER = "Invalid planet number: ";

    /**
     * A constant holding the message indicating that the planet number must be between 1 and a given upper limit.
     */
    private static final String MUST_BE_BETWEEN_1_AND = "Must be between 1 and ";

    /**
     * A constant holding a dot and a space, used for message formatting.
     */
    private static final String DOT = ". ";

    /**
     * Private constructor to ensure that the exception is created using the static factory method.
     *
     * @param message the detail message, saved for later retrieval by the {@link #getMessage()} method.
     */
    private InvalidPlanetNumberException(String message) {
        super(message);
    }

    /**
     * Static factory method for creating a new InvalidPlanetNumberException with the specified planet number
     * and total planets.
     *
     * @param planetNumber the invalid planet number.
     * @param totalPlanets the total number of valid planets.
     * @return a new InvalidPlanetNumberException with a formatted message.
     * @throws IllegalArgumentException if planetNumber is less than 1 or greater than totalPlanets.
     */
    @Contract("_, _ -> new")
    public static @NotNull InvalidPlanetNumberException createWith(int planetNumber, int totalPlanets) {
        if (planetNumber < 1 || planetNumber > totalPlanets) {
            throw new IllegalArgumentException(
                    INVALID_PLANET_NUMBER + planetNumber + MUST_BE_BETWEEN_1_AND + totalPlanets + DOT
            );
        }

        return new InvalidPlanetNumberException(
                INVALID_PLANET_NUMBER + planetNumber + DOT + MUST_BE_BETWEEN_1_AND + totalPlanets + DOT
        );
    }
}
