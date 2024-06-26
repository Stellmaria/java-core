package com.it.academy.gk.sc0.statements.task10;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

/**
 * This class is responsible for calculating the sum of a series of numbers inputted by the user.
 * The user inputs numbers one by one, and the program stops when the user enters 0.
 * The program then outputs the sum of all the numbers entered, excluding 0.
 */
public class SumOfNumbers {
    /**
     * Calculates the sum of a series of numbers inputted by the user.
     *
     * @param scanner The Scanner object used to read user input.
     * @return A string containing the series of numbers entered, separated by commas,
     *         followed by the label "Sum: " and the calculated sum.
     * @throws NullPointerException If the scanner parameter is null.
     */
    public String calculateSum(@NotNull final Scanner scanner) {
        final String separator = ",";
        final String sumLabel = "Sum: ";

        var sum = 0;
        var result = new StringBuilder();

        int number;

        do {
            number = scanner.nextInt();

            if (number != 0) {
                sum += number;
                result.append(number).append(separator);
            }
        } while (number != 0);

        return result.append(sumLabel).append(sum).toString();
    }
}
