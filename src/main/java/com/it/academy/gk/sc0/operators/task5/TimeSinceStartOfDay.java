package com.it.academy.gk.sc0.operators.task5;

import com.it.academy.gk.sc0.operators.exception.InvalidMinuteException;

/**
 * The TimeSinceStartOfDay class provides methods to calculate the number of hours and minutes since the start of the day.
 */
public class TimeSinceStartOfDay {
    /**
     * The number of minutes in an hour.
     */
    private static final int MINUTES_IN_HOUR = 60;
    /**
     * The number of hours in a day.
     */
    private static final int HOURS_IN_DAY = 24;
    /**
     * The error message used when an invalid number of minutes is encountered.
     */
    private static final String INVALID_MINUTES_MESSAGE = "The number of minutes should be between 0 and the total minutes in a day.";
    /**
     * The string used to indicate that a value was received.
     */
    private static final String RECEIVED = "Received:";
    /**
     * A space character.
     */
    private static final String SPACE = " ";

    /**
     * Calculates the number of hours since the start of the day given the number of minutes since the start of the day.
     *
     * @param m the number of minutes since the start of the day
     * @return the number of hours since the start of the day
     * @throws InvalidMinuteException if the given number of minutes is not between 0 and the total minutes in a day
     */
    public int calculateHours(final int m) throws InvalidMinuteException {
        validateMinutes(m);

        return m / MINUTES_IN_HOUR;
    }

    /**
     * Calculates the number of minutes since the last hour given the number of minutes since the start of the day.
     *
     * @param m the number of minutes since the start of the day
     * @return the number of minutes since the last hour
     * @throws InvalidMinuteException if the given number of minutes is not between 0 and the total minutes in a day
     */
    public int calculateMinutesSinceLastHour(final int m) throws InvalidMinuteException {
        validateMinutes(m);

        return m % MINUTES_IN_HOUR;
    }

    /**
     * Calculates the total number of minutes since the start of the day given the number of hours and minutes since the start of the day.
     *
     * @param h the number of hours since the start of the day
     * @param m the number of minutes since the last hour
     * @return the total number of minutes since the start of the day
     * @throws InvalidMinuteException if the given number of minutes is not between 0 and the total minutes in a day
     */
    public int calculateTotalMinutes(final int h, final int m) throws InvalidMinuteException {
        validateMinutes(m);

        return h * MINUTES_IN_HOUR + m;
    }

    /**
     * Validates the given number of minutes to ensure that it is between 0 and the total minutes in a day.
     *
     * @param m the number of minutes to be validated
     * @throws InvalidMinuteException if the given number of minutes is not between 0 and the total minutes in a day
     */
    private void validateMinutes(final int m) throws InvalidMinuteException {
        if (m < 0 || m >= MINUTES_IN_HOUR * HOURS_IN_DAY) {
            throw new InvalidMinuteException(INVALID_MINUTES_MESSAGE + SPACE + RECEIVED + SPACE + m);
        }
    }
}
