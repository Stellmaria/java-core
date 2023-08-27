package com.it.academy.gk.sc0.operators.exception;

/**
 * The InvalidTriangleSideException class represents an exception that is thrown when an invalid side length is encountered in a triangle.
 */
public class InvalidTriangleSideException extends IllegalArgumentException {
    /**
     * Constructs a new InvalidTriangleSideException with the specified detail message.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
    public InvalidTriangleSideException(String message) {
        super(message);
    }
}
