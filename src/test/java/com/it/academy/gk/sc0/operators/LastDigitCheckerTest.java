package com.it.academy.gk.sc0.operators;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for the LastDigitChecker class.
 */
class LastDigitCheckerTest {

    /**
     * This method provides test cases for the testCheckLastDigit method.
     *
     * @return A stream of test cases, where each test case is an array of objects.
     */
    @SuppressFBWarnings("NP_NONNULL_RETURN_VIOLATION")
    @Contract(pure = true)
    static @NotNull Stream<Object[]> provideNumbers() {
        return Stream.of(
                new Object[]{12341, true},
                new Object[]{12342, true},
                new Object[]{12343, true},
                new Object[]{12344, false},
                new Object[]{12345, false},
                new Object[]{12346, false},
                new Object[]{12347, false},
                new Object[]{12348, false},
                new Object[]{12349, false}
        );
    }

    /**
     * This method tests the checkLastDigit method of the LastDigitChecker class using positive and negative test cases.
     * The test cases are provided by the provideNumbers method.
     *
     * @param number         The input number to checkLastDigit method
     * @param expectedResult The expected output of the checkLastDigit method
     */
    @ParameterizedTest(name = "Check last digit of {0} is 1, 2, or 3")
    @DisplayName("Check last digit of number is 1, 2, or 3")
    @MethodSource("provideNumbers")
    void testCheckLastDigit(int number, boolean expectedResult) {
        var checker = new LastDigitChecker(number);

        assertEquals(expectedResult, checker.checkLastDigit());
    }
}