package com.it.academy.gk.sc0.operators.task1;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SumNumbersTest {
    private static String ARRAY_MUST_NOT_BE_EMPTY;
    private static String EXPECTED_NON_NULL_ARGUMENT;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException, IllegalAccessException {
        ARRAY_MUST_NOT_BE_EMPTY = getStaticFieldValue("ARRAY_MUST_NOT_BE_EMPTY");
        EXPECTED_NON_NULL_ARGUMENT = getStaticFieldValue("EXPECTED_NON_NULL_ARGUMENT");
    }

    private static String getStaticFieldValue(String fieldName) throws NoSuchFieldException, IllegalAccessException {
        var field = SumNumbers.class.getDeclaredField(fieldName);
        field.setAccessible(true);

        return (String) field.get(null);
    }

    static @NotNull Stream<Arguments> provideNumbersForSum() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 6L),
                Arguments.of(new int[]{0, 0, 0}, 0L),
                Arguments.of(new int[]{-1, 1}, 0L),
                Arguments.of(new int[]{-1, -1, -1}, -3L),
                Arguments.of(new int[]{Integer.MAX_VALUE, 1}, (long) Integer.MAX_VALUE + 1), // overflow
                Arguments.of(new int[]{Integer.MIN_VALUE, -1}, (long) Integer.MIN_VALUE - 1)  // overflow
        );
    }

    @ParameterizedTest(name = "Test with input numbers {0}, expecting sum {1}")
    @MethodSource("provideNumbersForSum")
    @DisplayName("Test sum method with various inputs.")
    void testSum(final int[] numbers, final long expected) {
        var actual = SumNumbers.sum(numbers);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideInvalidArraysForExceptionMessages() {
        return Stream.of(
                Arguments.of(
                        IllegalArgumentException.class, ARRAY_MUST_NOT_BE_EMPTY,
                        (Executable) () -> SumNumbers.sum(new int[]{})
                ),
                Arguments.of(
                        NullPointerException.class, EXPECTED_NON_NULL_ARGUMENT,
                        (Executable) () -> SumNumbers.sum((int[]) null)
                )
        );
    }

    @ParameterizedTest(name = "Test for exception = {0} with message = {1}")
    @MethodSource("provideInvalidArraysForExceptionMessages")
    @DisplayName("Test for array validation exceptions and their messages.")
    void testArrayValidationExceptionsAndMessages(final Class<? extends Exception> exception,
                                                  final String expected,
                                                  final Executable executable) {
        var actual = assertThrows(exception, executable).getMessage();

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideInvalidArraysForExceptions() {
        return Stream.of(
                Arguments.of(IllegalArgumentException.class, (Executable) () -> SumNumbers.sum(new int[]{})),
                Arguments.of(NullPointerException.class, (Executable) () -> SumNumbers.sum((int[]) null))
        );
    }

    @ParameterizedTest(name = "Test for exception = {0}")
    @MethodSource("provideInvalidArraysForExceptions")
    @DisplayName("Test for array validation exceptions.")
    void testArrayValidationExceptions(final Class<? extends Exception> expected, final Executable actual) {
        assertThrows(expected, actual);
    }

    static @NotNull Stream<Arguments> provideSingleElementForSum() {
        return Stream.of(
                Arguments.of(new int[]{5}, 5L),
                Arguments.of(new int[]{-5}, -5L),
                Arguments.of(new int[]{0}, 0L)
        );
    }

    @ParameterizedTest(name = "Test with a single element array {0}, expecting sum {1}")
    @MethodSource("provideSingleElementForSum")
    @DisplayName("Test sum method with a single element array.")
    void testSingleElementSum(final int @NotNull [] numbers, final long expected) {
        var actual = SumNumbers.sum(numbers);

        assertAll(
                () -> assertEquals(1, numbers.length),
                () -> assertEquals(expected, actual)
        );
    }

    @Test
    @DisplayName("Test sum method with a large array.")
    void testLargeArraySum() {
        var largeArray = new int[10000];
        var expected = 10000L;
        Arrays.fill(largeArray, 1);

        var actual = SumNumbers.sum(largeArray);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideMaxMinIntSum() {
        return Stream.of(
                Arguments.of(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE}, -1L)
        );
    }

    @ParameterizedTest(name = "Test sum method with max/min integer values {0}, expecting sum {1}")
    @MethodSource("provideMaxMinIntSum")
    @DisplayName("Test sum method with max/min integer values.")
    void testMaxMinIntSum(final int[] array, final long expected) {
        var actual = SumNumbers.sum(array);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideSumWithDuplicateElements() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 1, 1}, 5L)
        );
    }

    @ParameterizedTest(name = "Test sum method with duplicate elements {0}, expecting sum {1}")
    @MethodSource("provideSumWithDuplicateElements")
    @DisplayName("Test sum method with duplicate elements.")
    void testSumWithDuplicateElements(final int[] array, final long expected) {
        var actual = SumNumbers.sum(array);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideOverflowSum() {
        return Stream.of(
                Arguments.of(
                        new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE},
                        (long) Integer.MAX_VALUE + Integer.MAX_VALUE
                )
        );
    }

    @ParameterizedTest(name = "Test sum method with large numbers causing overflow {0}, expecting sum {1}")
    @MethodSource("provideOverflowSum")
    @DisplayName("Test sum method with large numbers causing overflow.")
    void testOverflowSum(final int[] array, final long expected) {
        var actual = SumNumbers.sum(array);

        assertEquals(expected, actual);
    }
}
