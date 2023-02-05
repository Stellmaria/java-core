package com.it.academy.gd.jc1.operators;

import static java.lang.String.format;

/**
 * <h3>RU: Типы данных. Переменные. Операторы. Методы.</h3>
 *
 * <h3>EN: Data types. Variables. Operators. Methods.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Summation {
    /**
     * <h4>RU: Задание 4.</h4>
     * <p>Написать метод, который принимает на вход два целых числа, делает их суммирование и
     * складывает результат с произведением двух этих чисел, и возвращает полученный результат из метода.
     * Передать на вход в метод любые два числа. Вывести полученный результат работы метода на экран.</p><br>
     *
     * <h4>EN: Task 4.</h4>
     * <p>Write a method that takes two integers as input, sums them up and adds the result to the product
     * of these two numbers, and returns the result from the method. Pass any two numbers to the method input.
     * Display the result of the method on the screen.</p><br>
     *
     * @param firstNumber  первое число / first number.
     * @param secondNumber второе число / second number.
     * @return результат сложения и умножения двух чисел / the result of adding and multiplying two numbers.
     */
    public String sumMul(final int firstNumber, final int secondNumber) {
        final var answer = "Answer : ";

        return format("%s%d", answer, add(firstNumber, secondNumber) + (mul(firstNumber, secondNumber)));
    }

    /**
     * <p>RU: Значение минимального двузначного числа.</p>
     *
     * <p>EN: The value of the minimum two-digit number.</p>
     *
     * @param firstNumber  первое число / first number.
     * @param secondNumber второе число / second number.
     * @return результат сложения двух чисел / the result of adding two numbers.
     */
    private int add(final int firstNumber, final int secondNumber) {
        return firstNumber + secondNumber;
    }

    /**
     * <p>RU: Значение минимального двузначного числа.</p>
     *
     * <p>EN: The value of the minimum two-digit number.</p>
     *
     * @param firstNumber  первое число / first number.
     * @param secondNumber второе число / second number.
     * @return результат умножения двух чисел / result of multiplying two numbers.
     */
    private int mul(final int firstNumber, final int secondNumber) {
        return firstNumber * secondNumber;
    }
}
