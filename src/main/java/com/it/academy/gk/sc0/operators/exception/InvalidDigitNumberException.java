package com.it.academy.gk.sc0.operators.exception;

/**
 * The InvalidDigitNumberException class represents an exception that is thrown when an invalid number of digits is encountered.
 */
public class InvalidDigitNumberException extends IllegalArgumentException {
    /**
     * Constructs a new InvalidDigitNumberException with the specified detail message.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
     */
    public InvalidDigitNumberException(String message) {
        super(message);
    }
}
