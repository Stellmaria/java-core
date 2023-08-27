package com.it.academy.gk.sc0.operators.task5;

import com.it.academy.gk.sc0.operators.exception.InvalidMinuteException;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * A test class for the TimeSinceStartOfDay class.
 */
@SuppressFBWarnings("NP_NONNULL_RETURN_VIOLATION")
public class TimeSinceStartOfDayTest {
    /**
     * The TimeSinceStartOfDay instance to be tested.
     */
    private TimeSinceStartOfDay timeSinceStartOfDay;

    /**
     * Provides a stream of valid minutes and hours for testing purposes.
     *
     * @return a stream of valid minutes and hours as arguments
     */
    public static @NotNull Stream<Arguments> validMinutesAndHoursProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(59, 0),
                Arguments.of(60, 1),
                Arguments.of(119, 1),
                Arguments.of(1440 - 1, 23)
        );
    }

    /**
     * Provides a stream of valid minutes and minutes since last hour for testing purposes.
     *
     * @return a stream of valid minutes and minutes since last hour as arguments
     */
    public static @NotNull Stream<Arguments> validMinutesAndMinutesSinceLastHourProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(59, 59),
                Arguments.of(60, 0),
                Arguments.of(119, 59),
                Arguments.of(1440 - 1, 59)
        );
    }

    /**
     * Provides a stream of valid hours, minutes, and total minutes for testing purposes.
     *
     * @return a stream of valid hours, minutes, and total minutes as arguments
     */
    public static @NotNull Stream<Arguments> validHoursAndMinutesAndTotalMinutesProvider() {
        return Stream.of(
                Arguments.of(0, 0, 0),
                Arguments.of(0, 59, 59),
                Arguments.of(1, 0, 60),
                Arguments.of(1, 59, 119),
                Arguments.of(23, 59, 1440 - 1)
        );
    }

    /**
     * Provides a stream of invalid minutes for testing purposes.
     *
     * @return a stream of invalid minutes as arguments
     */
    public static @NotNull Stream<Arguments> invalidMinutesProvider() {
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(-59),
                Arguments.of(1440),
                Arguments.of(1500)
        );
    }

    /**
     * Provides a stream of invalid hours and minutes for testing purposes.
     *
     * @return a stream of invalid hours and minutes as arguments
     */
    public static @NotNull Stream<Arguments> invalidHoursAndMinutesProvider() {
        return Stream.of(
                Arguments.of(0, -1),
                Arguments.of(-1, -1));
    }

    /**
     * Sets up the TimeSinceStartOfDay instance before each test.
     */
    @BeforeEach
    public void setUp() {
        timeSinceStartOfDay = new TimeSinceStartOfDay();
    }

    /**
     * Tests the calculateHours method with positive test cases.
     *
     * @param inputMinutes the input minutes
     * @param expected     the expected result
     */
    @DisplayName("Positive Test Cases for calculateHours")
    @ParameterizedTest(name = "calculateHours with {0} minutes should return {1} hours")
    @MethodSource("validMinutesAndHoursProvider")
    void testCalculateHours_PositiveCases(final int inputMinutes, final int expected) throws InvalidMinuteException {
        var actual = timeSinceStartOfDay.calculateHours(inputMinutes);

        assertEquals(expected, actual);
    }

    /**
     * Tests the calculateMinutesSinceLastHour method with positive test cases.
     *
     * @param inputMinutes the input minutes
     * @param expected     the expected result
     */
    @DisplayName("Positive Test Cases for calculateMinutesSinceLastHour")
    @ParameterizedTest(name = "calculateMinutesSinceLastHour with {0} minutes should return {1} minutes")
    @MethodSource("validMinutesAndMinutesSinceLastHourProvider")
    void testCalculateMinutesSinceLastHour_PositiveCases(final int inputMinutes,
                                                         final int expected) throws InvalidMinuteException {
        var actual = timeSinceStartOfDay.calculateMinutesSinceLastHour(inputMinutes);

        assertEquals(expected, actual);
    }

    /**
     * Tests the calculateTotalMinutes method with positive test cases.
     *
     * @param inputHours   the input hours
     * @param inputMinutes the input minutes
     * @param expected     the expected result
     */
    @DisplayName("Positive Test Cases for calculateTotalMinutes")
    @ParameterizedTest(name = "calculateTotalMinutes with {0} hours and {1} minutes should return {2} total minutes")
    @MethodSource("validHoursAndMinutesAndTotalMinutesProvider")
    void testCalculateTotalMinutes_PositiveCases(final int inputHours, final int inputMinutes,
                                                 final int expected) throws InvalidMinuteException {
        var actual = timeSinceStartOfDay.calculateTotalMinutes(inputHours, inputMinutes);

        assertEquals(expected, actual);
    }

    /**
     * Tests the validateMinutes method in calculateHours with negative test cases.
     *
     * @param invalidMinutes an invalid minute value
     */
    @DisplayName("Negative Test Cases for validateMinutes in calculateHours")
    @ParameterizedTest(name = "Invalid input {0} minutes should throw InvalidMinuteException")
    @MethodSource("invalidMinutesProvider")
    void testValidateMinutesInCalculateHours_NegativeCases(final int invalidMinutes) {
        assertThrows(InvalidMinuteException.class, () -> timeSinceStartOfDay.calculateHours(invalidMinutes));
    }

    /**
     * Tests the validateMinutes method in calculateMinutesSinceLastHour with negative test cases.
     *
     * @param invalidMinutes an invalid minute value
     */
    @DisplayName("Negative Test Cases for validateMinutes in calculateMinutesSinceLastHour")
    @ParameterizedTest(name = "Invalid input {0} minutes should throw InvalidMinuteException")
    @MethodSource("invalidMinutesProvider")
    void testValidateMinutesInCalculateMinutesSinceLastHour_NegativeCases(final int invalidMinutes) {
        assertThrows(
                InvalidMinuteException.class,
                () -> timeSinceStartOfDay.calculateMinutesSinceLastHour(invalidMinutes)
        );
    }

    /**
     * Tests the validateMinutes method in calculateMinutesSinceLastHour with negative test cases.
     *
     * @param invalidMinutes an invalid minute value
     */
    @DisplayName("Negative Test Cases for calculateTotalMinutes")
    @ParameterizedTest(name = "Invalid input {0} hours and {1} minutes should throw InvalidMinuteException")
    @MethodSource("invalidHoursAndMinutesProvider")
    void testCalculateTotalMinutes_NegativeCases(final int invalidHours, final int invalidMinutes) {
        assertThrows(
                InvalidMinuteException.class,
                () -> timeSinceStartOfDay.calculateTotalMinutes(invalidHours, invalidMinutes)
        );
    }
}
