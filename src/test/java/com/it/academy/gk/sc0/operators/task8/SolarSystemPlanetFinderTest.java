package com.it.academy.gk.sc0.operators.task8;

import com.it.academy.gk.sc0.operators.exception.InvalidPlanetNameException;
import com.it.academy.gk.sc0.operators.exception.InvalidPlanetNumberException;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * A test class for the SolarSystemPlanetFinder class.
 */
@SuppressFBWarnings("NP_NONNULL_RETURN_VIOLATION")
class SolarSystemPlanetFinderTest {
    /**
     * The SolarSystemPlanetFinder instance to be tested.
     */
    private SolarSystemPlanetFinder finder;

    /**
     * Provides a stream of valid planet numbers and their corresponding planet names for testing purposes.
     *
     * @return a stream of valid planet numbers and their corresponding planet names as arguments
     */
    static @NotNull Stream<Arguments> validPlanetNumberProvider() {
        return Stream.of(
                Arguments.of(1, "Mercury"),
                Arguments.of(2, "Venus"),
                Arguments.of(3, "Earth"),
                Arguments.of(4, "Mars"),
                Arguments.of(5, "Jupiter"),
                Arguments.of(6, "Saturn"),
                Arguments.of(7, "Uranus"),
                Arguments.of(8, "Neptune")
        );
    }

    /**
     * Provides a stream of invalid planet numbers for testing purposes.
     *
     * @return a stream of invalid planet numbers as arguments
     */
    static @NotNull Stream<Arguments> invalidPlanetNumberProvider() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(9),
                Arguments.of(-1)
        );
    }

    /**
     * Provides a stream of valid planet names and their corresponding planet numbers for testing purposes.
     *
     * @return a stream of valid planet names and their corresponding planet numbers as arguments
     */
    static @NotNull Stream<Arguments> validPlanetNameProvider() {
        return Stream.of(
                Arguments.of("Mercury", 1),
                Arguments.of("Venus", 2),
                Arguments.of("Earth", 3),
                Arguments.of("Mars", 4),
                Arguments.of("Jupiter", 5),
                Arguments.of("Saturn", 6),
                Arguments.of("Uranus", 7),
                Arguments.of("Neptune", 8)
        );
    }

    /**
     * Provides a stream of invalid planet names for testing purposes.
     *
     * @return a stream of invalid planet names as arguments
     */
    static @NotNull Stream<Arguments> invalidPlanetNameProvider() {
        return Stream.of(
                Arguments.of("Pluto"),
                Arguments.of("PlanetX"),
                Arguments.of("InvalidName")
        );
    }

    /**
     * Sets up the SolarSystemPlanetFinder instance before each test.
     */
    @BeforeEach
    public void setUp() {
        finder = new SolarSystemPlanetFinder();
    }

    /**
     * Tests the findPlanetByNumber method with valid planet numbers.
     *
     * @param planetNumber the planet number to be searched
     * @param expected     the expected planet name
     */
    @ParameterizedTest(name = "For planet number {0}, the planet name should be {1}")
    @MethodSource("validPlanetNumberProvider")
    @DisplayName("Valid planet numbers")
    void testFindPlanetByNumber(int planetNumber, String expected) throws InvalidPlanetNumberException {
        var actual = finder.findPlanetByNumber(planetNumber);

        assertEquals(expected, actual);
    }

    /**
     * Tests the findPlanetByNumber method with invalid planet numbers.
     *
     * @param planetNumber an invalid planet number
     */
    @ParameterizedTest(name = "Invalid planet number {0} should throw InvalidPlanetNumberException")
    @MethodSource("invalidPlanetNumberProvider")
    @DisplayName("Invalid planet numbers")
    void testInvalidPlanetNumbers(int planetNumber) {
        assertThrows(InvalidPlanetNumberException.class, () -> finder.findPlanetByNumber(planetNumber));
    }

    /**
     * Tests the findPlanetNumberByName method with valid planet names.
     *
     * @param planetName the planet name to be searched
     * @param expected   the expected planet number
     */
    @ParameterizedTest(name = "For planet name {0}, the planet number should be {1}")
    @MethodSource("validPlanetNameProvider")
    @DisplayName("Valid planet names")
    void testFindPlanetNumberByName(String planetName, int expected) throws InvalidPlanetNameException {
        var actual = finder.findPlanetNumberByName(planetName);

        assertEquals(expected, actual);
    }

    /**
     * Tests the findPlanetNumberByName method with invalid planet names.
     *
     * @param planetName an invalid planet name
     */
    @ParameterizedTest(name = "Invalid planet name {0} should throw InvalidPlanetNameException")
    @MethodSource("invalidPlanetNameProvider")
    @DisplayName("Invalid planet names")
    void testInvalidPlanetNames(String planetName) {
        assertThrows(InvalidPlanetNameException.class, () -> finder.findPlanetNumberByName(planetName));
    }
}
