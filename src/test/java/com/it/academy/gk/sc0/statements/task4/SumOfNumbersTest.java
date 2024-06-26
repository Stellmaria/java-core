package com.it.academy.gk.sc0.statements.task4;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SumOfNumbersTest {
    private static String THAN_OR_EQUAL_TO_1;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException, IllegalAccessException {
        var invalidDigitNumberMessageField = SumOfNumbers.class.getDeclaredField("THAN_OR_EQUAL_TO_1");
        invalidDigitNumberMessageField.setAccessible(true);
        THAN_OR_EQUAL_TO_1 = (String) invalidDigitNumberMessageField.get(null);
    }

    private static @NotNull Stream<Arguments> providerTestCalculateSumWithValidInput() {
        return Stream.of(
                Arguments.of(1, 1),
                Arguments.of(2, 3),
                Arguments.of(3, 6),
                Arguments.of(4, 10),
                Arguments.of(5, 15),
                Arguments.of(1000, 500500)
        );
    }

    @ParameterizedTest(name = "Test case #{index}: {arguments}")
    @DisplayName("Test calculateSum")
    @MethodSource("providerTestCalculateSumWithValidInput")
    void testCalculateSumWithValidInput(final int n, final int expected) {
        var actual = SumOfNumbers.calculateSum(n);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test calculateSum with n = 0")
    void testCalculateSum_NegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> SumOfNumbers.calculateSum(0));
    }

    @Test
    @DisplayName("Test calculateSum with n < 0")
    void testCalculateSum_ZeroInput() {
        assertThrows(IllegalArgumentException.class, () -> SumOfNumbers.calculateSum(-1));
    }

    static @NotNull Stream<Arguments> provideInvalidArgumentsAndMessage() {
        return Stream.of(
                Arguments.of((Executable) () -> SumOfNumbers.calculateSum(0), THAN_OR_EQUAL_TO_1),
                Arguments.of((Executable) () -> SumOfNumbers.calculateSum(-1), THAN_OR_EQUAL_TO_1)
        );
    }

    @ParameterizedTest(name = "Test calculateSum exception message")
    @MethodSource("provideInvalidArgumentsAndMessage")
    @DisplayName("Test calculateSum exception message")
    void testCalculateSumExceptionMessage(Executable executable, String expected) {
        var exception = assertThrows(IllegalArgumentException.class, executable);

        var actual = exception.getMessage();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test calculateSum with IllegalArgumentException")
    void testCalculateSumIllegalArgumentException() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> SumOfNumbers.calculateSum(0)),
                () -> assertThrows(IllegalArgumentException.class, () -> SumOfNumbers.calculateSum(-1))
        );
    }
}
