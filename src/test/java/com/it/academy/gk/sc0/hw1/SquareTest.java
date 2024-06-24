package com.it.academy.gk.sc0.hw1;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import static java.text.MessageFormat.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

///**
// * This class contains tests for the Square class.
// * It uses the JUnit 5 testing framework to define and run the tests.
// */
//@SuppressFBWarnings("DM_DEFAULT_ENCODING")
//@DisplayName("Square Test")
//@ExtendWith(MockitoExtension.class)
//class SquareTest {
//    /**
//     * The value of the private static field PROMPT_MESSAGE in the Square class.
//     */
//    private static String PROMPT_MESSAGE;
//    /**
//     * The value of the private static field AREA_MESSAGE in the Square class.
//     */
//    private static String AREA_MESSAGE;
//    /**
//     * The value of the private static field PERIMETER_MESSAGE in the Square class.
//     */
//    private static String PERIMETER_MESSAGE;
//    /**
//     * The value of the private static field INVALID_INPUT_MESSAGE in the Square class.
//     */
//    private static String INVALID_INPUT_MESSAGE;
//    /**
//     * A mock instance of the Logger class used for testing.
//     */
//    @Mock
//    private Logger LOGGER;
//    /**
//     * An instance of the Square class used for testing.
//     */
//    private Square SQUARE;
//    /**
//     * An instance of the ByteArrayOutputStream class used to capture the output of the System.out stream.
//     */
//    private ByteArrayOutputStream OUT;
//
//    /**
//     * Sets up the test class by creating mock instances of the Logger class,
//     * setting up the System.in and System.out streams,
//     * and using reflection to access the private static fields in the Square class
//     * and storing their values in the corresponding fields in this test class.
//     */
//    @SneakyThrows
//    @BeforeAll
//    static void setUp() {
//        var promptMessageField = Square.class.getDeclaredField("PROMPT_MESSAGE");
//        promptMessageField.setAccessible(true);
//        PROMPT_MESSAGE = (String) promptMessageField.get(null);
//
//        var areaMessageField = Square.class.getDeclaredField("AREA_MESSAGE");
//        areaMessageField.setAccessible(true);
//        AREA_MESSAGE = (String) areaMessageField.get(null);
//
//        var perimeterMessageField = Square.class.getDeclaredField("PERIMETER_MESSAGE");
//        perimeterMessageField.setAccessible(true);
//        PERIMETER_MESSAGE = (String) perimeterMessageField.get(null);
//
//        var invalidInputMessageField = Square.class.getDeclaredField("INVALID_INPUT_MESSAGE");
//        invalidInputMessageField.setAccessible(true);
//        INVALID_INPUT_MESSAGE = (String) invalidInputMessageField.get(null);
//    }
//
//    /**
//     * Sets up each test by creating a new instance of the Square class.
//     */
//    @BeforeEach
//    void beforeEach() {
//        OUT = new ByteArrayOutputStream();
//
//        System.setIn(new ByteArrayInputStream("5\n".getBytes(StandardCharsets.UTF_8)));
//        System.setOut(new PrintStream(OUT, true, StandardCharsets.UTF_8));
//
//        SQUARE = new Square(LOGGER);
//    }
//
//    /**
//     * Tests the calculateSquare method in the Square class
//     * by mocking the behavior of the Logger class and capturing the output of the System.out stream.
//     */
//    @Test
//    @DisplayName("Test calculateSquare method")
//    void testCalculateSquare() {
//        when(LOGGER.isLoggable(any())).thenReturn(true);
//        doAnswer(invocation -> {
//            Object[] args = invocation.getArguments();
//            OUT.write(args[0].toString().getBytes(StandardCharsets.UTF_8));
//            OUT.write('\n');
//            return null;
//        }).when(LOGGER).info(anyString());
//
//        SQUARE.calculateSquare();
//        String expectedOutput = format(
//                "{0}\n{1}\n{2}\n", PROMPT_MESSAGE, String.format(AREA_MESSAGE, 25.0),
//                String.format(PERIMETER_MESSAGE, 20.0)
//        );
//
//        assertEquals(expectedOutput, OUT.toString());
//    }
//
//    /**
//     * Tests the calculateSquare method in the Square class by mocking the behavior of the Logger class
//     * and capturing the output of the System.out stream with invalid input followed by valid input.
//     */
//    @Test
//    @DisplayName("Test calculateSquare method with invalid input followed by valid input")
//    void testCalculateSquareInvalidInputFollowedByValidInput() {
//        when(LOGGER.isLoggable(any())).thenReturn(true);
//        doAnswer(invocation -> {
//            Object[] args = invocation.getArguments();
//            OUT.write(args[0].toString().getBytes(StandardCharsets.UTF_8));
//            OUT.write('\n');
//            return null;
//        }).when(LOGGER).info(anyString());
//
//        doAnswer(invocation -> {
//            Object[] args = invocation.getArguments();
//            OUT.write(args[0].toString().getBytes(StandardCharsets.UTF_8));
//            OUT.write('\n');
//            return null;
//        }).when(LOGGER).warning(anyString());
//
//        System.setIn(new ByteArrayInputStream("invalid\n5\n".getBytes()));
//        SQUARE.calculateSquare();
//        var expectedOutput = format(
//                "{0}\n{1}\n{2}\n{3}\n{4}\n", PROMPT_MESSAGE, INVALID_INPUT_MESSAGE, PROMPT_MESSAGE,
//                String.format(AREA_MESSAGE, 25.0), String.format(PERIMETER_MESSAGE, 20.0)
//        );
//
//        assertEquals(expectedOutput, OUT.toString());
//    }
//
//    /**
//     * Tests the calculateSquare method in the Square class by mocking the behavior of the Logger class
//     * and capturing the output of the System.out stream with valid input.
//     */
//    @Test
//    @DisplayName("Test calculateSquare method with valid input")
//    void testCalculateSquareValidInput() {
//        when(LOGGER.isLoggable(any())).thenReturn(true);
//        doAnswer(invocation -> {
//            Object[] args = invocation.getArguments();
//            OUT.write(args[0].toString().getBytes(StandardCharsets.UTF_8));
//            OUT.write('\n');
//            return null;
//        }).when(LOGGER).info(anyString());
//
//        System.setIn(new ByteArrayInputStream("5\n".getBytes()));
//        SQUARE.calculateSquare();
//        var expectedOutput = format(
//                "{0}\n{1}\n{2}\n", PROMPT_MESSAGE, String.format(AREA_MESSAGE, 25.0),
//                String.format(PERIMETER_MESSAGE, 20.0)
//        );
//
//        assertEquals(expectedOutput, OUT.toString());
//    }
//}
