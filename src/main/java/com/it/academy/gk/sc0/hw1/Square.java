package com.it.academy.gk.sc0.hw1;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The side of the square is given (a - user input).
 * Find the area and perimeter of the square and handle invalid input.
 *
 * @author Anastasia Melnikova.
 */
public class Square {
    private static final int SIDES_IN_SQUARE = 4;
    private static final String INVALID_INPUT_MESSAGE = "Invalid input. Please enter a positive number.";
    private static final String PROMPT_MESSAGE = "Enter the length of one side of the square: ";
    private static final String AREA_MESSAGE = "The area of the square is: %.2f";
    private static final String PERIMETER_MESSAGE = "The perimeter of the square is: %.2f";

    private final Logger logger;

    /**
     * Constructs a new Square object with the specified logger.
     *
     * @param logger logger used for output.
     */
    @SuppressFBWarnings("EI_EXPOSE_REP2")
    public Square(final Logger logger) {
        this.logger = Objects.requireNonNull(logger, "logger");
    }

    /**
     * Reads a positive side length, then calculates and logs the square area and perimeter.
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

        final double area = sideLength * sideLength;
        final double perimeter = SIDES_IN_SQUARE * sideLength;

        if (logger.isLoggable(Level.INFO)) {
            logger.info(String.format(Locale.ROOT, AREA_MESSAGE, area));
            logger.info(String.format(Locale.ROOT, PERIMETER_MESSAGE, perimeter));
        }
    }
}
