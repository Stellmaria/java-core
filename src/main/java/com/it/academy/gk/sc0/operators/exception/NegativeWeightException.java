package com.it.academy.gk.sc0.operators.exception;

/**
 * This class represents a custom exception for handling negative weight values.
 * It extends the RuntimeException class, which means it does not require explicit catching.
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
public class NegativeWeightException extends RuntimeException {
    /**
     * Constructs a new NegativeWeightException with the specified detail message.
     *
     * @param message the detail message, saved for later retrieval by the {@link #getMessage()} method.
     *                This message should explain why this exception was thrown, such as "Weight cannot be negative".
     */
    public NegativeWeightException(final String message) {
        super(message);
    }
}
