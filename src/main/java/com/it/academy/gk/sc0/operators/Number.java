package com.it.academy.gk.sc0.operators;

import java.util.Arrays;

/**
 * <p>RU: Типы данных. Переменные. Операторы. Методы.</p>
 * <p>EN: Data types. Variables. Operators. Methods.</p>
 *
 * @author Anastasia Melnikova.
 */
public class Number {
    /**
     * <p>RU: Напишите программу, которая считывает три числа и выводит их сумму.</p>
     * <p>EN: Write a program that reads three numbers and prints their sum.</p>
     *
     * @param values numbers.
     * @return sum of numbers.
     */
    public int getSum(int... values) {
        return Arrays.stream(values).sum();
    }
}
