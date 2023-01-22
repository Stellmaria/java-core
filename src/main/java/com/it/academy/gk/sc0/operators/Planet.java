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
        String result;

        switch (number) {
            case 1:
                result = "Меркурий.";
                break;
            case 2:
                result = "Венера.";
                break;
            case 3:
                result = "Земля.";
                break;
            case 4:
                result = "Марс.";
                break;
            case 5:
                result = "Юпитер.";
                break;
            case 6:
                result = "Сатурн.";
                break;
            case 7:
                result = "Уран.";
                break;
            case 8:
                result = "Нептун.";
                break;
            default:
                result = "Планеты с таким номером не существует.";
                break;
        }
        return result;
    }
}
