package com.it.academy.gk.sc0.operators.task8;

import com.it.academy.gk.sc0.operators.exception.InvalidPlanetNameException;
import com.it.academy.gk.sc0.operators.exception.InvalidPlanetNumberException;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Utility class for finding planets in the Solar System.
 *
 * <p>This class provides methods to find the name of a planet based on its number, and vice versa.</p>
 *
 * <p>Example usage:</p>
 * <pre>
 *     Optional<String> planetName = SolarSystemPlanetFinder.findPlanetByNumber(3);
 *     Optional<Integer> planetNumber = SolarSystemPlanetFinder.findPlanetNumberByName("Earth");
 * </pre>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
@UtilityClass
public final class SolarSystemPlanetFinder {
    /**
     * A HashMap containing the planet numbers as keys and their names as values.
     */
    private static final HashMap<Integer, String> planetByNumber = new HashMap<>();

    static {
        for (Planet planet : Planet.values()) {
            planetByNumber.put(planet.getNumber(), planet.name());
        }
    }

    /**
     * Finds the name of a planet based on its number.
     *
     * @param planetNumber The number of the planet.
     * @return An Optional containing the name of the planet, or an empty Optional if the planet number is invalid.
     */
    @SneakyThrows
    public static @NotNull Optional<String> findPlanetByNumber(final int planetNumber) {
        Optional<String> result = Optional.ofNullable(planetByNumber.get(planetNumber));

        if (result.isPresent()) {
            return result;
        } else {
            throw InvalidPlanetNumberException.createWith(planetNumber, planetByNumber.size());
        }
    }

    /**
     * Finds the number of a planet based on its name.
     *
     * @param planetName The name of the planet. The name is case-insensitive.
     * @return An Optional containing the number of the planet, or an empty Optional if the planet name is invalid.
     */
    @SneakyThrows
    public static @NotNull Optional<Integer> findPlanetNumberByName(final @NotNull String planetName) {
        for (Map.Entry<Integer, String> entry : planetByNumber.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(planetName)) {
                return Optional.of(entry.getKey());
            }
        }

        throw new InvalidPlanetNameException(planetName);
    }
}
