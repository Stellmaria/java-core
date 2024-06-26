package com.it.academy.gk.sc0.statements.task3;

import com.it.academy.gk.sc0.statements.task3.exception.MultiplicationTableException;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * A utility class for generating a multiplication table.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public class MultiplicationTable {
    /**
     * A constant string to be used when a multiplication table for 0 cannot be generated.
     */
    private static final String CANNOT_BE_GENERATED = "Multiplication table for 0 cannot be generated.";

    /**
     * Prints a multiplication table for a given multiplier and number of rows.
     *
     * @param multiplier The number to generate the multiplication table for.
     * @param rows       The number of rows in the multiplication table.
     * @return A string representation of the multiplication table.
     * @throws MultiplicationTableException If the multiplier is 0.
     */
    public static String printMultiplicationTable(final int multiplier, final int rows)
            throws MultiplicationTableException {
        if (multiplier == 0) {
            throw new MultiplicationTableException(CANNOT_BE_GENERATED);
        }

        final var multiplicationSymbol = " x ";
        final var equalsSymbol = " = ";
        final var newline = "\n";

        return IntStream.rangeClosed(1, rows)
                .mapToObj(i -> i + multiplicationSymbol + multiplier + equalsSymbol + i * multiplier + newline)
                .collect(Collectors.joining());
    }
}
