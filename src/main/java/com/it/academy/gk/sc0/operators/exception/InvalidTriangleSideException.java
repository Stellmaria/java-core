package com.it.academy.gk.sc0.operators.exception;

/**
 * InvalidTriangleSideException is a custom exception class that extends the IllegalArgumentException.
 * This exception is thrown to indicate that an invalid side length has been used to define a triangle.
 *
 * <p>For example, you can throw this exception when the sum of the lengths of any
 * two sides of a triangle is less than or equal to the length of the third side.</p>
 *
 * <pre>
 *     if (a + b <= c || a + c <= b || b + c <= a) {
 *         throw new InvalidTriangleSideException("The given sides do not form a valid triangle");
 *     }
 * </pre>
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
     */
    public InvalidTriangleSideException(String message) {
        super(message);
    }
}
