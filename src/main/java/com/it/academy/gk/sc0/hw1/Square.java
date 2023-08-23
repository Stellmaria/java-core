package com.it.academy.gk.sc0.hw1;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The side of the square is given (a - user input).
 * Find the area and perimeter of the square.
 * Make sure to enter incorrect data.
 *
 * @author Anastasia Melnikova.
 */
public class Square {
    /**
     * The number of sides in a square (4).
     */
    private static final int SIDES_IN_SQUARE = 4;

    /**
     * The message to display when the user enters an invalid input.
     */
    private static final String INVALID_INPUT_MESSAGE = "Invalid input. Please enter a positive number.";

    /**
     * The message to prompt the user to enter the length of one side of the square.
     */
    private static final String PROMPT_MESSAGE = "Enter the length of one side of the square: ";

    /**
     * The message to display the calculated area of the square.
     */
    private static final String AREA_MESSAGE = "The area of the square is: %.2f";

    /**
     * The message to display the calculated perimeter of the square.
     */
    private static final String PERIMETER_MESSAGE = "The perimeter of the square is: %.2f";

    /**
     * A SafeLogger used to log messages to the console.
     */
    private final Logger logger;

    /**
     * Constructs a new Square object with the specified logger.
     *
     * @param logger the logger to use for logging messages.
     */
    @SuppressFBWarnings("EI_EXPOSE_REP2")
    public Square(final Logger logger) {
        this.logger = logger;
    }

    /**
     * This method calculates the area and perimeter of a square based on the length of its side.
     * It prompts the user to enter the length of the side of the square, validates the input,
     * and then calculates and displays the area and perimeter of the square.
     * <p/>
     * The method uses a Scanner object to read input from the standard input stream.
     * It displays a message prompting the user to enter the length of the side of the square
     * and then reads the entered value.
     * If the entered value is not a valid double, it displays an error message and prompts again.
     * If the entered value is less than or equal to zero, it also displays an error message and prompts again.
     * This process continues until a valid value is entered.
     * <p/>
     * Once a valid value is entered,
     * the method calculates the area and perimeter of the square using the formulae for these values.
     * It then checks if logging at the INFO level is enabled,
     * and if it is, it logs messages displaying the calculated area and perimeter.
     */
    public void calculateSquare() {
        double sideLength;

        try (Scanner scanner = new Scanner(System.in, StandardCharsets.UTF_8)) {
            do {
                logger.info(PROMPT_MESSAGE);

                while (!scanner.hasNextDouble()) {
                    logger.warning(INVALID_INPUT_MESSAGE);
                    logger.info(PROMPT_MESSAGE);
                    scanner.next();
                }
                sideLength = scanner.nextDouble();

                if (sideLength <= 0) {
                    logger.warning(INVALID_INPUT_MESSAGE);
                }
            } while (sideLength <= 0);
        }

        double area = sideLength * sideLength;
        double perimeter = SIDES_IN_SQUARE * sideLength;

        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.format(AREA_MESSAGE, area));
            logger.info(String.format(PERIMETER_MESSAGE, perimeter));
        }
    }
}
