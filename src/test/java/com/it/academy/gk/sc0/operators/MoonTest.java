package com.it.academy.gk.sc0.operators;

import com.it.academy.gk.sc0.operators.exception.NegativeWeightException;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * This class contains tests for the Moon class.
 */
class MoonTest {
    private Moon moon;

    /**
     * This method provides positive test cases for the testGetWeight method.
     *
     * @return A stream of test cases, where each test case is an array of objects.
     */
    @Contract(pure = true)
    private static @NotNull Stream<Object[]> weightProvider() {
        return Stream.of(
                new Object[]{0, 0},
                new Object[]{50, 50 * Moon.MOON_GRAVITY},
                new Object[]{100, 100 * Moon.MOON_GRAVITY}
        );
    }

    /**
     * This method provides negative test cases for the testGetWeightNegative method.
     *
     * @return A stream of test cases where each case is an array of objects
     */
    @Contract(pure = true)
    private static @NotNull Stream<Object[]> negativeWeightProvider() {
        return Stream.of(
                new Object[]{-50},
                new Object[]{-100}
        );
    }

    /**
     * This method sets up the test environment before each test.
     * It creates a new instance of the Moon class.
     */
    @BeforeEach
    void setUp() {
        moon = new Moon();
    }

    /**
     * This method tests the getWeight method of the Moon class using positive test cases.
     * The test cases are provided by the weightProvider method.
     *
     * @param weightOnEarth        The weight on Earth
     * @param expectedWeightOnMoon The expected weight on the Moon
     */
    @ParameterizedTest(name = "Weight on Earth: {0}, Weight on Moon: {1}")
    @MethodSource("weightProvider")
    @DisplayName("Test getWeight method with positive cases")
    void testGetWeight(double weightOnEarth, double expectedWeightOnMoon) {
        assertEquals(expectedWeightOnMoon, moon.getWeight(weightOnEarth));
    }

    /**
     * This method tests the getWeight method of the Moon class using negative test cases.
     * The test cases are provided by the negativeWeightProvider method.
     *
     * @param weightOnEarth The weight on Earth
     */
    @ParameterizedTest(name = "Weight on Earth: {0}")
    @MethodSource("negativeWeightProvider")
    @DisplayName("Test getWeight method with negative cases")
    void testGetWeightNegative(double weightOnEarth) {
        assertThrows(NegativeWeightException.class, () -> moon.getWeight(weightOnEarth));
    }
}
