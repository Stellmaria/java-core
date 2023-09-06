package com.it.academy.gk.sc0.operators.task5;

import com.it.academy.gk.sc0.operators.exception.InvalidMinuteException;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

/**
 * TimeSinceStartOfDay is a utility class
 * that provides methods for calculating hours and minutes since the start of the day based on the given minutes.
 *
 * <p>Example usage:</p>
 * <pre>
 *     int hours = TimeSinceStartOfDay.calculateHours(130);  // hours will be 2
 *     int minutes = TimeSinceStartOfDay.calculateMinutesSinceLastHour(130);  // minutes will be 10
 *     int totalMinutes = TimeSinceStartOfDay.calculateTotalMinutes(2, 10);  // totalMinutes will be 130
 * </pre>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
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
     * Calculates the number of hours since the start of the day based on the given minutes.
     *
     * @param m the minutes since the start of the day. Must be between zero and the total minutes in a day.
     * @return the number of hours.
     */
    @SneakyThrows
    public static int calculateHours(final int m) {
        validateMinutes(m);

        return m / MINUTES_IN_HOUR;
    }

    /**
     * Calculates the minutes since the last full hour based on the given minutes.
     *
     * @param m the minutes since the start of the day. Must be between zero and the total minutes in a day.
     * @return the minutes since the last full hour.
     */
    @SneakyThrows
    public static int calculateMinutesSinceLastHour(final int m) {
        validateMinutes(m);

        return m % MINUTES_IN_HOUR;
    }

    /**
     * Calculates the total number of minutes since the start of the day based on the given hours and minutes.
     *
     * @param h the hours since the start of the day.
     * @param m the minutes since the last full hour. Must be between 0 and 59.
     * @return the total number of minutes since the start of the day.
     */
    @SneakyThrows
    public static int calculateTotalMinutes(final int h, final int m) {
        validateMinutes(m);

        return h * MINUTES_IN_HOUR + m;
    }

    /**
     * Validates the given number of minutes.
     *
     * @param m the number of minutes to validate.
     */
    @SneakyThrows
    private static void validateMinutes(final int m) {
        if (m < 0 || m >= MINUTES_IN_HOUR * HOURS_IN_DAY) {
            throw new InvalidMinuteException(INVALID_MINUTES_MESSAGE + SPACE + RECEIVED + SPACE + m);
        }
    }
}
