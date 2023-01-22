package com.it.academy.gk.sc0.operators;

import com.it.academy.gk.sc0.operators.util.Const;

/**
 * <h3>RU: Типы данных. Переменные. Операторы. Методы.</h3>
 *
 * <h3>EN: Data types. Variables. Operators. Methods.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Moon {
    private static final Integer GRAVITY_ON_THE_MOON = 17;

    /**
     * <h4>RU: Задание 6.</h4>
     * <p>Сила тяжести на Луне составляет около 17% земной.
     * Напишите программу, которая вычислила бы ваш вес на Луне.</p><br>
     *
     * <h4>EN: Task 6.</h4>
     * <p>The force of gravity on the Moon is about 17% of Earth's.
     * Write a program that would calculate your weight on the moon.</p><br>
     *
     * @param weight земной вес / weight on earth.
     * @return вес на луне / weight on the moon.
     */
    public Double getWeight(Double weight) {
        return weight - (weight / Const.MAX_PERCENTAGE * GRAVITY_ON_THE_MOON);
    }
}
