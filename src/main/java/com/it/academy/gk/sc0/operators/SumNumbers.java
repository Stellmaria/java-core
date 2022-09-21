package com.it.academy.gk.sc0.operators;

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
    public int getSumNumbers(int value) {
        int sum = 0;
        while (value != 0) {
            sum += (value % 10);
            value /= 10;
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
    public int getMultiplicationNumber(int value) {
        int sum = 1;
        while (value != 0) {
            sum *= (value % 10);
            value /= 10;
        }
        return sum;
    }
}
