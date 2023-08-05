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
 * The MoonTest class is a test class for the Moon class.
 * <p>
 * This class contains several methods to test the functionality of the Moon class,
 * including methods to provide test data and methods to test the getWeight method of the Moon class.
 * This class uses the Reflection API to access private fields of the Moon class in its test methods.
 */
class MoonTest {
    /**
     * This is a private field of the MoonTest class that holds an instance of the Moon class.
     * It is used in the test methods of the MoonTest class to call the methods
     * of the Moon class and test their functionality.
     */
    private Moon moon;

    /**
     * Provides a stream of test data for the testGetWeight method.
     * <p>
     * This method returns a stream of arrays, where each array represents a test case with
     * an input weight on Earth and an expected output weight on the Moon.
     *
     * @return a stream of test data for the testGetWeight method
     */
    @Contract(pure = true)
    private static @NotNull Stream<Object[]> weightProvider() throws NoSuchFieldException, IllegalAccessException {
        var moonGravityField = Moon.class.getDeclaredField("MOON_GRAVITY");
        moonGravityField.setAccessible(true);
        var moonGravity = (double) moonGravityField.get(null);

        return Stream.of(
                new Object[]{0, 0},
                new Object[]{50, 50 * moonGravity},
                new Object[]{100, 100 * moonGravity}
        );
    }

    /**
     * Provides a stream of negative test data for the testGetWeightNegative method.
     * <p>
     * This method returns a stream of arrays, where each array represents a test case with
     * an input negative weight on Earth.
     *
     * @return a stream of negative test data for the testGetWeightNegative method
     */
    @Contract(pure = true)
    private static @NotNull Stream<Object[]> negativeWeightProvider() {
        return Stream.of(
                new Object[]{-50},
                new Object[]{-100}
        );
    }

    /**
     * Sets up the test environment before each test.
     * <p>
     * This method creates a new instance of the Moon class and assigns it to the moon field.
     */
    @BeforeEach
    void setUp() {
        moon = new Moon();
    }

    /**
     * Tests the getWeight method of the Moon class with positive cases.
     * <p>
     * This method takes a double representing a weight on Earth and a double representing the expected
     * output weight on the Moon as arguments.
     * It calls the getWeight method of the Moon class with
     * the provided weight on Earth
     * and asserts that the result is equal to the expected output weight on the Moon.
     *
     * @param weightOnEarth        a double representing a weight on Earth
     * @param expectedWeightOnMoon a double representing the expected output weight on the Moon
     */
    @ParameterizedTest(name = "Weight on Earth: {0}, Weight on Moon: {1}")
    @MethodSource("weightProvider")
    @DisplayName("Test getWeight method with positive cases")
    void testGetWeight(double weightOnEarth, double expectedWeightOnMoon) {
        var actual = moon.getWeight(weightOnEarth);

        assertEquals(expectedWeightOnMoon, actual);
    }

    /**
     * Tests the getWeight method of the Moon class with negative cases.
     * <p>
     * This method takes a double representing a negative weight on Earth as an argument.
     * It calls the getWeight method of the Moon class with the provided negative weight on Earth
     * and asserts that it throws a NegativeWeightException.
     *
     * @param weightOnEarth a double representing a negative weight on Earth
     */
    @ParameterizedTest(name = "Weight on Earth: {0}")
    @MethodSource("negativeWeightProvider")
    @DisplayName("Test getWeight method with negative cases")
    void testGetWeightNegative(double weightOnEarth) {
        assertThrows(NegativeWeightException.class, () -> moon.getWeight(weightOnEarth));
    }
}
