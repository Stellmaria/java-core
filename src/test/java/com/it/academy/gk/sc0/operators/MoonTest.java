package com.it.academy.gk.sc0.operators;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Moon.")
class MoonTest {
    private static Moon moon;

    @BeforeAll
    static void init() {
        moon = new Moon();
    }

    @Test
    @DisplayName("Test for method getWeight() from class Moon.")
    void getWeight() {
        var expected = 73.455;

        var actual = moon.getWeight(88.5);

        assertEquals(expected, actual);
    }
}