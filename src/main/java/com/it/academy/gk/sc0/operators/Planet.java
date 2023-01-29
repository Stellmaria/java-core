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
     * <p>RU: Инициализируем переменную текстом ответа. Соответствует планете с номером 1.</p><br>
     *
     * <p>EN: We initialize the variable with the response text. Corresponds to planet number 1.</p>
     */
    private static final String MERCURY = "Mercury.";

    /**
     * <p>RU: Инициализируем переменную текстом ответа. Соответствует планете с номером 2.</p><br>
     *
     * <p>EN: We initialize the variable with the response text. Corresponds to planet number 2.</p>
     */
    private static final String VENUS = "Venus.";

    /**
     * <p>RU: Инициализируем переменную текстом ответа. Соответствует планете с номером 3.</p><br>
     *
     * <p>EN: We initialize the variable with the response text. Corresponds to planet number 3.</p>
     */
    private static final String EARTH = "Earth.";

    /**
     * <p>RU: Инициализируем переменную текстом ответа. Соответствует планете с номером 4.</p><br>
     *
     * <p>EN: We initialize the variable with the response text. Corresponds to planet number 4.</p>
     */
    private static final String MARS = "Mars.";

    /**
     * <p>RU: Инициализируем переменную текстом ответа. Соответствует планете с номером 5.</p><br>
     *
     * <p>EN: We initialize the variable with the response text. Corresponds to planet number 5.</p>
     */
    private static final String JUPITER = "Jupiter.";

    /**
     * <p>RU: Инициализируем переменную текстом ответа. Соответствует планете с номером 6.</p><br>
     *
     * <p>EN: We initialize the variable with the response text. Corresponds to planet number 6.</p>
     */
    private static final String SATURN = "Saturn.";

    /**
     * <p>RU: Инициализируем переменную текстом ответа. Соответствует планете с номером 7.</p><br>
     *
     * <p>EN: We initialize the variable with the response text. Corresponds to planet number 7.</p>
     */
    private static final String URANIUM = "Uranium.";

    /**
     * <p>RU: Инициализируем переменную текстом ответа. Соответствует планете с номером 8.</p><br>
     *
     * <p>EN: We initialize the variable with the response text. Corresponds to planet number 8.</p>
     */
    private static final String NEPTUNE = "Neptune.";

    /**
     * <p>RU: Инициализируем переменную текстом ответа. Соответствует планете с номером <9.</p><br>
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
        String result;

        switch (number) {
            case 1:
                result = MERCURY;
                break;
            case 2:
                result = VENUS;
                break;
            case 3:
                result = EARTH;
                break;
            case 4:
                result = MARS;
                break;
            case 5:
                result = JUPITER;
                break;
            case 6:
                result = SATURN;
                break;
            case 7:
                result = URANIUM;
                break;
            case 8:
                result = NEPTUNE;
                break;
            default:
                result = ERROR;
        }

        return result;
    }
}
