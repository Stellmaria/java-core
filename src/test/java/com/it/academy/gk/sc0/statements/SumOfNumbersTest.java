package com.it.academy.gk.sc0.statements;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

/**
 * This class contains unit tests for the SumOfNumbers class.
 */
class SumOfNumbersTest {
    /**
     * Logger used to log messages.
     */
    private static final Logger logger = LoggerFactory.getLogger(SumOfNumbersTest.class);
    /**
     * An instance of the SumOfNumbers class, used to test its methods.
     */
    private SumOfNumbers sumOfNumbers;
    /**
     * A mock object for the Scanner class, used to simulate user input.
     */
    @Mock
    private Scanner scanner;

    /**
     * This method provides test cases for the testCalculateSum method.
     * Each test case consists of two arguments: the input value n and the expected result.
     * The expected result is the sum of the first n positive integers that should
     * be returned by the calculateSum method.
     */
    private static @NotNull Stream<Arguments> calculateSumTestCases() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 3),
                Arguments.of(3, 6),
                Arguments.of(4, 10),
                Arguments.of(5, 15)
        );
    }

    /**
     * This method provides test cases for the printIntermediateSums method.
     * Each test case consists of a TestCase object that contains the input values and the expected result.
     * The expected result is a string representing the intermediate sums
     * that should be printed by the printIntermediateSums method.
     */
    static @NotNull Stream<TestCase> printIntermediateSumsTestCases() {
        return Stream.of(
                new TestCase(5, 10, "1,3,6,10"),
                new TestCase(5, 15, "1,3,6,10,15"),
                new TestCase(5, 5, "1,3"),
                new TestCase(0, 10, ""),
                new TestCase(-1, 10, ""),
                new TestCase(5, -1, ""),
                new TestCase(5, 0, "")
        );
    }

    /**
     * Sets up the test environment by initializing objects and resources needed for testing.
     * This includes mock objects and an instance of the class being tested.
     * It also includes error handling code to log any exceptions that may occur while closing mock objects.
     */
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

    /**
     * This method tests the calculateSum method of the SumOfNumbers class.
     * It takes two arguments: the input value n and the expected result.
     * The expected result is the sum of the first n positive integers that should be returned
     * by the calculateSum method. The method calls the calculateSum method
     * with the specified input value n and compares the result to the expected result.
     */
    @ParameterizedTest(name = "Test case #{index}: {arguments}")
    @DisplayName("Test calculateSum")
    @MethodSource("calculateSumTestCases")
    void testCalculateSum(int n, int expected) {
        var actual = sumOfNumbers.calculateSum(n);

        assertEquals(expected, actual);
    }

    /**
     * This method tests the printIntermediateSums method of the SumOfNumbers class.
     * It takes a single argument: a TestCase object that contains the input values and the expected result.
     * The expected result is a string representing the intermediate sums that should be printed
     * by the printIntermediateSums method. The method calls the printIntermediateSums method
     * with the specified input values and compares the result to the expected result.
     */
    @ParameterizedTest(name = "{index} => n={0}, limit={1}, expected={2}")
    @DisplayName("printIntermediateSums")
    @MethodSource("printIntermediateSumsTestCases")
    void printIntermediateSums(@NotNull TestCase testCase) {
        var result = sumOfNumbers.printIntermediateSums(testCase.n, testCase.limit);

        assertEquals(testCase.expectedResult, result);
    }

    /**
     * This method tests the calculateSum method of the SumOfNumbers class that takes a Scanner object as an argument.
     * It sets up the scanner mock to return a sequence of numbers followed by 0,
     * and calls the calculateSum method with the scanner mock.
     * Finally, it verifies that the result is equal to the expected result.
     */
    @Test
    void calculateSum() {
        when(scanner.nextInt()).thenReturn(1, 2, 3, 0);
        var result = sumOfNumbers.calculateSum(scanner);

        assertEquals("1,2,3,Sum: 6", result);
    }

    /**
     * A record class that represents a test case for the printIntermediateSums method.
     * It contains the input values and the expected result for a single test case.
     */
    private record TestCase(int n, int limit, String expectedResult) {
    }
}
