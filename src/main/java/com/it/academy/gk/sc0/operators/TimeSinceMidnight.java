package com.it.academy.gk.sc0.operators;

/**
 * Task 5.
 * N minutes have passed since the beginning of the day.
 * Define: an integer number of hours that have passed since the beginning of the day.
 */
public class TimeSinceMidnight {
    /**
     * The number of minutes in an hour.
     */
    private static final int MINUTES_PER_HOUR = 60;

    /**
     * Calculates the number of hours since midnight given the number of minutes since midnight.
     * <p>
     * This method takes an integer representing the number of minutes since midnight as an argument
     * and returns the number of hours since midnight.
     * The result is calculated by dividing the number of minutes
     * by the number of minutes per hour (60).
     *
     * @param minutes an integer representing the number of minutes since midnight
     * @return the number of hours since midnight
     */
    public int hoursSinceMidnight(final int minutes) {
        return minutes / MINUTES_PER_HOUR;
    }
}
