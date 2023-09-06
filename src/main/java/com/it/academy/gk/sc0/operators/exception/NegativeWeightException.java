package com.it.academy.gk.sc0.operators.exception;

/**
 * NegativeWeightException is a custom exception class that extends the RuntimeException.
 * This exception is thrown to indicate
 * that a negative weight value has been used in an operation or object where only positive weights are valid.
 *
 * <p>For example, you can throw this exception in a method that calculates
 * the mass of an object if a negative weight is passed as an argument.</p>
 *
 * <pre>
 *     if (weight < 0) {
 *         throw new NegativeWeightException("Weight cannot be negative");
 *     }
 * </pre>
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
     */
    public NegativeWeightException(final String message) {
        super(message);
    }
}
