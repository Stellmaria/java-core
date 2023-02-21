package com.it.academy.gd.jc1.statements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Rub.")
class RubTest {
    private Rub rub;

    @BeforeEach
    void init() {
        rub = new Rub();
    }

    @Test
    @DisplayName("Test for method getSum() from class Rub.")
    void getSum() {
        // TODO:
        var expected = "1092 рубля.";

        var actual = rub.getSum(1092);

        assertEquals(expected, actual);
    }
}
