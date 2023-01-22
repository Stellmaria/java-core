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
     * Дано число, например, 12345.
     * Проверьте, что последней цифрой этого числа
     * является цифра 1, 2 или 3.
     * Если это так - выведите 'да',
     * в противном случае выведите 'нет'.
     */
    public String checkNumber(final long a) {
        String result = null;

        if ((a % Const.MINIMAL_TWO_DIGITAL_NUMBER == 1)
                || (a % Const.MINIMAL_TWO_DIGITAL_NUMBER == 2)
                || (a % Const.MINIMAL_TWO_DIGITAL_NUMBER == 3)) {
            result = "Yes.";
        } else {
            result = "No.";
        }
        return result;
    }
}
