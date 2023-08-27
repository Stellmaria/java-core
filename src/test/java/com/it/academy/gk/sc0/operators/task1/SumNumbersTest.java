package com.it.academy.gk.sc0.operators.task1;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The SumNumbersTest class is a test class for the SumNumbers class.
 * It contains tests for the sum method of the SumNumbers class.
 */
@SuppressFBWarnings("NP_NONNULL_RETURN_VIOLATION")
class SumNumbersTest {
    /**
     * The sumNumbers field is an instance of the SumNumbers class.
     */
    private SumNumbers sumNumbers;

    /**
     * The provideNumbersForSum method provides test data for the testSum method.
     * It returns a Stream of Arguments, where each Argument contains an array of numbers and the expected sum of those numbers.
     *
     * @return a Stream of Arguments for the testSum method
     */
    static @NotNull Stream<Arguments> provideNumbersForSum() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, 6),
                Arguments.of(new int[]{0, 0, 0}, 0),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{-1, 1}, 0),
                Arguments.of(new int[]{-1, -1, -1}, -3)
        );
    }

    /**
     * The setUp method is called before each test method.
     * It initializes the sumNumbers field with a new instance of the SumNumbers class.
     */
    @BeforeEach
    void setUp() {
        sumNumbers = new SumNumbers();
    }

    /**
     * The testSum method tests the sum method of the SumNumbers class with various inputs.
     * It is a parameterized test that uses the data provided by the provideNumbersForSum method.
     *
     * @param numbers  an array of numbers to be summed
     * @param expected the expected sum of the numbers
     */
    @ParameterizedTest(name = "Test with input numbers {0}, expecting sum {1}")
    @MethodSource("provideNumbersForSum")
    @DisplayName("Test sum method with various inputs")
    void testSum(final int[] numbers, final int expected) {
        var actual = sumNumbers.sum(numbers);

        assertEquals(expected, actual);
    }
}

