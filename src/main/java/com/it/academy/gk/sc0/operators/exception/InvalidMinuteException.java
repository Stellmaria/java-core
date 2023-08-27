package com.it.academy.gk.sc0.operators.exception;

/**
 * The InvalidMinuteException class represents an exception that is thrown when an invalid minute value is encountered.
 */
public class InvalidMinuteException extends Exception {
    /**
     * Constructs a new InvalidMinuteException with the specified detail message.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
    public InvalidMinuteException(String message) {
        super(message);
    }
}
