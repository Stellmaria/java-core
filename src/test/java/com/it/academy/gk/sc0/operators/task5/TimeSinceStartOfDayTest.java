package com.it.academy.gk.sc0.operators.task5;

import com.it.academy.gk.sc0.operators.task5.exception.InvalidMinuteException;
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

class TimeSinceStartOfDayTest {
    private static String INVALID_MINUTES_MESSAGE;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException, IllegalAccessException {
        var invalidMinutesMessage = TimeSinceStartOfDay.class.getDeclaredField("INVALID_MINUTES_MESSAGE");
        invalidMinutesMessage.setAccessible(true);
        INVALID_MINUTES_MESSAGE = (String) invalidMinutesMessage.get(null);
    }

    public static @NotNull Stream<Arguments> validMinutesAndHoursProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(59, 0),
                Arguments.of(60, 1),
                Arguments.of(119, 1),
                Arguments.of(1440 - 1, 23)
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
                Arguments.of(0, 0),
                Arguments.of(59, 59),
                Arguments.of(60, 0),
                Arguments.of(119, 59),
                Arguments.of(1440 - 1, 59)
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
                Arguments.of(0, 0, 0),
                Arguments.of(0, 59, 59),
                Arguments.of(1, 0, 60),
                Arguments.of(1, 59, 119),
                Arguments.of(23, 59, 1440 - 1)
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

    @DisplayName("Invalid cases for all time calculation methods")
    @ParameterizedTest(name = "With invalid input, method = {0}")
    @MethodSource("provideInvalidArgumentsAndExceptionType")
    void testInvalidCasesForAllMethods(final Executable actual, final Class<? extends Exception> expected) {
        assertThrows(expected, actual);
    }

    static @NotNull Stream<Arguments> provideInvalidArgumentsExceptionTypeAndMessage() {
        return Stream.of(
                Arguments.of(
                        (Executable) () -> calculateHours(-1),
                        InvalidMinuteException.class, INVALID_MINUTES_MESSAGE + "-1"
                ),
                Arguments.of(
                        (Executable) () -> calculateHours(-59),
                        InvalidMinuteException.class, INVALID_MINUTES_MESSAGE + "-59"
                ),
                Arguments.of(
                        (Executable) () -> calculateHours(1440),
                        InvalidMinuteException.class, INVALID_MINUTES_MESSAGE + "1440"
                ),
                Arguments.of(
                        (Executable) () -> calculateHours(1500),
                        InvalidMinuteException.class, INVALID_MINUTES_MESSAGE + "1500"
                ),
                Arguments.of(
                        (Executable) () -> calculateMinutesSinceLastHour(-1),
                        InvalidMinuteException.class, INVALID_MINUTES_MESSAGE + "-1"
                ),
                Arguments.of(
                        (Executable) () -> calculateMinutesSinceLastHour(-59),
                        InvalidMinuteException.class, INVALID_MINUTES_MESSAGE + "-59"
                ),
                Arguments.of(
                        (Executable) () -> calculateTotalMinutes(0, -1),
                        InvalidMinuteException.class, INVALID_MINUTES_MESSAGE + "-1"),
                Arguments.of(
                        (Executable) () -> calculateTotalMinutes(-1, -1),
                        InvalidMinuteException.class, INVALID_MINUTES_MESSAGE + "-1"
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
