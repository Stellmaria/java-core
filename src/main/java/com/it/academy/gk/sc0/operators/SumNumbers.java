package com.it.academy.gk.sc0.operators;

import com.it.academy.gk.sc0.operators.util.Const;

/**
 * <p>RU: Типы данных. Переменные. Операторы. Методы.</p>
 * <p>EN: Data types. Variables. Operators. Methods.</p>
 *
 * @author Anastasia Melnikova.
 */
public class SumNumbers {
    /**
     * <p>RU: Дано двузначное и трехзначное число.
     * Для каждого выведите сумму.</p>
     * <p>EN : Given a two-digit and a three-digit number.
     * For each print the sum and the product of the digits.</p>
     *
     * @param value число/number.
     * @return сумма цифр числа/sum of digits.
     */
    public int getSumNumbers(final int value) {
        int sum = 0;
        int digit = value;

        while (digit != 0) {
            sum += (digit % Const.MINIMAL_TWO_DIGITAL_NUMBER);
            digit /= Const.MINIMAL_TWO_DIGITAL_NUMBER;
        }
        return sum;
    }

    /**
     * <p>RU: Дано двузначное и трехзначное число.
     * Для каждого выведите произведение чисел.</p>
     * <p>EN : Given a two-digit and a three-digit number.
     * For each print the product of numbers..</p>
     *
     * @param value число/number.
     * @return произведение цифр числа/product of digits.
     */
    public int getMultiplicationNumber(final int value) {
        int sum = 1;
        int digit = value;

        while (digit != 0) {
            sum *= (digit % Const.MINIMAL_TWO_DIGITAL_NUMBER);
            digit /= Const.MINIMAL_TWO_DIGITAL_NUMBER;
        }
        return sum;
    }
}
