package com.it.academy.md.jc1.decision_making_statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class PlayerHealth {
    /**
     * <h4>RU: Задание 3.</h4>
     * <p>Разработать программу для игрового движка.</p>
     * <p>Необходимо окрасить шкалу HP игрока в соответствующий цвет, в зависимости от процентного соотношения
     * максимального количества HP и текущего.</p>
     * <p>Возвращает цвет для шкалы HP игрока, в зависимости от процентного соотношения максимального количества HP и
     * текущего. Когда меньше 25% - красный, меньше 50% - оранжевый, меньше 75% - желтый,
     * меньше либо равно 100 -зеленый.</p><br>
     *
     * <h4>EN: Task 3.</h4>
     * <p>Develop a program for the game engine.</p>
     * <p>It is necessary to color the player's HP bar in the appropriate color,
     * depending on the percentage of the maximum amount of HP and the current one.</p>
     * <p>Returns the color for the player's HP bar, based on the percentage of max HP and current HP.
     * When less than 25% - red, less than 50% - orange, less than 75% - yellow,
     * less than or equal to 100 - green.</p><br>
     *
     * @param currentHealthPoint текущее количество HP игрока / player's current HP.
     * @param maxHealthPoint     максимальное количество HP игрока / player's maximum HP.
     * @return null'КРАСНЫЙ''ОРАНЖЕВЫЙ''ЖЕЛТЫЙ''ЗЕЛЕНЫЙ' / null/'RED'/'ORANGE'/'YELLOW'/'GREEN'.
     */
    public String getColorHealthPoint(final int currentHealthPoint, final int maxHealthPoint) {
        final var percentage = 100f;

        final var percentageRed = 25;
        final var percentageOrange = 50;
        final var percentageYellow = 75;
        final var percentageGreen = 100;

        final var red = "RED";
        final var orange = "ORANGE";
        final var yellow = "YELLOW";
        final var green = "GREEN";

        final var getPercentage = percentage / ((double) maxHealthPoint / (double) currentHealthPoint);

        if (getPercentage <= 0) {
            return null;
        } else if (getPercentage < percentageRed) {
            return red;
        } else if (getPercentage < percentageOrange) {
            return orange;
        } else if (getPercentage < percentageYellow) {
            return yellow;
        } else if (getPercentage <= percentageGreen) {
            return green;
        } else {
            return null;
        }
    }
}
