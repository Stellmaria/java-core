package com.it.academy.gk.sc0.operators.exception;

/**
 * The InvalidAgeException class represents an exception that is thrown when an invalid age is encountered.
 */
public class InvalidAgeException extends Exception {
    /**
     * Constructs a new InvalidAgeException with the specified detail message.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
    public InvalidAgeException(String message) {
        super(message);
    }
}
