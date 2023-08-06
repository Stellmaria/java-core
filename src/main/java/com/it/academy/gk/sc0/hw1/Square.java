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
     * A logger for logging messages.
     */
    private final Logger logger;

    @SuppressFBWarnings("EI_EXPOSE_REP2")
    public Square(Logger logger) {
        this.logger = logger;
    }

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

        var area = sideLength * sideLength;
        var perimeter = SIDES_IN_SQUARE * sideLength;

        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.format(AREA_MESSAGE, area));
            logger.info(String.format(PERIMETER_MESSAGE, perimeter));
        }
    }
}
