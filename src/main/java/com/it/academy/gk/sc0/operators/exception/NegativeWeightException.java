package com.it.academy.gk.sc0.operators.exception;

/**
 * The NegativeWeightException class represents an exception that is thrown when a negative weight value is encountered.
 */
public class NegativeWeightException extends RuntimeException {
    /**
     * Constructs a new NegativeWeightException with the specified detail message.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
    public NegativeWeightException(final String message) {
        super(message);
    }
}
