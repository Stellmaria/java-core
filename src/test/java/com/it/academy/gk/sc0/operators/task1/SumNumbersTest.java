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

import static com.it.academy.gk.sc0.operators.task1.SumNumbers.sum;
import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.of;

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
                of(new int[]{1, 2, 3}, 6L),
                of(new int[]{0, 0, 0}, 0L),
                of(new int[]{-1, 1}, 0L),
                of(new int[]{-1, -1, -1}, -3L),
                of(new int[]{MAX_VALUE, 1}, (long) MAX_VALUE + 1),
                of(new int[]{MIN_VALUE, -1}, (long) MIN_VALUE - 1)
        );
    }

    @ParameterizedTest(name = "Test with input numbers {0}, expecting sum {1}")
    @MethodSource("provideNumbersForSum")
    @DisplayName("Test sum method with various inputs.")
    void testSum(final int[] numbers, final long expected) {
        var actual = sum(numbers);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideInvalidArraysForExceptionMessages() {
        return Stream.of(
                of(IllegalArgumentException.class, ARRAY_MUST_NOT_BE_EMPTY, (Executable) () -> sum(new int[]{})),
                of(NullPointerException.class, EXPECTED_NON_NULL_ARGUMENT, (Executable) () -> sum((int[]) null))
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
                of(IllegalArgumentException.class, (Executable) () -> sum(new int[]{})),
                of(NullPointerException.class, (Executable) () -> sum((int[]) null))
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
                of(new int[]{5}, 5L),
                of(new int[]{-5}, -5L),
                of(new int[]{0}, 0L)
        );
    }

    @ParameterizedTest(name = "Test with a single element array {0}, expecting sum {1}")
    @MethodSource("provideSingleElementForSum")
    @DisplayName("Test sum method with a single element array.")
    void testSingleElementSum(final int @NotNull [] numbers, final long expected) {
        var actual = sum(numbers);

        assertAll(
                () -> assertEquals(1, numbers.length),
                () -> assertEquals(expected, actual)
        );
    }

    static @NotNull Stream<Arguments> provideMaxMinIntSum() {
        return Stream.of(
                of(new int[]{MAX_VALUE, MIN_VALUE}, -1L)
        );
    }

    @ParameterizedTest(name = "Test sum method with max/min integer values {0}, expecting sum {1}")
    @MethodSource("provideMaxMinIntSum")
    @DisplayName("Test sum method with max/min integer values.")
    void testMaxMinIntSum(final int[] array, final long expected) {
        var actual = sum(array);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideSumWithDuplicateElements() {
        return Stream.of(
                of(new int[]{1, 1, 1, 1, 1}, 5L)
        );
    }

    @ParameterizedTest(name = "Test sum method with duplicate elements {0}, expecting sum {1}")
    @MethodSource("provideSumWithDuplicateElements")
    @DisplayName("Test sum method with duplicate elements.")
    void testSumWithDuplicateElements(final int[] array, final long expected) {
        var actual = sum(array);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideOverflowSum() {
        return Stream.of(
                of(new int[]{MAX_VALUE, MAX_VALUE}, (long) MAX_VALUE + MAX_VALUE)
        );
    }

    @ParameterizedTest(name = "Test sum method with large numbers causing overflow {0}, expecting sum {1}")
    @MethodSource("provideOverflowSum")
    @DisplayName("Test sum method with large numbers causing overflow.")
    void testOverflowSum(final int[] array, final long expected) {
        var actual = sum(array);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideZeroSum() {
        return Stream.of(
                of(new int[]{0, 0, 0}, 0L),
                of(new int[]{0}, 0L)
        );
    }

    @ParameterizedTest(name = "Test sum method with zero elements {0}, expecting sum {1}")
    @MethodSource("provideZeroSum")
    @DisplayName("Test sum method with zero elements.")
    void testZeroSum(final int[] array, final long expected) {
        var actual = sum(array);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideMixedNumbersSum() {
        return Stream.of(
                of(new int[]{10, -5, 5, -10, 20}, 20L)
        );
    }

    @ParameterizedTest(name = "Test sum method with mixed positive and negative numbers {0}, expecting sum {1}")
    @MethodSource("provideMixedNumbersSum")
    @DisplayName("Test sum method with mixed positive and negative numbers.")
    void testMixedNumbersSum(final int[] array, final long expected) {
        var actual = sum(array);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test sum method with a large array.")
    void testLargeArraySum() {
        var largeArray = new int[10_000];
        var expected = 10_000L;
        Arrays.fill(largeArray, 1);

        var actual = sum(largeArray);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test sum method with very large array.")
    void testVeryLargeArraySum() {
        var largeArray = new int[1_000_000];
        Arrays.fill(largeArray, 1);
        var expected = 1_000_000L;

        var actual = sum(largeArray);
        assertEquals(expected, actual);
    }
}
