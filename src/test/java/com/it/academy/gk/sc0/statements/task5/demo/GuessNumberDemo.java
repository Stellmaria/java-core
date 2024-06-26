package com.it.academy.gk.sc0.statements.task5.demo;

import com.it.academy.gk.sc0.statements.task5.GuessNumber;

/**
 * This class demonstrates the usage of the GuessNumber class.
 * It creates a new instance of GuessNumber with a range from 1 to 100,
 * and then starts the game by calling the play() method.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
public class GuessNumberDemo {
    /**
     * The main method is the entry point of the program.
     * It initializes the game and starts it.
     *
     * @param args Command line arguments (not used in this example)
     */
    public static void main(String[] args) {
        var game = new GuessNumber(1, 100);

        game.play();
    }
}
