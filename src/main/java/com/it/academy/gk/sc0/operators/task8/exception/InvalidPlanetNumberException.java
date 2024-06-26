package com.it.academy.gk.sc0.operators.task8.exception;

import org.jetbrains.annotations.NotNull;

/**
 * Custom exception class for handling invalid planet numbers.
 * This exception is thrown when a planet number is not within the valid range.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
public class InvalidPlanetNumberException extends Exception {
    /**
     * Error message prefix for invalid planet number.
     */
    public static final String INVALID_PLANET_NUMBER = "Invalid planet number: ";

    /**
     * Error message suffix indicating the range of valid planet numbers.
     */
    public static final String MUST_BE_BETWEEN_1_AND = "Must be between 1 and ";

    /**
     * Error message suffix for punctuation.
     */
    public static final String DOT = ". ";

    /**
     * Private constructor for the exception class.
     *
     * @param message The error message for the exception.
     */
    private InvalidPlanetNumberException(String message) {
        super(message);
    }

    /**
     * Factory method to create an instance of InvalidPlanetNumberException with a formatted error message.
     *
     * @param planetNumber The invalid planet number.
     * @param totalPlanets The total number of planets.
     * @return An instance of InvalidPlanetNumberException with a formatted error message.
     */
    public static @NotNull InvalidPlanetNumberException createWith(int planetNumber, int totalPlanets) {
        return new InvalidPlanetNumberException(
                INVALID_PLANET_NUMBER + planetNumber + DOT + MUST_BE_BETWEEN_1_AND + totalPlanets + DOT
        );
    }
}
