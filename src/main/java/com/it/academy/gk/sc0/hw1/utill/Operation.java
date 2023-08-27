package com.it.academy.gk.sc0.hw1.utill;

import lombok.Getter;

/**
 * This enum represents the different arithmetic operations that can be performed.
 * It has four values: ADDITION, SUBTRACTION, MULTIPLICATION, and DIVISION.
 * Each value has an associated operation number and symbol.
 *
 * @author Anastasia Melnikova.
 */
@Getter
public enum Operation {
    /**
     * Represents the equal operation.
     */
    EQUAL(0, "="),

    /**
     * Represents the addition operation.
     */
    ADDITION(1, "+"),

    /**
     * Represents the subtraction operation.
     */
    SUBTRACTION(2, "-"),

    /**
     * Represents the multiplication operation.
     */
    MULTIPLICATION(3, "*"),

    /**
     * Represents the division operation.
     */
    DIVISION(4, "/"),

    /**
     * Represents the square root operation.
     */
    SQUARE_ROOT(5, "√"),

    /**
     * Represents the exponentiation operation.
     */
    EXPONENTIATION(6, "^"),

    /**
     * Represents the logarithm operation.
     */
    LOGARITHM(7, "log"),

    /**
     * Represents the sine operation.
     */
    SINE(8, "sin"),

    /**
     * Represents the cosine operation.
     */
    COSINE(9, "cos"),

    /**
     * Represents the tangent operation.
     */
    TANGENT(10, "tan");

    /**
     * The number representing the operation.
     */
    private final int operationNumber;

    /**
     * The symbol representing the operation.
     */
    private final String symbol;

    /**
     * Constructs a new Operation with the specified operation number and symbol.
     *
     * @param operationNumber The number representing the operation.
     * @param symbol          The symbol representing the operation.
     */
    Operation(final int operationNumber, final String symbol) {
        this.operationNumber = operationNumber;
        this.symbol = symbol;
    }
}

