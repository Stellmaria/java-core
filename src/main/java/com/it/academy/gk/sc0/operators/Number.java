package com.it.academy.gk.sc0.operators;

import com.it.academy.gk.sc0.operators.util.Const;

import java.util.Arrays;

/**
 * <h3>RU: Типы данных. Переменные. Операторы. Методы.</h3>
 *
 * <h3>EN: Data types. Variables. Operators. Methods.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Number {
    /**
     * <h4>RU: Задание 1.</h4>
     * <p>Напишите программу, которая считывает три числа и выводит их сумму.</p><br>
     *
     * <h4>EN: Task 1.</h4>
     * <p>Write a program that reads three numbers and prints their sum.</p><br>
     *
     * @param values числа / numbers.
     * @return сумма чисел / sum of numbers.
     */
    public Integer getSum(final int... values) {
        return Arrays.stream(values).sum();
    }

    /**
     * <h4>RU: Задание 4.</h4>
     * <p>Дано двузначное и трехзначное число. Для каждого выведите сумму.</p><br>
     *
     * <h4>EN: Task 4.</h4>
     * <p>Given a two-digit and a three-digit number. For each print the sum and the product of the digits.</p><br>
     *
     * @param value число / number.
     * @return сумма цифр числа/sum of digits.
     */
    public Integer getSumNumbers(final Integer value) {
        var sum = 0;
        var digit = value;

        while (digit != 0) {
            sum += (digit % Const.MINIMAL_TWO_DIGITAL_NUMBER);
            digit /= Const.MINIMAL_TWO_DIGITAL_NUMBER;
        }
        return sum;
    }

    /**
     * <h4>RU: Задание 4.</h4>
     * <p>Дано двузначное и трехзначное число. Для каждого выведите произведение чисел.</p><br>
     *
     * <h4>EN: Task 4.</h4>
     * <p>Given a two-digit and a three-digit number. For each print the product of numbers.</p><br>
     *
     * @param value число / number.
     * @return произведение цифр числа/product of digits.
     */
    public Integer getMultiplicationNumber(final Integer value) {
        int sum = 1;
        int digit = value;

        while (digit != 0) {
            sum *= (digit % Const.MINIMAL_TWO_DIGITAL_NUMBER);
            digit /= Const.MINIMAL_TWO_DIGITAL_NUMBER;
        }

        return sum;
    }
}
