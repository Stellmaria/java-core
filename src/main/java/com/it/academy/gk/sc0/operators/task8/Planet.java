package com.it.academy.gk.sc0.operators.task8;

import lombok.Getter;

/**
 * Enum representing the planets in the Solar System.
 * Each planet is assigned a unique number starting from one (Mercury) to eight (Neptune).
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
@Getter
enum Planet {
    MERCURY(1),
    VENUS(2),
    EARTH(3),
    MARS(4),
    JUPITER(5),
    SATURN(6),
    URANUS(7),
    NEPTUNE(8);

    private final int number;

    /**
     * Constructor to initialize the unique number for each planet.
     *
     * @param number The unique number for the planet.
     */
    Planet(int number) {
        this.number = number;
    }
}
