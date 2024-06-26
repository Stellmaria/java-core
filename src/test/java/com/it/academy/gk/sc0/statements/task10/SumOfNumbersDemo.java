package com.it.academy.gk.sc0.statements.task10;

import java.util.Scanner;

class SumOfNumbersDemo {
    public static void main(String[] args) {
        var sumOfNumbers = new SumOfNumbers();
        System.out.println("Enter non-zero numbers (enter 0 to stop):");

        var result = sumOfNumbers.calculateSum(new Scanner(System.in));
        System.out.println(result);
    }
}
