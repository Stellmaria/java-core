package com.it.academy.gk.sc0.statements;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Task 5
 * Guess an integer that the computer "guessed" in a certain range.
 * The GuessNumber class allows a user to play a game where they try to guess
 * a number that the computer has "thought of" within a certain range.
 */
public class GuessNumber {
    /**
     * Message displayed at the start of the game.
     */
    private static final String START_GAME = "I'm thinking of a number. Can you guess what it is?";
    /**
     * Message prompting the player to enter their guess.
     */
    private static final String ENTER_GUESS = "Enter your guess: ";
    /**
     * Message displayed when the player's guess is too low.
     */
    private static final String TOO_LOW = "Your guess is too low.";
    /**
     * Message displayed when the player's guess is too high.
     */
    private static final String TOO_HIGH = "Your guess is too high.";
    /**
     * Message displayed when the player correctly guesses the number.
     */
    private static final String CORRECT = "Congratulations! You guessed the number.";
    /**
     * The randomly generated number that the player is trying to guess.
     */
    private final int number;
    /**
     * The scanner used to read input from the player.
     */
    private final Scanner scanner;
    /**
     * The logger used to log messages to the console.
     */
    private final Logger logger;
    /**
     * The random number generator used to generate random numbers.
     */
    private final SecureRandom rand;

    /**
     * Constructs a new GuessNumber game with a randomly generated number between min and max (inclusive).
     *
     * @param min the minimum value for the randomly generated number
     * @param max the maximum value for the randomly generated number
     */
    @SuppressFBWarnings("DM_DEFAULT_ENCODING")
    public GuessNumber(int min, int max) {
        this(min, max, new Scanner(System.in, StandardCharsets.UTF_8), Logger.getLogger(GuessNumber.class.getName()));
    }

    /**
     * Constructs a new GuessNumber game with a randomly generated number between min and max (inclusive),
     * using the specified scanner and logger.
     *
     * @param min     the minimum value for the randomly generated number
     * @param max     the maximum value for the randomly generated number
     * @param scanner the scanner used to read input from the player
     * @param logger  the logger used to log messages to the console
     */
    @SuppressFBWarnings({"EI_EXPOSE_REP2", "DMI_RANDOM_USED_ONLY_ONCE"})
    public GuessNumber(int min, int max, Scanner scanner, @NotNull Logger logger) {
        this.rand = new SecureRandom();
        this.number = generateRandomNumber(min, max);
        // Note: This class stores a reference to the Scanner object passed to its constructor,
        // and any changes made to this object outside of this class will affect its internal representation.
        this.scanner = scanner;
        this.logger = logger;
    }

    /**
     * Generates a new random number between min and max (inclusive).
     *
     * @param min the minimum value for the randomly generated number
     * @param max the maximum value for the randomly generated number
     * @return a new random number between min and max (inclusive)
     */
    private int generateRandomNumber(final int min, final int max) {
        return rand.nextInt((max - min) + 1) + min;
    }

    /**
     * Starts a new game and prompts the player to enter their guesses until they correctly guess the number.
     * This method uses the `logger` field to display messages to the player, and the `scanner`
     * field to read the player's guesses. It enters a loop that continues until the player correctly guesses
     * the number stored in the `number` field. During each iteration of the loop, it prompts the player
     * to enter their guess, reads an integer from `scanner`, and compares it to `number`.
     * If the guess is too low or too high, it logs an appropriate message using `logger`.
     * If the guess is correct, it logs a congratulatory message and exits the loop.
     */
    public void play() {
        logger.info(START_GAME);
        var guess = 0;

        while (guess != number) {
            logger.info(ENTER_GUESS);
            guess = scanner.nextInt();
            if (guess < number) {
                logger.info(TOO_LOW);
            } else if (guess > number) {
                logger.info(TOO_HIGH);
            } else {
                logger.info(CORRECT);
            }
        }
    }
}
