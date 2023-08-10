package com.it.academy.gk.sc0.hw1;

/**
 * Calculate monthly payments (m) and total payment
 * (s) on credit. The loan is known to be being in rubles, taken for two years, at p percent.
 */
public class LoanCalculator {
    /**
     * The number of months in a year.
     */
    private static final int MONTHS_IN_YEAR = 12;

    /**
     * The value of 100 percent.
     */
    private static final int PERCENT = 100;

    /**
     * The loan amount in rubles.
     */
    private final double loanAmount;

    /**
     * The number of years the loan is taken for.
     */
    private final int years;

    /**
     * The annual interest rate as a percentage.
     */
    private final double interestRate;

    /**
     * Constructs a new LoanCalculator with the specified loan amount, number of years, and interest rate.
     *
     * @param loanAmount   the loan amount in rubles.
     * @param years        the number of years the loan is taken for.
     * @param interestRate the annual interest rate as a percentage.
     */
    public LoanCalculator(final double loanAmount, final int years, final double interestRate) {
        this.loanAmount = loanAmount;
        this.years = years;
        this.interestRate = interestRate;
    }

    /**
     * Calculates the monthly payment for the loan.
     * <p/>
     * This method calculates the monthly payment using the formula for annuity payments.
     * It first calculates the monthly interest rate
     * by dividing the annual interest rate by the number of months in a year and by 100
     * to convert from percentage.
     * Then it calculates the total number of months for the loan
     * and uses these values to calculate and return the monthly payment.
     *
     * @return the monthly payment for the loan.
     */
    public double calculateMonthlyPayment() {
        double monthlyInterestRate = interestRate / MONTHS_IN_YEAR / PERCENT;
        int months = years * MONTHS_IN_YEAR;

        return Math.round(loanAmount * monthlyInterestRate /
                          (1 - Math.pow(1 + monthlyInterestRate, -months)) * PERCENT) / (double) PERCENT;
    }

    /**
     * Calculates the total payment for the loan.
     * <p/>
     * This method calculates and returns the total payment
     * by multiplying the monthly payment by the total number of months for the loan.
     *
     * @return the total payment for the loan.
     */
    public double calculateTotalPayment() {
        return Math.round(calculateMonthlyPayment() * years * MONTHS_IN_YEAR * PERCENT) / (double) PERCENT;
    }
}
