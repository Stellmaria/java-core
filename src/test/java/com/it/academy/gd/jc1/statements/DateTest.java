package com.it.academy.gd.jc1.statements;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Date.")
class DateTest {
    private final Date date = new Date();

    @Test
    @DisplayName("Test for method getNextDay() from class Date.")
    void getNextDay() {
        // TODO:
        var expected = "1:2:2004";

        var actual = date.getNextMonth(31, 1, 2004);

        assertEquals(expected, actual);
    }
}
