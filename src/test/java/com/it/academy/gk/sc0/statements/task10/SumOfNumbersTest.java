package com.it.academy.gk.sc0.statements.task10;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class SumOfNumbersTest {
    @Mock
    private Scanner scanner;

    private static final Logger logger = LoggerFactory.getLogger(SumOfNumbersTest.class);

    private SumOfNumbers sumOfNumbers;

    @BeforeEach
    public void setUp() {
        sumOfNumbers = new SumOfNumbers();

        var mocks = MockitoAnnotations.openMocks(this);

        try {
            sumOfNumbers = new SumOfNumbers();
        } finally {
            try {
                mocks.close();
            } catch (Exception e) {
                logger.error(e, () -> "An error occurred while closing mocks");
            }
        }
    }

    @Test
    void calculateSum() {
        when(scanner.nextInt()).thenReturn(1, 2, 3, 0);

        var result = sumOfNumbers.calculateSum(scanner);

        assertEquals("1,2,3,Sum: 6", result);
    }
}
