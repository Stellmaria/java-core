package com.it.academy.gk.sc0.operators.exception;

/**
 * InvalidDigitNumberException is a custom exception class that extends the IllegalArgumentException.
 * This exception is thrown to indicate that an invalid number of digits has been used in an operation or input.
 *
 * <p>For example, you could throw this exception when a phone number
 * does not have the required number of digits.</p>
 *
 * <pre>
 *     if (phoneNumber.length() != 10) {
 *         throw new InvalidDigitNumberException("Phone number must have 10 digits");
 *     }
 * </pre>
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
     */
    public InvalidDigitNumberException(String message) {
        super(message);
    }
}
