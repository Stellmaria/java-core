package com.it.academy.gk.sc0.operators.exception;

/**
 * InvalidAgeException is a custom exception class that extends the standard Exception class.
 * This exception is thrown to indicate that an invalid age value has been used.
 *
 * <p>For example, you can throw this exception when an age parameter
 * in your code is set to a negative number, or exceeds a certain limit.</p>
 *
 * <pre>
 *     if (age < 0 || age > 150) {
 *         throw new InvalidAgeException("Invalid age: " + age);
 *     }
 * </pre>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
public class InvalidAgeException extends Exception {
    /**
     * Constructs a new InvalidAgeException with the specified detail message.
     *
     * @param message the detail message, saved for later retrieval by the {@link #getMessage()} method.
     */
    public InvalidAgeException(String message) {
        super(message);
    }
}
