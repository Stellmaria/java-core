package com.it.academy.md.jc1.statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Month {
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
        final var january = "JANUARY";
        final var february = "FEBRUARY";
        final var march = "MARCH";
        final var april = "APRIL";
        final var may = "MAY";
        final var june = "JUNE";
        final var july = "JULY";
        final var august = "AUGUST";
        final var september = "SEPTEMBER";
        final var october = "OCTOBER";
        final var november = "NOVEMBER";
        final var december = "DECEMBER";

        return switch (monthNumber) {
            case 1 -> january;
            case 2 -> february;
            case 3 -> march;
            case 4 -> april;
            case 5 -> may;
            case 6 -> june;
            case 7 -> july;
            case 8 -> august;
            case 9 -> september;
            case 10 -> october;
            case 11 -> november;
            case 12 -> december;
            default -> null;
        };
    }
}
