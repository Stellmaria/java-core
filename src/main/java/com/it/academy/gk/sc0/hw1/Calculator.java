package com.it.academy.gk.sc0.hw1;

import java.util.AbstractMap;
import java.util.stream.Stream;

/**
 * Let the user besides the number operation enter two numbers,
 * and depending on the operation number with the entered numbers perform certain actions
 * (for example, when entering the number 3, the numbers are multiplied).
 * The result of the operation is displayed on the console.
 *
 * @author Anastasia Melnikova.
 */
public class Calculator {
    /**
     * The message to display when prompting the user to enter the number of an operation.
     */
    private static final String PROMPT_MESSAGE = "Enter the number of the operation: 1. Addition 2. Subtraction " +
                                                 "3. Multiplication ";

    /**
     * The message to display when the entered number does not correspond to any operation.
     */
    private static final String INVALID_OPERATION_MESSAGE = "The operation is not defined.";

    /**
     * The separator used to insert a line break in a string.
     */
    private static final String LINE_SEPARATOR = "\n";

    /**
     * The symbol used to represent the equal sign in a string.
     */
    private static final String EQUALS_SYMBOL = " = ";

    /**
     * The symbol used to represent the addition operation in a string.
     */
    private static final String ADDITION_SYMBOL = " + ";

    /**
     * The symbol used to represent the subtraction operation in a string.
     */
    private static final String SUBTRACTION_SYMBOL = " - ";

    /**
     * The symbol used to represent the multiplication operation in a string.
     */
    private static final String MULTIPLICATION_SYMBOL = " * ";

    /**
     * A constant representing an empty string separator.
     */
    private static final String SEPARATOR = "";

    /**
     * Calculates the result of a mathematical operation between two numbers.
     * <p/>
     * This method takes in three parameters: operationNumber, firstNumber, and secondNumber.
     * The operationNumber parameter represents the mathematical operation to perform where 1 is for addition,
     * 2 is for subtraction, and 3 is for multiplication.
     * The firstNumber and secondNumber parameters represent the two numbers to use in the calculation.
     * <p/>
     * The method creates a stream of AbstractMap.SimpleEntry objects,
     * where the key is the operation number and the value is the result of the calculation.
     * The stream is then filtered to only include the entry with the matching operation number,
     * and the findFirst method is used to get the first (and only) entry in the filtered stream.
     * The ifPresentOrElse method is then used
     * to either append the result of the calculation to the result string builder
     * if an entry was found or append the INVALID_OPERATION_MESSAGE if no entry was found.
     *
     * @param operationNumber The number representing the operation to perform.
     *                        One for addition, 2 for subtraction, and 3 for multiplication.
     * @param firstNumber     The first number to use in the calculation.
     * @param secondNumber    The second number to use in the calculation.
     * @return A string containing the result of the calculation, or an error message if the operation is invalid.
     */
    public String calculate(final int operationNumber, final double firstNumber, final double secondNumber) {
        var result = new StringBuilder();
        result.append(PROMPT_MESSAGE).append(LINE_SEPARATOR);

        Stream.of(
                        new AbstractMap.SimpleEntry<>(1, firstNumber + secondNumber),
                        new AbstractMap.SimpleEntry<>(2, firstNumber - secondNumber),
                        new AbstractMap.SimpleEntry<>(3, firstNumber * secondNumber)
                )
                .filter(entry -> entry.getKey() == operationNumber)
                .findFirst()
                .ifPresentOrElse(
                        entry -> result.append(firstNumber)
                                .append(getOperationSymbol(operationNumber))
                                .append(secondNumber)
                                .append(EQUALS_SYMBOL)
                                .append(entry.getValue()),
                        () -> result.append(INVALID_OPERATION_MESSAGE)
                );

        return result.toString();
    }

    /**
     * Returns the symbol representing the given operation number.
     *
     * @param operationNumber The number representing the operation.
     *                        One for addition, 2 for subtraction, and 3 for multiplication.
     * @return The symbol representing the given operation number, or an empty string if the operation is invalid.
     */
    private String getOperationSymbol(final int operationNumber) {
        return switch (operationNumber) {
            case 1 -> ADDITION_SYMBOL;
            case 2 -> SUBTRACTION_SYMBOL;
            case 3 -> MULTIPLICATION_SYMBOL;
            default -> SEPARATOR;
        };
    }
}
