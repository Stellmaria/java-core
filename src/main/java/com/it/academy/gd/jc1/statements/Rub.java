package com.it.academy.gd.jc1.statements;

import com.it.academy.gk.sc0.operators.util.Const;

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
     * добавив к нему слово "рублей в правильном падеже".</p><br>
     *
     * <h4>EN: Task 1.</h4>
     * <p>Set an integer as a variable, this number is the amount of money in rubles.
     * Display this number on the screen, adding the word "rubles in the correct case" to it.</p><br>
     *
     * @param sum начальная сумма / initial amount
     * @return сумма с правильным падежом / amount with the correct case.
     */
    public String getSum(final int sum) {
        final var rubles = " рублей.";
        final var rubel = " рубль.";
        final var rubel1 = " рубля.";
        final var error = "Некорректная сумма ";
        final var stringBuilder = new StringBuilder();
        final var remainder10 = sum % Const.MINIMAL_TWO_DIGITAL_NUMBER * Const.MINIMAL_TWO_DIGITAL_NUMBER;
        final var remainder100 = sum % Const.MINIMAL_TWO_DIGITAL_NUMBER;

        // TODO:
        if (remainder10 == 0 || (5 <= remainder10 && remainder10 <= 9)
            || (11 <= remainder100 && remainder100 <= 19)) {
            stringBuilder.append(sum)
                    .append(rubles);
        } else if (remainder100 == 1) {
            stringBuilder.append(sum)
                    .append(rubel);
        } else if (2 <= remainder100 && remainder100 <= 4) {
            stringBuilder.append(sum)
                    .append(rubel1);
        } else {
            stringBuilder.append(error)
                    .append(sum);
        }
        return stringBuilder.toString();
    }
}
