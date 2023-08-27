package com.it.academy.gk.sc0.operators.exception;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

/**
 * The InvalidPlanetNumberException class represents an exception that is thrown when an invalid planet number is encountered.
 */
public class InvalidPlanetNumberException extends Exception {
    /**
     * Constructs a new InvalidPlanetNumberException with the specified detail message.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
    private InvalidPlanetNumberException(String message) {
        super(message);
    }

    /**
     * Creates a new InvalidPlanetNumberException with a detail message that includes the invalid planet number and the total number of planets.
     *
     * @param planetNumber the invalid planet number
     * @param totalPlanets the total number of planets
     * @return a new InvalidPlanetNumberException with a detail message that includes the invalid planet number and the total number of planets
     */
    @Contract("_, _ -> new")
    public static @NotNull InvalidPlanetNumberException createWith(int planetNumber, int totalPlanets) {
        return new InvalidPlanetNumberException("Invalid planet number: " + planetNumber +
                                                ". Must be between 1 and " + totalPlanets + ".");
    }
}
