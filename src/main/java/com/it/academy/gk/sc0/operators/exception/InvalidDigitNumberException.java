package com.it.academy.gk.sc0.operators.exception;

/**
 * This class represents a custom exception for invalid digit numbers.
 * It extends the IllegalArgumentException class.
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
public class InvalidDigitNumberException extends IllegalArgumentException {
    /**
     * Constructs a new InvalidDigitNumberException with the specified detail message.
     *
     * @param message the detail message, saved for later retrieval by the {@link #getMessage()} method.
     *                This message should explain why this exception is thrown.
     */
    public InvalidDigitNumberException(String message) {
        super(message);
    }
}
