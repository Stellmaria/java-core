package com.it.academy.gd.jc1.statements;

import com.it.academy.md.jc1.statements.LeapYear;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
@AllArgsConstructor
public class Date {
    // TODO:
    /**
     *
     */
    private static final String COLON = ":";

    // TODO:
    /**
     *
     */
    private final LeapYear leapYear = new LeapYear();

    /**
     * <h4>RU: Задание 9.</h4>
     * <p>Задать три числа - день, месяц, год. Вывести на экран в виде трех чисел дату следующего дня.</p><br>
     *
     * <h4>EN: Task 9.</h4>
     * <p>Set three numbers - day, month, year. Display the date of the next day as three numbers.</p><br>
     *
     * @param day   текущий день / this day.
     * @param month текущий месяц / current month.
     * @param year  текущий год / this year.
     * @return новая дата / new date.
     */
    public String getNextMonth(int day, int month, int year) {
        final var leap = leapYear.isLeapYear(year);
        final var stringBuilder = new StringBuilder();

        // TODO:
        if (day == 28 || day == 29 && month == 2 && leap) {
            getNextMonth(month, year, stringBuilder);
        } else if (day == 31 &&
                   month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10) {
            getNextMonth(month, year, stringBuilder);
        } else if (day == 31 && month == 12) {
            day = 1;
            month = 1;
            year++;

            stringBuilder.append(day)
                    .append(COLON)
                    .append(month)
                    .append(COLON)
                    .append(year);
        } else {
            day++;

            stringBuilder.append(day)
                    .append(COLON)
                    .append(month)
                    .append(COLON)
                    .append(year);
        }
        return stringBuilder.toString();
    }

    /**
     * <p>RU: Обнуление месяца.</p>
     *
     * <p>EN: Resetting the month.</p>
     *
     * @param month         текущий месяц / current month.
     * @param year          текущий год / this year.
     * @param stringBuilder для выведения результата / to get the result.
     */
    private void getNextMonth(int month, int year, final @NotNull StringBuilder stringBuilder) {
        final var day = 1;

        month++;

        stringBuilder.append(day)
                .append(COLON)
                .append(month)
                .append(COLON)
                .append(year);
    }
}
