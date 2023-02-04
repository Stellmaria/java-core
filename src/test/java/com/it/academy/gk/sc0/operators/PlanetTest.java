package com.it.academy.gk.sc0.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Planet.")
class PlanetTest {
    private Planet planet;

    @BeforeEach
    void init() {
        planet = new Planet();
    }

    static @NotNull Stream<Arguments> planetNumberProviderArguments() {
        return Stream.of(
                Arguments.of("Mercury.", 1),
                Arguments.of("Venus.", 2),
                Arguments.of("Earth.", 3),
                Arguments.of("Mars.", 4),
                Arguments.of("Jupiter.", 5),
                Arguments.of("Saturn.", 6),
                Arguments.of("Uranium.", 7),
                Arguments.of("Neptune.", 8),
                Arguments.of("There is no planet with this number.", 0),
                Arguments.of("There is no planet with this number.", -1)
        );
    }

    @ParameterizedTest(name = "Planet name {0} - {1}")
    @MethodSource("planetNumberProviderArguments")
    @DisplayName("Test for method getNamePlanet() from class Planet.")
    void getNamePlanet(String expected, int number) {
        var actual = planet.getNamePlanet(number);

        assertEquals(expected, actual);
    }
}