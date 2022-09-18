package com.it.academy.gk.sc0.operators;

/**
 * <p>RU: Типы данных. Переменные. Операторы. Методы.</p>
 * <p>EN: Data types. Variables. Operators. Methods.</p>
 *
 * @author Anastasia Melnikova.
 */
public class Apples {
    /**
     * <p>RU: N школьников делят k яблок поровну,
     * неделящийся остаток остается в корзинке. </p>
     * <ul>
     *     <li>Сколько яблок достанется каждому школьнику? </li>
     *     <li>Сколько яблок останется в корзинке? </li>
     * </ul>
     * <p>Программа получает на вход числа n и k
     * и должна вывести искомое количество яблок (два числа).</p>
     * <p>EN: N schoolchildren divide k apples equally,
     * the non-divisible remainder remains in the basket. </p>
     * <ul>
     *      <li>How many apples will each student get? </li>
     *      <li>How many apples will be left in the basket? </li>
     * </ul>
     * <p>The program receives the numbers n and k
     * as input and should output the desired
     * number of apples (two numbers).</p>
     *
     * @param student количество студентов/number of students.
     * @param apples  начальное количество яблок/starting number of apples.
     * @return количество яблок для каждого студента/number of apples
     * for each student.
     */

    public String getApples(final int student, final int apples) {
        return String.format(
                "Students will receive: %d%nThe basket will contain: %d",
                calculateAppealsForStudent(student, apples),
                calculateRemainingApples(student, apples));
    }

    /**
     * <p>RU: Посчитывает остаток яблок в корзине</p>
     * <p>EN: Calculates the remaining apples in the basket.</p>
     *
     * @param student количество студентов/number of students.
     * @param apples  начальное количество яблок/starting number of apples.
     * @return the number of apples.
     */
    private int calculateRemainingApples(final int student, final int apples) {
        return apples % student;
    }

    /**
     * <p>RU: Подсчитывает количество яблок для каждого ученика.</p>
     * <p>EN: Calculates the number of apples for each student.</p>
     *
     * @param student количество студентов/number of students.
     * @param apples  начальное количество яблок/starting number of apples.
     * @return the number of apples.
     */
    private int calculateAppealsForStudent(final int student,
                                           final int apples) {
        return apples / student;
    }
}
