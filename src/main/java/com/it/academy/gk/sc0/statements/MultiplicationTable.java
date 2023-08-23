package com.it.academy.gk.sc0.statements;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Task 3: Print the multiplication table for 3.
 * This class contains a method that prints a multiplication table for a given multiplier and number of rows.
 *
 * @author Anastasia Melnikova.
 */
public class MultiplicationTable {
    /**
     * The symbol used to represent multiplication.
     */
    private static final String MULTIPLICATION_SYMBOL = " x ";

    /**
     * The symbol used to represent equality.
     */
    private static final String EQUALS_SYMBOL = " = ";

    /**
     * The newline character.
     */
    private static final String NEWLINE = "\n";

    /**
     * Generates a multiplication table for the given multiplier and number of rows.
     * <p/>
     * The printMultiplicationTable method generates a string representation of a multiplication table for
     * the given multiplier and number of rows.
     * Each row of the table shows the result of multiplying the row number by the multiplier.
     * The rows are separated by newline characters.
     * The method uses an IntStream to generate a stream of integers from 1 to row, inclusive.
     * For each integer in the stream, it concatenates it with the MULTIPLICATION_SYMBOL, multiplier, EQUALS_SYMBOL,
     * and the result of multiplying the integer by multiplier.
     * It then appends a NEWLINE character to create a new row in the table.
     * Finally, it collects all rows into a single string using Collectors.joining().
     *
     * @param multiplier the multiplier to use in the multiplication table.
     * @param rows       the number of rows in the multiplication table.
     * @return a string representation of the multiplication table.
     */
    public String printMultiplicationTable(final int multiplier, final int rows) {
        return IntStream.rangeClosed(1, rows)
                .mapToObj(i -> i + MULTIPLICATION_SYMBOL + multiplier + EQUALS_SYMBOL + i * multiplier + NEWLINE)
                .collect(Collectors.joining());
    }
}

