package com.it.academy.gk.sc0.statements.task9;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SumOfNumbersTest {
    private static String BE_NON_NEGATIVE;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException, IllegalAccessException {
        var invalidDigitNumberMessageField = SumOfNumbers.class.getDeclaredField("BE_NON_NEGATIVE");
        invalidDigitNumberMessageField.setAccessible(true);
        BE_NON_NEGATIVE = (String) invalidDigitNumberMessageField.get(null);
    }

    static @NotNull Stream<Arguments> printIntermediateSumsTestCases() {
        return Stream.of(
                Arguments.of(5, 10, "1,3,6,10"),
                Arguments.of(5, 15, "1,3,6,10,15"),
                Arguments.of(5, 5, "1,3"),
                Arguments.of(0, 10, ""),
                Arguments.of(5, 0, "")
        );
    }

    @ParameterizedTest(name = "{index} => n={0}, limit={1}, expected={2}")
    @DisplayName("printIntermediateSums")
    @MethodSource("printIntermediateSumsTestCases")
    void printIntermediateSums(int n, int limit, String expectedResult) {
        var result = SumOfNumbers.printIntermediateSums(n, limit);

        assertEquals(expectedResult, result);
    }

    static @NotNull Stream<Arguments> provideInvalidArguments() {
        return Stream.of(
                Arguments.of(-5, 10),
                Arguments.of(5, -10)
        );
    }


    @ParameterizedTest(name = "Invalid arguments: n={0}, limit={1}")
    @DisplayName("printIntermediateSums with IllegalArgumentException")
    @MethodSource("provideInvalidArguments")
    void testPrintIntermediateSumsIllegalArgumentException(int n, int limit) {
        var exception = assertThrows(
                IllegalArgumentException.class, () -> SumOfNumbers.printIntermediateSums(n, limit)
        );

        assertEquals(BE_NON_NEGATIVE, exception.getMessage());
    }
}
