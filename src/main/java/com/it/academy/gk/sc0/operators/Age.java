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
     * <h4>RU: Задание 7.</h4><br>
     * <p>Вывести ребенок, взрослый или старик в зависимости от возраста.
     * Ребенок от 0 до 17 лет (включительно). Взрослый от 18 до 69 лет
     * (включительно). Старик от 70 и старше.
     * Долгожитель, если больше 120.</p><br>
     *
     * <h4>EN: Task 7.</h4>
     * <p>Bring out a child, adult or old man depending on age.
     * Child from 0 to 17 years old (inclusive).
     * Adult from 18 to 69 years old (inclusive).
     * Old man 70 and older. Long-liver, if more than 120.</p><br>
     *
     * @param age возраст / age.
     * @return ответ соответственно полученному возрасту / answer according to the received age.
     */
    public String checkAge(final int age) {
        int child = 17;
        int adult = 69;
        int older = 120;

        String result = null;

        if (age > 0 && age <= child) {
            result = "Child.";
        } else if (age >= child + 1 && age <= adult) {
            result = "Adult.";
        } else if (age >= adult + 1) {
            result = ("Older.");
            if (age >= older) {
                result = "Long-liver.";
            }
        }
        return result;
    }
}
