package com.it.academy.gk.sc0.operators.task5;

import com.it.academy.gk.sc0.operators.task5.exception.InvalidMinuteException;
import lombok.experimental.UtilityClass;

/**
 * Utility class for calculating time since the start of the day.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public final class TimeSinceStartOfDay {
    /**
     * A constant for the number of minutes in an hour.
     */
    private static final int MINUTES_IN_HOUR = 60;

    /**
     * A constant for the number of hours in a day.
     */
    private static final int HOURS_IN_DAY = 24;

    /**
     * A constant holding the default message for invalid minutes.
     */
    private static final String INVALID_MINUTES_MESSAGE =
            "The number of minutes should be between 0 and the total minutes in a day.";

    /**
     * A constant for the prefix "Received:" in validation messages.
     */
    private static final String RECEIVED = "Received:";

    /**
     * A constant for space used in validation messages.
     */
    private static final String SPACE = " ";

    /**
     * Calculates the number of hours since the start of the day based on the total minutes.
     *
     * @param m The total number of minutes since the start of the day.
     * @return The number of hours since the start of the day.
     * @throws InvalidMinuteException If the provided minutes are not within
     *                                the valid range (0 to total minutes in a day).
     */
    public static int calculateHours(final int m) throws InvalidMinuteException {
        validateMinutes(m);

        return m / MINUTES_IN_HOUR;
    }

    /**
     * Calculates the number of minutes since the start of the last hour.
     *
     * @param m The total number of minutes since the start of the day.
     * @return The number of minutes since the start of the last hour.
     * @throws InvalidMinuteException If the provided minutes are not within
     *                                the valid range (0 to total minutes in a day).
     *                                This exception is thrown when the input minutes are less than 0 or
     *                                greater than or equal to the total minutes in a day.
     */
    public static int calculateMinutesSinceLastHour(final int m) throws InvalidMinuteException {
        validateMinutes(m);

        return m % MINUTES_IN_HOUR;
    }

    /**
     * Calculates the total number of minutes since the start of the day based on the given hours and minutes.
     *
     * @param h The number of hours since the start of the day.
     * @param m The number of minutes since the start of the hour.
     * @return The total number of minutes since the start of the day.
     * @throws InvalidMinuteException If the provided minutes are not within
     *                                the valid range (0 to total minutes in a day).
     */
    public static int calculateTotalMinutes(final int h, final int m) throws InvalidMinuteException {
        validateMinutes(m);

        return h * MINUTES_IN_HOUR + m;
    }

    /**
     * Validates the input minutes to ensure they are within the valid range.
     *
     * @param m The total number of minutes since the start of the day.
     * @throws InvalidMinuteException If the provided minutes are not within
     *                                the valid range (0 to total minutes in a day).
     *                                This exception is thrown when the input minutes are less than 0 or
     *                                greater than or equal to the total minutes in a day.
     */
    private static void validateMinutes(final int m) throws InvalidMinuteException {
        if (m < 0 || m >= MINUTES_IN_HOUR * HOURS_IN_DAY) {
            throw new InvalidMinuteException(INVALID_MINUTES_MESSAGE + SPACE + RECEIVED + SPACE + m);
        }
    }
}
