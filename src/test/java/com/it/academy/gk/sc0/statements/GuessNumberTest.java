package com.it.academy.gk.sc0.statements;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Scanner;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * This is a test class for the GuessNumber class.
 * It contains several test methods that test various aspects of the GuessNumber class.
 */
class GuessNumberTest {
    /**
     * This is a private static field that holds the value of the TOO_LOW constant from the GuessNumber class.
     */
    private static String TOO_LOW;
    /**
     * This is a private static field that holds the value of the TOO_HIGH constant from the GuessNumber class.
     */
    private static String TOO_HIGH;
    /**
     * This is a private static field that holds the value of the CORRECT constant from the GuessNumber class.
     */
    private static String CORRECT;
    /**
     * This is a private field that holds an instance of the GuessNumber class.
     */
    private GuessNumber guessNumber;
    /**
     * This is a private field that holds an instance of the Scanner class.
     */
    private Scanner scanner;
    /**
     * This is a private field that holds an instance of the Logger class.
     */
    private Logger logger;

    /**
     * This method sets up constants before all tests are run.
     * It uses reflection to access the private fields of the GuessNumber class and assigns their values
     * to the corresponding fields in this test class.
     */
    @BeforeAll
    public static void setUpConstants() throws Exception {
        var tooLowField = GuessNumber.class.getDeclaredField("TOO_LOW");
        tooLowField.setAccessible(true);
        TOO_LOW = (String) tooLowField.get(null);

        var tooHighField = GuessNumber.class.getDeclaredField("TOO_HIGH");
        tooHighField.setAccessible(true);
        TOO_HIGH = (String) tooHighField.get(null);

        var correctField = GuessNumber.class.getDeclaredField("CORRECT");
        correctField.setAccessible(true);
        CORRECT = (String) correctField.get(null);
    }

    /**
     * This method sets up the test environment before each test is run.
     * It creates mock objects for the Scanner and Logger classes and initializes a new instance
     * of the GuessNumber class with these mock objects.
     */
    @BeforeEach
    public void setUp() {
        scanner = Mockito.mock(Scanner.class);
        logger = Mockito.mock(Logger.class);
        guessNumber = new GuessNumber(1, 10, scanner, logger);
    }

    /**
     * This test method tests that the generateRandomNumber method returns a number within the specified range.
     * It uses reflection to access the private generateRandomNumber method of the GuessNumber class
     * and invokes it with a specified range. The returned value is then checked to be within the specified range.
     */
    @Test
    void testGenerateRandomNumberReturnsNumberWithinRange() throws Exception {
        var generateRandomNumberMethod = GuessNumber.class.getDeclaredMethod(
                "generateRandomNumber", int.class, int.class
        );
        generateRandomNumberMethod.setAccessible(true);

        var min = 1;
        var max = 10;
        var randomNumber = (int) generateRandomNumberMethod.invoke(guessNumber, min, max);
        assertTrue(randomNumber >= min && randomNumber <= max);
    }

    /**
     * This test method tests that the generateRandomNumber method returns different numbers on subsequent calls.
     * It uses reflection to access the private generateRandomNumber method of the GuessNumber class
     * and invokes it twice with the same range. The returned values are then checked to be different from each other.
     */
    @Test
    void testGenerateRandomNumberReturnsDifferentNumbersOnSubsequentCalls() throws Exception {
        var generateRandomNumberMethod = GuessNumber.class.getDeclaredMethod(
                "generateRandomNumber", int.class, int.class
        );
        generateRandomNumberMethod.setAccessible(true);

        var min = 1;
        var max = 10;
        var randomNumber = (int) generateRandomNumberMethod.invoke(guessNumber, min, max);
        var randomNumber2 = (int) generateRandomNumberMethod.invoke(guessNumber, min, max);
        assertNotEquals(randomNumber, randomNumber2);
    }

    /**
     * This test method tests that the generateRandomNumber method returns a number within a new specified range.
     * It uses reflection to access the private generateRandomNumber method of the GuessNumber class
     * and invokes it with a new specified range. The returned value is then checked to be
     * within the new specified range.
     */
    @Test
    void testGenerateRandomNumberReturnsNumberWithinNewRange() throws Exception {
        var generateRandomNumberMethod = GuessNumber.class.getDeclaredMethod(
                "generateRandomNumber", int.class, int.class
        );
        generateRandomNumberMethod.setAccessible(true);

        var newMin = 5;
        var newMax = 15;
        var newRandomNumber = (int) generateRandomNumberMethod.invoke(guessNumber, newMin, newMax);
        assertTrue(newRandomNumber >= newMin && newRandomNumber <= newMax);
    }

    /**
     * This test method tests that the play method works correctly and outputs the appropriate messages
     * when the user inputs a number that is less than, greater than, or equal to the secret number.
     * It uses Mockito to mock the behavior of the Scanner class and returns predefined values when
     * its nextInt method is called. The logger object is also mocked, and its info method
     * is verified to have been called with the appropriate arguments.
     */
    @Test
    void testPlay() throws Exception {
        var numberField = GuessNumber.class.getDeclaredField("number");
        numberField.setAccessible(true);
        var number = (int) numberField.get(guessNumber);

        when(scanner.nextInt()).thenReturn(number - 1, number + 1, number);
        guessNumber.play();
        verify(logger, times(1)).info(TOO_LOW);
        verify(logger, times(1)).info(TOO_HIGH);
        verify(logger, times(1)).info(CORRECT);
    }

    /**
     * This test method tests that the play method works correctly and outputs the appropriate messages
     * when the user inputs a number that is less than, greater than, or equal to the secret number.
     * It uses Mockito to mock the behavior of the Scanner class and returns predefined values
     * when its nextInt method is called. The logger object is also mocked, and its info method
     * is verified to have been called with the appropriate arguments.
     */
    @Test
    void testPlayNegative() throws Exception {
        var numberField = GuessNumber.class.getDeclaredField("number");
        numberField.setAccessible(true);
        var number = (int) numberField.get(guessNumber);

        when(scanner.nextInt()).thenReturn(number - 1, number + 1, number + 2, number);
        guessNumber.play();
        verify(logger, times(1)).info(TOO_LOW);
        verify(logger, times(2)).info(TOO_HIGH);
        verify(logger, times(1)).info(CORRECT);
    }

    /**
     * This test method tests that the play method works correctly and outputs the appropriate messages
     * when the user inputs a number that is less than, greater than, or equal to the secret number.
     * It uses Mockito to mock the behavior of the Scanner class and returns predefined values
     * when its nextInt method is called. The logger object is also mocked, and its info method
     * is verified to have been called with the appropriate arguments.
     */
    @Test
    void testPlayPositive() throws Exception {
        var numberField = GuessNumber.class.getDeclaredField("number");
        numberField.setAccessible(true);
        var number = (int) numberField.get(guessNumber);

        when(scanner.nextInt()).thenReturn(number - 1, number + 1, number);
        guessNumber.play();
        verify(logger, times(1)).info(TOO_LOW);
        verify(logger, times(1)).info(TOO_HIGH);
        verify(logger, times(1)).info(CORRECT);
    }
}