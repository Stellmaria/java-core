package com.it.academy.gk.sc0.hw1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for the LoanCalculator class. It uses the JUnit 5 testing framework to define
 * and run the tests.
 */
class LoanCalculatorTest {
    /**
     * The LoanCalculator object used in the tests.
     */
    private LoanCalculator calculator;

    /**
     * Provides the arguments for the testCalculateMonthlyPayment method.
     *
     * @return an array of arrays containing the loan amount, number of years, interest rate,
     * and expected monthly payment
     */
    private static Object[][] monthlyPaymentProvider() {
        return new Object[][]{
                {100000, 2, 5, 4387.14},
                {200000, 3, 10, 6453.44},
                {300000, 4, 15, 8349.22},
                {400000, 5, 20, 10597.55},
                {500000, 6, 25, 13468.59}
        };
    }

    /**
     * Provides the arguments for the testCalculateTotalPayment method.
     *
     * @return an array of arrays containing the loan amount, number of years, interest rate and expected total payment
     */
    private static Object[][] totalPaymentProvider() {
        return new Object[][]{
                {100000, 2, 5, 105291.36},
                {200000, 3, 10, 232323.84},
                {300000, 4, 15, 400762.56},
                {400000, 5, 20, 635853.0},
                {500000, 6, 25, 969738.48}
        };
    }

    /**
     * Sets up a new LoanCalculator object before each test.
     */
    @BeforeEach
    void setUp() {
        calculator = new LoanCalculator(100000, 2, 5);
    }

    /**
     * Tests the calculateMonthlyPayment method of the LoanCalculator class with different loan amounts,
     * number of years, and interest rates.
     *
     * @param loanAmount   the loan amount in rubles
     * @param years        the number of years the loan is taken for
     * @param interestRate the annual interest rate as a percentage
     * @param expected     the expected monthly payment
     */
    @DisplayName("Monthly payment calculation")
    @ParameterizedTest(name = "Loan amount: {0}, years: {1}, interest rate: {2}, expected monthly payment: {3}")
    @MethodSource("monthlyPaymentProvider")
    void testCalculateMonthlyPayment(double loanAmount, int years, double interestRate, double expected) {
        calculator = new LoanCalculator(loanAmount, years, interestRate);
        var actual = calculator.calculateMonthlyPayment();

        assertEquals(expected, actual, 0.01);
    }

    /**
     * Tests the calculateTotalPayment method of the LoanCalculator class with different loan amounts,
     * number of years and interest rates.
     *
     * @param loanAmount   the loan amount in rubles
     * @param years        the number of years the loan is taken for
     * @param interestRate the annual interest rate as a percentage
     * @param expected     the expected total payment
     */
    @DisplayName("Total payment calculation")
    @ParameterizedTest(name = "Loan amount: {0}, years: {1}, interest rate: {2}, expected total payment: {3}")
    @MethodSource("totalPaymentProvider")
    void testCalculateTotalPayment(double loanAmount, int years, double interestRate, double expected) {
        calculator = new LoanCalculator(loanAmount, years, interestRate);

        var actual = calculator.calculateTotalPayment();

        assertEquals(expected, actual, 0.01);
    }
}
