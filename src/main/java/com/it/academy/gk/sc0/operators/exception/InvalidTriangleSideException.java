package com.it.academy.gk.sc0.operators.exception;

/**
 * This class represents a custom exception that is thrown when an invalid side length is used to define a triangle.
 * It extends the IllegalArgumentException class.
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
public class InvalidTriangleSideException extends IllegalArgumentException {
    /**
     * Constructs a new InvalidTriangleSideException with the specified detail message.
     *
     * @param message the detail message, saved for later retrieval by the {@link #getMessage()} method.
     *                This message should explain why the exception was thrown, such as "The given sides do not form a valid triangle".
     */
    public InvalidTriangleSideException(String message) {
        super(message);
    }
}
