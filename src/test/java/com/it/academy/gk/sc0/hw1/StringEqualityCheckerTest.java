package com.it.academy.gk.sc0.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test class for the StringEqualityChecker class.
 */
class StringEqualityCheckerTest {
    /**
     * An instance of the StringEqualityChecker class used for testing.
     */
    private StringEqualityChecker checker;

    /**
     * Provides test cases for the areStringsEqual method.
     *
     * @return an array of test cases, where each case is an array containing the input strings and the expected result
     */
    private static Object[][] areStringsEqualTestCases() {
        return new Object[][]{
                // Positive test cases
                {"hello", "hello", "The strings are equal."},
                {"HELLO", "HELLO", "The strings are equal."},
                {"123", "123", "The strings are equal."},
                {"", "", "The strings are equal."},
                // Negative test cases
                {"hello", "world", "The strings are not equal."},
                {"hello", "HELLO", "The strings are not equal."},
                {"123", "456", "The strings are not equal."},
                {"hello", "", "The strings are not equal."},
        };
    }

    /**
     * Initializes the StringEqualityChecker instance before each test.
     */
    @BeforeEach
    public void setUp() {
        checker = new StringEqualityChecker();
    }

    /**
     * Tests the areStringsEqual method using parameterized tests.
     *
     * @param string1        the first string to compare
     * @param string2        the second string to compare
     * @param expectedResult the expected result of the comparison
     */
    @ParameterizedTest(name = "{index} => string1={0}, string2={1}, expectedResult={2}")
    @DisplayName("areStringsEqual method test")
    @MethodSource("areStringsEqualTestCases")
    void testAreStringsEqual(String string1, String string2, String expectedResult) {
        var actual = checker.areStringsEqual(string1, string2);

        assertEquals(expectedResult, actual);
    }
}
