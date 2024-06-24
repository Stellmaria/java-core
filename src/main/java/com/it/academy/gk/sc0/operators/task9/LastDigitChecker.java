package com.it.academy.gk.sc0.operators.task9;

import java.util.HashSet;
import java.util.Set;

/**
 * LastDigitChecker is a utility class that provides a method for checking
 * whether the last digit of a given number is within a specific set of valid digits.
 *
 * <p>Example usage:</p>
 * <pre>
 *     LastDigitChecker checker = new LastDigitChecker();
 *     String response = checker.checkLastDigit(12);  // response will be "yes"
 * </pre>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
public class LastDigitChecker {
    /**
     * A constant for the divisor used to find the last digit of a number.
     */
    private static final int CHECK_DIVISOR = 10;

    /**
     * A constant for the response when the last digit is valid.
     */
    private static final String YES_RESPONSE = "yes";

    /**
     * A constant for the response when the last digit is not valid.
     */
    private static final String NO_RESPONSE = "no";

    /**
     * A set containing valid last digits.
     */
    private static final Set<Integer> VALID_LAST_DIGITS = new HashSet<>(Set.of(1, 2, 3));

    /**
     * Checks whether the last digit of a given number is within a specific set of valid digits.
     *
     * <p>Example usage:</p>
     * <pre>
     *     LastDigitChecker checker = new LastDigitChecker();
     *     String response = checker.checkLastDigit(12);  // response will be "yes"
     * </pre>
     *
     * @param number the number whose last digit is to be checked.
     * @return "yes" if the last digit is valid, "no" otherwise.
     */
    public String checkLastDigit(final int number) {
        var lastDigit = number % CHECK_DIVISOR;

        return VALID_LAST_DIGITS.contains(lastDigit) ? YES_RESPONSE : NO_RESPONSE;
    }
}
