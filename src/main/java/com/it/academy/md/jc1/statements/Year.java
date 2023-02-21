package com.it.academy.md.jc1.statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Year {
    /**
     * <h4>RU: Задание 14.</h4>
     * <p>Разработать программу для сайта посвященного астрологии.</p>
     * <p>Определить название года по китайскому календарю, если считать что нет никаких циклических смещений, т.е.
     * нижеприведенный цикл повторяется для любых 12 лет после 0 н.э.</p>
     * <ul>
     *     <li>2001 - `Змея`</li>
     *     <li>2002 - `Лошадь`</li>
     *     <li>2003 - `Коза`</li>
     *     <li>2004 - `Обезьяна`</li>
     *     <li>2005 - `Петух`</li>
     *     <li>2006 - `Собака`</li>
     *     <li>2007 - `Свинья`</li>
     *     <li>2008 - `Крыса`</li>
     *     <li>2009 - `Бык`</li>
     *     <li>2010 - `Тигр`</li>
     *     <li>2011 - `Кролик`</li>
     *     <li>2012 - `Дракон`</li>
     * </ul>
     * <p>Определяет названия года по китайскому календарю.</p><br>
     *
     * <h4>EN: Task 14.</h4>
     * <p>Develop a program for a website dedicated to astrology.</p>
     * <p>Determine the name of the year according to the Chinese calendar, assuming that there are no cyclic shifts,
     * i.e. the cycle below repeats for any 12 years after 0 AD.</p>
     * <ul>
     *     <li>2001 - `Snake`</li>
     *     <li>2002 - `Horse`</li>
     *     <li>2003 - `Goat`</li>
     *     <li>2004 - `Monkey`</li>
     *     <li>2005 - `Rooster`</li>
     *     <li>2006 - `Dog`</li>
     *     <li>2007 - `Pig`</li>
     *     <li>2008 - `Rat`</li>
     *     <li>2009 - `Ox`</li>
     *     <li>2010 - `Tiger`</li>
     *     <li>2011 - `Rabbit`</li>
     *     <li>2012 - `Dragon`</li>
     * </ul>
     * <p>Determines the names of the year according to the Chinese calendar.</p><br>
     *
     * @param year Год дня рождения (больше 0 г. н.э.) / Birthday year (greater than 0 AD).
     * @return название года по китайскому календарю / name of the year according to the Chinese calendar.
     */
    public String getZodiacYearName(final int year) {
        final var monthInYear = 12;
        final var monkey = "Monkey";
        final var rooster = "Rooster";
        final var dog = "Dog";
        final var pig = "Pig";
        final var rat = "Rat";
        final var ox = "Ox";
        final var tiger = "Tiger";
        final var rabbit = "Rabbit";
        final var dragon = "Dragon";
        final var snake = "Snake";
        final var horse = "Horse";
        final var goat = "Goat";

        return switch (year % monthInYear) {
            case 0 -> monkey;
            case 1 -> rooster;
            case 2 -> dog;
            case 3 -> pig;
            case 4 -> rat;
            case 5 -> ox;
            case 6 -> tiger;
            case 7 -> rabbit;
            case 8 -> dragon;
            case 9 -> snake;
            case 10 -> horse;
            case 11 -> goat;
            default -> null;
        };
    }
}
