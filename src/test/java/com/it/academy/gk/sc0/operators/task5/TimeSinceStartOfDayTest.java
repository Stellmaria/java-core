package com.it.academy.gk.sc0.operators.task5;

import com.it.academy.gk.sc0.operators.exception.InvalidMinuteException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.it.academy.gk.sc0.operators.task5.TimeSinceStartOfDay.calculateHours;
import static com.it.academy.gk.sc0.operators.task5.TimeSinceStartOfDay.calculateMinutesSinceLastHour;
import static com.it.academy.gk.sc0.operators.task5.TimeSinceStartOfDay.calculateTotalMinutes;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * TimeSinceStartOfDayTest is a test class
 * that performs unit tests for methods related to the calculation of time since the start of the day.
 *
 * <p>This class uses JUnit 5 for unit testing and exception testing to validate the behavior of methods
 * for various time calculations.</p>
 *
 * @author Ansatsia Melnikova
 * @version 1.0
 * @since 2023-09-03
 */
public class TimeSinceStartOfDayTest {
    private static String INVALID_MINUTES_MESSAGE;
    private static String RECEIVED;
    private static String SPACE;

    /**
     * Setup method executed before all tests in the class to initialize the static fields.
     */
    @SneakyThrows
    @BeforeAll
    public static void beforeAll() {
        var invalidMinutesMessageField =
                TimeSinceStartOfDay.class.getDeclaredField("INVALID_MINUTES_MESSAGE");
        invalidMinutesMessageField.setAccessible(true);
        INVALID_MINUTES_MESSAGE = (String) invalidMinutesMessageField.get(null);

        var receivedField = TimeSinceStartOfDay.class.getDeclaredField("RECEIVED");
        receivedField.setAccessible(true);
        RECEIVED = (String) receivedField.get(null);

        var spaceField = TimeSinceStartOfDay.class.getDeclaredField("SPACE");
        spaceField.setAccessible(true);
        SPACE = (String) spaceField.get(null);
    }

    /**
     * Provides valid minutes and their corresponding hours for parameterized testing of the
     * {@link TimeSinceStartOfDay#calculateHours(int)} method.
     *
     * @return a {@link Stream} of {@link Arguments} containing valid minutes and expected hours.
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
     * Provides valid minutes and their corresponding minutes since last hour for parameterized testing of the
     * {@link TimeSinceStartOfDay#calculateMinutesSinceLastHour(int)} method.
     *
     * @return a {@link Stream} of {@link Arguments} containing valid minutes and expected minutes since last hour.
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
     * Provides valid hours, minutes and their corresponding total minutes for parameterized testing of the
     * {@link TimeSinceStartOfDay#calculateTotalMinutes(int, int)} method.
     *
     * @return a {@link Stream} of {@link Arguments} containing valid hours, minutes and expected total minutes.
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

    static @NotNull Stream<Arguments> provideInvalidArgumentsAndExceptionType() {
        return Stream.of(
                Arguments.of((Executable) () -> calculateHours(-1), InvalidMinuteException.class),
                Arguments.of((Executable) () -> calculateHours(-59), InvalidMinuteException.class),
                Arguments.of((Executable) () -> calculateHours(1440), InvalidMinuteException.class),
                Arguments.of((Executable) () -> calculateHours(1500), InvalidMinuteException.class),
                Arguments.of((Executable) () -> calculateMinutesSinceLastHour(-1), InvalidMinuteException.class),
                Arguments.of((Executable) () -> calculateMinutesSinceLastHour(-59), InvalidMinuteException.class),
                Arguments.of((Executable) () -> calculateTotalMinutes(0, -1), InvalidMinuteException.class),
                Arguments.of((Executable) () -> calculateTotalMinutes(-1, -1), InvalidMinuteException.class)
        );
    }

    /**
     * Constructs an exception message using the provided invalid minutes.
     *
     * @param minutes the invalid minutes.
     * @return the constructed exception message.
     */
    @Contract(pure = true)
    private static @NotNull String buildExceptionMessage(int minutes) {
        return INVALID_MINUTES_MESSAGE + SPACE + RECEIVED + SPACE + minutes;
    }

    /**
     * Provides invalid arguments, expected exception types, and messages for parameterized testing of
     * time calculation methods.
     *
     * @return a {@link Stream} of {@link Arguments} containing invalid arguments, expected exception types,
     * and messages.
     */
    static @NotNull Stream<Arguments> provideInvalidArgumentsExceptionTypeAndMessage() {
        return Stream.of(
                Arguments.of((Executable) () -> calculateHours(-1), InvalidMinuteException.class,
                        buildExceptionMessage(-1)),
                Arguments.of((Executable) () -> calculateHours(-59), InvalidMinuteException.class,
                        buildExceptionMessage(-59)),
                Arguments.of((Executable) () -> calculateHours(1440), InvalidMinuteException.class,
                        buildExceptionMessage(1440)),
                Arguments.of((Executable) () -> calculateHours(1500), InvalidMinuteException.class,
                        buildExceptionMessage(1500)),
                Arguments.of((Executable) () -> calculateMinutesSinceLastHour(-1), InvalidMinuteException.class,
                        buildExceptionMessage(-1)),
                Arguments.of((Executable) () -> calculateMinutesSinceLastHour(-59), InvalidMinuteException.class,
                        buildExceptionMessage(-59)),
                Arguments.of((Executable) () -> calculateTotalMinutes(0, -1), InvalidMinuteException.class,
                        buildExceptionMessage(-1)),
                Arguments.of((Executable) () -> calculateTotalMinutes(-1, -1), InvalidMinuteException.class,
                        buildExceptionMessage(-1))
        );
    }

    /**
     * Tests the {@link TimeSinceStartOfDay#calculateHours(int)} method with valid input parameters
     * for the number of minutes and expected number of hours.
     *
     * @param inputMinutes the input number of minutes.
     * @param expected     the expected number of hours.
     */
    @DisplayName("Positive Test Cases for calculateHours")
    @ParameterizedTest(name = "calculateHours with {0} minutes should return {1} hours")
    @MethodSource("validMinutesAndHoursProvider")
    void testCalculateHours_PositiveCases(final int inputMinutes, final int expected) {
        var actual = calculateHours(inputMinutes);

        assertEquals(expected, actual);
    }

    /**
     * Tests the {@link TimeSinceStartOfDay#calculateMinutesSinceLastHour(int)} method with valid input parameters
     * for the number of minutes and expected number of minutes since the last hour.
     *
     * @param inputMinutes the input number of minutes.
     * @param expected     the expected number of minutes since the last hour.
     */
    @DisplayName("Positive Test Cases for calculateMinutesSinceLastHour")
    @ParameterizedTest(name = "calculateMinutesSinceLastHour with {0} minutes should return {1} minutes")
    @MethodSource("validMinutesAndMinutesSinceLastHourProvider")
    void testCalculateMinutesSinceLastHour_PositiveCases(final int inputMinutes, final int expected) {
        var actual = calculateMinutesSinceLastHour(inputMinutes);

        assertEquals(expected, actual);
    }

    /**
     * Tests the {@link TimeSinceStartOfDay#calculateTotalMinutes(int, int)} method with valid input parameters
     * for the number of hours, minutes and expected total minutes.
     *
     * @param inputHours   the input number of hours.
     * @param inputMinutes the input number of minutes.
     * @param expected     the expected total number of minutes.
     */
    @DisplayName("Positive Test Cases for calculateTotalMinutes")
    @ParameterizedTest(name = "calculateTotalMinutes with {0} hours and {1} minutes should return {2} total minutes")
    @MethodSource("validHoursAndMinutesAndTotalMinutesProvider")
    void testCalculateTotalMinutes_PositiveCases(final int inputHours, final int inputMinutes, final int expected) {
        var actual = calculateTotalMinutes(inputHours, inputMinutes);

        assertEquals(expected, actual);
    }

    /**
     * Tests invalid cases for all time calculation methods and expects a specific exception type.
     *
     * @param actual   the executable code block that should throw an exception.
     * @param expected the expected exception class.
     */
    @DisplayName("Invalid cases for all time calculation methods")
    @ParameterizedTest(name = "With invalid input, method = {0}")
    @MethodSource("provideInvalidArgumentsAndExceptionType")
    void testInvalidCasesForAllMethods(final Executable actual, final Class<? extends Exception> expected) {
        assertThrows(expected, actual);
    }

    /**
     * Tests invalid cases for all time calculation methods and expects a specific exception message.
     *
     * @param executable          the executable code block that should throw an exception.
     * @param expectedExceptionType the expected exception class.
     * @param expected            the expected exception message.
     */
    @DisplayName("Invalid cases for all time calculation methods with exception message")
    @ParameterizedTest(name = "With invalid input, method = {0}")
    @MethodSource("provideInvalidArgumentsExceptionTypeAndMessage")
    void testInvalidCasesForAllMethodsWithMessage(final Executable executable,
                                                  final Class<? extends Exception> expectedExceptionType,
                                                  final String expected) {
        var actual = assertThrows(expectedExceptionType, executable).getMessage();

        assertEquals(expected, actual);
    }
}
