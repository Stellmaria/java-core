package com.it.academy.md.jc1.decision_making_statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class BattleCityResult {
    /**
     * <p>RU: Значение бонусных очков.</p>
     *
     * <p>EN: The value of bonus points.</p>
     */
    private static final int BONUS_POINT = 500;

    /**
     * <p>RU: Значение очков за убийство.</p>
     *
     * <p>EN: The value of points for a kill.</p>
     */
    private static final int KILL_POINT = 100;

    /**
     * <h4>RU: Задание 6.</h4>
     * <p>Разработать программу для игрового движка.</p>
     * <p>Два игрока играют в “Battle City” (танчики времен приставок “SEGA” и “Dendy”).
     * После каждого боя им, в зависимости от количества уничтоженных танков, начисляются очки:
     * <ul>
     *      <li>Тому, кто уничтожил больше танков начисляется дополнительные 500 очков.</li>
     *      <li>В случае когда уничтожено одинаковое количество танков, бонусные очки не начисляются никому.</li>
     *      <li>За 1 танк начисляется 100 очков.</li>
     * </ul>
     * <p>Высчитывает результаты боя.</p><br>
     *
     * <h4>EN: Task 6.</h4>
     * <p>Develop a program for a game engine.</p>
     * <p>Two players play in "Battle City" (tanks from the time of the prefixes "SEGA" and "Dendy").
     * After each battle, they, depending on the number of tanks destroyed, are awarded points:
     * <ul>
     *      <li>The one who destroyed more tanks is awarded an additional 500 points.</li>
     *      <li>In the case when the same number of tanks are destroyed, bonus points are not awarded to anyone.</li>
     *      <li>For 1 tank, 100 points are awarded.</li>
     * </ul>
     * <p>Calculates the results of the battle.</p><br>
     *
     * @param tanksKilledFirstPlayer  количество танков, убитых первым игроком /
     *                                number of tanks killed by the first player.
     * @param tanksKilledSecondPlayer количество танков, убитых вторым игроком /
     *                                number of tanks killed by the second player.
     * @return 'Игрок 1: {0}. Игрок 2: {1}', где {0} - очки первого игрока, {1} - очки второго игрока /
     * 'Player 1: {0}. Player 2: {1}', where {0} - points of the first player, {1} - points of the second player.
     */
    public String getResult(int tanksKilledFirstPlayer, int tanksKilledSecondPlayer) {
        final var firstPlayer = "Player 1: ";
        final var secondPlayer = ". Player 2: ";

        final var bonusPoint = BONUS_POINT / 100;

        if (tanksKilledFirstPlayer > tanksKilledSecondPlayer) {
            tanksKilledFirstPlayer += bonusPoint;
        } else if (tanksKilledFirstPlayer < tanksKilledSecondPlayer) {
            tanksKilledSecondPlayer += bonusPoint;
        }

        return firstPlayer + KILL_POINT * tanksKilledFirstPlayer + secondPlayer + KILL_POINT * tanksKilledSecondPlayer;
    }
}
