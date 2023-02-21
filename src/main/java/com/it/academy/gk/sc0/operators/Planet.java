package com.it.academy.gk.sc0.operators;

/**
 * <h3>RU: Типы данных. Переменные. Операторы. Методы.</h3>
 *
 * <h3>EN: Data types. Variables. Operators. Methods.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Planet {
    /**
     * <h4>RU: Задание 8.</h4>
     * <p>Выведите название планеты солнечной системы по ее порядковому номеру
     * (первая планета – самая близкая к солнцу).</p><br>
     *
     * <h4>EN: Task 7.</h4>
     * <p>Print the name of the planet of the solar system
     * by its serial number (the first planet is the closest to the sun).</p><br>
     *
     * @param number номер планеты / planet number.
     * @return название планеты / planet name.
     */
    public String getNamePlanet(final int number) {
        final var mercury = "Mercury.";
        final var venus = "Venus.";
        final var earth = "Earth.";
        final var mars = "Mars.";
        final var jupiter = "Jupiter.";
        final var saturn = "Saturn.";
        final var uranium = "Uranium.";
        final var neptune = "Neptune.";

        return switch (number) {
            case 1 -> mercury;
            case 2 -> venus;
            case 3 -> earth;
            case 4 -> mars;
            case 5 -> jupiter;
            case 6 -> saturn;
            case 7 -> uranium;
            case 8 -> neptune;
            default -> null;
        };
    }
}
