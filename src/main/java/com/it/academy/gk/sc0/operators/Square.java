package com.it.academy.gk.sc0.operators;

/**
 * <h3>RU: Типы данных. Переменные. Операторы. Методы.</h3>
 *
 * <h3>EN: Data types. Variables. Operators. Methods.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Square {
    /**
     * <h4>RU: Задание 2.</h4>
     * <p> Напишите программу, которая считывает длины двух катетов
     * в прямоугольном треугольнике и выводит его площадь.</p><br>
     *
     * <h4>EN: Task 2.</h4>
     * <p>Write a program that reads the lengths of two side in a right triangle and prints its area.</p><br>
     *
     * @param a первый катет / first side.
     * @param b второй катет / second side.
     * @return площадь прямоугольного треугольника.
     */
    public double getSquare(final double a, final double b) {
        return (a * b) / 2.0;
    }
}
