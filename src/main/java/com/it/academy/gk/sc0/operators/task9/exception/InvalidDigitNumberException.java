package com.it.academy.gk.sc0.operators.task9.exception;

/**
 * Custom exception class for handling invalid digit number exceptions.
 * This exception is thrown when an operation requires a digit number that is not valid.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
public class InvalidDigitNumberException extends IllegalArgumentException {

    /**
     * Constructs a new InvalidDigitNumberException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the Throwable.getMessage() method)
     */
    public InvalidDigitNumberException(String message) {
        super(message);
    }
}
