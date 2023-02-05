package com.it.academy.md.jc1.decision_making_statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class LeapYear {
    /**
     * <h4>RU: задание 7.</h4>
     * <p>Разработать программу для desktop приложения.</p>
     * <p>Определить является ли год високосным. Распределение високосных годов происходит следующим образом:</p>
     * <ul>
     *     <li>год, номер которого кратен 400, — високосный</li>
     *     <li>другие года, номера которых кратны 100, — невисокосные</li>
     *     <li>другие года, номер которых кратен 4, — високосные</li>
     *     <li>остальные года — невисокосные</li>
     * </ul>
     * <p>Определяет является ли год високосным.</p><br>
     *
     * <h4>EN: task 7.</h4>
     * <p>Determine if the year is a leap year. The distribution of leap years is as follows:</p>
     * <p>Determine if the year is a leap year. The distribution of leap years is as follows:</p>
     * <ul>
     *     <li>a year that is a multiple of 400 is a leap year</li>
     *     <li>other years whose numbers are multiples of 100 are non-leap years.</li>
     *     <li>other years whose number is a multiple of 4 are leap years.</li>
     *     <li>other years are non-leap years.</li>
     * </ul>
     * <p>Determines whether a year is a leap year.</p><br>
     *
     * @param year год / year.
     * @return <code>ложь</code>/<code>истина</code> / <code>false</code>/<code>true</code>.
     */
    public boolean isLeapYear(final int year) {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}
