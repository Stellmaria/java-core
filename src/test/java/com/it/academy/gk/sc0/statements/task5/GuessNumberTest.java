package com.it.academy.gk.sc0.statements.task5;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * This class is responsible for testing the GuessNumber class.
 * It uses JUnit 5 and Mockito for testing.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@DisplayName("Guess Number Test")
@ExtendWith(MockitoExtension.class)
class GuessNumberTest {
    private static String TOO_LOW;
    private static String TOO_HIGH;
    private static String CORRECT;
    private static String INVALID_INPUT;

    private int number;

    private Method generateRandomNumberMethod;
    private GuessNumber guessNumber;

    @Mock
    private Scanner scanner;
    @Mock
    private Logger logger;

    /**
     * This method is called before all test methods in the class.
     * It initializes the static variables TOO_LOW, TOO_HIGH, CORRECT, and INVALID_INPUT
     * by fetching their values from the GuessNumber class using reflection.
     *
     * @throws NoSuchFieldException   If the specified field does not exist.
     * @throws IllegalAccessException If the specified field is not accessible.
     */
    @BeforeAll
    public static void beforeAll() throws NoSuchFieldException, IllegalAccessException {
        TOO_LOW = getStaticFieldValue("TOO_LOW");
        TOO_HIGH = getStaticFieldValue("TOO_HIGH");
        CORRECT = getStaticFieldValue("CORRECT");
        INVALID_INPUT = getStaticFieldValue("INVALID_INPUT");
    }

    /**
     * This method retrieves the value of a static field from the GuessNumber class.
     *
     * @param fieldName The name of the static field to retrieve the value from.
     * @return The value of the specified static field.
     * @throws NoSuchFieldException   If the specified field does not exist.
     * @throws IllegalAccessException If the specified field is not accessible.
     */
    private static String getStaticFieldValue(String fieldName) throws NoSuchFieldException, IllegalAccessException {
        var field = GuessNumber.class.getDeclaredField(fieldName);
        field.setAccessible(true);

        return (String) field.get(null);
    }

    /**
     * This method is called before each test method in the class.
     * It initializes the GuessNumber object, fetches the generated number from the object,
     * and retrieves the generateRandomNumber method for testing purposes.
     *
     * @throws NoSuchFieldException   If the specified field does not exist.
     * @throws IllegalAccessException If the specified field is not accessible.
     * @throws NoSuchMethodException  If the specified method does not exist.
     */
    @BeforeEach
    public void setUp() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        guessNumber = new GuessNumber(1, 10, scanner, logger);

        var numberField = GuessNumber.class.getDeclaredField("number");
        numberField.setAccessible(true);
        number = (int) numberField.get(guessNumber);

        generateRandomNumberMethod = GuessNumber.class.getDeclaredMethod(
                "generateRandomNumber", int.class, int.class
        );
        generateRandomNumberMethod.setAccessible(true);
    }

    /**
     * This test method verifies that the generateRandomNumber method returns a number within the specified range.
     *
     * @throws InvocationTargetException If an error occurs while invoking the method.
     * @throws IllegalAccessException    If the method is not accessible.
     */
    @Test
    @DisplayName("Test generateRandomNumber method returns number within range")
    void testGenerateRandomNumberReturnsNumberWithinRange() throws InvocationTargetException, IllegalAccessException {
        var min = 1;
        var max = 10;

        // Invoke the generateRandomNumber method with the specified range
        var randomNumber = (int) generateRandomNumberMethod.invoke(guessNumber, min, max);

        assertTrue(randomNumber >= min && randomNumber <= max);
    }

    /**
     * This test method verifies that the generateRandomNumber method returns a different number on subsequent calls.
     *
     * @throws InvocationTargetException If an error occurs while invoking the method.
     * @throws IllegalAccessException    If the method is not accessible.
     */
    @Test
    @DisplayName("Test generateRandomNumber method returns different numbers on subsequent calls")
    void testGenerateRandomNumberReturnsDifferentNumbersOnSubsequentCalls()
            throws InvocationTargetException, IllegalAccessException {
        var min = 1;
        var max = 10;

        // Invoke the generateRandomNumber method with the specified range to get the first random number
        var randomNumber = (int) generateRandomNumberMethod.invoke(guessNumber, min, max);
        // Invoke the generateRandomNumber method with the same range to get the second random number
        var randomNumber2 = (int) generateRandomNumberMethod.invoke(guessNumber, min, max);

        assertNotEquals(randomNumber, randomNumber2);
    }

    /**
     * This test method verifies that the generateRandomNumber method returns a number within the new specified range.
     *
     * @throws InvocationTargetException If an error occurs while invoking the method.
     * @throws IllegalAccessException    If the method is not accessible.
     */
    @Test
    @DisplayName("Test generateRandomNumber method returns number within new range")
    void testGenerateRandomNumberReturnsNumberWithinNewRange()
            throws InvocationTargetException, IllegalAccessException {
        var newMin = 5;
        var newMax = 15;

        // Invoke the generateRandomNumber method with the new range to get a new random number
        var newRandomNumber = (int) generateRandomNumberMethod.invoke(guessNumber, newMin, newMax);

        assertTrue(newRandomNumber >= newMin && newRandomNumber <= newMax);
    }

    /**
     * This test method verifies the functionality of the play method in the GuessNumber class.
     * The play method is expected to interact with the user through the scanner object,
     * and log messages to the logger object based on the user's guesses.
     * <p>
     * The test uses Mockito to mock the scanner and logger objects, and sets up the expected behavior
     * for the scanner.nextInt() method and the logger.log() method.
     * <p>
     * The test case covers a scenario where the user makes three guesses: one too low, one too high,
     * and one correct. The expected behavior is that the logger.log() method is called three times,
     * with the appropriate log messages for each guess.
     */
    @Test
    @DisplayName("Test play method with three guesses: one too low, one too high, one correct")
    void testPlay() {
        when(scanner.nextInt()).thenReturn(number - 1, number + 1, number);

        guessNumber.play();

        // Verify that the logger.log() method is called three times with the appropriate log messages
        verify(logger, times(1)).log(Level.INFO, TOO_LOW);
        verify(logger, times(1)).log(Level.INFO, TOO_HIGH);
        verify(logger, times(1)).log(Level.INFO, CORRECT);
    }

    /**
     * This test method verifies the functionality of the play method in the GuessNumber class.
     * The play method is expected to interact with the user through the scanner object,
     * and log messages to the logger object based on the user's guesses.
     * <p>
     * The test uses Mockito to mock the scanner and logger objects, and sets up the expected behavior
     * for the scanner.nextInt() method and the logger.log() method.
     * <p>
     * The test case covers a scenario where the user makes four guesses: one too low, two too high,
     * and one correct. The expected behavior is that the logger.log() method is called four times,
     * with the appropriate log messages for each guess.
     */
    @Test
    @DisplayName("Test play method with four guesses: one too low, two too high, one correct")
    void testPlayNegative() {
        when(scanner.nextInt()).thenReturn(number - 1, number + 1, number + 2, number);

        guessNumber.play();

        // Verify that the logger.log() method is called with the appropriate log messages
        // The times() method is used to specify the expected number of calls for each log message
        verify(logger, times(1)).log(Level.INFO, TOO_LOW);
        verify(logger, times(2)).log(Level.INFO, TOO_HIGH);
        verify(logger, times(1)).log(Level.INFO, CORRECT);
    }

    /**
     * This test method verifies the functionality of the play method in the GuessNumber class.
     * The play method is expected to interact with the user through the scanner object,
     * and log messages to the logger object based on the user's guesses.
     * <p>
     * The test uses Mockito to mock the scanner and logger objects, and sets up the expected behavior
     * for the scanner.nextInt() method and the logger.log() method.
     * <p>
     * The test case covers a scenario where the user makes guesses that are out of the specified range.
     * The expected behavior is that the logger.log() method is called twice, with the appropriate log messages
     * for the guesses that is too low and too high. The logger.log() method should also be called once
     * with the correct log message for the correct guess.
     */
    @Test
    @DisplayName("Test play method with out of range guesses")
    void testPlayWithOutOfRangeGuesses() {
        when(scanner.nextInt()).thenReturn(0, 11, number);

        guessNumber.play();

        // Verify that the logger.log() method is called with the appropriate log messages
        // The times() method is used to specify the expected number of calls for each log message
        verify(logger, times(1)).log(Level.INFO, TOO_LOW);
        verify(logger, times(1)).log(Level.INFO, TOO_HIGH);
        verify(logger, times(1)).log(Level.INFO, CORRECT);
    }

    /**
     * This test method verifies the functionality of the play method in the GuessNumber class.
     * The play method is expected to interact with the user through the scanner object,
     * and log messages to the logger object based on the user's guesses.
     * <p>
     * The test uses Mockito to mock the scanner and logger objects, and sets up the expected behavior
     * for the scanner.nextInt() method and the logger.log() method.
     * <p>
     * The test case covers a scenario where the user makes multiple attempts before guessing correctly.
     * The expected behavior is that the logger.log() method is called twice with the appropriate log messages
     * for the guesses that is too low, and once with the correct log message for the correct guess.
     */
    @Test
    @DisplayName("Test play method with multiple attempts before correct guess")
    void testMultipleAttemptsBeforeCorrectGuess() {
        when(scanner.nextInt()).thenReturn(number - 1, number - 1, number);

        guessNumber.play();

        // Verify that the logger.log() method is called with the appropriate log messages
        // The times() method is used to specify the expected number of calls for each log message
        verify(logger, times(2)).log(Level.INFO, TOO_LOW);
        verify(logger, times(1)).log(Level.INFO, CORRECT);
    }

    /**
     * This test method verifies the functionality of the play method in the GuessNumber class.
     * The play method is expected to interact with the user through the scanner object,
     * and log messages to the logger object based on the user's guesses.
     * <p>
     * The test uses Mockito to mock the scanner and logger objects, and sets up the expected behavior
     * for the scanner.nextInt() method and the logger.log() method.
     * <p>
     * The test case covers a scenario where the user makes guesses that are negative numbers.
     * The expected behavior is that the logger.log() method is called twice with the appropriate log messages
     * for the guesses that is too high and too low. The logger.log() method should also be called once
     * with the correct log message for the correct guess.
     */
    @Test
    @DisplayName("Test play method with negative number guesses")
    void testPlayWithNegativeNumbers() {
        when(scanner.nextInt()).thenReturn(number + 1, number - 1, number);

        guessNumber.play();

        // Verify that the logger.log() method is called with the appropriate log messages
        // The times() method is used to specify the expected number of calls for each log message
        verify(logger, times(1)).log(Level.INFO, TOO_HIGH);
        verify(logger, times(1)).log(Level.INFO, TOO_LOW);
        verify(logger, times(1)).log(Level.INFO, CORRECT);
    }

    /**
     * This test method verifies the functionality of the play method in the GuessNumber class.
     * The play method is expected to interact with the user through the scanner object,
     * and log messages to the logger object based on the user's guesses.
     * <p>
     * The test uses Mockito to mock the scanner and logger objects, and sets up the expected behavior
     * for the scanner.nextInt() method and the logger.log() method.
     * <p>
     * The test case covers a scenario where the user makes guesses that are not integers.
     * The expected behavior is that the logger.log() method is called once with the appropriate log message
     * for the invalid input, and then the logger.log() method is called again with the correct log message
     * for the correct guess.
     */
    @Test
    @DisplayName("Test play method with invalid input")
    void testPlayWithInvalidInput() {
        when(scanner.nextInt()).thenThrow(InputMismatchException.class).thenReturn(number);

        guessNumber.play();

        // Verify that the logger.log() method is called with the appropriate log messages
        // The times() method is used to specify the expected number of calls for each log message
        verify(logger, times(1)).log(Level.WARNING, INVALID_INPUT);
        verify(logger, times(1)).log(Level.INFO, CORRECT);
    }

    /**
     * This test method verifies the functionality of the play method in the GuessNumber class.
     * The play method is expected to interact with the user through the scanner object,
     * and log messages to the logger object based on the user's guesses.
     * <p>
     * The test uses Mockito to mock the scanner and logger objects, and sets up the expected behavior
     * for the scanner.nextInt() method and the logger.log() method.
     * <p>
     * The test case covers a scenario where the user makes a guess that is a boundary value (either 1 or 10).
     * The expected behavior is that the logger.log() method is called once with the appropriate log message
     * for the guess, and then the logger.log() method is called again with the correct log message
     * for the correct guess.
     *
     * @param guess The boundary guess to test. It can be either 1 or 10.
     */
    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    @DisplayName("Test play method with boundary guesses")
    void testPlayWithBoundaryGuesses(int guess) {
        when(scanner.nextInt()).thenReturn(guess, number);

        guessNumber.play();

        if (guess < number) {
            verify(logger, times(1)).log(Level.INFO, TOO_LOW);
        } else if (guess > number) {
            verify(logger, times(1)).log(Level.INFO, TOO_HIGH);
        }

        verify(logger, times(1)).log(Level.INFO, CORRECT);
    }

    /**
     * This test method verifies the functionality of the play method in the GuessNumber class.
     * The play method is expected to interact with the user through the scanner object,
     * and log messages to the logger object based on the user's guesses.
     * <p>
     * The test uses Mockito to mock the scanner and logger objects, and sets up the expected behavior
     * for the scanner.nextInt() method and the logger.log() method.
     * <p>
     * The test case covers a scenario where the range of the guessing game is set to the minimum
     * and maximum values (1 and 1 respectively).
     * The expected behavior is that the logger.log() method is called once with the correct log message
     * for the correct guess.
     *
     * @throws NoSuchFieldException   If the specified field does not exist.
     * @throws IllegalAccessException If the specified field is not accessible.
     */
    @Test
    @DisplayName("Test play method with minimum and maximum range values")
    void testPlayWithMinMaxRange() throws NoSuchFieldException, IllegalAccessException {
        var min = 1;
        var max = 1;
        guessNumber = new GuessNumber(min, max, scanner, logger);
        var numberField = GuessNumber.class.getDeclaredField("number");
        numberField.setAccessible(true);
        number = (int) numberField.get(guessNumber);
        when(scanner.nextInt()).thenReturn(number);

        guessNumber.play();

        verify(logger, times(1)).log(Level.INFO, CORRECT);
    }
}
