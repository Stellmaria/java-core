package com.it.academy.gk.sc0.hw1;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.logging.Logger;

import static java.text.MessageFormat.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * This class contains tests for the Square class. It uses the JUnit 5 testing framework to define and run the tests.
 */
class SquareTest {
    /**
     * Tests the calculateSquare method of the Square class.
     * <p>
     * This test uses reflection to access private fields of the Square class
     * and mock objects to simulate user input and output. It sets up a mock logger object to capture
     * log messages and verifies that the calculateSquare method produces the expected output
     * when given a specific user input.
     *
     * @throws NoSuchFieldException   if a field with the specified name is not found
     * @throws IllegalAccessException if access to the specified field is denied
     */
    @Test
    void testCalculateSquare() throws NoSuchFieldException, IllegalAccessException {
        var in = new ByteArrayInputStream("5\n".getBytes());
        var out = new ByteArrayOutputStream();
        System.setIn(in);
        System.setOut(new PrintStream(out));
        var logger = mock(Logger.class);
        var promptMessageField = Square.class.getDeclaredField("PROMPT_MESSAGE");
        promptMessageField.setAccessible(true);
        var promptMessage = (String) promptMessageField.get(null);
        var areaMessageField = Square.class.getDeclaredField("AREA_MESSAGE");
        areaMessageField.setAccessible(true);
        var areaMessage = (String) areaMessageField.get(null);
        var perimeterMessageField = Square.class.getDeclaredField("PERIMETER_MESSAGE");
        perimeterMessageField.setAccessible(true);
        var perimeterMessage = (String) perimeterMessageField.get(null);
        when(logger.isLoggable(any())).thenReturn(true);
        doAnswer(invocation -> {
            Object[] args = invocation.getArguments();
            out.write(args[0].toString().getBytes());
            out.write('\n');
            return null;
        }).when(logger).info(anyString());

        var square = new Square(logger);
        square.calculateSquare();

        var expectedOutput = format("{0}\n{1}\n{2}\n", promptMessage, String.format(areaMessage, 25.0), String.format(perimeterMessage, 20.0));
        assertEquals(expectedOutput, out.toString());
    }
}
