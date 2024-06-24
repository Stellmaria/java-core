package com.it.academy.gk.sc0.statements;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

///**
// * This is a test class for the GuessNumber class.
// * It contains several test methods that test various aspects of the GuessNumber class.
// */
//@DisplayName("Guess Number Test")
//@ExtendWith(MockitoExtension.class)
//class GuessNumberTest {
//    /**
//     * This is a private static field that holds the value of the TOO_LOW constant from the GuessNumber class.
//     */
//    private static String TOO_LOW;
//
//    /**
//     * This is a private static field that holds the value of the TOO_HIGH constant from the GuessNumber class.
//     */
//    private static String TOO_HIGH;
//
//    /**
//     * This is a private static field that holds the value of the CORRECT constant from the GuessNumber class.
//     */
//    private static String CORRECT;
//
//    /**
//     * The secret number that the user is trying to guess.
//     */
//    private int number;
//
//    /**
//     * The generateRandomNumber method of the GuessNumber class, accessed using reflection.
//     */
//    private Method generateRandomNumberMethod;
//
//    /**
//     * This is a private field that holds an instance of the GuessNumber class.
//     */
//    private GuessNumber guessNumber;
//
//    /**
//     * This is a private field that holds an instance of the Scanner class.
//     */
//    @Mock
//    private Scanner scanner;
//
//    /**
//     * This is a private field that holds an instance of the Logger class.
//     */
//    @Mock
//    private Logger logger;
//
//    /**
//     * This method sets up constants before all tests are run.
//     * It uses reflection to access the private fields of the GuessNumber class and assigns their values
//     * to the corresponding fields in this test class.
//     */
//    @SneakyThrows
//    @BeforeAll
//    public static void setUpConstants() {
//        var tooLowField = GuessNumber.class.getDeclaredField("TOO_LOW");
//        tooLowField.setAccessible(true);
//        TOO_LOW = (String) tooLowField.get(null);
//
//        var tooHighField = GuessNumber.class.getDeclaredField("TOO_HIGH");
//        tooHighField.setAccessible(true);
//        TOO_HIGH = (String) tooHighField.get(null);
//
//        var correctField = GuessNumber.class.getDeclaredField("CORRECT");
//        correctField.setAccessible(true);
//        CORRECT = (String) correctField.get(null);
//    }
//
//    /**
//     * This method sets up the test environment before each test is run.
//     * It creates mock objects for the Scanner and Logger classes
//     * and initializes a new instance of the GuessNumber class with these mock objects.
//     */
//    @SneakyThrows
//    @BeforeEach
//    public void setUp() {
//        guessNumber = new GuessNumber(1, 10, scanner, logger);
//
//        var numberField = GuessNumber.class.getDeclaredField("number");
//        numberField.setAccessible(true);
//        number = (int) numberField.get(guessNumber);
//
//        generateRandomNumberMethod =
//                GuessNumber.class.getDeclaredMethod("generateRandomNumber", int.class, int.class);
//        generateRandomNumberMethod.setAccessible(true);
//    }
//
//    /**
//     * This test method tests that the generateRandomNumber method returns a number within the specified range.
//     * It uses reflection to access the private generateRandomNumber method of the GuessNumber class
//     * and invokes it with a specified range. The returned value is then checked to be within the specified range.
//     */
//    @SneakyThrows
//    @Test
//    void testGenerateRandomNumberReturnsNumberWithinRange() {
//        int min = 1;
//        int max = 10;
//
//        int randomNumber = (int) generateRandomNumberMethod.invoke(guessNumber, min, max);
//
//        assertTrue(randomNumber >= min && randomNumber <= max);
//    }
//
//    /**
//     * This test method tests that the generateRandomNumber method returns different numbers on subsequent calls.
//     * It uses reflection to access the private generateRandomNumber method of the GuessNumber class
//     * and invokes it twice with the same range. The returned values are then checked to be different from each other.
//     */
//    @SneakyThrows
//    @Test
//    void testGenerateRandomNumberReturnsDifferentNumbersOnSubsequentCalls() {
//        int min = 1;
//        int max = 10;
//
//        int randomNumber = (int) generateRandomNumberMethod.invoke(guessNumber, min, max);
//        int randomNumber2 = (int) generateRandomNumberMethod.invoke(guessNumber, min, max);
//
//        assertNotEquals(randomNumber, randomNumber2);
//    }
//
//    /**
//     * This test method tests that the generateRandomNumber method returns a number within a new specified range.
//     * It uses reflection to access the private generateRandomNumber method of the GuessNumber class
//     * and invokes it with a new specified range.
//     * The returned value is then checked to be within the new specified range.
//     */
//    @SneakyThrows
//    @Test
//    void testGenerateRandomNumberReturnsNumberWithinNewRange() {
//        int newMin = 5;
//        int newMax = 15;
//
//        int newRandomNumber = (int) generateRandomNumberMethod.invoke(guessNumber, newMin, newMax);
//
//        assertTrue(newRandomNumber >= newMin && newRandomNumber <= newMax);
//    }
//
//    /**
//     * This test method tests that the play method works correctly and outputs the appropriate messages
//     * when the user inputs a number that is less than, greater than, or equal to the secret number.
//     * It uses Mockito to mock the behavior of the Scanner class and returns predefined values when
//     * its nextInt method is called. The logger object is also mocked, and its info method
//     * is verified to have been called with the appropriate arguments.
//     */
//    @Test
//    void testPlay() {
//        when(scanner.nextInt()).thenReturn(number - 1, number + 1, number);
//
//        guessNumber.play();
//
//        verify(logger, times(1)).log(Level.INFO, TOO_LOW);
//        verify(logger, times(1)).log(Level.INFO, TOO_HIGH);
//        verify(logger, times(1)).log(Level.INFO, CORRECT);
//    }
//
//    /**
//     * This test method tests that the play method works correctly and outputs the appropriate messages
//     * when the user inputs a number that is less than, greater than, or equal to the secret number.
//     * It uses Mockito to mock the behavior of the Scanner class and returns predefined values
//     * when its nextInt method is called. The logger object is also mocked, and its info method
//     * is verified to have been called with the appropriate arguments.
//     */
//    @Test
//    void testPlayNegative() {
//        when(scanner.nextInt()).thenReturn(number - 1, number + 1, number + 2, number);
//
//        guessNumber.play();
//
//        verify(logger, times(1)).log(Level.INFO, TOO_LOW);
//        verify(logger, times(2)).log(Level.INFO, TOO_HIGH);
//        verify(logger, times(1)).log(Level.INFO, CORRECT);
//    }
//
//    /**
//     * This test method tests that the play method works correctly and outputs the appropriate messages
//     * when the user inputs a number that is less than, greater than, or equal to the secret number.
//     * It uses Mockito to mock the behavior of the Scanner class and returns predefined values
//     * when its nextInt method is called. The logger object is also mocked, and its info method
//     * is verified to have been called with the appropriate arguments.
//     */
//    @Test
//    void testPlayPositive() {
//        when(scanner.nextInt()).thenReturn(number - 1, number + 1, number);
//
//        guessNumber.play();
//
//        verify(logger, times(1)).log(Level.INFO, TOO_LOW);
//        verify(logger, times(1)).log(Level.INFO, TOO_HIGH);
//        verify(logger, times(1)).log(Level.INFO, CORRECT);
//    }
//}