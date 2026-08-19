package com.it.academy.gd.jc1.statements;

import com.it.academy.md.jc1.statements.LeapYear;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Date {
    private static final String COLON = ":";

    private final LeapYear leapYear = new LeapYear();

    /**
     * <h4>RU: Задание 9.</h4>
     * <p>Задать три числа - день, месяц, год. Вывести дату следующего дня.</p><br>
     *
     * <h4>EN: Task 9.</h4>
     * <p>Set three numbers - day, month and year. Return the date of the next day.</p><br>
     *
     * @param day   текущий день / current day.
     * @param month текущий месяц / current month.
     * @param year  текущий год / current year.
     * @return следующая дата в формате day:month:year / next date in day:month:year format.
     */
    public String getNextDay(final int day, final int month, final int year) {
        validateDate(day, month, year);

        final int daysInMonth = getDaysInMonth(month, year);
        if (day < daysInMonth) {
            return formatDate(day + 1, month, year);
        }
        if (month == 12) {
            return formatDate(1, 1, year + 1);
        }
        return formatDate(1, month + 1, year);
    }

    /**
     * Compatibility method retained for the original exercise API.
     *
     * @param day   current day.
     * @param month current month.
     * @param year  current year.
     * @return next date.
     */
    public String getNextMonth(final int day, final int month, final int year) {
        return getNextDay(day, month, year);
    }

    private int getDaysInMonth(final int month, final int year) {
        switch (month) {
            case 2:
                return leapYear.isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    private void validateDate(final int day, final int month, final int year) {
        if (year <= 0) {
            throw new IllegalArgumentException("Year must be positive");
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be between 1 and 12");
        }

        final int daysInMonth = getDaysInMonth(month, year);
        if (day < 1 || day > daysInMonth) {
            throw new IllegalArgumentException("Day is out of range for the specified month");
        }
    }

    private String formatDate(final int day, final int month, final int year) {
        return day + COLON + month + COLON + year;
    }
}
