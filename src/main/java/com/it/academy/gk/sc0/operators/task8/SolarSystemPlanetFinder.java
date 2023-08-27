package com.it.academy.gk.sc0.operators.task8;

import com.it.academy.gk.sc0.operators.exception.InvalidPlanetNameException;
import com.it.academy.gk.sc0.operators.exception.InvalidPlanetNumberException;

/**
 * The SolarSystemPlanetFinder class provides a method to find the name of a planet in the Solar System given its number.
 */
public class SolarSystemPlanetFinder {
    /**
     * An array of planet names in the Solar System, in order from the Sun.
     */
    private final String[] planetNames = {
            "Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"
    };

    /**
     * Finds the name of a planet in the Solar System given its number.
     *
     * @param planetNumber the number of the planet, where 1 is the closest to the Sun
     * @return the name of the planet
     * @throws InvalidPlanetNumberException if the given planet number is not between 1 and the total number of planets in the Solar System
     */
    public String findPlanetByNumber(final int planetNumber) throws InvalidPlanetNumberException {
        validatePlanetNumber(planetNumber);

        return planetNames[planetNumber - 1];
    }

    /**
     * Finds the number of a planet in the Solar System given its name.
     *
     * @param planetName the name of the planet
     * @return the number of the planet, where 1 is the closest to the Sun
     * @throws InvalidPlanetNameException if the given planet name is not a valid planet name in the Solar System
     */
    public int findPlanetNumberByName(final String planetName) throws InvalidPlanetNameException {
        for (int i = 0; i < planetNames.length; i++) {
            if (planetNames[i].equals(planetName)) {
                return i + 1;
            }
        }
        throw new InvalidPlanetNameException(planetName);
    }

    /**
     * Validates the given planet number to ensure that it is between 1 and the total number of planets in the Solar System.
     *
     * @param planetNumber the planet number to be validated
     * @throws InvalidPlanetNumberException if the given planet number is not between 1 and the total number of planets in the Solar System
     */
    private void validatePlanetNumber(final int planetNumber) throws InvalidPlanetNumberException {
        if (planetNumber < 1 || planetNumber > planetNames.length) {
            throw InvalidPlanetNumberException.createWith(planetNumber, planetNames.length);
        }
    }
}
