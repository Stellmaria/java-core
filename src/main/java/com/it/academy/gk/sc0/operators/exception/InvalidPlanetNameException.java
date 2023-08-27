package com.it.academy.gk.sc0.operators.exception;

/**
 * The InvalidPlanetNameException class represents an exception that is thrown when an invalid planet name is encountered.
 */
public class InvalidPlanetNameException extends Exception {
    /**
     * Constructs a new InvalidPlanetNameException with the specified detail message.
     *
     * @param planetName the invalid planet name
     */
    public InvalidPlanetNameException(String planetName) {
        super("Invalid planet name: " + planetName);
    }
}
