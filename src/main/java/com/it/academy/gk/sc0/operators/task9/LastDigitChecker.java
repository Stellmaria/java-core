package com.it.academy.gk.sc0.operators.task9;

import java.util.HashSet;
import java.util.Set;

/**
 * The LastDigitChecker class provides a method to check if the last digit of a given number is 1, 2, or 3.
 */
public class LastDigitChecker {
    /**
     * The divisor used to calculate the last digit of a number.
     */
    private static final int CHECK_DIVISOR = 10;
    /**
     * The response returned when the last digit of the given number is 1, 2, or 3.
     */
    private static final String YES_RESPONSE = "yes";
    /**
     * The response returned when the last digit of the given number is not 1, 2, or 3.
     */
    private static final String NO_RESPONSE = "no";
    /**
     * A set of valid last digits.
     */
    private static final Set<Integer> VALID_LAST_DIGITS = new HashSet<>(Set.of(1, 2, 3));

    /**
     * Checks if the last digit of a given number is 1, 2, or 3.
     *
     * @param number the number to be checked
     * @return "yes" if the last digit of the given number is 1, 2, or 3; "no" otherwise
     */
    public String checkLastDigit(final int number) {
        int lastDigit = number % CHECK_DIVISOR;

        return VALID_LAST_DIGITS.contains(lastDigit) ? YES_RESPONSE : NO_RESPONSE;
    }
}
