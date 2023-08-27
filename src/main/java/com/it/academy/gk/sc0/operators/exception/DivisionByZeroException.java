package com.it.academy.gk.sc0.operators.exception;

/**
 * The DivisionByZeroException class represents an exception that is thrown when an attempt is made to divide by zero.
 */
public class DivisionByZeroException extends IllegalArgumentException {
    /**
     * Constructs a new DivisionByZeroException with the specified detail message.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
    public DivisionByZeroException(String message) {
        super(message);
    }
}
