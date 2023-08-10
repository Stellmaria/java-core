package com.it.academy.gk.sc0.operators.exception;

/**
 * The NegativeWeightException class represents an exception that is thrown when a weight value is negative.
 * <p>
 * This class extends the RuntimeException class and provides a constructor that takes a string message as an argument.
 * The message is passed to the superclass constructor to be used as the detail message for the exception.
 */
public class NegativeWeightException extends RuntimeException {
    /**
     * Constructs a new NegativeWeightException with the specified detail message.
     *
     * @param message the detail message.
     *                The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
    public NegativeWeightException(final String message) {
        super(message);
    }
}
