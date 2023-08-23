package com.it.academy.gk.sc0.hw1;

/**
 * Write a console program that displays to the user message.
 * "Enter operation number: 1. Addition 2. Subtraction 3. Multiplication."
 * Next to the name of each operation is indicated its number — for example, the subtraction operation has number 2.
 * Let the user enter the operation number in the program,
 * and depending on this number, the program displays the name operations.
 * To determine the operation by the entered number, use the switch...case construct.
 * If the entered user number does not match any operation (for example, the number 120),
 * then display a message to the user that the operation is not defined.
 *
 * @author Anastasia Melnikova.
 */
public class OperationSelector {
    /**
     * The message to display when prompting the user to enter the number of an operation.
     */
    private static final String PROMPT_MESSAGE = "Enter the number of the operation: 1. Addition 2. " +
                                                 "Subtraction 3. Multiplication ";

    /**
     * The message to display when the entered number does not correspond to any operation.
     */
    private static final String INVALID_OPERATION_MESSAGE = "The operation is not defined.";

    /**
     * The name of the addition operation.
     */
    private static final String ADDITION = "Addition";

    /**
     * The name of the subtraction operation.
     */
    private static final String SUBTRACTION = "Subtraction";

    /**
     * The name of the multiplication operation.
     */
    private static final String MULTIPLICATION = "Multiplication";

    /**
     * The separator used to insert a line break in a string.
     */
    private static final String SEPARATOR = "\n";

    /**
     * Prompts the user to enter the number of an operation and returns the name of the corresponding operation.
     * <p/>
     * This method displays a message that prompts the user to enter the number of an operation.
     * It then reads the number entered by the user
     * and uses an if statement to determine the name of the corresponding operation.
     * If the entered number corresponds to a valid operation, it returns the name of that operation.
     * Otherwise, it returns a message indicating that the operation is not defined.
     *
     * @param operationNumber the number of the operation entered by the user.
     * @return a string that describes the selected operation or indicates that the operation is not defined.
     */
    public String selectOperation(final int operationNumber) {
        return PROMPT_MESSAGE + SEPARATOR +
               switch (operationNumber) {
                   case 1 -> ADDITION;
                   case 2 -> SUBTRACTION;
                   case 3 -> MULTIPLICATION;
                   default -> INVALID_OPERATION_MESSAGE;
               };
    }
}
