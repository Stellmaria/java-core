package com.it.academy.gk.sc0.operators.task8;

/**
 * This enum represents the eight planets in our solar system.
 * Each planet is associated with a unique number.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@SuppressWarnings("LombokGetterMayBeUsed")
enum Planet {
    /**
     * Mercury is the smallest planet in our solar system.
     */
    MERCURY(1),

    /**
     * Venus is the second planet from the Sun.
     */
    VENUS(2),

    /**
     * Earth is the third planet from the Sun and the only known celestial body to support life.
     */
    EARTH(3),

    /**
     * Mars is the fourth planet from the Sun.
     */
    MARS(4),

    /**
     * Jupiter is the fifth planet from the Sun.
     */
    JUPITER(5),

    /**
     * Saturn is the sixth planet from the Sun.
     */
    SATURN(6),

    /**
     * Uranus is the seventh planet from the Sun.
     */
    URANUS(7),

    /**
     * Neptune is the eighth and farthest known planet from the Sun.
     */
    NEPTUNE(8);

    /**
     * The unique number associated with each planet.
     */
    private final int number;

    /**
     * Constructor for Planet enum.
     *
     * @param number The unique number associated with the planet.
     */
    Planet(int number) {
        this.number = number;
    }

    /**
     * Getter for the unique number associated with the planet.
     *
     * @return The unique number associated with the planet.
     */
    public int getNumber() {
        return number;
    }
}
