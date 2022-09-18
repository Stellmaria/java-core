package com.it.academy.md.jc1.operators;

/**
 * <p>RU: Типы данных. Переменные. Операторы. Методы.</p>
 * <p>EN: Data types. Variables. Operators. Methods.</p>
 *
 * @author Anastasia Melnikova.
 */
public class DepositAccount {
    private static final float PERCENTAGE = 100.0f;

    /**
     * RU:
     * <p>Высчитывает итоговую сумму на депозитном счете, при условии:</p>
     * <ul>
     *     <li>Процент простой, т.е. всегда считается от первоначальной суммы вклада.</li>
     *     <li>Вклад без возможности досрочного снятия.</li>
     * </ul>
     * <p>EN: </p>
     * <p>Calculates the total amount on the deposit account, provided:</p>
     * <ul>
     *      <li>Percentage is simple, i.e. always calculated from the initial deposit amount.</li>
     *      <li>Deposit without the possibility of early withdrawal.</li>
     * </ul>
     *
     * @param depositAmount           первоначальная сумма на счете/initial account balance.
     * @param depositYears            время вклада в годах/deposit time in years.
     * @param depositAnnualPercentage ежегодный простой процент/annual simple interest.
     */
    public float getTotalDepositAmount(int depositAmount, int depositYears, int depositAnnualPercentage) {
        return depositAmount + depositYears * depositAmount * depositAnnualPercentage / PERCENTAGE;
    }
}
