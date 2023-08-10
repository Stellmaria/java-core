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
 * This class contains tests for the StringConcatenator class.
 * It uses the JUnit 5 testing framework to define and run the tests.
 */
@DisplayName("String Concatenator Test")
class StringConcatenatorTest {
    /**
     * The StringConcatenator object used in the tests.
     */
    private StringConcatenator concatenator;

    /**
     * Sets up a new StringConcatenator object before each test.
     */
    @BeforeEach
    void setUp() {
        concatenator = new StringConcatenator();
    }

    /**
     * Provides the arguments for the testConcatenateStrings method.
     *
     * @return a stream of arguments for the testConcatenateStrings method.
     */
    private static @NotNull Stream<Arguments> stringProvider() {
        return Stream.of(
                Arguments.of("Hello", "World", "HelloWorld"),
                Arguments.of("", "World", "World"),
                Arguments.of("Hello", "", "Hello"),
                Arguments.of("", "", "")
        );
    }

    /**
     * Tests the concatenateStrings method of the StringConcatenator class with different pairs of strings.
     *
     * @param firstString  the first string to concatenate.
     * @param secondString the second string to concatenate.
     * @param expected     the expected result of the concatenateStrings method.
     */
    @ParameterizedTest(name = "First string: {0}, second string: {1}, expected: {2}")
    @MethodSource("stringProvider")
    @DisplayName("Test concatenateStrings method with different pairs of strings")
    void testConcatenateStrings(final String firstString, final String secondString, final String expected) {
        String actual = concatenator.concatenateStrings(firstString, secondString);

        assertEquals(expected, actual);
    }
}
