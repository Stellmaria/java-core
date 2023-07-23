package com.it.academy.gk.sc0.statements;

import org.jetbrains.annotations.NotNull;

import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.iterate;
import static java.util.stream.IntStream.rangeClosed;

/**
 * <h3>RU: Циклы.</h3>
 *
 * <h3>EN: Cycles.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Cycle {
    // TODO:
    /**
     * <p>RU: Константа со значением.</p>
     *
     * <p>EN: A constant with a value.</p>
     */
    private static final String SPACE = " ";

    // TODO:
    /**
     *
     */
    private final Random random;

    /**
     * Instantiates a new Cycle.
     */
    public Cycle() {
        try {
            random = SecureRandom.getInstanceStrong();
        } catch (NoSuchAlgorithmException e) {
            // TODO:
            throw new RuntimeException(e);
        }
    }

    /**
     * <h4>RU: Задание 1*.</h4>
     * <p>Необходимо вывести на экран числа от 1 до 7. То есть на экране должно быть: 1 2 3 4 5 6 7.</p><br>
     *
     * <h4>EN: Task 1*.</h4>
     * <p>It is necessary to display numbers from 1 to 7 on the screen.
     * That is, the screen should be: 1 2 3 4 5 6 7.</p><br>
     *
     * @param max максимальное число / maximum number.
     * @return заданная последовательность / given sequence.
     */
    public String giveCycleSeven(final int max) {
        final var stringBuilder = new StringBuilder();

        var i = 0;

        while (i < max) {
            i++;

            stringBuilder.append(i).append(SPACE);
        }
        return stringBuilder.toString();
    }

    /**
     * <h4>RU: Задание 2*.</h4>
     * <p>Необходимо вывести на экран вот такую последовательность чисел: 100 90 80 70 60 50 40 30 20 10.</p><br>
     *
     * <h4>EN: Task 2*.</h4>
     * <p>It is necessary to display the following sequence of numbers on the
     * screen: 100 90 80 70 60 50 40 30 20 10.</p><br>
     *
     * @param min минимальное число / minimum number.
     * @param max максимальное число / maximum number.
     * @return заданная последовательность / given sequence.
     */
    public String giveCycleSequence(final int min, int max) {
        final var stringBuilder = new StringBuilder();

        while (max >= min) {
            stringBuilder.append(max).append(SPACE);

            max -= min;
        }
        return stringBuilder.toString();
    }

    /**
     * <h4>RU: Задание 4*.</h4>
     * <p>Необходимо вывести на экран числа от 3 до -3. То есть на экране должно быть: 3 2 1 0 -1 -2 -3.</p><br>
     *
     * <h4>EN: Task 4*.</h4>
     * <p>It is necessary to display numbers from 3 to -3 on the screen.
     * That is, the screen should be: 3 2 1 0 -1 -2 -3.</p><br>
     *
     * @param min минимальное число / minimum number.
     * @param max максимальное число / maximum number.
     * @return заданная последовательность / given sequence.
     */
    public String giveCycleThree(final int min, final int max) {
        return iterate(max, i -> i >= min, i -> i - 1)
                .mapToObj(i -> i + SPACE)
                .collect(Collectors.joining());
    }

    /**
     * <h4>RU: Задание 1.</h4>
     * <p>Необходимо вывести на экран числа от 1 до 5. На экране должно быть: 1 2 3 4 5.</p><br>
     *
     * <h4>EN: Task 1.</h4>
     * <p>It is necessary to display numbers from 1 to 5. The screen should show: 1 2 3 4 5.</p><br>
     *
     * @param min минимальное число / minimum number.
     * @param max максимальное число / maximum number.
     * @return заданная последовательность / given sequence.
     */
    public String giveCycleOne(final int min, final int max) {
        return rangeClosed(min, max)
                .mapToObj(i -> i + SPACE)
                .collect(Collectors.joining());
    }

    /**
     * <h4>RU: Задание 2.</h4>
     * <p>Необходимо вывести на экран числа от 5 до 1. На экране должно быть 5 4 3 2 1.</p><br>
     *
     * <h4>EN: Task 2.</h4>
     * <p>It is necessary to display numbers from 5 to 1. The screen should show 5 4 3 2 1.</p><br>
     *
     * @param min минимальное число / minimum number.
     * @param max максимальное число / maximum number.
     * @return заданная последовательность / given sequence.
     */
    public String giveCycleFive(final int min, final int max) {
        return iterate(max, i -> i >= min, i -> i - 1)
                .mapToObj(i -> i + SPACE)
                .collect(Collectors.joining());
    }

    /**
     * <h4>RU: Задание 3.</h4>
     * <p>Необходимо вывести на экран таблицу умножения на 3.</p><br>
     *
     * <h4>EN: Task 3.</h4>
     * <p>Display the multiplication table for 3.</p><br>
     *
     * @param min    the min
     * @param max    the max
     * @param number the number
     * @return таблица умножения на 3 / multiplication table for 3.
     */
    public String giveCycleOnThree(final int min, final int max, final int number) {
        // TODO:
        return rangeClosed(min, max)
                .mapToObj(j -> number + " * " + j + " = " + number * j + "\n")
                .collect(Collectors.joining());
    }

    /**
     * <h4>RU: Задание 4.</h4>
     * <p>Напишите программу, где пользователь вводит любое целое положительное число.
     * А программа суммирует все числа от 1 до введенного пользователем числа.</p><br>
     *
     * <h4>EN: Task 4.</h4>
     * <p>Write a program where the user enters any positive integer.
     * And the program sums up all numbers from 1 to the number entered by the user.</p><br>
     *
     * @param min the min
     * @param max the max
     * @return результат сложения / addition result.
     */
    public int getSummation(int min, int max) {
        return rangeClosed(min, max).sum();
    }

    /**
     * <h4>RU: Задание 5.</h4>
     * <p>Отгадать целое число, которое "загадал" компьютер в определенном диапазоне.</p><br>
     *
     * <h4>EN: Task 5.</h4>
     * <p>Guess an integer that the computer "guessed" in a certain range.</p><br>
     *
     * @param min минимальное число / minimum number.
     * @param max максимальное число / maximum number.
     * @return загаданное число / hidden number.
     */
    public String guessTheNumber(final int min, final int max) {
        var scanner = new Scanner(System.in, StandardCharsets.UTF_8);

        final var stringAnswer = "Answer ";

        final var answer = this.random.nextInt(max - min) + min;

        String result = null;

        while (scanner.hasNextLine()) {
            if (answer == scanner.nextInt()) {
                result = stringAnswer + answer;
                break;
            }
        }

        return result;
    }

    /**
     * <h4>RU: Задание 6.</h4>
     * <p>Сколько нечетных чисел на отрезке [0; n].</p><br>
     *
     * <h4>EN: Task 6.</h4>
     * <p>How many odd numbers are on the interval [0; n].</p><br>
     *
     * @param min минимальное число / minimum number.
     * @param max максимальное число / maximum number.
     * @return результат / result.
     */
    public long getSequenceSegment(final int min, final int max) {
        return rangeClosed(min, max).filter(j -> j % 2 != 0).count();
    }

    /**
     * <h4>RU: Задание 7.</h4>
     * <p>Выведите на экран в цикле 10 раз фразу "Я изучаю программирование". При выводе сделайте такое разветвление
     * в теле цикла, чтобы вместо 3-й и 9-й по счету фразу выводилась фраза "Меня интересует высокая зарплата!".
     * Должен получится следующий вывод строк:<br>
     * Я изучаю программирование<br>
     * Я изучаю программирование<br>
     * Меня интересует высокая зарплата!<br>
     * Я изучаю программирование<br>
     * Я изучаю программирование<br>
     * Я изучаю программирование<br>
     * Я изучаю программирование<br>
     * Я изучаю программирование<br>
     * Меня интересует высокая зарплата!<br>
     * Я изучаю программирование</p><br>
     *
     * <h4>EN: Task 7.</h4>
     * <p>Display the phrase "I'm learning programming" 10 times in a loop.
     * When outputting, make such a branch in the loop body so that instead of the 3rd and 9th phrase in a row,
     * the phrase "I'm interested in a high salary!" You should get the following output lines:<br>
     * I'm learning programming<br>
     * I'm learning programming<br>
     * I'm interested in a high salary!<br>
     * I'm learning programming<br>
     * I'm learning programming<br>
     * I'm learning programming<br>
     * I'm learning programming<br>
     * I'm learning programming<br>
     * I'm interested in a high salary!<br>
     * I am learning programming</p><br>
     *
     * @param max          максимальное число / maximum number.
     * @param firstNumber  первое число для цикла / first number for loop.
     * @param secondNumber второе число для цикла / second number for loop.
     * @return результат / result.
     */
    public String getCycle(int max, int firstNumber, int secondNumber) {
        final var result = new StringBuilder();

        for (var i = 0; i <= max; i++) {
            if (i == firstNumber || i == secondNumber) {
                // TODO:
                result.append("I'm interested in a high salary!\n");
                continue;
            }
            // TODO:
            result.append("I'm learning programming\n");
        }
        return result.toString();
    }

    /**
     * <h4>RU: Задание 8.</h4>
     * <p>Найти на отрезке [19; 97] первое число кратное 17.</p><br>
     *
     * <h4>EN: Task 8.</h4>
     * <p>Find on the interval [19; 97] the first number is a multiple of 17.</p><br>
     *
     * @param min      минимальное число / minimum number.
     * @param max      максимальное число / maximum number.
     * @param multiple число для поиска кратности / number to find multiplicity.
     * @return первое число кратное числу multiple / first multiple of multiple.
     */
    public int getMultiple(final int min, final int max, final int multiple) {
        return rangeClosed(min, max)
                .filter(i -> i % multiple == 0)
                .findFirst()
                .orElse(0);
    }

    /**
     * <h4>RU: Задание 9.</h4>
     * <p>С клавиатуры вводится некоторое число. Пусть считается сумма <code>int sum = 1 + 2 + 3 + 4 + 5</code>и т.д.
     * Каждая цифра суммы выводиться в консоль через запятую (без пробела). Остановите вывод до того,
     * как сумма превысит введённое число. Например:<br>
     * Ввод: 122<br>
     * Вывод: 1,3,6,10,15,21,28,36,45,55,66,78,91,105,120</p><br>
     *
     * <h4>EN: Task 9.</h4>
     * <p>A number is entered from the keyboard. Let the sum be considered <code>int sum = 1 + 2 + 3 + 4 + 5</code>, etc.
     * Each digit of the sum is output to the console separated by a comma (without a space).
     * Stop the withdrawal before the amount exceeds the entered number.
     * For example:<br>
     * Input: 122<br>
     * Output: 1,3,6,10,15,21,28,36,45,55,66,78,91,105,120</p><br>
     *
     * @param max максимальное число / maximum number.
     * @return суммы цифр / sums of digits.
     */
    public String getSum(final int max) {
        final var result = new StringBuilder();
        var sum = 0;

        for (var i = 1; i < max; i++) {
            sum += i;
            if (sum <= max) {
                // TODO:
                result.append(sum).append(',');
            }
        }
        return result.toString();
    }

    /**
     * <h4>RU: Задание 10.</h4>
     * <p>Пользователь вводит ненулевые числа до тех пор пока не введет ноль. Найдите сумму этих чисел.</p><br>
     *
     * <h4>EN: Task 10.</h4>
     * <p>The user enters non-zero numbers until they enter zero. Find the sum of these numbers.</p><br>
     *
     * @param numbers числа / numbers.
     * @return сумма полученных чисел / the sum of the received numbers.
     */
    public int geSum(final int @NotNull [] numbers) {
        var sum = 0;

        for (var number : numbers) {
            if (number != 0) {
                sum += number;
            } else {
                break;
            }
        }
        return sum;
    }
}
