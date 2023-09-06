package com.it.academy.gk.sc0.operators.exception;

/**
 * InvalidNumberOfStudentsException is a custom exception class that extends {@link RuntimeException}.
 * It is thrown when an invalid number of students is provided for an operation.
 *
 * <p>Example usage:</p>
 * <pre>
 *     if (numberOfStudents < 0) {
 *         throw new InvalidNumberOfStudentsException("The number of students cannot be negative.");
 *     }
 * </pre>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-03
 */
public class InvalidNumberOfStudentsException extends RuntimeException {
    /**
     * Constructs a new InvalidNumberOfStudentsException with the specified detail message.
     *
     * @param message the detail message, saved for later retrieval by the {@link #getMessage()} method.
     */
    public InvalidNumberOfStudentsException(String message) {
        super(message);
    }
}
