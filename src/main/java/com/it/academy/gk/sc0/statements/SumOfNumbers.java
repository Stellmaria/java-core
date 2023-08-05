package com.it.academy.gk.sc0.statements;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Task 4: Write a program where the user enters any positive integer, and the program calculates
 * the sum of all numbers from 1 to the entered number.
 * Task 9.
 * A number is entered from the keyboard. Let the sum be considered int sum = 1 + 2 + 3 + 4 + 5, etc.
 * Each digit of the sum is output to the console separated by a comma (without a space).
 * Stop the withdrawal before the amount exceeds the entered number.
 * For example, Input: 122
 * Output: 1,3,6,10,15,21,28,36,45,55,66,78,91,105,120
 * Task 10.
 * The user enters non-zero numbers until they enter zero. Find the sum of these numbers.
 */
public class SumOfNumbers {
    /**
     * The separator used between intermediate sums.
     */
    private static final String SEPARATOR = ",";
    /**
     * A constant of type String that contains the text "Sum: ".
     * It is used to label the sum of numbers when printing the result.
     */
    private static final String SUM_LABEL = "Sum: ";

    /**
     * Calculates the sum of numbers from 1 to a given integer n.
     * <p>
     * This method calculates the sum of numbers from 1 to a given integer n.
     * It uses an IntStream to generate a stream of integers from 1 to n, inclusive,
     * and then calculates the sum of all integers in the stream using the sum() method.
     *
     * @param n the upper bound for calculating the sum
     * @return the sum of numbers from 1 to n
     */
    public int calculateSum(final int n) {
        return IntStream.rangeClosed(1, n).sum();
    }

    /**
     * Calculates the sum of numbers from 1 to n and prints the intermediate sums until the sum exceeds the given limit.
     * <p>
     * This method calculates the sum of numbers from 1 to n and prints the intermediate sums until the sum exceeds
     * the given limit using the Stream API. It generates a stream of integers from 1 to n, inclusive,
     * and calculates the cumulative sum of all integers in the stream using a custom collector.
     * It then filters the stream to include only sums that are less than or equal to the limit,
     * maps each sum to a string, and collects all strings into a single string using Collectors.joining().
     *
     * @param n     the upper bound for calculating the sum
     * @param limit the limit for printing intermediate sums
     * @return a string containing the intermediate sums separated by SEPARATOR
     */
    public String printIntermediateSums(final int n, final int limit) {
        return IntStream.rangeClosed(1, n)
                .boxed()
                .collect(
                        ArrayList<Integer>::new,
                        (list, i) -> list.add(list.isEmpty() ? i : list.get(list.size() - 1) + i),
                        ArrayList::addAll
                )
                .stream()
                .filter(sum -> sum <= limit)
                .map(Object::toString)
                .collect(Collectors.joining(SEPARATOR));
    }

    /**
     * Calculates the sum of non-zero numbers entered by the user until the user enters zero.
     * <p>
     * This method prompts the user to enter non-zero numbers until the user enters zero. It then calculates
     * the sum of all entered numbers and returns it as a string.
     *
     * @param scanner A Scanner object for reading user input.
     * @return A string containing the sum of all entered numbers.
     */
    public String calculateSum(@NotNull Scanner scanner) {
        var sum = 0;
        int number;
        var result = new StringBuilder();

        do {
            number = scanner.nextInt();
            if (number != 0) {
                sum += number;
                result.append(number).append(SEPARATOR);
            }
        } while (number != 0);
        result.append(SUM_LABEL).append(sum);

        return result.toString();
    }
}
