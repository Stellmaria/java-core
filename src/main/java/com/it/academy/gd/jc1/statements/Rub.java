package com.it.academy.gd.jc1.statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Rub {
    /**
     * <h4>RU: Задание 1.</h4>
     * <p>Задать целое число в виде переменной, это число - сумма денег в рублях. Вывести это число на экран,
     * добавив к нему слово "рублей" в правильном падеже.</p><br>
     *
     * <h4>EN: Task 1.</h4>
     * <p>Set an integer as a variable, this number is the amount of money in rubles.
     * Display this number with the Russian word for rubles in the correct grammatical form.</p><br>
     *
     * @param sum начальная сумма / initial amount.
     * @return сумма с правильным падежом / amount with the correct grammatical form.
     */
    public String getSum(final int sum) {
        if (sum < 0) {
            return "Некорректная сумма " + sum;
        }

        final int lastTwoDigits = sum % 100;
        final int lastDigit = sum % 10;
        final String suffix;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            suffix = " рублей.";
        } else if (lastDigit == 1) {
            suffix = " рубль.";
        } else if (lastDigit >= 2 && lastDigit <= 4) {
            suffix = " рубля.";
        } else {
            suffix = " рублей.";
        }

        return sum + suffix;
    }
}
