package com.it.academy.gk.sc0.operators.exception;

/**
 * This class represents a custom exception for invalid planet names.
 * It extends the standard Exception class.
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
public class InvalidPlanetNameException extends Exception {
    /**
     * A constant holding the default invalid planet name message.
     * This message is prepended to the planet name when the exception is thrown.
     */
    private static final String INVALID_PLANET_NAME = "Invalid planet name: ";

    /**
     * Constructs a new InvalidPlanetNameException with the specified planet name.
     * The constructor automatically prepends a standard message to the planet name.
     *
     * @param planetName the name of the planet, which will be included in the final
     *                   detail message, saved for later retrieval by the {@link #getMessage()} method.
     * @throws IllegalArgumentException if the planetName is null or empty
     */
    public InvalidPlanetNameException(String planetName) {
        super(INVALID_PLANET_NAME + planetName);
        if (planetName == null || planetName.isEmpty()) {
            throw new IllegalArgumentException("Planet name cannot be null or empty");
        }
    }
}
