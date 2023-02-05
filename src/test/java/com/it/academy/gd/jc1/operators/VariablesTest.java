package com.it.academy.gd.jc1.operators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Variables.")
class VariablesTest {
    private Variables variables;

    @BeforeEach
    void init() {
        variables = new Variables();
    }

    @Test
    @DisplayName("Test for method sumMul() from class Summation.")
    void getVariable() {
        var expected = "85\n" +
                       "22015\n" +
                       "1000000\n" +
                       "4294967295\n" +
                       "a\n" +
                       "0.25\n" +
                       "1.234E-5\n" +
                       "true";

        var actual = variables.getVariable();

        assertEquals(expected, actual);
    }
}