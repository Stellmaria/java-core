package com.it.academy.gk.sc0.operators.task2.exception;

/**
 * Custom exception class to handle invalid triangle side lengths.
 * This exception is thrown when a triangle's side length is less than or equal to zero.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
public class InvalidTriangleSideException extends IllegalArgumentException {
    /**
     * Constructs a new InvalidTriangleSideException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method)
     */
    public InvalidTriangleSideException(String message) {
        super(message);
    }
}
