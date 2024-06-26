package com.it.academy.gk.sc0.operators.task8.exception;

import org.jetbrains.annotations.NotNull;

/**
 * Custom exception class for handling invalid planet names.
 * This exception is thrown when a planet name is null, empty, or contains only whitespace.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
public class InvalidPlanetNameException extends Exception {
    /**
     * Constant string for the error message prefix.
     */
    private static final String INVALID_PLANET_NAME_PREFIX = "Invalid planet name: ";

    /**
     * Constant string for the error message when the planet name is null or empty.
     */
    public static final String NULL_OR_EMPTY_PLANET_NAME = "Empty or null planet name.";

    /**
     * Constructor for InvalidPlanetNameException.
     *
     * @param planetName The name of the planet that caused the exception.
     */
    public InvalidPlanetNameException(String planetName) {
        super(generateMessage(planetName));
    }

    /**
     * Private helper method to generate the error message based on the planet name.
     *
     * @param planetName The name of the planet.
     * @return The error message.
     */
    private static @NotNull String generateMessage(String planetName) {
        if (planetName == null || planetName.trim().isEmpty()) {
            return INVALID_PLANET_NAME_PREFIX + NULL_OR_EMPTY_PLANET_NAME;
        } else {
            return INVALID_PLANET_NAME_PREFIX + planetName;
        }
    }
}
