package com.it.academy.gk.sc0.hw1;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the StringEqualityChecker class.
 */
@DisplayName("String Equality Checker Test")
class StringEqualityCheckerTest {
    /**
     * An instance of the StringEqualityChecker class used for testing.
     */
    private StringEqualityChecker checker;

    /**
     * Initializes the StringEqualityChecker instance before each test.
     */
    @BeforeEach
    public void setUp() {
        checker = new StringEqualityChecker();
    }

    /**
     * Provides test cases for the areStringsEqual method.
     *
     * @return a stream of test cases, where each case is an array containing the input strings and the expected result.
     */
    private static @NotNull Stream<Arguments> areStringsEqualTestCases() {
        return Stream.of(
                Arguments.of("hello", "hello", "The strings are equal."),
                Arguments.of("HELLO", "HELLO", "The strings are equal."),
                Arguments.of("123", "123", "The strings are equal."),
                Arguments.of("", "", "The strings are equal."),
                Arguments.of("hello", "world", "The strings are not equal."),
                Arguments.of("hello", "HELLO", "The strings are not equal."),
                Arguments.of("123", "456", "The strings are not equal."),
                Arguments.of("hello", "", "The strings are not equal.")
        );
    }

    /**
     * Tests the areStringsEqual method using parameterized tests.
     *
     * @param string1        the first string to compare.
     * @param string2        the second string to compare.
     * @param expectedResult the expected result of the comparison.
     */
    @ParameterizedTest(name = "{index} => string1={0}, string2={1}, expectedResult={2}")
    @DisplayName("areStringsEqual method test")
    @MethodSource("areStringsEqualTestCases")
    void testAreStringsEqual(final String string1, final String string2, final String expectedResult) {
        String actual = checker.areStringsEqual(string1, string2);

        assertEquals(expectedResult, actual);
    }
}
