package com.it.academy.md.jc1.operators;

/**
 * <p>RU: Типы данных. Переменные. Операторы. Методы.</p>
 * <p>EN: Data types. Variables. Operators. Methods.</p>
 *
 * @author Anastasia Melnikova.
 */
public class GameSessionTime {
    /**
     * <p>RU: Значение секунд в часу.</p>
     * <p>EN: The value of seconds in an hour.</p>
     */
    public static final int SECONDS_TO_HOURS = 3600;
    /**
     * <p>RU: Значение секунд в минуте.</p>
     * <p>EN: Meaning of seconds in a minute.</p>
     */
    public static final int SECONDS_TO_MINUTES = 60;
    /**
     * <p>RU: Значение секунд в дне.</p>
     * <p>EN: The value of seconds in a day.</p>
     */
    public static final int SECONDS_TO_DAYS = 86400;
    /**
     * <p>RU: Значение часов в дне.</p>
     * <p>EN: The value of hours in a day.</p>
     */
    public static final int HOURS_IN_DAY = 24;
    /**
     * <p>RU: Значение минут в часе.</p>
     * <p>EN: The value of minutes in an hour.</p>
     */
    public static final int MINUTES_IN_HOURS = 60;
    /**
     * <p>RU: Значение секунд в секунде.</p>
     * <p>EN: The value of seconds in a second.</p>
     */
    public static final int SECONDS_IN_SECONDS = 60;

    /**
     * <p>RU: Высчитывает сколько времени пользователь провел в игре.</p>
     * <p>EN: Calculates how much time the user spent in the game.</p>
     *
     * @param playingTimeInSeconds - количество секунд проведенных пользователем
     *                             в игре/number of seconds spent
     *                             by the user in the game.
     * @return время в формате 'D H:m:s', где D - дни, H - часы,
     * m - минуты, s - секунды/time in the format 'D H:m:s', where D - days,
     * H - hours, m - minutes, s - seconds.
     */
    public String getPlayingTime(final int playingTimeInSeconds) {
        int hours = playingTimeInSeconds / SECONDS_TO_HOURS;
        int minutes = playingTimeInSeconds / SECONDS_TO_MINUTES;
        int days = playingTimeInSeconds / SECONDS_TO_DAYS;

        return (days + " " + hours % HOURS_IN_DAY
                + ":" + minutes % MINUTES_IN_HOURS
                + ":" + playingTimeInSeconds % SECONDS_IN_SECONDS);
    }
}
