package com.it.academy.gk.sc0.operators.exception;

/**
 * InvalidPlanetNameException is a custom exception class that extends the standard Exception class.
 * This exception is thrown to indicate that an invalid planet name has been used.
 *
 * <p>For example, you can throw this exception when a given planet name
 * is not found in a list of known planets.</p>
 *
 * <pre>
 *     if (!knownPlanets.contains(planetName)) {
 *         throw new InvalidPlanetNameException(planetName);
 *     }
 * </pre>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
public class InvalidPlanetNameException extends Exception {
    /**
     * A constant holding the default invalid planet name message. This message is
     * prepended to the planet name when the exception is thrown.
     */
    private static final String INVALID_PLANET_NAME = "Invalid planet name: ";

    /**
     * Constructs a new InvalidPlanetNameException with the specified planet name.
     * The constructor automatically prepends a standard message to the planet name.
     *
     * @param planetName the name of the planet, which will be included in the final
     *                   detail message, saved for later retrieval by the {@link #getMessage()} method.
     */
    public InvalidPlanetNameException(String planetName) {
        super(INVALID_PLANET_NAME + planetName);
    }
}
