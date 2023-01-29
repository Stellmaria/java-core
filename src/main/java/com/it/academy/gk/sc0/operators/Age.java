package com.it.academy.gk.sc0.operators;

/**
 * <h3>RU: Типы данных. Переменные. Операторы. Методы.</h3>
 *
 * <h3>EN: Data types. Variables. Operators. Methods.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Age {
    /**
     * <p>RU: Инициализируем переменную если число меньше 0.</p><br>
     *
     * <p>EN: We initialize the variable if the number is less than 0.</p>
     */
    private static final String ERROR = "Error.";

    /**
     * <p>RU: Инициализируем переменную если число меньше 17 и больше 0.</p><br>
     *
     * <p>EN: We initialize the variable if the number is less than 17 and greater than 0.</p>
     */
    private static final String CHILD = "Child.";

    /**
     * <p>RU: Инициализируем переменную если число меньше 69 и больше 18.</p><br>
     *
     * <p>EN: We initialize the variable if the number is less than 69 and greater than 18.</p>
     */
    private static final String ADULT = "Adult.";

    /**
     * <p>RU: Инициализируем переменную если число меньше 120 и больше 70.</p><br>
     *
     * <p>EN: We initialize the variable if the number is less than 120 and greater than 70.</p>
     */
    private static final String OLDER = "Older.";

    /**
     * <p>RU: Инициализируем переменную если число больше 120.</p><br>
     *
     * <p>EN: We initialize the variable if the number is greater than 120.</p>
     */
    private static final String LONG_LIVER = "\nLong-liver.";

    /**
     * <h4>RU: Задание 7.</h4>
     * <p>Вывести ребенок, взрослый или старик в зависимости от возраста.
     * Ребенок от 0 до 17 лет (включительно). Взрослый от 18 до 69 лет (включительно). Старик от 70 и старше.
     * Долгожитель, если больше 120.</p><br>
     *
     * <h4>EN: Task 7.</h4>
     * <p>Bring out a child, adult or old man depending on age. Child from 0 to 17 years old (inclusive).
     * Adult from 18 to 69 years old (inclusive). Old man 70 and older. Long-liver, if more than 120.</p><br>
     *
     * @param age возраст / age.
     * @return ответ соответственно полученному возрасту / answer according to the received age.
     */
    public String checkAge(final int age) {
        final int child = 17;
        final int adult = 69;
        final int older = 120;

        String result = ERROR;

        if (age > 0 && age <= child) {
            result = CHILD;
        } else if (age >= child + 1 && age <= adult) {
            result = ADULT;
        } else if (age >= adult + 1) {
            result = OLDER;
            if (age >= older) {
                result += LONG_LIVER;
            }
        }

        return result;
    }
}
