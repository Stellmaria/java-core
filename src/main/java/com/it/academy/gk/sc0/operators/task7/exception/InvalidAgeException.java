package com.it.academy.gk.sc0.operators.task7.exception;

/**
 * Custom exception class to handle invalid age exceptions.
 * This exception is thrown when an age value is not within the acceptable range.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
public class InvalidAgeException extends Exception {
    /**
     * Constructs a new InvalidAgeException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public InvalidAgeException(String message) {
        super(message);
    }
}
