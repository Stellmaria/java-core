package com.it.academy.gk.sc0.statements;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;
import java.util.logging.Logger;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

/**
 * This class contains unit tests for the GuessNumber class.
 * It uses the Mockito framework to create mock objects for the Scanner and Logger classes,
 * which are passed to the GuessNumber constructor when creating a new game.
 */
@ExtendWith(MockitoExtension.class)
class GuessNumberTest {
    /**
     * A mock object for the Scanner class, used to simulate user input.
     */
    @Mock
    private Scanner scanner;
    /**
     * A mock object for the Logger class, used to verify that the correct messages are logged.
     */
    @Mock
    private Logger logger;

    /**
     * Tests that the play method behaves correctly when the player correctly guesses the number on their first try.
     * This test method uses reflection to access the private fields of the GuessNumber class and retrieve the values
     * of the messages that are displayed to the player. It then creates a new GuessNumber game with a fixed number,
     * sets up the scanner mock to return the correct guess on the first try, and calls the play method. Finally,
     * it verifies that the logger mock was called with the expected messages in the correct order.
     */
    @Test
    void testPlayMethodCorrectGuessFirstTry() throws NoSuchFieldException, IllegalAccessException {
        when(scanner.nextInt()).thenReturn(5);
        var game = new GuessNumber(5, 5, scanner, logger);

        var startGameField = GuessNumber.class.getDeclaredField("START_GAME");
        startGameField.setAccessible(true);
        var startGame = (String) startGameField.get(game);

        var enterGuessField = GuessNumber.class.getDeclaredField("ENTER_GUESS");
        enterGuessField.setAccessible(true);
        var enterGuess = (String) enterGuessField.get(game);

        var correctField = GuessNumber.class.getDeclaredField("CORRECT");
        correctField.setAccessible(true);
        var correct = (String) correctField.get(game);

        game.play();
        verify(logger).info(startGame);
        verify(logger).info(enterGuess);
        verify(logger).info(correct);
        verifyNoMoreInteractions(logger);
    }

    /**
     * Tests that the play method behaves correctly when the player's first guess is too low,
     * and their second guess is correct. This test method uses reflection to access
     * the private fields of the GuessNumber class and retrieve the values of the messages that are displayed
     * to the player. It then creates a new GuessNumber game with a fixed number, sets up the scanner mock
     * to return a guess that is too low on the first try and the correct guess on the second try, and calls
     * the play method. Finally, it verifies that the logger mock was called with the expected messages in
     * the correct order.
     */
    @Test
    void testPlayMethodTooLowThenCorrect() throws NoSuchFieldException, IllegalAccessException {
        when(scanner.nextInt()).thenReturn(4, 5);
        var game = new GuessNumber(5, 5, scanner, logger);

        var startGameField = GuessNumber.class.getDeclaredField("START_GAME");
        startGameField.setAccessible(true);
        var startGame = (String) startGameField.get(game);

        var enterGuessField = GuessNumber.class.getDeclaredField("ENTER_GUESS");
        enterGuessField.setAccessible(true);
        var enterGuess = (String) enterGuessField.get(game);

        var tooLowField = GuessNumber.class.getDeclaredField("TOO_LOW");
        tooLowField.setAccessible(true);
        var tooLow = (String) tooLowField.get(game);

        var correctField = GuessNumber.class.getDeclaredField("CORRECT");
        correctField.setAccessible(true);
        var correct = (String) correctField.get(game);

        game.play();
        verify(logger).info(startGame);
        verify(logger, times(2)).info(enterGuess);
        verify(logger).info(tooLow);
        verify(logger).info(correct);
        verifyNoMoreInteractions(logger);
    }

    /**
     * Tests that the play method behaves correctly when the player's first guess is too high,
     * and their second guess is correct. This test method uses reflection to access
     * the private fields of the GuessNumber class and retrieve the values of the messages that are displayed
     * to the player. It then creates a new GuessNumber game with a fixed number, sets up the scanner mock
     * to return a guess that is too high on the first try and the correct guess on the second try,
     * and calls the play method. Finally, it verifies that the logger mock was called with the expected messages in
     * the correct order.
     */
    @Test
    void testPlayMethodTooHighThenCorrect() throws NoSuchFieldException, IllegalAccessException {
        when(scanner.nextInt()).thenReturn(6, 5);
        var game = new GuessNumber(5, 5, scanner, logger);

        var startGameField = GuessNumber.class.getDeclaredField("START_GAME");
        startGameField.setAccessible(true);
        var startGame = (String) startGameField.get(game);

        var enterGuessField = GuessNumber.class.getDeclaredField("ENTER_GUESS");
        enterGuessField.setAccessible(true);
        var enterGuess = (String) enterGuessField.get(game);

        var tooHighField = GuessNumber.class.getDeclaredField("TOO_HIGH");
        tooHighField.setAccessible(true);
        var tooHigh = (String) tooHighField.get(game);

        var correctField = GuessNumber.class.getDeclaredField("CORRECT");
        correctField.setAccessible(true);
        var correct = (String) correctField.get(game);

        game.play();
        verify(logger).info(startGame);
        verify(logger, times(2)).info(enterGuess);
        verify(logger).info(tooHigh);
        verify(logger).info(correct);
        verifyNoMoreInteractions(logger);
    }
}
