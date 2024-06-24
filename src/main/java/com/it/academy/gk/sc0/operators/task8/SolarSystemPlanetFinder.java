package com.it.academy.gk.sc0.operators.task8;

import com.it.academy.gk.sc0.operators.exception.InvalidPlanetNameException;
import com.it.academy.gk.sc0.operators.exception.InvalidPlanetNumberException;
import lombok.experimental.UtilityClass;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
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
 *     // planetName: Optional["Earth"]
 *
 *     Optional<Integer> planetNumber = SolarSystemPlanetFinder.findPlanetNumberByName("Earth");
 *     // planetNumber: Optional[3]
 * </pre>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
@UtilityClass
public final class SolarSystemPlanetFinder {
    /**
     * A Map containing the planet numbers as keys and their names as values.
     */
    private static final Map<Integer, String> planetByNumber;

    static {
        var map = new HashMap<Integer, String>();

        for (Planet planet : Planet.values()) {
            map.put(planet.getNumber(), planet.name());
        }

        planetByNumber = Collections.unmodifiableMap(map);
    }

    /**
     * Finds the name of a planet based on its number.
     * <p>
     * Example:
     * <pre>
     *     Optional<String> planetName = SolarSystemPlanetFinder.findPlanetByNumber(3);
     *     // planetName: Optional["Earth"]
     * </pre>
     *
     * @param planetNumber The number of the planet.
     * @return An Optional containing the name of the planet, or an empty Optional if the planet number is invalid.
     */
    public static @NotNull Optional<String> findPlanetByNumber(final int planetNumber)
            throws InvalidPlanetNumberException {
        var planetName = planetByNumber.get(planetNumber);

        if (planetName != null) {
            return Optional.of(planetName);
        } else {
            throw InvalidPlanetNumberException.createWith(planetNumber, planetByNumber.size());
        }
    }

    /**
     * Finds the number of a planet based on its name.
     * <p>
     * Example:
     * <pre>
     *     Optional<Integer> planetNumber = SolarSystemPlanetFinder.findPlanetNumberByName("Earth");
     *     // planetNumber: Optional[3]
     * </pre>
     *
     * @param planetName The name of the planet. The name is case-insensitive.
     * @return An Optional containing the number of the planet, or an empty Optional if the planet name is invalid.
     */
    public static @NotNull Optional<Integer> findPlanetNumberByName(final @NotNull String planetName)
            throws InvalidPlanetNameException {
        for (Map.Entry<Integer, String> entry : planetByNumber.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(planetName)) {
                return Optional.of(entry.getKey());
            }
        }

        throw new InvalidPlanetNameException(planetName);
    }
}
