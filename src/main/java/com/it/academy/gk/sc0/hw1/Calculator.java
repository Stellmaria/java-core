package com.it.academy.gk.sc0.hw1;

/**
 * Change the previous program. Let the user besides the number
 * operation enter two numbers, and depending on the operation number with
 * the entered numbers perform certain actions (for example,
 * when entering the number 3, the numbers are multiplied).
 * The result of the operation is displayed on the console.
 */
public class Calculator {
    /**
     * The message to display when prompting the user to enter the number of an operation.
     */
    private static final String PROMPT_MESSAGE = "Enter the number of the operation: 1. Addition 2. Subtraction " +
                                                 "3. Multiplication";
    /**
     * The message to display when the entered number does not correspond to any operation.
     */
    private static final String INVALID_OPERATION_MESSAGE = "The operation is not defined.";
    /**
     * The symbol used to represent the equal sign in a string.
     */
    private static final String EQUALS_SYMBOL = " = ";
    /**
     * The symbol used to represent the addition operation in a string.
     */
    private static final String ADDITION_SYMBOL = " + ";
    /**
     * The separator used to insert a line break in a string.
     */
    private static final String LINE_SEPARATOR = "\n";
    /**
     * The symbol used to represent the subtraction operation in a string.
     */
    private static final String SUBTRACTION_SYMBOL = " - ";

    /**
     * The symbol used to represent the multiplication operation in a string.
     */
    private static final String MULTIPLICATION_SYMBOL = " * ";

    /**
     * Prompts the user to enter the number of an operation and two numbers, performs the selected operation
     * on the entered numbers, and returns the result.
     * <p>
     * This method displays a message that prompts the user to enter the number of an operation.
     * It then reads the number entered by the user and uses an if statement to determine which operation to perform.
     * It also reads two numbers entered by the user and performs the selected operation on these numbers.
     * If the entered number corresponds to a valid operation, it returns a string that describes the result
     * of performing that operation on the entered numbers. Otherwise, it returns a message indicating
     * that the operation is not defined.
     *
     * @param operationNumber the number of the operation entered by the user
     * @param firstNumber     the first number entered by the user
     * @param secondNumber    the second number entered by the user
     * @return a string that describes the result of performing the selected operation on the entered numbers
     * or indicates that the operation is not defined
     */
    public String calculate(int operationNumber, double firstNumber, double secondNumber) {
        var result = new StringBuilder();

        result.append(PROMPT_MESSAGE).append(LINE_SEPARATOR);
        if (operationNumber == 1) {
            result.append(firstNumber).append(ADDITION_SYMBOL).append(secondNumber).append(EQUALS_SYMBOL)
                    .append(firstNumber + secondNumber);
        } else if (operationNumber == 2) {
            result.append(firstNumber).append(SUBTRACTION_SYMBOL).append(secondNumber).append(EQUALS_SYMBOL)
                    .append(firstNumber - secondNumber);
        } else if (operationNumber == 3) {
            result.append(firstNumber).append(MULTIPLICATION_SYMBOL).append(secondNumber).append(EQUALS_SYMBOL)
                    .append(firstNumber * secondNumber);
        } else {
            result.append(INVALID_OPERATION_MESSAGE);
        }
        return result.toString();
    }
}
