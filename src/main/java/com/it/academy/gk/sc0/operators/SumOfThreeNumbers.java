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
     * This method takes three numbers as arguments and returns their sum.
     *
     * @param a the first number
     * @param b the second number
     * @param c the third number
     * @return the sum of the three numbers
     */
    public int sum(int a, int b, int c) {
        return a + b + c;
    }

    /**
     * This method calculates the sum of a two-digit number's digits.
     * <p>
     * It takes in an integer representing a two-digit number and returns an integer representing
     * its digits' sum. The calculation is done by dividing the input number by `BASE` (10)
     * to get the tenth digit, and taking the remainder of the input number divided by `BASE` to get
     * the unit digit. The sum is then calculated by adding these two digits together.
     *
     * @param num A two-digit integer.
     * @return The input number's digits' sum.
     */
    public int sumOfTwoDigitNumber(int num) {
        return num / BASE + num % BASE;
    }

    /**
     * This method calculates the sum of a three-digit number's digits.
     * <p>
     * It takes in an integer representing a three-digit number and returns an integer representing
     * its digits' sum. The calculation is done by dividing the input number by `HUNDREDS_PLACE`
     * (100) to get the hundredth digit, dividing the input number by `TENS_PLACE` (10) and taking
     * the remainder when divided by `BASE` (10) to get the tenth digit, and taking the remainder
     * of the input number divided by `BASE` to get the unit digit. The sum is then calculated by
     * adding these three digits together.
     *
     * @param num A three-digit integer.
     * @return The input number's digits' sum.
     */
    public int sumOfThreeDigitNumber(int num) {
        return num / HUNDREDS_PLACE + (num / TENS_PLACE) % BASE + num % BASE;
    }
}
