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

        switch (number) {
            case 1:
                return mercury;
            case 2:
                return venus;
            case 3:
                return earth;
            case 4:
                return mars;
            case 5:
                return jupiter;
            case 6:
                return saturn;
            case 7:
                return uranium;
            case 8:
                return neptune;
            default:
                return null;
        }
    }
}
