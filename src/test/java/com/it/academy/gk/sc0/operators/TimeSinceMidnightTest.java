package com.it.academy.gk.sc0.operators;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for the TimeSinceMidnight class.
 */
class TimeSinceMidnightTest {
    private TimeSinceMidnight timeSinceMidnight;

    /**
     * Provides test data for the testHoursSinceMidnight method.
     *
     * @return A stream of test data, where each element is an array containing the input values and
     * expected result for a test case.
     */
    @SuppressFBWarnings("NP_NONNULL_RETURN_VIOLATION")
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
     * Initializes the TimeSinceMidnight object before each test case.
     */
    @BeforeEach
    void setUp() {
        timeSinceMidnight = new TimeSinceMidnight();
    }

    /**
     * Tests the hoursSinceMidnight method in the TimeSinceMidnight class with positive and negative cases.
     *
     * @param minutes  The number of minutes that have passed since midnight.
     * @param expected The expected number of hours that have passed since midnight.
     */
    @ParameterizedTest(name = "Test case {index}: {0} minutes since midnight is {1} hours since midnight")
    @MethodSource("testCases")
    @DisplayName("Test hoursSinceMidnight method with positive and negative cases")
    void testHoursSinceMidnight(int minutes, int expected) {
        assertEquals(expected, timeSinceMidnight.hoursSinceMidnight(minutes));
    }
}
