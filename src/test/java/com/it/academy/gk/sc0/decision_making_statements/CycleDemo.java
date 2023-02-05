package com.it.academy.gk.sc0.decision_making_statements;

import java.util.Scanner;

public class CycleDemo {
    public static void main(String[] args) {
        var cycle = new Cycle();
        var scanner = new Scanner(System.in);

        System.out.println(cycle.guessTheNumber(1, 10, scanner));
    }
}
