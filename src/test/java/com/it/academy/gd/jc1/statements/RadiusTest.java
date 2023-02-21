package com.it.academy.gd.jc1.statements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Radius.")
class RadiusTest {
    private Radius radius;

    @BeforeEach
    void init() {
        radius = new Radius();
    }

    @Test
    @DisplayName("Test for method isClosed() from class Radius.")
    void isClosed() {
        // TODO:
        var expected = true;

        var actual = radius.isClosed(10, 5, 15);

        assertEquals(expected, actual);
    }
}
