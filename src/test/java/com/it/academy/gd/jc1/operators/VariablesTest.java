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
    @DisplayName("Test for method getVariable() from class Variables.")
    void getVariable() {
        var expected = """
                85
                22015
                1000000
                4294967295
                a
                0.25
                1.234E-5
                true""";

        var actual = variables.getVariable();

        assertEquals(expected, actual);
    }
}