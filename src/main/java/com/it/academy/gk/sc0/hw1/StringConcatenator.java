package com.it.academy.gk.sc0.hw1;

import org.jetbrains.annotations.NotNull;

/**
 * Using the methods of the String class, output a string that is the result of concatenating two given strings.
 *
 * @author Anastasia Melnikova.
 */
public class StringConcatenator {
    /**
     * Concatenates two given strings and returns the result.
     * <p/>
     * This method takes two strings as input and returns a new string
     * that is the result of concatenating the two input strings using the concat method of the String class.
     *
     * @param firstString  the first string to concatenate.
     * @param secondString the second string to concatenate.
     * @return a new string that is the result of concatenating the two input strings.
     */
    public String concatenateStrings(final @NotNull String firstString, final String secondString) {
        return firstString.concat(secondString);
    }
}
