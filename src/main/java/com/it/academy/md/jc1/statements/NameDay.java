package com.it.academy.md.jc1.statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class NameDay {
    /**
     * <h4>RU: Задание 4.</h4>
     * <p>Возвращает название дня недели, в зависимости от его порядкового номера.</p><br>
     * <p>Разработать программу для desktop приложения которая преобразует номер дня недели
     * в его словесный аналог.</p><br>
     *
     * <h4>EN: Task 4.</h4>
     * <p>Develop a program for a desktop application that converts the number of the day
     * of the week into its verbal counterpart.</p>
     * <p>Returns the name of the day of the week, depending on its ordinal number.</p><br>
     *
     * @param dayOfWeekNumber номер дня недели / day of the week number.
     * @return день недели на английском языке (UPPER CASE) / day of the week in English (UPPER CASE).
     */
    public String getDayOfWeekNumber(final int dayOfWeekNumber) {
        final var monday = "MONDAY";
        final var tuesday = "TUESDAY";
        final var wednesday = "WEDNESDAY";
        final var thursday = "THURSDAY";
        final var friday = "FRIDAY";
        final var saturday = "SATURDAY";
        final var sunday = "SUNDAY";

        return switch (dayOfWeekNumber) {
            case 1 -> monday;
            case 2 -> tuesday;
            case 3 -> wednesday;
            case 4 -> thursday;
            case 5 -> friday;
            case 6 -> saturday;
            case 7 -> sunday;
            default -> null;
        };
    }
}
