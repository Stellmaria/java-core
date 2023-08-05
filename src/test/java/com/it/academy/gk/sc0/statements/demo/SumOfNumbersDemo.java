package com.it.academy.gk.sc0.statements.demo;

import com.it.academy.gk.sc0.statements.SumOfNumbers;

import java.util.Scanner;

class SumOfNumbersDemo {
    public static void main(String[] args) {
        var sumOfNumbers = new SumOfNumbers();
        System.out.println("Enter non-zero numbers (enter 0 to stop):");
        var result = sumOfNumbers.calculateSum(new Scanner(System.in));
        System.out.println(result);
    }
}