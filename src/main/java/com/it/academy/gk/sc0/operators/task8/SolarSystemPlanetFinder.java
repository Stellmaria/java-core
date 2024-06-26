package com.it.academy.gk.sc0.operators.task8;

import com.it.academy.gk.sc0.operators.task8.exception.InvalidPlanetNameException;
import com.it.academy.gk.sc0.operators.task8.exception.InvalidPlanetNumberException;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * A utility class for finding planets in the solar system by their number or name.
 * It uses a map to store planet numbers as keys and planet names as values for efficient lookup.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public final class SolarSystemPlanetFinder {
    /**
     * A map containing planet numbers as keys and planet names as values.
     * Initialized in the static block.
     */
    private static final Map<Integer, String> planetByNumber;

    static {
        var map = new HashMap<Integer, String>();

        for (Planet planet : Planet.values()) {
            map.put(planet.getNumber(), planet.name());
        }
        // Make the map unmodifiable to prevent accidental modifications
        planetByNumber = Collections.unmodifiableMap(map);
    }

    /**
     * Finds the planet name by its number.
     *
     * @param planetNumber The number of the planet.
     * @return An Optional containing the planet name if found, otherwise an empty Optional.
     * @throws InvalidPlanetNumberException If the planet number is invalid.
     */
    public static @NotNull Optional<String> findPlanetByNumber(final int planetNumber)
            throws InvalidPlanetNumberException {
        if (planetNumber < 1 || planetNumber > planetByNumber.size()) {
            throw InvalidPlanetNumberException.createWith(planetNumber, planetByNumber.size());
        }
        return Optional.ofNullable(planetByNumber.get(planetNumber));
    }

    /**
     * Finds the planet number by its name.
     *
     * @param planetName The name of the planet.
     * @return An Optional containing the planet number if found, otherwise an empty Optional.
     * @throws InvalidPlanetNameException If the planet name is invalid.
     */
    public static @NotNull Optional<Integer> findPlanetNumberByName(final String planetName)
            throws InvalidPlanetNameException {
        for (Map.Entry<Integer, String> entry : planetByNumber.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(planetName)) {
                return Optional.of(entry.getKey());
            }
        }
        throw new InvalidPlanetNameException(planetName);
    }
}
