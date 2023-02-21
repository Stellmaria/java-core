package com.it.academy.gd.jc1.operators;

/**
 * <h3>RU: Типы данных. Переменные. Операторы. Методы.</h3>
 *
 * <h3>EN: Data types. Variables. Operators. Methods.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Variables {
    /**
     * <h4>RU: Задание 3.</h4>
     * <p>Написать код, который выведет значения переменных на экран.</p><br>
     *
     * <h4>EN: Task 3.</h4>
     * <p>Write code that displays the values of variables on the screen.</p><br>
     *
     * @return строка с переменными / line with variables.
     */
    public String getVariable() {
        final byte b = 0x55;
        final short s = 0x55ff;
        final var i = 1_000_000;
        final var l = 0xffffffffL;
        final var c = 'a';
        final var f = 0.25F;
        final var d = 0.00001234;
        final var boll = true;
        final var tb = "\n";

        return String.valueOf(b) + tb + s + tb + i + tb + l + tb + c + tb + f + tb + d + tb + boll;
    }
}
