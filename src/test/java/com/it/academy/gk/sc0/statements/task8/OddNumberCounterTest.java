package com.it.academy.gk.sc0.statements.task8;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@DisplayName("Odd Number Counter Test")
class OddNumberCounterTest {
    private static String BE_NON_NEGATIVE;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException, IllegalAccessException {
        var invalidDigitNumberMessageField = OddNumberCounter.class.getDeclaredField("BE_NON_NEGATIVE");
        invalidDigitNumberMessageField.setAccessible(true);
        BE_NON_NEGATIVE = (String) invalidDigitNumberMessageField.get(null);
    }


    private static @NotNull Stream<Arguments> countOddNumbersTestCases() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 1),
                Arguments.of(2, 1),
                Arguments.of(3, 2),
                Arguments.of(4, 2),
                Arguments.of(5, 3)
        );
    }

    @ParameterizedTest(name = "countOddNumbers({0}) should return {1}")
    @DisplayName("Test countOddNumbers method")
    @MethodSource("countOddNumbersTestCases")
    void testCountOddNumbers(int n, int expected) {
        int actual = OddNumberCounter.countOddNumbers(n);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test countOddNumbers with negative input should throw IllegalArgumentException")
    void testCountOddNumbersNegativeInput() {
        var exception = assertThrows(IllegalArgumentException.class, () -> OddNumberCounter.countOddNumbers(-1));

        assertEquals(BE_NON_NEGATIVE, exception.getMessage());
    }
}
