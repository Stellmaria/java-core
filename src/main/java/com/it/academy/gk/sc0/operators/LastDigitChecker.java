package com.it.academy.gk.sc0.operators;

/**
 * Task 9.
 * Given a number, for example, 12345. Check that the last digit of this number is 1, 2 or 3.
 * If so, print 'yes,' otherwise print 'no.'
 */
public record LastDigitChecker(int number) {
    /**
     * The base used to calculate the last digit of the number.
     */
    private static final int BASE = 10;

    /**
     * The first valid last digit.
     */
    private static final int FIRST_VALID_LAST_DIGIT = 1;

    /**
     * The second valid last digit.
     */
    private static final int SECOND_VALID_LAST_DIGIT = 2;

    /**
     * The third valid last digit.
     */
    private static final int THIRD_VALID_LAST_DIGIT = 3;

    /**
     * Checks if the last digit of the number is valid.
     * <p/>
     * This method calculates the last digit of the number
     * by finding the remainder when dividing the number by the base.
     * It then checks if the last digit is equal to one of the three valid last digits.
     *
     * @return true if the last digit of the number is valid, false otherwise.
     */
    public boolean checkLastDigit() {
        int lastDigit = this.number % BASE;

        return lastDigit == FIRST_VALID_LAST_DIGIT || lastDigit == SECOND_VALID_LAST_DIGIT
               || lastDigit == THIRD_VALID_LAST_DIGIT;
    }
}

