package com.it.academy.gk.sc0.operators;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The TimeSinceMidnightTest class is a test class for the TimeSinceMidnight class.
 */
@DisplayName("Time Since Midnight Test")
class TimeSinceMidnightTest {
    /**
     * This is a private field of the TimeSinceMidnightTest class that holds an instance of the TimeSinceMidnight class.
     * It is used in the test methods of the TimeSinceMidnightTest class
     * to call the methods of the TimeSinceMidnight class and test their functionality.
     */
    private TimeSinceMidnight timeSinceMidnight;

    /**
     * Provides a stream of test data for the testHoursSinceMidnight method.
     *
     * @return a stream of test data for the testHoursSinceMidnight method.
     */
    @SuppressFBWarnings("NP_NONNULL_RETURN_VIOLATION")
    @Contract(pure = true)
    static @NotNull Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(59, 0),
                Arguments.of(60, 1),
                Arguments.of(119, 1),
                Arguments.of(120, 2),
                Arguments.of(-1, 0)
        );
    }

    /**
     * Sets up the test environment before each test.
     * <p/>
     * This method creates a new instance of the TimeSinceMidnight class and assigns it to the timeSinceMidnight field.
     */
    @SuppressFBWarnings("NP_NONNULL_RETURN_VIOLATION")
    @BeforeEach
    void setUp() {
        timeSinceMidnight = new TimeSinceMidnight();
    }

    /**
     * Tests the hoursSinceMidnight method of the TimeSinceMidnight class with positive and negative cases.
     *
     * @param minutes       an integer representing a number of minutes since midnight.
     * @param expectedHours an integer representing the expected output number of hours since midnight.
     */
    @ParameterizedTest(name = "Test case {index}: {0} minutes since midnight is {1} hours since midnight")
    @MethodSource("testCases")
    @DisplayName("Test hoursSinceMidnight method with positive and negative cases")
    void testHoursSinceMidnight(final int minutes, final int expectedHours) {
        int actual = timeSinceMidnight.hoursSinceMidnight(minutes);

        assertEquals(expectedHours, actual);
    }
}
