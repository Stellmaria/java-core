package com.it.academy.gd.jc1.statements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class House.")
class HouseTest {
    private House house;

    @BeforeEach
    void init() {
        house = new House();
    }

    @Test
    @DisplayName("Test for method isEnoughSpace() from class House.")
    void isEnoughSpace() {
        // TODO:
        var expected = true;

        var actual = house.isEnoughSpace(
                10, 5, 10, 5, 20, 10
        );

        assertEquals(expected, actual);
    }
}
