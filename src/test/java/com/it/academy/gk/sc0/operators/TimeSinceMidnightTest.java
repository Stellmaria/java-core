package com.it.academy.gk.sc0.operators;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The TimeSinceMidnightTest class is a test class for the TimeSinceMidnight class.
 * <p>
 * This class contains several methods to test the functionality of the TimeSinceMidnight class,
 * including methods to provide test data and methods to test the hoursSinceMidnight method
 * of the TimeSinceMidnight class.
 */
class TimeSinceMidnightTest {
    /**
     * This is a private field of the TimeSinceMidnightTest class that holds an instance
     * of the TimeSinceMidnight class.
     * It is used in the test methods of the TimeSinceMidnightTest class to call the methods
     * of the TimeSinceMidnight class and test their functionality.
     */
    private TimeSinceMidnight timeSinceMidnight;

    /**
     * Provides a stream of test data for the testHoursSinceMidnight method.
     * <p>
     * This method returns a stream of arrays, where each array represents a test case with
     * an input number of minutes since midnight and an expected output number of hours since midnight.
     *
     * @return a stream of test data for the testHoursSinceMidnight method
     */
    @Contract(pure = true)
    static @NotNull Stream<Object[]> testCases() {
        return Stream.of(
                new Object[]{0, 0},
                new Object[]{59, 0},
                new Object[]{60, 1},
                new Object[]{119, 1},
                new Object[]{120, 2},
                new Object[]{-1, 0}
        );
    }

    /**
     * Sets up the test environment before each test.
     * <p>
     * This method creates a new instance of the TimeSinceMidnight class and assigns it to the timeSinceMidnight field.
     */
    @BeforeEach
    void setUp() {
        timeSinceMidnight = new TimeSinceMidnight();
    }

    /**
     * Tests the hoursSinceMidnight method of the TimeSinceMidnight class with positive and negative cases.
     * <p>
     * This method takes an integer representing a number of minutes since midnight and an integer representing
     * the expected output number of hours since midnight as arguments.
     * It calls the hoursSinceMidnight method of the TimeSinceMidnight class with
     * the provided number of minutes since midnight
     * and asserts that the result is equal to the expected output number of hours since midnight.
     *
     * @param minutes       an integer representing a number of minutes since midnight
     * @param expectedHours an integer representing the expected output number of hours since midnight
     */
    @ParameterizedTest(name = "Test case {index}: {0} minutes since midnight is {1} hours since midnight")
    @MethodSource("testCases")
    @DisplayName("Test hoursSinceMidnight method with positive and negative cases")
    void testHoursSinceMidnight(int minutes, int expectedHours) {
        var actual = timeSinceMidnight.hoursSinceMidnight(minutes);

        assertEquals(expectedHours, actual);
    }
}
