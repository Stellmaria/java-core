package com.it.academy.gk.sc0.operators.task8;

/**
 * Enum representing the planets in the Solar System.
 * Each planet is assigned a unique number starting from one (Mercury) to eight (Neptune).
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
@SuppressWarnings("LombokGetterMayBeUsed")
enum Planet {
    /**
     * Mercury is the first planet from the Sun and the closest to it.
     */
    MERCURY(1),

    /**
     * Venus is the second planet from the Sun.
     */
    VENUS(2),

    /**
     * Earth is the third planet from the Sun and the only known to harbor life.
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

    private final int number;

    /**
     * Constructor to initialize the unique number for each planet.
     *
     * @param number The unique number for the planet. It should be a positive integer starting from 1.
     *               Each planet is assigned a unique number in this range.
     */
    Planet(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
