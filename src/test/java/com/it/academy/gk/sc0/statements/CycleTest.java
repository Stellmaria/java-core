package com.it.academy.gk.sc0.statements;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Cycle.")
class CycleTest {
    private Cycle cycle;

    @BeforeEach
    void init() {
        cycle = new Cycle();
    }

    @Test
    @DisplayName("Test for method giveCycleSeven() from class Cycle.")
    void giveCycle() {
        // TODO:
        var expected = "1 2 3 4 5 6 7 ";

        var actual = cycle.giveCycleSeven(7);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test for method giveCycleSequence() from class Cycle.")
    void giveCycleSequence() {
        // TODO:
        var expected = "100 90 80 70 60 50 40 30 20 10 ";

        var actual = cycle.giveCycleSequence(10, 100);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test for method giveCycleThree() from class Cycle.")
    void giveCycleThree() {
        // TODO:
        var expected = "3 2 1 0 -1 -2 -3 ";

        var actual = cycle.giveCycleThree(-3, 3);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test for method giveCycleOne() from class Cycle.")
    void giveCycleOne() {
        // TODO:
        var expected = "1 2 3 4 5 ";

        var actual = cycle.giveCycleOne(1, 5);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test for method giveCycleFive() from class Cycle.")
    void giveCycleFive() {
        // TODO:
        var expected = "5 4 3 2 1 ";

        var actual = cycle.giveCycleFive(1, 5);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test for method giveCycleOnThree() from class Cycle.")
    void giveCycleOnThree() {
        // TODO:
        var expected = """
                3 * 1 = 3
                3 * 2 = 6
                3 * 3 = 9
                3 * 4 = 12
                3 * 5 = 15
                3 * 6 = 18
                3 * 7 = 21
                3 * 8 = 24
                3 * 9 = 27
                3 * 10 = 30
                """;

        var actual = cycle.giveCycleOnThree(1, 10, 3);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test for method getSummation() from class Cycle.")
    void getSummation() {
        // TODO:
        var expected = 3;

        var actual = cycle.getSummation(1, 2);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test for method getSequenceSegment() from class Cycle.")
    void getSequenceSegment() {
        // TODO:
        var expected = 3;

        var actual = cycle.getSequenceSegment(0, 6);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test for method getCycle() from class Cycle.")
    void getCycle() {
        // TODO:
        var expected = """
                I'm learning programming
                I'm learning programming
                I'm learning programming
                I'm interested in a high salary!
                I'm learning programming
                I'm learning programming
                I'm learning programming
                I'm learning programming
                I'm learning programming
                I'm interested in a high salary!
                I'm learning programming
                """;

        var actual = cycle.getCycle(10, 3, 9);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test for method getMultiple() from class Cycle.")
    void getMultiple() {
        // TODO:
        var expected = 34;

        var actual = cycle.getMultiple(19, 97, 17);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test for method getMultiple() from class Cycle.")
    void getSum() {
        // TODO:
        var mas = new int[]{1, 2, 3, 0, 4};
        var expected = 6;

        var actual = cycle.geSum(mas);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test for method getMultiple() from class Cycle.")
    void getStringSum() {
        // TODO:
        var expected = "1,3,6,10,15,21,28,36,45,55,66,78,91,105,120,";

        var actual = cycle.getSum(122);

        assertEquals(expected, actual);
    }
}