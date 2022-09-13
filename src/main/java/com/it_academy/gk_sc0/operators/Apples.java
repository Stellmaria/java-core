package com.it_academy.gk_sc0.operators;

/**
 * <p>RU: Типы данных. Переменные. Операторы. Методы.</p>
 * <p>EN: Data types. Variables. Operators. Methods.</p>
 *
 * @author Anastasia Melnikova.
 */
public class Apples {
    /**
     * RU:
     * <p>N школьников делят k яблок поровну, неделящийся остаток остается в корзинке. </p>
     * <ul>
     *     <li>Сколько яблок достанется каждому школьнику? </li>
     *     <li>Сколько яблок останется в корзинке? </li>
     * </ul>
     * <p>Программа получает на вход числа n и k и должна вывести искомое количество яблок (два числа).</p>
     * <p>EN:</p>
     * <p>N schoolchildren divide k apples equally, the non-divisible remainder remains in the basket. </p>
     * <ul>
     *      <li>How many apples will each student get? </li>
     *      <li>How many apples will be left in the basket? </li>
     * </ul>
     * <p>The program receives the numbers n and k as input and should output the desired
     * number of apples (two numbers).</p>
     *
     * @param student количество студентов.
     * @param apples  начальное количество яблок.
     * @return количество яблок для каждого студента.
     */

    public String getApples(int student, int apples) {
        return String.format("Students will receive: %d%nThe basket will contain: %d",
                calculateAppealsForStudent(student, apples), calculateRemainingApples(student, apples));
    }

    /**
     * RU:
     * <p>Посчитывает остаток яблок в корзине</p>
     * <p>EN:</p>
     * <p>Calculates the remaining apples in the basket.</p>
     *
     * @return the number of apples.
     */
    private int calculateRemainingApples(int student, int apples) {
        return apples % student;
    }

    /**
     * RU:
     * <p>Подсчитывает количество яблок для каждого ученика.</p>
     * <p>EN:</p>
     * <p>Calculates the number of apples for each student.</p>
     *
     * @return the number of apples.
     */
    private int calculateAppealsForStudent(int student, int apples) {
        return apples / student;
    }
}
