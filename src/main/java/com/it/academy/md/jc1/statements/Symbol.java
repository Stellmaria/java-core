package com.it.academy.md.jc1.statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Symbol {
    /**
     * <h4>RU: Задание 11.</h4>
     * <p>Разработать программу для desktop приложения.</p>
     * <p>Необходимо определить, какие символы вводит пользователь:</p>
     * <ul>
     *      <li>латиница</li>
     *      <li>кириллица</li>
     *      <li>цифра</li>
     *      <li>специальный символ</li>
     * </ul>
     * <p>Так же программа не должна зависеть от регистра.</p>
     * <p>Определяет к какому типу относится данный символ.</p><br>
     *
     * <h4>EN: Task 11.</h4>
     * <p>Develop a program for a desktop application.</p>
     * <p>It is necessary to determine what characters the user enters:</p>
     * <ul>
     *      <li>latin</li>
     *      <li>cyrillic</li>
     *      <li>digit</li>
     *      <li>special character</li>
     * </ul>
     * <p>Also, the program should not be case sensitive.</p>
     * <p>Determines what type the given character belongs to.</p><br>
     *
     * @param symbol символ / symbol.
     * @return <code>латиница</code>/<code>кириллица</code>/<code>цифра</code>/<code>не определено</code>/
     * <code>latin</code>/<code>cyrillic</code>/<code>digit</code>/<code>undefined</code>
     */
//    public String getSymbolType(final char symbol) {
//        final var minDigit = '0';
//        final var maxDigit = '9';
//        final var minLatin = 'A';
//        final var maxLatin = 'Z';
//        final var minLatinA = 'a';
//        final var maxLatinZ = 'z';
//        final var minCyrillic = 'А';
//        final var maxCyrillic = 'Я';
//        final var minCyrillicA = 'а';
//        final var maxCyrillicZ = 'я';
//        final var digit = "digit";
//        final var latin = "latin";
//        final var cyrillic = "cyrillic";
//        final var undefined = "undefined";
//
//        if ((minDigit <= symbol) && (symbol <= maxDigit)) {
//            return digit;
//        } else if ((minLatin <= symbol) && (symbol <= maxLatin)) {
//            return latin;
//        } else if ((minLatinA <= symbol) && (symbol <= maxLatinZ)) {
//            return latin;
//        } else if ((minCyrillic <= symbol) && (symbol <= maxCyrillic)) {
//            return cyrillic;
//        } else if ((minCyrillicA <= symbol) && (symbol <= maxCyrillicZ)) {
//            return cyrillic;
//        } else {
//            return undefined;
//        }
//    }
}
