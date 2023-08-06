package com.it.academy.gk.sc0.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for the StringConcatenator class.
 * It uses the JUnit 5 testing framework to define and run the tests.
 */
class StringConcatenatorTest {
    /**
     * The StringConcatenator object used in the tests.
     */
    private StringConcatenator concatenator;

    /**
     * Provides the arguments for the testConcatenateStrings method.
     *
     * @return an array of arrays containing the first string, the second string, and the expected
     * result of the concatenateStrings method
     */
    private static Object[][] stringProvider() {
        return new Object[][]{
                {"Hello", "World", "HelloWorld"},
                {"", "World", "World"},
                {"Hello", "", "Hello"},
                {"", "", ""}
        };
    }

    /**
     * Sets up a new StringConcatenator object before each test.
     */
    @BeforeEach
    void setUp() {
        concatenator = new StringConcatenator();
    }

    /**
     * Tests the concatenateStrings method of the StringConcatenator class with different pairs of strings.
     *
     * @param firstString  the first string to concatenate
     * @param secondString the second string to concatenate
     * @param expected     the expected result of the concatenateStrings method
     */
    @ParameterizedTest(name = "First string: {0}, second string: {1}, expected: {2}")
    @MethodSource("stringProvider")
    void testConcatenateStrings(String firstString, String secondString, String expected) {
        var actual = concatenator.concatenateStrings(firstString, secondString);

        assertEquals(expected, actual);
    }
}
