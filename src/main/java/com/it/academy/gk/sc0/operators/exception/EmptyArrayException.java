package com.it.academy.gk.sc0.operators.exception;

/**
 * EmptyArrayException is a custom exception class that extends {@link IllegalArgumentException}.
 * It is thrown when an operation cannot be performed on an empty array.
 *
 * <p>Example usage:</p>
 * <pre>
 *     if (array.length == 0) {
 *         throw new EmptyArrayException("The array cannot be empty.");
 *     }
 * </pre>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
public class EmptyArrayException extends IllegalArgumentException {
    /**
     * Constructs a new EmptyArrayException with the specified detail message.
     *
     * @param message the detail message, saved for later retrieval by the {@link #getMessage()} method.
     */
    public EmptyArrayException(String message) {
        super(message);
    }
}
