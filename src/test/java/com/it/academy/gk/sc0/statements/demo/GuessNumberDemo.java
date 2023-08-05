package com.it.academy.gk.sc0.statements.demo;

import com.it.academy.gk.sc0.statements.GuessNumber;

public class GuessNumberDemo {
    public static void main(String[] args) {
        var game = new GuessNumber(1, 10);
        game.play();
    }
}
