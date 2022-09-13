package com.it_academy.gk_sc0.operators;

/**
 * <p>RU: Типы данных. Переменные. Операторы. Методы.</p>
 * <p>EN: Data types. Variables. Operators. Methods.</p>
 *
 * @author Anastasia Melnikova.
 */
public class Square {
    /**
     * RU:
     * <p>Напишите программу, которая считывает длины двух катетов
     * в прямоугольном треугольнике и выводит его площадь.</p>
     * <p>EN:</p>
     * <p>Write a program that reads the lengths of two side in a right triangle and prints its area.</p>
     *
     * @param a первый катет/first side.
     * @param b второй катет/second side.
     * @return площадь прямоугольного треугольника.
     */
    public double getSquare(double a, double b) {
        return (a * b) / 2.0;
    }
}
