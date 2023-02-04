package com.it.academy.gk.sc0.operators;

import com.it.academy.md.jc1.operators.util.Const;

/**
 * <h3>RU: Типы данных. Переменные. Операторы. Методы.</h3>
 *
 * <h3>EN: Data types. Variables. Operators. Methods.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Time {
    /**
     * <h4>RU: Задание 5.</h4>
     * <p>С начала суток прошло m минут. Определить: целое количество часов, прошедших с начала суток.</p><br>
     *
     * <h4>EN: Task 5.</h4>
     * <p>N minutes have passed since the beginning of the day.
     * Define: an integer number of hours that have passed since the beginning of the day.</p><br>
     *
     * @param value минуты / minutes.
     * @return количество часов / number of hours.
     */
    public int getHour(final int value) {
        return value / Const.MINUTES_IN_HOURS;
    }

    /**
     * <h4>RU: Задание 5.</h4>
     * <p>С начала суток прошло m минут.
     * Определить количество минут, прошедших с момента начала последнего часа.</p><br>
     *
     * <h4>EN: Task 5.</h4>
     * <p>N minutes have passed since the beginning of the day.
     * Determine the number of minutes that have passed since the beginning of the last hour.</p><br>
     *
     * @param value минуты / minutes.
     * @return количество минут / number of minutes.
     */
    public int getMinute(final int value) {
        return value % Const.MINUTES_IN_HOURS;
    }
}
