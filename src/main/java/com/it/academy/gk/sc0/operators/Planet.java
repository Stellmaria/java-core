package com.it.academy.gk.sc0.operators;

public class Planet {
    /**
     * The name of the first planet in the Solar System, closest to the Sun.
     */
    public static final String MERCURY = "Mercury";
    /**
     * The name of the second planet in the Solar System.
     */
    public static final String VENUS = "Venus";
    /**
     * The name of the third planet in the Solar System.
     */
    public static final String EARTH = "Earth";
    /**
     * The name of the fourth planet in the Solar System.
     */
    public static final String MARS = "Mars";
    /**
     * The name of the fifth planet in the Solar System.
     */
    public static final String JUPITER = "Jupiter";
    /**
     * The name of the sixth planet in the Solar System.
     */
    public static final String SATURN = "Saturn";
    /**
     * The name of the seventh planet in the Solar System.
     */
    public static final String URANUS = "Uranus";
    /**
     * The name of the eighth planet in the Solar System, farthest from the Sun.
     */
    public static final String NEPTUNE = "Neptune";

    /**
     * The ordinal number representing the first planet in the Solar System, closest to the Sun.
     */
    public static final int FIRST_PLANET = 1;
    /**
     * The ordinal number representing the second planet in the Solar System.
     */
    public static final int SECOND_PLANET = 2;
    /**
     * The ordinal number representing the third planet in the Solar System.
     */
    public static final int THIRD_PLANET = 3;
    /**
     * The ordinal number representing the fourth planet in the Solar System.
     */
    public static final int FOURTH_PLANET = 4;
    /**
     * The ordinal number representing the fifth planet in the Solar System.
     */
    public static final int FIFTH_PLANET = 5;
    /**
     * The ordinal number representing the sixth planet in the Solar System.
     */
    public static final int SIXTH_PLANET = 6;
    /**
     * The ordinal number representing the seventh planet in the Solar System.
     */
    public static final int SEVENTH_PLANET = 7;
    /**
     * The ordinal number representing the eighth planet in the Solar System, farthest from the Sun.
     */
    public static final int EIGHTH_PLANET = 8;

    /**
     * Error message returned when an invalid input is provided to getPlanetName method
     */
    public static final String INVALID_INPUT_ERROR_MESSAGE = "Invalid input. Please enter a valid " +
                                                             "planet number between 1 and 8.";

    /**
     * Task 7: Print a planet's name in the Solar System by its ordinal number (the first planet is closest to the Sun).
     * <p>
     * Returns a planet's name in the Solar System based on its ordinal number.
     * <p>
     * This method takes an integer representing a planet's ordinal number in the Solar System,
     * where `FIRST_PLANET` represents the first planet (closest to Sun) and `EIGHTH_PLANET` represents
     * the eighth planet (farthest from Sun).
     * It returns a string representing that ordinal number's corresponding
     * planet's name.
     * <p>
     * If the input ordinal number is not between `FIRST_PLANET` and `EIGHTH_PLANET` (inclusively),
     * this method returns an error message indicating that an invalid input was provided.
     *
     * @param planetNumber A planet's ordinal number in the Solar System.
     * @return That ordinal number's corresponding planet's name, or an error message if input is invalid.
     */
    public String getPlanetName(int planetNumber) {
        if (planetNumber == FIRST_PLANET) {
            return MERCURY;
        } else if (planetNumber == SECOND_PLANET) {
            return VENUS;
        } else if (planetNumber == THIRD_PLANET) {
            return EARTH;
        } else if (planetNumber == FOURTH_PLANET) {
            return MARS;
        } else if (planetNumber == FIFTH_PLANET) {
            return JUPITER;
        } else if (planetNumber == SIXTH_PLANET) {
            return SATURN;
        } else if (planetNumber == SEVENTH_PLANET) {
            return URANUS;
        } else if (planetNumber == EIGHTH_PLANET) {
            return NEPTUNE;
        } else {
            return INVALID_INPUT_ERROR_MESSAGE;
        }
    }
}
