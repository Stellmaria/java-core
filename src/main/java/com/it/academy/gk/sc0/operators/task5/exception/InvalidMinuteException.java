package com.it.academy.gk.sc0.operators.task5.exception;

/**
 * Custom exception class for handling invalid minute values.
 * This exception is thrown when a minute value is not within the valid range (0-59).
 */
public class InvalidMinuteException extends Exception {
    /**
     * Constructs a new InvalidMinuteException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method)
     */
    public InvalidMinuteException(String message) {
        super(message);
    }
}
