package com.it.academy.md.jc1.operators;

import com.it.academy.md.jc1.operators.util.Const;

/**
 * <h4>RU: Типы данных. Переменные. Операторы. Методы.</h4>
 *
 * <h4>EN: Data types. Variables. Operators. Methods.</h4>
 *
 * @author Anastasia Melnikova.
 */
public class GameSessionTime {
    /**
     * <p>RU: Высчитывает сколько времени пользователь провел в игре.</p><br>
     *
     * <p>EN: Calculates how much time the user spent in the game.</p><br>
     *
     * @param playingTimeInSeconds - количество секунд проведенных пользователем
     *                             в игре / number of seconds spent
     *                             by the user in the game.
     * @return время в формате 'D H:m:s', где D - дни, H - часы,
     * m - минуты, s - секунды / time in the format 'D H:m:s', where D - days,
     * H - hours, m - minutes, s - seconds.
     */
    public String getPlayingTime(final int playingTimeInSeconds) {
        final var hours = playingTimeInSeconds / Const.SECONDS_TO_HOURS;
        final var minutes = playingTimeInSeconds / Const.SECONDS_TO_MINUTES;
        final var days = playingTimeInSeconds / Const.SECONDS_TO_DAYS;

        // TODO:
        return (days + " " + hours % Const.HOURS_IN_DAY + ":"
                + minutes % Const.MINUTES_IN_HOURS + ":"
                + playingTimeInSeconds % Const.SECONDS_IN_SECONDS
        );
    }
}
