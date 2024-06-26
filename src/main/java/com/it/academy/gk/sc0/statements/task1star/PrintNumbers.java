package com.it.academy.gk.sc0.statements.task1star;

import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * This utility class provides methods to generate and print numbers within a given range.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public class PrintNumbers {
    /**
     * Generates a string representation of numbers within a specified range, separated by spaces.
     *
     * @param start The starting number (inclusive) of the range.
     * @param end   The ending number (inclusive) of the range.
     * @return A string containing numbers from start to end, separated by spaces.
     * @throws IllegalArgumentException If the start number is greater than the end number.
     */
    public static String generateNumbersTask1Star(final int start, final int end) {
        return IntStream.rangeClosed(start, end)
                .mapToObj(Integer::toString) // map each number to a string using Integer::toString,
                .collect(Collectors.joining(" "));
    }
}
