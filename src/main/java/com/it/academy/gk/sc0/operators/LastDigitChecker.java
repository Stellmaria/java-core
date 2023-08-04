package com.it.academy.gk.sc0.operators;

/**
 * Task 9.
 * Given a number, for example, 12345. Check that the last digit of this number is 1, 2 or 3. If so, print 'yes,'
 * otherwise print 'no.'
 */
public record LastDigitChecker(int number) {
    /**
     * The base used to calculate the last digit of the number.
     */
    public static final int BASE = 10;
    /**
     * The first valid last digit.
     */
    public static final int FIRST_VALID_LAST_DIGIT = 1;

    /**
     * The second valid last digit.
     */
    public static final int SECOND_VALID_LAST_DIGIT = 2;

    /**
     * The third valid last digit.
     */
    public static final int THIRD_VALID_LAST_DIGIT = 3;

    /**
     * Checks if the last digit of the number is 1, 2, or 3.
     * <p>
     * This method calculates the last digit of the number by finding the remainder when the number is divided by 10.
     * Then it checks if the last digit is equal to one of the valid last digits (1, 2, or 3) and returns true if it is,
     * and false otherwise.
     *
     * @return true if the last digit of the number is 1, 2, or 3; false otherwise
     */
    public boolean checkLastDigit() {
        var lastDigit = this.number % BASE;

        return lastDigit == FIRST_VALID_LAST_DIGIT || lastDigit == SECOND_VALID_LAST_DIGIT
               || lastDigit == THIRD_VALID_LAST_DIGIT;
    }
}

