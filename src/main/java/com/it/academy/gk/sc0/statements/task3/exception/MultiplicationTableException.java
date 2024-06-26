package com.it.academy.gk.sc0.statements.task3.exception;

/**
 * Custom exception class for handling errors related to the multiplication table.
 * This class extends the built-in Exception class.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
public class MultiplicationTableException extends Exception {

    /**
     * Constructs a new MultiplicationTableException with the specified detail message.
     *
     * @param message the detail message (which is saved for later retrieval by the
     *                {@link #getMessage()} method).
     */
    public MultiplicationTableException(String message) {
        super(message);
    }
}
