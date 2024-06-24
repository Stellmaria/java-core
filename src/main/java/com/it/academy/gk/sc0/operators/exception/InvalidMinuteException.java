package com.it.academy.gk.sc0.operators.exception;

/**
 * This class represents a custom exception for invalid minute values in time-related operations.
 * It extends the standard Exception class.
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
public class InvalidMinuteException extends Exception {
    /**
     * Constructs a new InvalidMinuteException with the specified detail message.
     *
     * @param message the detail message, saved for later retrieval by the {@link #getMessage()} method.
     *                This message should describe the reason for the exception, such as "Invalid minute value: " + minute.
     */
    public InvalidMinuteException(String message) {
        super(message);
    }
}
