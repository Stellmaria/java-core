package com.it.academy.gk.sc0.operators.exception;

/**
 * InvalidMinuteException is a custom exception class that extends the standard Exception class.
 * This exception is thrown to indicate that an invalid minute value has been used in a time-related operation.
 *
 * <p>For example, you can throw this exception when a minute value in your
 * code is either less than 0 or greater than 59.</p>
 *
 * <pre>
 *     if (minute < 0 || minute > 59) {
 *         throw new InvalidMinuteException("Invalid minute value: " + minute);
 *     }
 * </pre>
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
     */
    public InvalidMinuteException(String message) {
        super(message);
    }
}
