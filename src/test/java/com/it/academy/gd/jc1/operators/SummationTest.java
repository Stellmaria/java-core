package com.it.academy.gd.jc1.operators;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Summation.")
class SummationTest {
    private Summation summation;

    @BeforeEach
    void init() {
        summation = new Summation();
    }

    @Test
    @DisplayName("Test for method sumMul() from class Summation.")
    void sumMul() {
        var expected = "Answer : 5";

        var actual = summation.sumMul(1, 2);

        assertEquals(expected, actual);
    }
}