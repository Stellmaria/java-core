package com.it.academy.gk.sc0.statements;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Task 1*: Print the numbers from 1 to 7 on the screen. The output should be: 1 2 3 4 5 6 7.
 * <p>
 * Task 2*: Print the sequence of numbers from 100 to 10 on the screen.
 * The output should be: 100 90 80 70 60 50 40 30 20 10.
 * <p>
 * Task 1: Print numbers from 1 to 5. The output should be: 1 2 3 4 5.
 * Task 2: Print numbers from 5 to 1. The output should be: 5 4 3 2 1.
 */
public class PrintNumbers {
    /**
     * The separator used between numbers.
     */
    private static final String SEPARATOR = " ";

    /**
     * Generates a string of numbers from start to end, separated by a space.
     * <p>
     * This method generates a string of numbers from start to end, inclusive, separated by a space.
     * It uses an IntStream to generate a stream of integers from start to end, inclusive.
     * For each integer in the stream, it concatenates it with the SEPARATOR and collects
     * all strings into a single string using Collectors.joining().
     *
     * @param start the first number in the generated string
     * @param end   the last number in the generated string
     * @return a string of numbers from start to end, separated by a space
     */
    public String generateNumbersTask1(final int start, final int end) {
        return IntStream.rangeClosed(start, end)
                .mapToObj(i -> i + SEPARATOR)
                .collect(Collectors.joining());
    }

    /**
     * Generates a string of numbers from first to last, incremented by increment, separated by a space.
     * <p>
     * This method generates a string of numbers from first to last, incremented by increment,
     * separated by a space. It uses an IntStream to generate a stream of integers from first to last,
     * inclusive, incremented by increment. For each integer in the stream, it concatenates it with
     * the SEPARATOR and collects all strings into a single string using Collectors.joining().
     *
     * @param first     the first number in the generated string
     * @param last      the last number in the generated string
     * @param increment the increment between numbers in the generated string
     * @return a string of numbers from first to last, incremented by increment, separated by a space
     */
    public String generateNumbersTask2(final int first, final int last, final int increment) {
        return IntStream.iterate(first, i -> i >= last, i -> i + increment)
                .mapToObj(i -> i + SEPARATOR)
                .collect(Collectors.joining());
    }

    /**
     * Generates a string of numbers from upperBound to lowerBound in descending order, separated by a space.
     * <p>
     * This method generates a string of numbers from upperBound to lowerBound in descending order,
     * separated by a space. It uses an IntStream to generate a stream of integers from upperBound to lowerBound,
     * inclusive, decremented by 1. For each integer in the stream, it concatenates it with the SEPARATOR
     * and collects all strings into a single string using Collectors.joining().
     *
     * @param upperBound the first number in the generated string
     * @param lowerBound the last number in the generated string
     * @return a string of numbers from upperBound to lowerBound in descending order, separated by a space
     */
    public String printNumbersTask4(final int upperBound, final int lowerBound) {
        return IntStream.iterate(upperBound, i -> i >= lowerBound, i -> i - 1)
                .mapToObj(i -> i + SEPARATOR)
                .collect(Collectors.joining());
    }

    /**
     * Generates a string of numbers from minValue to maxValue in ascending order, separated by a space.
     * <p>
     * This method generates a string of numbers from minValue to maxValue in ascending order, separated by a space.
     * It uses an IntStream to generate a stream of integers from minValue to maxValue, inclusive.
     * For each integer in the stream, it concatenates it with the SEPARATOR and collects all strings into
     * a single string using Collectors.joining().
     *
     * @param minValue the first number in the generated string
     * @param maxValue the last number in the generated string
     * @return a string of numbers from minValue to maxValue in ascending order, separated by a space
     */
    public String printNumbersTask1(final int minValue, final int maxValue) {
        return IntStream.rangeClosed(minValue, maxValue)
                .mapToObj(i -> i + SEPARATOR)
                .collect(Collectors.joining());
    }

    /**
     * Generates a string of numbers from begin to finish in descending order, separated by a space.
     * <p>
     * This method generates a string of numbers from begin to finish in descending order, separated by a space.
     * It uses an IntStream to generate a stream of integers from begin to finish, inclusive.
     * For each integer in the stream, it concatenates it with the SEPARATOR and collects all strings into
     * a single string using Collectors.joining().
     *
     * @param begin  the first number in the generated string
     * @param finish the last number in the generated string
     * @return a string of numbers from begin to finish in descending order, separated by a space
     */
    public String printNumbersTask2(final int begin, final int finish) {
        return IntStream.iterate(begin, i -> i >= finish, i -> i - 1)
                .mapToObj(i -> i + SEPARATOR)
                .collect(Collectors.joining());
    }
}

