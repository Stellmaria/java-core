package com.it.academy.gk.sc0.operators;

/**
 * Task 1: Write a program that reads three numbers and prints their sum.
 * Task 4: Given a two-digit and a three-digit number. For each print the sum of the digits.
 */
public class SumOfThreeNumbers {
    /**
     * The base of the decimal number system, used for arithmetic operations and number representation.
     */
    private static final int BASE = 10;

    /**
     * The place value of the hundredth digit in a three-digit number.
     */
    private static final int HUNDREDS_PLACE = 100;

    /**
     * The place value of the tenth digit in a two- or three-digit number.
     */
    private static final int TENS_PLACE = 10;

    /**
     * Calculates the sum of three numbers.
     * <p/>
     * This method takes three integer arguments `a`, `b`, and `c`, and returns their sum.
     * The sum is calculated by adding the three numbers together using the `+` operator.
     *
     * @param a the first number.
     * @param b the second number.
     * @param c the third number.
     * @return the sum of a, b, and c.
     */
    public int sum(final int a, final int b, final int c) {
        return a + b + c;
    }

    /**
     * Calculates the sum of the digits of a two-digit number.
     * <p/>
     * This method takes a two-digit integer `num` as an argument and returns the sum of its digits.
     * The sum is calculated by dividing `num` by the base of the decimal number system (10) to get the ten digits,
     * and finding the remainder when dividing `num` by the base to get the one's digit.
     * These two digits are then added together using the `+` operator.
     *
     * @param num a two-digit number.
     * @return the sum of the digits of num.
     */
    public int sumOfTwoDigitNumber(final int num) {
        return num / BASE + num % BASE;
    }

    /**
     * Calculates the sum of the digits of a three-digit number.
     * <p/>
     * This method takes a three-digit integer `num` as an argument and returns the sum of its digits.
     * The sum is calculated by dividing `num` by the place value of the hundredth digit (100)
     * to get the hundreds digit, dividing `num` by the place value of the tenth digit (10) and finding the remainder
     * when dividing by the base to get the tens digit, and finding the remainder when dividing `num`
     * by the base to get the one digit.
     * These three digits are then added together using the `+` operator.
     *
     * @param num a three-digit number.
     * @return the sum of the digits of num.
     */
    public int sumOfThreeDigitNumber(final int num) {
        return num / HUNDREDS_PLACE + (num / TENS_PLACE) % BASE + num % BASE;
    }
}
