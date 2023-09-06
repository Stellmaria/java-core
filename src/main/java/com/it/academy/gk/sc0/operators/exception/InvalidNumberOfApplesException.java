package com.it.academy.gk.sc0.operators.exception;

/**
 * InvalidNumberOfApplesException is a custom exception class that extends {@link RuntimeException}.
 * It is thrown when an invalid number of apples is provided for an operation.
 *
 * <p>Example usage:</p>
 * <pre>
 *     if (numberOfApples < 0) {
 *         throw new InvalidNumberOfApplesException("The number of apples cannot be negative.");
 *     }
 * </pre>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-03
 */
public class InvalidNumberOfApplesException extends RuntimeException {
    /**
     * Constructs a new InvalidNumberOfApplesException with the specified detail message.
     *
     * @param message the detail message, saved for later retrieval by the {@link #getMessage()} method.
     */
    public InvalidNumberOfApplesException(String message) {
        super(message);
    }
}
