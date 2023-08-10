package com.it.academy.gk.sc0.operators;

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
 * The PlanetTest class tests the functionality of the Planet class.
 */
@DisplayName("Planet Test")
class PlanetTest {
    /**
     * These are private static fields of the PlanetTest class
     * that hold the values of the planet name constants from the Planet class.
     * They are used in the test methods of the PlanetTest class
     * to compare the expected and actual values of calculations involving planet names.
     */
    private static String MERCURY;
    private static String VENUS;
    private static String EARTH;
    private static String MARS;
    private static String JUPITER;
    private static String SATURN;
    private static String URANUS;
    private static String NEPTUNE;
    /**
     * This is a private static field of the PlanetTest class
     * that holds the value of the INVALID_INPUT_ERROR_MESSAGE constant from the Planet class.
     * It is used in the test methods of the PlanetTest class
     * to compare the expected and actual values of error messages.
     */
    private static String INVALID_INPUT_ERROR_MESSAGE;
    /**
     * This is a private field of the PlanetTest class that holds an instance of the Planet class.
     * It is used in the test methods of the PlanetTest class
     * to call the methods of the Planet class and test their functionality.
     */
    private Planet planet;

    /**
     * This method is called before all tests are run.
     * It uses reflection to access and retrieve the values of the planet name constants
     * and INVALID_INPUT_ERROR_MESSAGE constant from the Planet class
     * and assigns them to corresponding fields in this test class.
     */
    @SneakyThrows
    @BeforeAll
    static void beforeAll() {
        var mercuryField = Planet.class.getDeclaredField("MERCURY");
        mercuryField.setAccessible(true);
        MERCURY = (String) mercuryField.get(null);

        var venusField = Planet.class.getDeclaredField("VENUS");
        venusField.setAccessible(true);
        VENUS = (String) venusField.get(null);

        var earthField = Planet.class.getDeclaredField("EARTH");
        earthField.setAccessible(true);
        EARTH = (String) earthField.get(null);

        var marsField = Planet.class.getDeclaredField("MARS");
        marsField.setAccessible(true);
        MARS = (String) marsField.get(null);

        var jupiterrsField = Planet.class.getDeclaredField("JUPITER");
        jupiterrsField.setAccessible(true);
        JUPITER = (String) jupiterrsField.get(null);

        var saturnField = Planet.class.getDeclaredField("SATURN");
        saturnField.setAccessible(true);
        SATURN = (String) saturnField.get(null);

        var uranusField = Planet.class.getDeclaredField("URANUS");
        uranusField.setAccessible(true);
        URANUS = (String) uranusField.get(null);

        var neptuneField = Planet.class.getDeclaredField("NEPTUNE");
        neptuneField.setAccessible(true);
        NEPTUNE = (String) neptuneField.get(null);

        var errorMessageField = Planet.class.getDeclaredField("INVALID_INPUT_ERROR_MESSAGE");
        errorMessageField.setAccessible(true);
        INVALID_INPUT_ERROR_MESSAGE = (String) errorMessageField.get(null);
    }

    /**
     * Provides a stream of valid test data for the testGetPlanetNameWithValidInput method.
     *
     * @return a stream of valid test data for the testGetPlanetNameWithValidInput method
     */
    private static @NotNull Stream<Arguments> validInputProvider() {
        return Stream.of(
                Arguments.of(1, MERCURY),
                Arguments.of(2, VENUS),
                Arguments.of(3, EARTH),
                Arguments.of(4, MARS),
                Arguments.of(5, JUPITER),
                Arguments.of(6, SATURN),
                Arguments.of(7, URANUS),
                Arguments.of(8, NEPTUNE));
    }

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    void setUp() {
        planet = new Planet();
    }

    /**
     * Provides a stream of invalid test data for the testGetPlanetNameWithInvalidInput method.
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
     * Tests the getPlanetName method of the Planet class with valid input.
     *
     * @param planetNumber an integer representing a planet number
     * @param expected     a string representing the expected output planet name
     */
    @DisplayName("Test getPlanetName with valid input")
    @ParameterizedTest(name = "Test getPlanetName({0}) = {1}")
    @MethodSource("validInputProvider")
    void testGetPlanetNameWithValidInput(final int planetNumber, final String expected) {
        String actual = planet.getPlanetName(planetNumber);

        assertEquals(expected, actual);
    }

    /**
     * Tests the getPlanetName method of the Planet class with invalid input.
     *
     * @param planetNumber an integer representing an invalid planet number
     */
    @DisplayName("Test getPlanetName with invalid input")
    @ParameterizedTest(name = "Test getPlanetName({0}) = null")
    @MethodSource("invalidInputProvider")
    void testGetPlanetNameWithInvalidInput(final int planetNumber) {
        String actual = planet.getPlanetName(planetNumber);

        assertEquals(INVALID_INPUT_ERROR_MESSAGE, actual);
    }
}