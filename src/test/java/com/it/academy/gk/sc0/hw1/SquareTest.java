package com.it.academy.gk.sc0.hw1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("Square Test")
@ExtendWith(MockitoExtension.class)
class SquareTest {
    private InputStream originalIn;

    @Mock
    private Logger logger;

    @BeforeEach
    void setUp() {
        originalIn = System.in;
        when(logger.isLoggable(Level.INFO)).thenReturn(true);
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn);
    }

    @Test
    @DisplayName("Calculate area and perimeter for valid input")
    void calculateSquare() {
        System.setIn(new ByteArrayInputStream("5\n".getBytes(StandardCharsets.UTF_8)));

        new Square(logger).calculateSquare();

        verify(logger).info("Enter the length of one side of the square: ");
        verify(logger).info("The area of the square is: 25.00");
        verify(logger).info("The perimeter of the square is: 20.00");
    }

    @Test
    @DisplayName("Retry after non-numeric and non-positive input")
    void retryInvalidInput() {
        System.setIn(new ByteArrayInputStream("invalid\n-2\n5\n".getBytes(StandardCharsets.UTF_8)));

        new Square(logger).calculateSquare();

        verify(logger, times(3)).info("Enter the length of one side of the square: ");
        verify(logger, times(2)).warning("Invalid input. Please enter a positive number.");
        verify(logger).info("The area of the square is: 25.00");
        verify(logger).info("The perimeter of the square is: 20.00");
    }
}
