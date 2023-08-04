package com.it.academy.gk.sc0.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for the Planet class.
 */
class PlanetTest {
    private Planet planet;

    /**
     * Provides valid input values for the testGetPlanetNameWithValidInput test method.
     * <p>
     * This method returns a stream of Arguments objects representing pairs of input and expected output
     * values for the getPlanetName method.
     * Each pair consists of an integer representing a planet's ordinal
     * number in the Solar System and a string representing that ordinal number's corresponding planet's name.
     *
     * @return A stream of Arguments objects representing pairs of inputs and expected output values for
     * the getPlanetName method.
     */
    private static @NotNull Stream<Arguments> validInputProvider() {
        return Stream.of(Arguments.of(1, Planet.MERCURY), Arguments.of(2, Planet.VENUS), Arguments.of(3, Planet.EARTH), Arguments.of(4, Planet.MARS), Arguments.of(5, Planet.JUPITER), Arguments.of(6, Planet.SATURN), Arguments.of(7, Planet.URANUS), Arguments.of(8, Planet.NEPTUNE));
    }

    /**
     * Provides invalid input values for the testGetPlanetNameWithInvalidInput test method.
     * <p>
     * This method returns a stream of Arguments objects representing invalid input values for
     * the getPlanetName method.
     * Each Argument object consists of a single integer representing an invalid
     * ordinal number for a planet in the Solar System (i.e., not between 1 and 8 inclusive).
     *
     * @return A stream of Arguments objects representing invalid input values for the getPlanetName method.
     */
    private static @NotNull Stream<Arguments> invalidInputProvider() {
        return Stream.of(Arguments.of(0), Arguments.of(-1), Arguments.of(9), Arguments.of(Integer.MAX_VALUE), Arguments.of(Integer.MIN_VALUE));
    }

    /**
     * Initializes a new instance of the Planet class before each test.
     */
    @BeforeEach
    void setUp() {
        planet = new Planet();
    }

    /**
     * Tests the getPlanetName method with valid input.
     * <p>
     * This test method uses the @ParameterizedTest annotation to run multiple tests with different
     * input values provided by the validInputProvider method.
     * This method uses the @MethodSource
     * annotation to specify the name of the method that provides the input values.
     * The validInputProvider
     * method returns a stream of Arguments objects representing pairs of input and expected output values
     * for the getPlanetName method.
     */
    @DisplayName("Test getPlanetName with valid input")
    @ParameterizedTest(name = "Test getPlanetName({0}) = {1}")
    @MethodSource("validInputProvider")
    void testGetPlanetNameWithValidInput(int planetNumber, String expected) {
        assertEquals(expected, planet.getPlanetName(planetNumber));
    }

    /**
     * Tests the getPlanetName method with invalid input.
     * <p>
     * This test method uses the @ParameterizedTest annotation to run multiple tests with different
     * input values provided by the invalidInputProvider method.
     * This method uses the @MethodSource
     * annotation to specify the name of the method that provides the input values.
     * The invalidInputProvider
     * method returns a stream of Arguments objects representing invalid input values for the getPlanetName
     * method.
     * For each invalid input value, this test method asserts that the getPlanetName method returns null.
     */
    @DisplayName("Test getPlanetName with invalid input")
    @ParameterizedTest(name = "Test getPlanetName({0}) = null")
    @MethodSource("invalidInputProvider")
    void testGetPlanetNameWithInvalidInput(int planetNumber) {
        assertEquals(Planet.INVALID_INPUT_ERROR_MESSAGE, planet.getPlanetName(planetNumber));
    }
}
