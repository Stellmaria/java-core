package com.it.academy.gk.sc0.statements.task5;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * A class to play a guessing game.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
public class GuessNumber {
    /**
     * The message displayed at the start of the game.
     */
    private static final String START_GAME = "I'm thinking of a number. Can you guess what it is?";

    /**
     * The message prompting the user to enter their guess.
     */
    private static final String ENTER_GUESS = "Enter your guess: ";

    /**
     * The message displayed when the user's guess is too low.
     */
    private static final String TOO_LOW = "Your guess is too low.";

    /**
     * The message displayed when the user's guess is too high.
     */
    private static final String TOO_HIGH = "Your guess is too high.";

    /**
     * The message displayed when the user correctly guesses the number.
     */
    private static final String CORRECT = "Congratulations! You guessed the number.";

    /**
     * The message displayed when the user enters an invalid input.
     */
    private static final String INVALID_INPUT = "Invalid input. Please enter an integer.";

    /**
     * The error message displayed when the minimum value is greater than the maximum value.
     */
    public static final String EQUAL_TO_MAX_VALUE = "Min value must be less than or equal to max value.";

    /**
     * The randomly generated number that the user needs to guess.
     */
    private final int number;

    /**
     * The Scanner object used for reading user input.
     */
    private final Scanner scanner;

    /**
     * The Logger object used for logging messages.
     */
    private final Logger logger;

    /**
     * The SecureRandom object used for generating the random number.
     */
    private final SecureRandom rand;

    /**
     * Constructor for GuessNumber class.
     *
     * @param min The minimum value for the generated number.
     * @param max The maximum value for the generated number.
     */
    public GuessNumber(final int min, final int max) {
        this(min, max, new Scanner(System.in, StandardCharsets.UTF_8), Logger.getLogger(GuessNumber.class.getName()));
    }

    /**
     * Constructor for GuessNumber class.
     *
     * @param min     The minimum value for the generated number.
     * @param max     The maximum value for the generated number.
     * @param scanner The scanner object for user input.
     * @param logger  The logger object for logging messages.
     */
    public GuessNumber(final int min, final int max, final Scanner scanner, final Logger logger) {
        if (min > max) {
            throw new IllegalArgumentException(EQUAL_TO_MAX_VALUE);
        }
        this.rand = new SecureRandom();
        this.number = generateRandomNumber(min, max);
        this.scanner = scanner;
        this.logger = logger;
    }

    /**
     * Generates a random number within the specified range.
     *
     * @param min The minimum value for the generated number.
     * @param max The maximum value for the generated number.
     * @return The generated random number.
     */
    private int generateRandomNumber(final int min, final int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    /**
     * Plays the guessing game.
     */
    public void play() {
        logger.log(Level.INFO, START_GAME);

        var guess = 0;

        while (guess != number) {
            logger.log(Level.INFO, ENTER_GUESS);

            try {
                guess = scanner.nextInt();
            } catch (Exception e) {
                logger.log(Level.WARNING, INVALID_INPUT);
                scanner.next();
                continue;
            }

            if (guess < number) {
                logger.log(Level.INFO, TOO_LOW);
            } else if (guess > number) {
                logger.log(Level.INFO, TOO_HIGH);
            } else {
                logger.log(Level.INFO, CORRECT);
            }
        }
    }
}
