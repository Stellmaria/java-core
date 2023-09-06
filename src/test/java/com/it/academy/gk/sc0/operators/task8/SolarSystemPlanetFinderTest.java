package com.it.academy.gk.sc0.operators.task8;

import com.it.academy.gk.sc0.operators.exception.InvalidPlanetNameException;
import com.it.academy.gk.sc0.operators.exception.InvalidPlanetNumberException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

import static com.it.academy.gk.sc0.operators.task8.SolarSystemPlanetFinder.findPlanetByNumber;
import static com.it.academy.gk.sc0.operators.task8.SolarSystemPlanetFinder.findPlanetNumberByName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * SolarSystemPlanetFinderTest is a test class that performs unit tests for methods related to age classification.
 *
 * <p>This class uses JUnit 5 for parameterized testing and exception testing to validate the behavior of methods
 * for various age groups.</p>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
class SolarSystemPlanetFinderTest {
    /**
     * Provides valid planet numbers and their corresponding planet names for parameterized testing.
     *
     * @return a {@link Stream} of {@link Arguments} containing valid planet numbers and expected planet names.
     */
    static @NotNull Stream<Arguments> validPlanetNumberProvider() {
        return Stream.of(
                Arguments.of(1, Planet.MERCURY.name()),
                Arguments.of(2, Planet.VENUS.name()),
                Arguments.of(3, Planet.EARTH.name()),
                Arguments.of(4, Planet.MARS.name()),
                Arguments.of(5, Planet.JUPITER.name()),
                Arguments.of(6, Planet.SATURN.name()),
                Arguments.of(7, Planet.URANUS.name()),
                Arguments.of(8, Planet.NEPTUNE.name())
        );
    }

    /**
     * Tests the {@link SolarSystemPlanetFinder#findPlanetByNumber(int)} method with valid planet numbers.
     *
     * @param planetNumber the planet number to look up.
     * @param expected     the expected planet name for the given planet number.
     */
    @ParameterizedTest(name = "For planet number {0}, the planet name should be {1}")
    @MethodSource("validPlanetNumberProvider")
    @DisplayName("Valid planet numbers")
    @SneakyThrows
    void testFindPlanetByNumber(final int planetNumber, final String expected) {
        Optional<String> actualOptional = findPlanetByNumber(planetNumber);
        assertTrue(actualOptional.isPresent(), "Optional should not be empty");
        String actual = actualOptional.orElseThrow();

        assertEquals(expected, actual);
    }

    /**
     * Provides valid planet numbers and their corresponding planet names for parameterized testing.
     *
     * @return a {@link Stream} of {@link Arguments} containing valid planet numbers and expected planet names.
     */
    static @NotNull Stream<Arguments> invalidPlanetNumberProvider() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(9),
                Arguments.of(-1)
        );
    }

    /**
     * Tests the {@link SolarSystemPlanetFinder#findPlanetByNumber(int)} method with invalid planet numbers.
     *
     * @param planetNumber the invalid planet number to test.
     */
    @ParameterizedTest(name = "Invalid planet number {0} should throw InvalidPlanetNumberException")
    @MethodSource("invalidPlanetNumberProvider")
    @DisplayName("Invalid planet numbers")
    void testInvalidPlanetNumbers(final int planetNumber) {
        assertThrows(InvalidPlanetNumberException.class, () -> findPlanetByNumber(planetNumber));
    }

    /**
     * Provides valid planet names and their corresponding planet numbers for parameterized testing.
     *
     * @return a {@link Stream} of {@link Arguments} containing valid planet names and expected planet numbers.
     */
    static @NotNull Stream<Arguments> validPlanetNameProvider() {
        return Stream.of(
                Arguments.of(Planet.MERCURY.name(), 1),
                Arguments.of(Planet.VENUS.name(), 2),
                Arguments.of(Planet.EARTH.name(), 3),
                Arguments.of(Planet.MARS.name(), 4),
                Arguments.of(Planet.JUPITER.name(), 5),
                Arguments.of(Planet.SATURN.name(), 6),
                Arguments.of(Planet.URANUS.name(), 7),
                Arguments.of(Planet.NEPTUNE.name(), 8)
        );
    }

    /**
     * Tests the {@link SolarSystemPlanetFinder#findPlanetNumberByName(String)} method with valid planet names.
     *
     * @param planetName the planet name to look up.
     * @param expected   the expected planet number for the given planet name.
     */
    @ParameterizedTest(name = "For planet name {0}, the planet number should be {1}")
    @MethodSource("validPlanetNameProvider")
    @DisplayName("Valid planet names")
    @SneakyThrows
    void testFindPlanetNumberByName(final String planetName, final int expected) {
        var actualOptional = findPlanetNumberByName(planetName);
        assertTrue(actualOptional.isPresent(), "Optional should not be empty");
        int actual = actualOptional.orElseThrow();

        assertEquals(expected, actual);
    }

    /**
     * Provides invalid planet names for parameterized testing.
     *
     * @return a {@link Stream} of {@link Arguments} containing invalid planet names.
     */
    static @NotNull Stream<Arguments> invalidPlanetNameProvider() {
        return Stream.of(
                Arguments.of("Pluto"),
                Arguments.of("PlanetX"),
                Arguments.of("InvalidName")
        );
    }

    /**
     * Tests the {@link SolarSystemPlanetFinder#findPlanetNumberByName(String)} method with invalid planet names.
     *
     * @param planetName the invalid planet name to test.
     */
    @ParameterizedTest(name = "Invalid planet name {0} should throw InvalidPlanetNameException")
    @MethodSource("invalidPlanetNameProvider")
    @DisplayName("Invalid planet names")
    void testInvalidPlanetNames(final String planetName) {
        assertThrows(InvalidPlanetNameException.class, () -> findPlanetNumberByName(planetName));
    }

    /**
     * Provides invalid planet numbers along with expected exception messages for parameterized testing.
     *
     * @return a {@link Stream} of {@link Arguments} containing invalid planet numbers and their expected exception messages.
     */
    static @NotNull Stream<Arguments> invalidPlanetNumberProviderWithMessage() {
        return Stream.of(
                Arguments.of(0, "Invalid planet number: 0. Must be between 1 and 8. "),
                Arguments.of(9, "Invalid planet number: 9. Must be between 1 and 8. "),
                Arguments.of(-1, "Invalid planet number: -1. Must be between 1 and 8. ")
        );
    }

    /**
     * Tests the {@link SolarSystemPlanetFinder#findPlanetByNumber(int)} method with invalid planet numbers,
     * checking both the exception type and the exception message.
     *
     * @param invalidPlanetNumber the invalid planet number to test.
     * @param expected the expected exception message.
     */
    @ParameterizedTest(name = "Invalid planet number {0} should throw InvalidPlanetNumberException")
    @MethodSource("invalidPlanetNumberProviderWithMessage")
    @DisplayName("Invalid planet numbers")
    void testInvalidPlanetNameExceptionMessage(final int invalidPlanetNumber, final String expected) {
        var actual = assertThrows(InvalidPlanetNumberException.class, () ->
                findPlanetByNumber(invalidPlanetNumber)).getMessage();

        assertEquals(expected, actual);
    }

    /**
     * Provides invalid planet names along with expected exception messages for parameterized testing.
     *
     * @return a {@link Stream} of {@link Arguments} containing invalid planet names and their expected exception messages.
     */
    static @NotNull Stream<Arguments> invalidPlanetNameProviderWithName() {
        return Stream.of(
                Arguments.of("Pluto", new InvalidPlanetNameException("Pluto").getMessage()),
                Arguments.of("Xyz", new InvalidPlanetNameException("Xyz").getMessage()),
                Arguments.of("", new InvalidPlanetNameException("").getMessage())
        );
    }

    /**
     * Tests the {@link SolarSystemPlanetFinder#findPlanetNumberByName(String)} method with invalid planet names,
     * checking both the exception type and the exception message.
     *
     * @param invalidPlanetName the invalid planet name to test.
     * @param expected the expected exception message.
     */
    @ParameterizedTest(name = "Invalid planet name {0} should throw InvalidPlanetNameException")
    @MethodSource("invalidPlanetNameProviderWithName")
    @DisplayName("Invalid planet names")
     void testInvalidPlanetNameExceptionMessage(final String invalidPlanetName, final String expected) {
        var exception = assertThrows(InvalidPlanetNameException.class,
                () -> SolarSystemPlanetFinder.findPlanetNumberByName(invalidPlanetName)).getMessage();

        assertEquals(expected, exception);
    }
}
