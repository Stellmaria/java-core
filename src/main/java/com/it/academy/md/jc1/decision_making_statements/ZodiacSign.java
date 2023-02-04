package com.it.academy.md.jc1.decision_making_statements;

/**
 * <h3>RU: Принятие решений.</h3>
 *
 * <h3>EN: Decision making statements.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class ZodiacSign {
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
        return month == 2 || month == 3;
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
        return month == 1 || month == 2 && day <= 19;
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
        return month == 12 || month == 1 && day <= 20;
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
        return month == 11 || month == 12 && day <= 21;
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
        return month == 10 || month == 11 && day <= 22;
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
        return month == 9 || month == 10 && day <= 22;
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
        return month == 8 || month == 9 && day <= 21;
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
        return month == 7 || month == 8 && day <= 22;
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
        return month == 6 || month == 7 && day <= 22;
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
        return month == 5 || month == 6 && day <= 21;
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
        return month == 4 || month == 5 && day <= 20;
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
        return month == 3 && day >= 21 || month == 4 && day <= 20;
    }
}
