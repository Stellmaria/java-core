package com.it.academy.gd.jc1.statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Radius {
    /**
     * <h4>RU: Задание 7.</h4>
     * <p>Имеется прямоугольное отверстие размерами a и b, где a и b – целые числа. Определить,
     * можно ли его полностью закрыть круглой картонкой радиусом r (тоже целое число).</p><br>
     *
     * <h4>EN: Task 7.</h4>
     * <p>There is a rectangular hole with dimensions a and b, where a and b are integers.
     * Determine whether it can be completely covered with a round cardboard of radius r (also an integer).</p><br>
     *
     * @param width  ширина отверстия / hole width.
     * @param length длина отверстия / hole length.
     * @param radius радиус картонки / carton radius.
     * @return если можно то <code>true</code>, нельзя <code>false</code> /
     * if possible then <code>true</code>, not <code>false</code>.
     */
    public boolean isClosed(final int width, final int length, final int radius) {
        return radius * radius >= (width * width + length * length) / 4;
    }
}
