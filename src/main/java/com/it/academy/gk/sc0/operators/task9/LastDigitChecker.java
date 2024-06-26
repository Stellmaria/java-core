package com.it.academy.gk.sc0.operators.task9;

import lombok.experimental.UtilityClass;

import java.util.HashSet;
import java.util.Set;

/**
 * A utility class to check if the last digit of a given number is 1, 2, or 3.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public class LastDigitChecker {
    /**
     * The divisor used to get the last digit of a number.
     */
    private static final int CHECK_DIVISOR = 10;

    /**
     * The response when the last digit is valid.
     */
    private static final String YES_RESPONSE = "yes";

    /**
     * The response when the last digit is not valid.
     */
    private static final String NO_RESPONSE = "no";

    /**
     * A set of valid last digits (1, 2, 3).
     */
    private static final Set<Integer> VALID_LAST_DIGITS = new HashSet<>(Set.of(1, 2, 3));

    /**
     * Checks if the last digit of the given number is 1, 2, or 3.
     *
     * @param number The number to check.
     * @return {@link #YES_RESPONSE} if the last digit is valid, {@link #NO_RESPONSE} otherwise.
     */
    public static String checkLastDigit(final int number) {
        return VALID_LAST_DIGITS.contains(number % CHECK_DIVISOR) ? YES_RESPONSE : NO_RESPONSE;
    }
}
