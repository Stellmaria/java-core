package com.it.academy.gk.sc0.operators;

/**
 * The TimeSinceMidnight class provides a method to calculate the number of hours that have passed since midnight,
 * given the number of minutes that have passed since midnight.
 */
public class TimeSinceMidnight {
    /**
     * The number of minutes in an hour.
     */
    private static final int MINUTES_PER_HOUR = 60;

    /**
     * Task 5.
     * N minutes have passed since the beginning of the day.
     * Define: an integer number of hours that have passed since the beginning of the day.
     * <p>
     * Calculates the number of hours that have passed since midnight, given the number of minutes that have passed
     * since midnight. This method takes an integer parameter `minutes`, which represents the number of minutes that
     * have passed since midnight. The method then divides this number by the constant `MINUTES_PER_HOUR`, which is
     * defined as 60, to calculate the number of hours that have passed since midnight. The result is then returned as
     * an integer value.
     * <p>
     * For example, if the method is called with an input of 120 minutes, it will divide 120 by 60 to calculate that
     * 2 hours have passed since midnight. Similarly, if the method is called with an input of 59 minutes, it will
     * divide 59 by 60 to calculate that 0 hours have passed since midnight.
     *
     * @param minutes The number of minutes that have passed since midnight.
     * @return The number of hours that have passed since midnight.
     */
    public int hoursSinceMidnight(int minutes) {
        return minutes / MINUTES_PER_HOUR;
    }
}
