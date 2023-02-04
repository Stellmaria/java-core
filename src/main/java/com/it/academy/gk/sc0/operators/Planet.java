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
     * <p>RU: Инициализируем переменную текстом ответа. Соответствует планете с номером 1.</p>
     *
     * <p>EN: We initialize the variable with the response text. Corresponds to planet number 1.</p>
     */
    private static final String MERCURY = "Mercury.";

    /**
     * <p>RU: Инициализируем переменную текстом ответа. Соответствует планете с номером 2.</p>
     *
     * <p>EN: We initialize the variable with the response text. Corresponds to planet number 2.</p>
     */
    private static final String VENUS = "Venus.";

    /**
     * <p>RU: Инициализируем переменную текстом ответа. Соответствует планете с номером 3.</p>
     *
     * <p>EN: We initialize the variable with the response text. Corresponds to planet number 3.</p>
     */
    private static final String EARTH = "Earth.";

    /**
     * <p>RU: Инициализируем переменную текстом ответа. Соответствует планете с номером 4.</p>
     *
     * <p>EN: We initialize the variable with the response text. Corresponds to planet number 4.</p>
     */
    private static final String MARS = "Mars.";

    /**
     * <p>RU: Инициализируем переменную текстом ответа. Соответствует планете с номером 5.</p>
     *
     * <p>EN: We initialize the variable with the response text. Corresponds to planet number 5.</p>
     */
    private static final String JUPITER = "Jupiter.";

    /**
     * <p>RU: Инициализируем переменную текстом ответа. Соответствует планете с номером 6.</p>
     *
     * <p>EN: We initialize the variable with the response text. Corresponds to planet number 6.</p>
     */
    private static final String SATURN = "Saturn.";

    /**
     * <p>RU: Инициализируем переменную текстом ответа. Соответствует планете с номером 7.</p>
     *
     * <p>EN: We initialize the variable with the response text. Corresponds to planet number 7.</p>
     */
    private static final String URANIUM = "Uranium.";

    /**
     * <p>RU: Инициализируем переменную текстом ответа. Соответствует планете с номером 8.</p>
     *
     * <p>EN: We initialize the variable with the response text. Corresponds to planet number 8.</p>
     */
    private static final String NEPTUNE = "Neptune.";

    /**
     * <p>RU: Инициализируем переменную текстом ответа. Соответствует планете с номером <9.</p>
     *
     * <p>EN: We initialize the variable with the response text. Corresponds to planet number <9.</p>
     */
    private static final String ERROR = "There is no planet with this number.";

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
        switch (number) {
            case 1:
                return MERCURY;
            case 2:
                return VENUS;
            case 3:
                return EARTH;
            case 4:
                return MARS;
            case 5:
                return JUPITER;
            case 6:
                return SATURN;
            case 7:
                return URANIUM;
            case 8:
                return NEPTUNE;
            default:
                return ERROR;
        }
    }
}
