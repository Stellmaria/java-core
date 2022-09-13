package com.it_academy.md_jc1.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.stream.Stream.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class DepositAccount.")
class DepositAccountTest {
    private static DepositAccount depositAccount;

    @BeforeAll
    static void init() {
        depositAccount = new DepositAccount();
    }

    static @NotNull Stream<Arguments> totalDepositAmountProvideArguments() {
        return of(
                Arguments.of(1501, 5, 7, 2026.35f),
                Arguments.of(0, 15, 100, 0.0f),
                Arguments.of(10000, 5, 0, 10000.0f),
                Arguments.of(100, 5, 100, 600.0f)
        );
    }

    @MethodSource("totalDepositAmountProvideArguments")
    @DisplayName("Test for method getTotalDepositAmount() from class DepositAccount.")
    @ParameterizedTest(name = "Deposit. Amount: {0}, years: {1}, annual percentage: {2}.")
    void testTotalDepositAmount(int depositAmount, int depositYears, int depositAnnualPercentage, float expected) {
        var actual = depositAccount.getTotalDepositAmount(depositAmount, depositYears, depositAnnualPercentage);

        assertEquals(expected, actual);
    }
}
