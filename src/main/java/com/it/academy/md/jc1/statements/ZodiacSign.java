package com.it.academy.md.jc1.statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class ZodiacSign {
    /**
     * <p>RU: Значение первого месяца.</p>
     *
     * <p>EN: The value of the first month.</p>
     */
    private static final int FIRST_MONTH = 1;

    /**
     * <p>RU: Значение второго месяца.</p>
     *
     * <p>EN: Meaning of the second month.</p>
     */
    private static final int SECOND_MONTH = 2;

    /**
     * <p>RU: Значение третьего месяца.</p>
     *
     * <p>EN: Meaning of the third month.</p>
     */
    private static final int THIRD_MONTH = 3;

    /**
     * <p>RU: Значение четвертого месяца.</p>
     *
     * <p>EN: Meaning of the fourth month.</p>
     */
    private static final int FOURTH_MONTH = 4;

    /**
     * <p>RU: Значение пятого месяца.</p>
     *
     * <p>EN: Meaning of the fifth month.</p>
     */
    private static final int FIFTH_MONTH = 5;

    /**
     * <p>RU: Значение шестого месяца.</p>
     *
     * <p>EN: Meaning of the sixth month.</p>
     */
    private static final int SIXTH_MONTH = 6;

    /**
     * <p>RU: Значение седьмого месяца.</p>
     *
     * <p>EN: Meaning of the seventh month.</p>
     */
    private static final int SEVENTH_MONTH = 7;

    /**
     * <p>RU: Значение восьмого месяца.</p>
     *
     * <p>EN: Meaning of the eighth month.</p>
     */
    private static final int EIGHTH_MONTH = 8;

    /**
     * <p>RU: Значение девятого месяца.</p>
     *
     * <p>EN: Meaning of the ninth month.</p>
     */
    private static final int NINTH_MONTH = 9;

    /**
     * <p>RU: Значение десятого месяца.</p>
     *
     * <p>EN: The value of the tenth month.</p>
     */
    private static final int TENTH_MONTH = 10;

    /**
     * <p>RU: Значение одиннадцатого месяца.</p>
     *
     * <p>EN: The value of the eleventh month.</p>
     */
    private static final int ELEVENTH_MONTH = 11;

    /**
     * <p>RU: Значение двенадцатого месяца.</p>
     *
     * <p>EN: Meaning of the twelfth month.</p>
     */
    private static final int TWELFTH_MONTH = 12;

    /**
     * <p>RU: Значение девятнадцатого дня.</p>
     *
     * <p>EN: The meaning of the nineteenth day.</p>
     */
    private static final int NINETEENTH_DAY = 19;

    /**
     * <p>RU: Значение двадцатого дня.</p>
     *
     * <p>EN: The meaning of the twentieth day.</p>
     */
    private static final int TWENTIETH_DAY = 20;

    /**
     * <p>RU: Значение двадцать первого дня.</p>
     *
     * <p>EN: Meaning of the twenty-first day.</p>
     */
    private static final int TWENTY_FIRST_DAY = 21;

    /**
     * <p>RU: Значение двадцать второго дня.</p>
     *
     * <p>EN: Meaning of the twenty-second day.</p>
     */
    private static final int TWENTY_SECOND_DAY = 22;

    /**
     * <h4>RU: Задание 12.</h4>
     * <p>Разработать программу для сайта посвященного астрологии.</p>
     * <p>Определить знак зодиака:</p>
     * <ul>
     *     <li>21.3-20.4 - `Овен`</li>
     *     <li>21.4-20.5 - `Телец`</li>
     *     <li>21.5-21.6 - `Близнецы`</li>
     *     <li>22.6-22.7 - `Рак`</li>
     *     <li>23.7-22.8 - `Лев`</li>
     *     <li>23.8-21.9 - `Дева`</li>
     *     <li>22.9-22.10 - `Весы`</li>
     *     <li>23.10-22.11 - `Скорпион`</li>
     *     <li>23.11-21.12 - `Стрелец`</li>
     *     <li>22.12-20.1 - `Козерог`</li>
     *     <li>21.1-19.2 - `Водолей`</li>
     *     <li>20.2-20.3 - `Рыбы`</li>
     * </ul>
     * <p>Определяет знак зодиака.</p><br>
     *
     * <h4>EN: Task 12.</h4>
     * <p>Develop a program for a site dedicated to astrology.</p>
     * <p>Determine the sign of the zodiac:</p>
     * <ul>
     *     <li>21.3-20.4 - `Ram`</li>
     *     <li>21.4-20.5 - `Bull`</li>
     *     <li>21.5-21.6 - `Twins`</li>
     *     <li>22.6-22.7 - `Crab`</li>
     *     <li>23.7-22.8 - `Lion`</li>
     *     <li>23.8-21.9 - `Maiden`</li>
     *     <li>22.9-22.10 - `Scales`</li>
     *     <li>23.10-22.11 - `Scorpion`</li>
     *     <li>23.11-21.12 - `Archer`</li>
     *     <li>22.12-20.1 - `Goat`</li>
     *     <li>21.1-19.2 - `Water-bearer`</li>
     *     <li>20.2-20.3 - `Pisces`</li>
     * </ul>
     * <p>Determines the sign of the zodiac.</p><br>
     *
     * @param day   число дня рождения / birthday number.
     * @param month месяц дня рождения / birthday month.
     * @return знак зодиака / zodiac sign.
     */
    public String getZodiacSign(final int day, final int month) {
        final var ram = "Ram";
        final var bull = "Bull";
        final var twins = "Twins";
        final var crab = "Crab";
        final var lion = "Lion";
        final var maiden = "Maiden";
        final var scales = "Scales";
        final var scorpion = "Scorpion";
        final var archer = "Archer";
        final var goat = "Goat";
        final var waterBearer = "Water-bearer";
        final var pisces = "Pisces";

        if (isRamCondition(day, month)) {
            return ram;
        } else if (isBullCondition(day, month)) {
            return bull;
        } else if (isTwinsCondition(day, month)) {
            return twins;
        } else if (isCrabCondition(day, month)) {
            return crab;
        } else if (isLionCondition(day, month)) {
            return lion;
        } else if (isMaidenCondition(day, month)) {
            return maiden;
        } else if (isScalesCondition(day, month)) {
            return scales;
        } else if (isScorpionCondition(day, month)) {
            return scorpion;
        } else if (isArcherCondition(day, month)) {
            return archer;
        } else if (isGoatCondition(day, month)) {
            return goat;
        } else if (isWaterBearerCondition(day, month)) {
            return waterBearer;
        } else if (isPhisherCondition(month)) {
            return pisces;
        } else {
            return null;
        }
    }

    /**
     * <p>RU: Проверка условия.</p>
     *
     * <p>EN: Condition check.</p><br>
     *
     * @param month месяц дня рождения / birthday month.
     * @return true если условие выполнено, false если не выполнены условие / true if the condition is met,
     * false if the conditions are not met.
     */
    private boolean isPhisherCondition(final int month) {
        return month == SECOND_MONTH
               || month == THIRD_MONTH;
    }

    /**
     * <p>RU: Проверка условия.</p>
     *
     * <p>EN: Condition check.</p><br>
     *
     * @param day   число дня рождения / birthday number.
     * @param month месяц дня рождения / birthday month.
     * @return true если условие выполнено, false если не выполнены условие / true if the condition is met,
     * false if the conditions are not met.
     */
    private boolean isWaterBearerCondition(final int day, final int month) {
        return month == FIRST_MONTH
               || month == SECOND_MONTH
                  && day <= NINETEENTH_DAY;
    }

    /**
     * <p>RU: Проверка условия.</p>
     *
     * <p>EN: Condition check.</p><br>
     *
     * @param day   число дня рождения / birthday number.
     * @param month месяц дня рождения / birthday month.
     * @return true если условие выполнено, false если не выполнены условие / true if the condition is met,
     * false if the conditions are not met.
     */
    private boolean isGoatCondition(final int day, final int month) {
        return month == TWELFTH_MONTH
               || month == FIRST_MONTH
                  && day <= TWENTIETH_DAY;
    }

    /**
     * <p>RU: Проверка условия.</p>
     *
     * <p>EN: Condition check.</p><br>
     *
     * @param day   число дня рождения / birthday number.
     * @param month месяц дня рождения / birthday month.
     * @return true если условие выполнено, false если не выполнены условие / true if the condition is met,
     * false if the conditions are not met.
     */
    private boolean isArcherCondition(final int day, final int month) {
        return month == ELEVENTH_MONTH
               || month == TWELFTH_MONTH
                  && day <= TWENTY_FIRST_DAY;
    }

    /**
     * <p>RU: Проверка условия.</p>
     *
     * <p>EN: Condition check.</p><br>
     *
     * @param day   число дня рождения / birthday number.
     * @param month месяц дня рождения / birthday month.
     * @return true если условие выполнено, false если не выполнены условие / true if the condition is met,
     * false if the conditions are not met.
     */
    private boolean isScorpionCondition(final int day, final int month) {
        return month == TENTH_MONTH
               || month == ELEVENTH_MONTH
                  && day <= TWENTY_SECOND_DAY;
    }

    /**
     * <p>RU: Проверка условия.</p>
     *
     * <p>EN: Condition check.</p><br>
     *
     * @param day   число дня рождения / birthday number.
     * @param month месяц дня рождения / birthday month.
     * @return true если условие выполнено, false если не выполнены условие / true if the condition is met,
     * false if the conditions are not met.
     */
    private boolean isScalesCondition(final int day, final int month) {
        return month == NINTH_MONTH
               || month == TENTH_MONTH
                  && day <= TWENTY_SECOND_DAY;
    }

    /**
     * <p>RU: Проверка условия.</p>
     *
     * <p>EN: Condition check.</p><br>
     *
     * @param day   число дня рождения / birthday number.
     * @param month месяц дня рождения / birthday month.
     * @return true если условие выполнено, false если не выполнены условие / true if the condition is met,
     * false if the conditions are not met.
     */
    private boolean isMaidenCondition(final int day, final int month) {
        return month == EIGHTH_MONTH
               || month == NINTH_MONTH
                  && day <= TWENTY_FIRST_DAY;
    }

    /**
     * <p>RU: Проверка условия.</p>
     *
     * <p>EN: Condition check.</p><br>
     *
     * @param day   число дня рождения / birthday number.
     * @param month месяц дня рождения / birthday month.
     * @return true если условие выполнено, false если не выполнены условие / true if the condition is met,
     * false if the conditions are not met.
     */
    private boolean isLionCondition(final int day, final int month) {
        return month == SEVENTH_MONTH
               || month == EIGHTH_MONTH
                  && day <= TWENTY_SECOND_DAY;
    }

    /**
     * <p>RU: Проверка условия.</p>
     *
     * <p>EN: Condition check.</p><br>
     *
     * @param day   число дня рождения / birthday number.
     * @param month месяц дня рождения / birthday month.
     * @return true если условие выполнено, false если не выполнены условие / true if the condition is met,
     * false if the conditions are not met.
     */
    private boolean isCrabCondition(final int day, final int month) {
        return month == SIXTH_MONTH
               || month == SEVENTH_MONTH
                  && day <= TWENTY_SECOND_DAY;
    }

    /**
     * <p>RU: Проверка условия.</p>
     *
     * <p>EN: Condition check.</p><br>
     *
     * @param day   число дня рождения / birthday number.
     * @param month месяц дня рождения / birthday month.
     * @return true если условие выполнено, false если не выполнены условие / true if the condition is met,
     * false if the conditions are not met.
     */
    private boolean isTwinsCondition(final int day, final int month) {
        return month == FIFTH_MONTH
               || month == SIXTH_MONTH
                  && day <= TWENTY_FIRST_DAY;
    }

    /**
     * <p>RU: Проверка условия.</p>
     *
     * <p>EN: Condition check.</p><br>
     *
     * @param day   число дня рождения / birthday number.
     * @param month месяц дня рождения / birthday month.
     * @return true если условие выполнено, false если не выполнены условие / true if the condition is met,
     * false if the conditions are not met.
     */
    private boolean isBullCondition(final int day, final int month) {
        return month == FOURTH_MONTH
               || month == FIFTH_MONTH
                  && day <= TWENTIETH_DAY;
    }

    /**
     * <p>RU: Проверка условия.</p>
     *
     * <p>EN: Condition check.</p><br>
     *
     * @param day   число дня рождения / birthday number.
     * @param month месяц дня рождения / birthday month.
     * @return true если условие выполнено, false если не выполнены условие / true if the condition is met,
     * false if the conditions are not met.
     */
    private boolean isRamCondition(final int day, final int month) {
        return month == THIRD_MONTH
               && day >= TWENTY_FIRST_DAY
               || month == FOURTH_MONTH
                  && day <= TWENTIETH_DAY;
    }
}
