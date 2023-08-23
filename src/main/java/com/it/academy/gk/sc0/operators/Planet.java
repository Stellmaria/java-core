package com.it.academy.gk.sc0.operators;

/**
 * Task 7: Print a planet's name in the Solar System by its ordinal number (the first planet is closest to the Sun).
 *
 * @author Anastasia Melnikova.
 */
public class Planet {
    /**
     * Error message returned when an invalid input is provided to getPlanetName method
     */
    private static final String INVALID_INPUT_ERROR_MESSAGE = "Invalid input. Please enter a valid " +
                                                              "planet number between 1 and 8.";

    /**
     * The name of the first planet in the Solar System, closest to the Sun.
     */
    private static final String MERCURY = "Mercury";

    /**
     * The name of the second planet in the Solar System.
     */
    private static final String VENUS = "Venus";

    /**
     * The name of the third planet in the Solar System.
     */
    private static final String EARTH = "Earth";

    /**
     * The name of the fourth planet in the Solar System.
     */
    private static final String MARS = "Mars";

    /**
     * The name of the fifth planet in the Solar System.
     */
    private static final String JUPITER = "Jupiter";

    /**
     * The name of the sixth planet in the Solar System.
     */
    private static final String SATURN = "Saturn";

    /**
     * The name of the seventh planet in the Solar System.
     */
    private static final String URANUS = "Uranus";

    /**
     * The name of the eighth planet in the Solar System, farthest from the Sun.
     */
    private static final String NEPTUNE = "Neptune";

    /**
     * The ordinal number representing the first planet in the Solar System, closest to the Sun.
     */
    private static final int FIRST_PLANET = 1;

    /**
     * The ordinal number representing the second planet in the Solar System.
     */
    private static final int SECOND_PLANET = 2;

    /**
     * The ordinal number representing the third planet in the Solar System.
     */
    private static final int THIRD_PLANET = 3;

    /**
     * The ordinal number representing the fourth planet in the Solar System.
     */
    private static final int FOURTH_PLANET = 4;

    /**
     * The ordinal number representing the fifth planet in the Solar System.
     */
    private static final int FIFTH_PLANET = 5;

    /**
     * The ordinal number representing the sixth planet in the Solar System.
     */
    private static final int SIXTH_PLANET = 6;

    /**
     * The ordinal number representing the seventh planet in the Solar System.
     */
    private static final int SEVENTH_PLANET = 7;

    /**
     * The ordinal number representing the eighth planet in the Solar System, farthest from the Sun.
     */
    private static final int EIGHTH_PLANET = 8;

    /**
     * Returns a string representation of a planet's name by its ordinal number
     * (the first planet is closest to the Sun).
     * <p/>
     * This method takes an integer representing a planet's ordinal number as an argument
     * and returns the corresponding planet's name.
     * The first planet is closest to the Sun, and the eighth planet is farthest from the Sun.
     * If the provided planet number is not between 1 and 8, this method returns an error message.
     *
     * @param planetNumber an integer representing a planet's ordinal number.
     * @return a string representation of a planet's name.
     */
    public String getPlanetName(final int planetNumber) {
        return switch (planetNumber) {
            case FIRST_PLANET -> MERCURY;
            case SECOND_PLANET -> VENUS;
            case THIRD_PLANET -> EARTH;
            case FOURTH_PLANET -> MARS;
            case FIFTH_PLANET -> JUPITER;
            case SIXTH_PLANET -> SATURN;
            case SEVENTH_PLANET -> URANUS;
            case EIGHTH_PLANET -> NEPTUNE;
            default -> INVALID_INPUT_ERROR_MESSAGE;
        };
    }
}
