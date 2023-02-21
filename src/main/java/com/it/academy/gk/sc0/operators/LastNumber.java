package com.it.academy.gk.sc0.operators;

import com.it.academy.gk.sc0.operators.util.Const;

/**
 * <h3>RU: Типы данных. Переменные. Операторы. Методы.</h3>
 *
 * <h3>EN: Data types. Variables. Operators. Methods.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class LastNumber {
    /**
     * <h4>RU: Задание 9.</h4>
     * <p>Дано число, например, 12345. Проверьте, что последней цифрой этого числа является цифра 1, 2 или 3.
     * Если это так - выведите 'да', в противном случае выведите 'нет'.</p><br>
     *
     * <h4>EN: Task 9.</h4>
     * <p>Given a number, for example 12345. Check that the last digit of this number is 1, 2 or 3. If so, print 'yes',
     * otherwise print 'no'.</p><br>
     *
     * @param number получаемое число / received number.
     * @return если последняя цифра 1 или 2 или 3 то ответ да, иначе нет /
     * if the last digit is 1 or 2 or 3 then the answer is yes, otherwise no.
     */
    public boolean checkNumber(final long number) {
        final var remainder = number % Const.MINIMAL_TWO_DIGITAL_NUMBER;

        return 1 <= remainder && remainder <= 3;
    }
}
