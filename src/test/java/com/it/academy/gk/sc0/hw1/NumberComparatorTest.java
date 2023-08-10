package com.it.academy.gk.sc0.hw1;

import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for the NumberComparator class.
 * It uses the JUnit 5 testing framework to define and run the tests.
 */
@DisplayName("Number Comparator Test")
class NumberComparatorTest {
    /**
     * The value of the private static field FIRST_GREATER in the NumberComparator class.
     */
    private static String FIRST_GREATER;

    /**
     * The value of the private static field FIRST_LESS in the NumberComparator class.
     */
    private static String FIRST_LESS;

    /**
     * The value of the private static field EQUALS in the NumberComparator class.
     */
    private static String EQUAL;

    /**
     * An instance of the NumberComparator class used for testing.
     */
    private NumberComparator comparator;

    /**
     * Sets up the test class by using reflection to access the private static fields in the NumberComparator class
     * and storing their values in the corresponding fields in this test class.
     */
    @SneakyThrows
    @BeforeAll
    static void setAll() {
        var firstGreaterField = NumberComparator.class.getDeclaredField("FIRST_GREATER");
        firstGreaterField.setAccessible(true);
        FIRST_GREATER = (String) firstGreaterField.get(null);

        var firstLessField = NumberComparator.class.getDeclaredField("FIRST_LESS");
        firstLessField.setAccessible(true);
        FIRST_LESS = (String) firstLessField.get(null);

        var equalField = NumberComparator.class.getDeclaredField("EQUAL");
        equalField.setAccessible(true);
        EQUAL = (String) equalField.get(null);
    }

    /**
     * Provides a stream of arguments for testing the compareNumbers method in the NumberComparator class.
     *
     * @return a stream of arguments for testing the compareNumbers method in the NumberComparator class.
     */
    private static @NotNull Stream<Arguments> numberProvider() {
        return Stream.of(
                Arguments.of(1, 2, FIRST_LESS),
                Arguments.of(2, 1, FIRST_GREATER),
                Arguments.of(1, 1, EQUAL),
                Arguments.of(-1, -2, FIRST_GREATER),
                Arguments.of(-2, -1, FIRST_LESS),
                Arguments.of(-1, -1, EQUAL),
                Arguments.of(0, 0, EQUAL)
        );
    }

    /**
     * Sets up each test by creating a new instance of the NumberComparator class.
     */
    @BeforeEach
    void setUp() {
        comparator = new NumberComparator();
    }

    /**
     * Tests the compareNumbers method in the NumberComparator class with different combinations of input numbers.
     *
     * @param firstNumber  the first number to compare.
     * @param secondNumber the second number to compare.
     * @param expected     the expected result of the comparison.
     */
    @ParameterizedTest
    @MethodSource("numberProvider")
    void compareNumbers(double firstNumber, double secondNumber, String expected) {
        assertEquals(expected, comparator.compareNumbers(firstNumber, secondNumber));
    }

    /**
     * Tests the compareNumbers method of the NumberComparator class with different pairs of numbers.
     *
     * @param firstNumber  the first number to compare.
     * @param secondNumber the second number to compare.
     * @param expected     the expected result of the compareNumbers method.
     */
    @ParameterizedTest(name = "First number: {0}, second number: {1}, expected: {2}")
    @MethodSource("numberProvider")
    @DisplayName("Test compareNumbers method with different pairs of numbers")
    void testCompareNumbers(final double firstNumber, final double secondNumber, final String expected) {
        String actual = comparator.compareNumbers(firstNumber, secondNumber);

        assertEquals(expected, actual);
    }
}
