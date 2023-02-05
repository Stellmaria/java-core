package com.it.academy.md.jc1.decision_making_statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Fuel {
    /**
     * <h4>RU: Задание 10.</h4>
     * <p>Разработать программу для сети АЗС.</p>
     * <p>Программа вычисляет на какую АЗС необходимо доставить топливо в первую очередь.</p>
     * <p>Программа вычисляет на какую АЗС необходимо доставить топливо в первую очередь.
     * Если количество запасов топлива наименьшее на нескольких АЗС,
     * то вывести первую АЗС в порядке возрастания номера АЗС.
     * Например: если на всех заправках одинаковое количество, то вернуть <code>1</code>.</p><br>
     *
     * <h4>EN: Task 10.</h4>
     * <p>Develop a program for a network of gas stations.</p>
     * <p>The program calculates to which gas station it is necessary to deliver fuel in the first place.</p>
     * <p>The program calculates to which gas station it is necessary to deliver fuel in the first place.
     * <p>If the amount of fuel reserves is the smallest at several gas stations,
     * then display the first gas station in ascending order of the gas station number.
     * For example: if all gas stations have the same quantity, then return <code>1</code>.</p><br>
     *
     * @param firstFuelReserves  запасы топлива на первой заправке / fuel reserves at the first refueling.
     * @param secondFuelReserves запасы топлива на второй заправке / fuel reserves at the second refueling.
     * @param thirdFuelReserves  запасы топлива на третьей заправке / fuel reserves at the third refueling.
     * @return номер заправки / filling number..
     */
    public int getNumberStation(final int firstFuelReserves, final int secondFuelReserves,
                                final int thirdFuelReserves) {
        final var first = 1;
        final var second = 2;
        final var third = 3;

        if (firstFuelReserves <= secondFuelReserves && firstFuelReserves <= thirdFuelReserves) {
            return first;
        } else if (secondFuelReserves < firstFuelReserves && secondFuelReserves <= thirdFuelReserves) {
            return second;
        } else {
            return third;
        }
    }
}
