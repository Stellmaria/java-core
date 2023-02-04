package com.it.academy.md.jc1.decision_making_statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class NameDay {
    /**
     * <p>RU: Значение дня недели под номером 1.</p>
     *
     * <p>EN: The value of the day of the week at number 1</p>
     */
    private static final String MONDAY = "MONDAY";

    /**
     * <p>RU: Значение дня недели под номером 2.</p>
     *
     * <p>EN: The value of the day of the week at number 2.</p>
     */
    private static final String TUESDAY = "TUESDAY";

    /**
     * <p>RU: Значение дня недели под номером 3.</p>
     *
     * <p>EN: The value of the day of the week at number 3.</p>
     */
    private static final String WEDNESDAY = "WEDNESDAY";

    /**
     * <p>RU: Значение дня недели под номером 4.</p>
     *
     * <p>EN: The value of the day of the week at number 4.</p>
     */
    private static final String THURSDAY = "THURSDAY";

    /**
     * <p>RU: Значение дня недели под номером 5.</p>
     *
     * <p>EN: The value of the day of the week at number 5.</p>
     */
    private static final String FRIDAY = "FRIDAY";

    /**
     * <p>RU: Значение дня недели под номером 6.</p>
     *
     * <p>EN: The value of the day of the week at number 6.</p>
     */
    private static final String SATURDAY = "SATURDAY";

    /**
     * <p>RU: Значение дня недели под номером 7.</p>
     *
     * <p>EN: The value of the day of the week at number 7.</p>
     */
    private static final String SUNDAY = "SUNDAY";

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
        switch (dayOfWeekNumber) {
            case 1:
                return MONDAY;
            case 2:
                return TUESDAY;
            case 3:
                return WEDNESDAY;
            case 4:
                return THURSDAY;
            case 5:
                return FRIDAY;
            case 6:
                return SATURDAY;
            case 7:
                return SUNDAY;
            default:
                return null;
        }
    }
}
