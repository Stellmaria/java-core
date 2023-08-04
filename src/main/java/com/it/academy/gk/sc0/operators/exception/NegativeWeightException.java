package com.it.academy.gk.sc0.operators.exception;

/**
 * Exception thrown when a negative weight is encountered.
 */
public class NegativeWeightException extends RuntimeException {
    /**
     * Constructs a new NegativeWeightException with the specified detail message.
     *
     * @param message the detail message
     */
    public NegativeWeightException(String message) {
        super(message);
    }
}
