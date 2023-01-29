package com.it.academy.md.jc1.operators;

import com.it.academy.md.jc1.operators.util.Const;

/**
 * <h4>RU: Типы данных. Переменные. Операторы. Методы.</h4>
 *
 * <h4>EN: Data types. Variables. Operators. Methods.</h4>
 *
 * @author Anastasia Melnikova.
 */
public class DepositAccount {
    /**
     * <p>RU: Высчитывает итоговую сумму на депозитном счете, при условии:</p>
     * <ul>
     *     <li>Процент простой, т.е. всегда считается
     *     от первоначальной суммы вклада.</li>
     *     <li>Вклад без возможности досрочного снятия.</li>
     * </ul><br>
     *
     * <p>EN: Calculates the total amount on the deposit account, provided:</p>
     * <ul>
     *      <li>Percentage is simple, i.e. always calculated
     *      from the initial deposit amount.</li>
     *      <li>Deposit without the possibility of early withdrawal.</li>
     * </ul>
     *
     * @param depositAmount           первоначальная сумма на счете /
     *                                initial account balance.
     * @param depositYears            время вклада в годах /
     *                                deposit time in years.
     * @param depositAnnualPercentage ежегодный простой процент /
     *                                annual simple interest.
     * @return сумма на счете/account amount.
     */
    public float getTotalDepositAmount(final int depositAmount, final int depositYears,
                                       final int depositAnnualPercentage) {
        return depositAmount + depositYears * depositAmount * depositAnnualPercentage / Const.PERCENTAGE;
    }
}
