package com.it.academy.md.jc1.decision_making_statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class GameTable {
    /**
     * <h4>RU: Задание 1.</h4>
     * <p>Разработать программу для игрового движка.</p>
     * <p>После каждого боя выводится таблица статистики боя для команды. Расположение в данной таблице зависит
     * от урона нанесенного в бою. Определить вошел ли игрок в ТОП игроков своей команды.</p><br>
     *
     * <h4>EN: Task 1.</h4>
     * <p>Develop a program for a game engine.</p>
     * <p>After each battle, a table of battle statistics
     * for the team is displayed. The position in this table depends on the damage dealt in battle.
     * Determine if the player is in the TOP players of his team.</p><br>
     *
     * @param sizeTop                размер квоты для ТОП игроков команды / quota for TOP team players.
     * @param positionPlayerByDamage позиция игрока по убыванию урона в своей команде /
     *                               player's position in decreasing damage in his team
     * @return когда вошел в ТОП игроков, тогда <code>true</code> когда не вошел в ТОП игроков,
     * тогда <code>false</code> / when included in the TOP players, then <code>true</code>
     * when not included in the TOP players, then <code>false</code>
     */
    boolean isTopPlayer(final int sizeTop, final int positionPlayerByDamage) {
        return sizeTop >= positionPlayerByDamage;
    }
}
