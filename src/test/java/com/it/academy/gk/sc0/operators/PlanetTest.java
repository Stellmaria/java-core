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
 * The PlanetTest class tests the functionality of the Planet class.
 * <p>
 * This class uses the Reflection API to access private fields of the Planet class in its test methods.
 * It contains test methods that test the getPlanetName method of the Planet class with valid and invalid input.
 */
class PlanetTest {
    /**
     * A private instance variable of the PlanetTest class that holds an instance of the Planet class.
     * <p>
     * This field is used in the test methods of the PlanetTest class
     * to call the methods of the Planet class and test their functionality.
     */
    private Planet planet;

    /**
     * Provides a stream of valid test data for the testGetPlanetNameWithValidInput method.
     * <p>
     * This method returns a stream of Arguments, where each Argument represents
     * a test case with an input planet number and an expected output planet name.
     *
     * @return a stream of valid test data for the testGetPlanetNameWithValidInput method
     */
    private static @NotNull Stream<Arguments> validInputProvider() throws NoSuchFieldException, IllegalAccessException {
        var mercuryField = Planet.class.getDeclaredField("MERCURY");
        mercuryField.setAccessible(true);
        var mercury = (String) mercuryField.get(null);

        var venusField = Planet.class.getDeclaredField("VENUS");
        venusField.setAccessible(true);
        var venus = (String) venusField.get(null);

        var earthField = Planet.class.getDeclaredField("EARTH");
        earthField.setAccessible(true);
        var earth = (String) earthField.get(null);

        var marsField = Planet.class.getDeclaredField("MARS");
        marsField.setAccessible(true);
        var mars = (String) marsField.get(null);

        var jupiterField = Planet.class.getDeclaredField("JUPITER");
        jupiterField.setAccessible(true);
        var jupiter = (String) jupiterField.get(null);

        var saturnField = Planet.class.getDeclaredField("SATURN");
        saturnField.setAccessible(true);
        var saturn = (String) saturnField.get(null);

        var uranusField = Planet.class.getDeclaredField("URANUS");
        uranusField.setAccessible(true);
        var uranus = (String) uranusField.get(null);

        var neptuneField = Planet.class.getDeclaredField("NEPTUNE");
        neptuneField.setAccessible(true);
        var neptune = (String) neptuneField.get(null);

        return Stream.of(
                Arguments.of(1, mercury),
                Arguments.of(2, venus),
                Arguments.of(3, earth),
                Arguments.of(4, mars),
                Arguments.of(5, jupiter),
                Arguments.of(6, saturn),
                Arguments.of(7, uranus),
                Arguments.of(8, neptune));
    }

    /**
     * Provides a stream of invalid test data for the testGetPlanetNameWithInvalidInput method.
     * <p>
     * This method returns a stream of Arguments, where each Argument represents
     * a test case with an input invalid planet number.
     *
     * @return a stream of invalid test data for the testGetPlanetNameWithInvalidInput method
     */
    private static @NotNull Stream<Arguments> invalidInputProvider() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(-1),
                Arguments.of(9),
                Arguments.of(Integer.MAX_VALUE),
                Arguments.of(Integer.MIN_VALUE));
    }

    /**
     * Sets up the test environment before each test.
     * <p>
     * This method creates a new instance of the Planet class and assigns it to the planet field.
     */
    @BeforeEach
    void setUp() {
        planet = new Planet();
    }

    /**
     * Tests the getPlanetName method of the Planet class with valid input.
     * <p>
     * This method takes an integer representing a planet number and a string representing
     * the expected output planet name as arguments.
     * It calls the getPlanetName method
     * of the Planet class with the provided planet number and asserts that the result
     * is equal to the expected output planet name.
     *
     * @param planetNumber an integer representing a planet number
     * @param expected     a string representing the expected output planet name
     */
    @DisplayName("Test getPlanetName with valid input")
    @ParameterizedTest(name = "Test getPlanetName({0}) = {1}")
    @MethodSource("validInputProvider")
    void testGetPlanetNameWithValidInput(int planetNumber, String expected) {
        var actual = planet.getPlanetName(planetNumber);

        assertEquals(expected, actual);
    }

    /**
     * Tests the getPlanetName method of the Planet class with invalid input.
     * <p>
     * This method takes an integer representing an invalid planet number as an argument.
     * It calls the getPlanetName method of the Planet class with the provided invalid planet number
     * and asserts that the result is equal to an error message indicating that the input is invalid.
     *
     * @param planetNumber an integer representing an invalid planet number
     */
    @DisplayName("Test getPlanetName with invalid input")
    @ParameterizedTest(name = "Test getPlanetName({0}) = null")
    @MethodSource("invalidInputProvider")
    void testGetPlanetNameWithInvalidInput(int planetNumber) throws NoSuchFieldException, IllegalAccessException {
        var errorMessageField = Planet.class.getDeclaredField("INVALID_INPUT_ERROR_MESSAGE");
        errorMessageField.setAccessible(true);
        var errorMessage = (String) errorMessageField.get(null);

        var actual = planet.getPlanetName(planetNumber);

        assertEquals(errorMessage, actual);
    }
}