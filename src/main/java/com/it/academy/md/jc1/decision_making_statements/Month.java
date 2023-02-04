package com.it.academy.md.jc1.decision_making_statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Month {
    /**
     * <p>RU: Значение месяца под номером 1.</p>
     *
     * <p>EN: The value of the month at number 1.</p>
     */
    private static final String JANUARY = "JANUARY";

    /**
     * <p>RU: Значение месяца под номером 2.</p>
     *
     * <p>EN: The value of the month at number 2.</p>
     */
    private static final String FEBRUARY = "FEBRUARY";

    /**
     * <p>RU: Значение месяца под номером 3.</p>
     *
     * <p>EN: The value of the month at number 3.</p>
     */
    private static final String MARCH = "MARCH";

    /**
     * <p>RU: Значение месяца под номером 4.</p>
     *
     * <p>EN: The value of the month at number 4.</p>
     */
    private static final String APRIL = "APRIL";

    /**
     * <p>RU: Значение месяца под номером 5.</p>
     *
     * <p>EN: The value of the month at number 5.</p>
     */
    private static final String MAY = "MAY";

    /**
     * <p>RU: Значение месяца под номером 6.</p>
     *
     * <p>EN: The value of the month at number 6.</p>
     */
    private static final String JUNE = "JUNE";

    /**
     * <p>RU: Значение месяца под номером 7.</p>
     *
     * <p>EN: The value of the month at number 7.</p>
     */
    private static final String JULY = "JULY";

    /**
     * <p>RU: Значение месяца под номером 8.</p>
     *
     * <p>EN: The value of the month at number 8.</p>
     */
    private static final String AUGUST = "AUGUST";

    /**
     * <p>RU: Значение месяца под номером 9.</p>
     *
     * <p>EN: The value of the month at number 9.</p>
     */
    private static final String SEPTEMBER = "SEPTEMBER";

    /**
     * <p>RU: Значение месяца под номером 10.</p>
     *
     * <p>EN: The value of the month at number 10.</p>
     */
    private static final String OCTOBER = "OCTOBER";

    /**
     * <p>RU: Значение месяца под номером 11.</p>
     *
     * <p>EN: The value of the month at number 11.</p>
     */
    private static final String NOVEMBER = "NOVEMBER";

    /**
     * <p>RU: Значение месяца под номером 12.</p>
     *
     * <p>EN: The value of the month at number 12.</p>
     */
    private static final String DECEMBER = "DECEMBER";

    /**
     * <h4>RU: Задание 5.</h4>
     * <p>Разработать программу для игрового движка.</p>
     * <p>Игрок при регистрации вводит свою дату рождения и она хранится в формате 'dd/MM/yyyy'.
     * В профиле игрока необходимо месяц выводить не в числовом формате, а в текстовом.
     * Определить название месяца в зависимости от номера.</p>
     * <p>Возвращает название месяца, в зависимости от его порядкового номера.</p><br>
     *
     * <h4>EN: Task 5.</h4>
     * <p>Develop a program for the game engine.</p>
     * <p>When registering, the player enters his date of birth and it is stored in the format 'ddMMyyyy'.
     * In the player's profile, the month must be displayed not in numerical format, but in text.
     * Get the name of the month depending on the number.</p>
     * <p>Returns the name of the month, depending on its ordinal number.</p><br>
     *
     * @param monthNumber номер месяца / month number.
     * @return месяц на английском языке (UPPER CASE) / month in English (UPPER CASE).
     */
    public String getMonthName(final int monthNumber) {
        switch (monthNumber) {
            case 1:
                return JANUARY;
            case 2:
                return FEBRUARY;
            case 3:
                return MARCH;
            case 4:
                return APRIL;
            case 5:
                return MAY;
            case 6:
                return JUNE;
            case 7:
                return JULY;
            case 8:
                return AUGUST;
            case 9:
                return SEPTEMBER;
            case 10:
                return OCTOBER;
            case 11:
                return NOVEMBER;
            case 12:
                return DECEMBER;
            default:
                return null;
        }
    }
}
