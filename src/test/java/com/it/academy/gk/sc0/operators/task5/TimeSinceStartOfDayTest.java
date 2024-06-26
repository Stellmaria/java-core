package com.it.academy.gk.sc0.operators.task5;

import com.it.academy.gk.sc0.operators.task5.exception.InvalidMinuteException;
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
import static org.junit.jupiter.params.provider.Arguments.of;

class TimeSinceStartOfDayTest {
    private static String INVALID_MINUTES_MESSAGE;
    private static String RECEIVED;
    private static String SPACE;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException, IllegalAccessException {
        INVALID_MINUTES_MESSAGE = getStaticFieldValue("INVALID_MINUTES_MESSAGE");
        RECEIVED = getStaticFieldValue("RECEIVED");
        SPACE = getStaticFieldValue("SPACE");
    }

    private static String getStaticFieldValue(String fieldName) throws NoSuchFieldException, IllegalAccessException {
        var field = TimeSinceStartOfDay.class.getDeclaredField(fieldName);
        field.setAccessible(true);

        return (String) field.get(null);
    }

    @Contract(pure = true)
    private static @NotNull String buildExceptionMessage(int minutes) {
        return INVALID_MINUTES_MESSAGE + SPACE + RECEIVED + SPACE + minutes;
    }

    public static @NotNull Stream<Arguments> validMinutesAndHoursProvider() {
        return Stream.of(
                of(0, 0),
                of(59, 0),
                of(60, 1),
                of(119, 1),
                of(1440 - 1, 23)
        );
    }

    @DisplayName("Positive Test Cases for calculateHours")
    @ParameterizedTest(name = "calculateHours with {0} minutes should return {1} hours")
    @MethodSource("validMinutesAndHoursProvider")
    void testCalculateHours_PositiveCases(final int inputMinutes, final int expected) throws InvalidMinuteException {
        var actual = calculateHours(inputMinutes);

        assertEquals(expected, actual);
    }

    public static @NotNull Stream<Arguments> validMinutesAndMinutesSinceLastHourProvider() {
        return Stream.of(
                of(0, 0),
                of(59, 59),
                of(60, 0),
                of(119, 59),
                of(1440 - 1, 59)
        );
    }

    @DisplayName("Positive Test Cases for calculateMinutesSinceLastHour")
    @ParameterizedTest(name = "calculateMinutesSinceLastHour with {0} minutes should return {1} minutes")
    @MethodSource("validMinutesAndMinutesSinceLastHourProvider")
    void testCalculateMinutesSinceLastHour_PositiveCases(final int inputMinutes,
                                                         final int expected) throws InvalidMinuteException {
        var actual = calculateMinutesSinceLastHour(inputMinutes);

        assertEquals(expected, actual);
    }

    public static @NotNull Stream<Arguments> validHoursAndMinutesAndTotalMinutesProvider() {
        return Stream.of(
                of(0, 0, 0),
                of(0, 59, 59),
                of(1, 0, 60),
                of(1, 59, 119),
                of(23, 59, 1440 - 1)
        );
    }

    @DisplayName("Positive Test Cases for calculateTotalMinutes")
    @ParameterizedTest(name = "calculateTotalMinutes with {0} hours and {1} minutes should return {2} total minutes")
    @MethodSource("validHoursAndMinutesAndTotalMinutesProvider")
    void testCalculateTotalMinutes_PositiveCases(final int inputHours,
                                                 final int inputMinutes,
                                                 final int expected) throws InvalidMinuteException {
        var actual = calculateTotalMinutes(inputHours, inputMinutes);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideInvalidArgumentsAndExceptionType() {
        return Stream.of(
                of((Executable) () -> calculateHours(-1), InvalidMinuteException.class),
                of((Executable) () -> calculateHours(-59), InvalidMinuteException.class),
                of((Executable) () -> calculateHours(1440), InvalidMinuteException.class),
                of((Executable) () -> calculateHours(1500), InvalidMinuteException.class),
                of((Executable) () -> calculateMinutesSinceLastHour(-1), InvalidMinuteException.class),
                of((Executable) () -> calculateMinutesSinceLastHour(-59), InvalidMinuteException.class),
                of((Executable) () -> calculateTotalMinutes(0, -1), InvalidMinuteException.class),
                of((Executable) () -> calculateTotalMinutes(-1, -1), InvalidMinuteException.class)
        );
    }

    @DisplayName("Invalid cases for all time calculation methods")
    @ParameterizedTest(name = "With invalid input, method = {0}")
    @MethodSource("provideInvalidArgumentsAndExceptionType")
    void testInvalidCasesForAllMethods(final Executable actual, final Class<? extends Exception> expected) {
        assertThrows(expected, actual);
    }

    static @NotNull Stream<Arguments> provideInvalidArgumentsExceptionTypeAndMessage() {
        return Stream.of(
                of(
                        (Executable) () -> calculateHours(-1),
                        InvalidMinuteException.class, buildExceptionMessage(-1)
                ),
                of(
                        (Executable) () -> calculateHours(-59),
                        InvalidMinuteException.class, buildExceptionMessage(-59)
                ),
                of(
                        (Executable) () -> calculateHours(1440),
                        InvalidMinuteException.class, buildExceptionMessage(1440)
                ),
                of(
                        (Executable) () -> calculateHours(1500),
                        InvalidMinuteException.class, buildExceptionMessage(1500)
                ),
                of(
                        (Executable) () -> calculateMinutesSinceLastHour(-1),
                        InvalidMinuteException.class, buildExceptionMessage(-1)
                ),
                of(
                        (Executable) () -> calculateMinutesSinceLastHour(-59),
                        InvalidMinuteException.class, buildExceptionMessage(-59)
                ),
                of(
                        (Executable) () -> calculateTotalMinutes(0, -1),
                        InvalidMinuteException.class, buildExceptionMessage(-1)
                ),
                of(
                        (Executable) () -> calculateTotalMinutes(-1, -1),
                        InvalidMinuteException.class, buildExceptionMessage(-1)
                )
        );
    }

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
