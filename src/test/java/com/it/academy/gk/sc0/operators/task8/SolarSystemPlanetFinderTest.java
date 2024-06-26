package com.it.academy.gk.sc0.operators.task8;

import com.it.academy.gk.sc0.operators.task8.exception.InvalidPlanetNameException;
import com.it.academy.gk.sc0.operators.task8.exception.InvalidPlanetNumberException;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static com.it.academy.gk.sc0.operators.task8.SolarSystemPlanetFinder.findPlanetByNumber;
import static com.it.academy.gk.sc0.operators.task8.SolarSystemPlanetFinder.findPlanetNumberByName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolarSystemPlanetFinderTest {
    private static String getStaticFieldValue(String fieldName) throws NoSuchFieldException, IllegalAccessException {
        var field = InvalidPlanetNumberException.class.getDeclaredField(fieldName);
        field.setAccessible(true);

        return (String) field.get(null);
    }

    static @NotNull Stream<Arguments> invalidPlanetNumberProviderWithMessage() throws Exception {
        var invalidPlanetNumber = getStaticFieldValue("INVALID_PLANET_NUMBER_PREFIX");
        var mustBeBetween1And = getStaticFieldValue("MUST_BE_BETWEEN_1_AND");
        var dot = getStaticFieldValue("DOT");
        var totalPlanets = Planet.values().length;

        return Stream.of(
                Arguments.of(0, String.format(
                                "%s%d%s%s%s%d%s",
                                invalidPlanetNumber, 0, dot, " ", mustBeBetween1And, totalPlanets, dot
                        )
                ),
                Arguments.of(
                        9,
                        String.format(
                                "%s%d%s%s%s%d%s",
                                invalidPlanetNumber, 9, dot, " ", mustBeBetween1And, totalPlanets, dot
                        )
                ),
                Arguments.of(
                        -1,
                        String.format(
                                "%s%d%s%s%s%d%s",
                                invalidPlanetNumber, -1, dot, " ", mustBeBetween1And, totalPlanets, dot
                        )
                )
        );
    }

    @ParameterizedTest(name = "Invalid planet number {0} should throw InvalidPlanetNumberException")
    @MethodSource("invalidPlanetNumberProviderWithMessage")
    @DisplayName("Invalid planet numbers")
    void testInvalidPlanetNameExceptionMessage(final int invalidPlanetNumber, final String expected) {
        var actual = assertThrows(
                InvalidPlanetNumberException.class, () -> findPlanetByNumber(invalidPlanetNumber)
        ).getMessage();

        assertEquals(expected, actual);
    }

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

    @ParameterizedTest(name = "For planet number {0}, the planet name should be {1}")
    @MethodSource("validPlanetNumberProvider")
    @DisplayName("Valid planet numbers")
    void testFindPlanetByNumber(final int planetNumber, final String expected) throws InvalidPlanetNumberException {
        var actualOptional = findPlanetByNumber(planetNumber);
        assertTrue(actualOptional.isPresent());

        var actual = actualOptional.orElseThrow();

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> invalidPlanetNumberProvider() {
        return Stream.of(
                Arguments.of(0),
                Arguments.of(9),
                Arguments.of(-1)
        );
    }

    @ParameterizedTest(name = "Invalid planet number {0} should throw InvalidPlanetNumberException")
    @MethodSource("invalidPlanetNumberProvider")
    @DisplayName("Invalid planet numbers")
    void testInvalidPlanetNumbers(final int planetNumber) {
        assertThrows(InvalidPlanetNumberException.class, () -> findPlanetByNumber(planetNumber));
    }

    @ParameterizedTest(name = "Extremely invalid planet number {0} should throw InvalidPlanetNumberException")
    @ValueSource(ints = {Integer.MIN_VALUE, Integer.MAX_VALUE})
    @DisplayName("Extremely invalid planet numbers")
    void testExtremelyInvalidPlanetNumbers(final int planetNumber) {
        assertThrows(InvalidPlanetNumberException.class, () -> findPlanetByNumber(planetNumber));
    }

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

    @ParameterizedTest(name = "For planet name {0}, the planet number should be {1}")
    @MethodSource("validPlanetNameProvider")
    @DisplayName("Valid planet names")
    void testFindPlanetNumberByName(final String planetName, final int expected) throws InvalidPlanetNameException {
        var actualOptional = findPlanetNumberByName(planetName);
        assertTrue(actualOptional.isPresent());

        var actual = actualOptional.orElseThrow();

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> invalidPlanetNameProvider() {
        return Stream.of(
                Arguments.of("Pluto"),
                Arguments.of("PlanetX"),
                Arguments.of("InvalidName")
        );
    }

    @ParameterizedTest(name = "Invalid planet name {0} should throw InvalidPlanetNameException")
    @MethodSource("invalidPlanetNameProvider")
    @DisplayName("Invalid planet names")
    void testInvalidPlanetNames(final String planetName) {
        assertThrows(InvalidPlanetNameException.class, () -> findPlanetNumberByName(planetName));
    }

    static @NotNull Stream<Arguments> invalidPlanetNameProviderWithName() {
        return Stream.of(
                Arguments.of("Pluto", new InvalidPlanetNameException("Pluto").getMessage()),
                Arguments.of("Xyz", new InvalidPlanetNameException("Xyz").getMessage()),
                Arguments.of("", new InvalidPlanetNameException("").getMessage())
        );
    }

    @ParameterizedTest(name = "Invalid planet name {0} should throw InvalidPlanetNameException")
    @MethodSource("invalidPlanetNameProviderWithName")
    @DisplayName("Invalid planet names")
    void testInvalidPlanetNameExceptionMessage(final String invalidPlanetName, final String expected) {
        var exception = assertThrows(InvalidPlanetNameException.class, () -> findPlanetNumberByName(invalidPlanetName))
                .getMessage();

        assertEquals(expected, exception);
    }

    static @NotNull Stream<Arguments> extremelyInvalidPlanetNameProvider() {
        return Stream.of(
                Arguments.of((String) null),
                Arguments.of("   "),
                Arguments.of("\t\n")
        );
    }

    @ParameterizedTest(name = "Extremely invalid planet name {0} should throw InvalidPlanetNameException")
    @MethodSource("extremelyInvalidPlanetNameProvider")
    @DisplayName("Extremely invalid planet names")
    void testExtremelyInvalidPlanetNames(final String planetName) {
        assertThrows(InvalidPlanetNameException.class, () -> findPlanetNumberByName(planetName));
    }
}
