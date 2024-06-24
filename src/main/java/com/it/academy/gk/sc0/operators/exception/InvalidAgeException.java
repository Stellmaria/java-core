package com.it.academy.gk.sc0.operators.exception;

/**
 * This class represents a custom exception called InvalidAgeException.
 * It extends the standard Exception class and is thrown when an invalid age value is used.
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
public class InvalidAgeException extends Exception {
    /**
     * Constructs a new InvalidAgeException with the specified detail message.
     *
     * @param message the detail message, saved for later retrieval by the {@link #getMessage()} method.
     *                This message should describe the reason for the exception, such as "Invalid age: " followed by the invalid age value.
     */
    public InvalidAgeException(String message) {
        super(message);
    }
}
