package com.it.academy.gk.sc0.hw1.exception;

/**
 * This class represents an exception that is thrown when an invalid operation is passed to a method.
 * It extends the RuntimeException class.
 *
 * @author Anastasia Melnikova.
 */
public class InvalidOperationException extends RuntimeException {
    /**
     * Constructs a new InvalidOperationException with the specified detail message.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the getMessage() method.
     */
    public InvalidOperationException(String message) {
        super(message);
    }
}