package com.it.academy.gk.sc0.hw1;

import org.jetbrains.annotations.NotNull;

/**
 * The user enters two lines.
 * Determine if these strings are the same (case-sensitive).
 */
public class StringEqualityChecker {
    /**
     * Message to be returned when the strings are equal
     */
    private static final String EQUAL_STRINGS_MESSAGE = "The strings are equal.";
    /**
     * Message to be returned when the strings are not equal
     */
    private static final String UNEQUAL_STRINGS_MESSAGE = "The strings are not equal.";

    /**
     * Determines if two strings are equal (case-sensitive).
     * Use the equals method of the String class to compare the two strings. If they are equal,
     * return the EQUAL_STRINGS_MESSAGE constant. Otherwise, return the UNEQUAL_STRINGS_MESSAGE constant
     *
     * @param string1 the first string to compare, must not be null
     * @param string2 the second string to compare
     * @return a message indicating whether the strings are equal or not
     */
    public String areStringsEqual(@NotNull String string1, String string2) {
        return (string1.equals(string2) ? EQUAL_STRINGS_MESSAGE : UNEQUAL_STRINGS_MESSAGE);
    }
}
