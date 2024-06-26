package com.it.academy.gk.sc0.operators.task6.exception;

/**
 * Custom exception class to handle situations where a weight value is negative.
 * This exception is thrown when a negative weight is encountered during the execution of the program.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
public class NegativeWeightException extends RuntimeException {
    /**
     * Constructs a new NegativeWeightException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method)
     */
    public NegativeWeightException(final String message) {
        super(message);
    }
}
