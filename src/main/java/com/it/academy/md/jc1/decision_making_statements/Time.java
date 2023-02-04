package com.it.academy.md.jc1.decision_making_statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Time {
    /**
     * <h4>RU: Задание 2.</h4>
     * <p>Разработать программу для desktop приложения которая выведет приветствие для пользователя
     * в зависимости от времени суток.</p><br>
     *
     * <h4>EN: Task 2.</h4>
     * <p>Develop a program for a desktop application that will display a greeting for the user depending
     * on the time of day.</p><br>
     *
     * @param hour текущее значение часов (от 0 до 23) / current hour value (from 0 to 23).
     * @return одно из приветствий / one of the greetings:
     * <ul>
     *     <li>когда 6-11 это "Доброе утро" / when 6-11 that 'Good morning'.</li>
     *     <li>когда 12-17 то "Добрый день" / when 12-17 that 'Good day'.</li>
     *     <li>когда 18-23 то "Добрый вечер" / when 18-23 that 'Good evening'.</li>
     *     <li>когда 0-5 это "Доброй ночи"/ when 0-5 that 'Good night'.</li>
     * </ul>
     */
    public String getGreetingByHour(final int hour) {
        final var goodNight = "Good night";
        final var goodMorning = "Good morning";
        final var goodDay = "Good day";
        final var goodEvening = "Good evening";

        final var goodMorningHour = 6;
        final var noonHour = 12;
        final var goodEveningHour = 18;
        final var midnight = 24;

        if (hour >= 0 && hour <= goodMorningHour - 1) {
            return goodNight;
        } else if (hour >= goodMorningHour && hour <= noonHour - 1) {
            return goodMorning;
        } else if (hour >= noonHour && hour <= goodEveningHour - 1) {
            return goodDay;
        } else if (hour >= goodEveningHour && hour <= midnight - 1) {
            return goodEvening;
        } else {
            return null;
        }
    }
}
