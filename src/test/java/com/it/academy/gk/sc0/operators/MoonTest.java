package com.it.academy.gk.sc0.operators;

import com.it.academy.gk.sc0.operators.exception.NegativeWeightException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * The MoonTest class is a test class for the Moon class.
 */
@DisplayName("Moon Test")
class MoonTest {
    /**
     * This is a private static field of the MoonTest class that holds the value of the MOON_GRAVITY constant
     * from the Moon class.
     * It is used in the test methods of the MoonTest class
     * to compare the expected and actual values of calculations involving the moon's gravity.
     */
    private static double MOON_GRAVITY;
    /**
     * This is a private field of the MoonTest class that holds an instance of the Moon class.
     * It is used in the test methods of the MoonTest class
     * to call the methods of the Moon class and test their functionality.
     */
    private Moon moon;

    /**
     * This method is called before all tests are run.
     * It uses reflection
     * to access and retrieve the value of the MOON_GRAVITY constant from the Moon class
     * and assigns it to the MOON_GRAVITY field in this test class.
     */
    @SneakyThrows
    @BeforeAll
    static void beforeAll() {
        var moonGravityField = Moon.class.getDeclaredField("MOON_GRAVITY");
        moonGravityField.setAccessible(true);
        MOON_GRAVITY = (double) moonGravityField.get(null);
    }

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    void setUp() {
        moon = new Moon();
    }

    /**
     * Provides a stream of test data for a method that calculates the weight of an object on the moon.
     *
     * @return a stream of test data for a method that calculates the weight of an object on the moon
     */
    @Contract(pure = true)
    private static @NotNull Stream<Arguments> weightProvider() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(50, 50 * MOON_GRAVITY),
                Arguments.of(100, 100 * MOON_GRAVITY)
        );
    }

    /**
     * Provides a stream of negative test cases for a method that calculates the weight of an object on the moon.
     *
     * @return a stream of negative test cases for a method that calculates the weight of an object on the moon
     */
    @Contract(pure = true)
    private static @NotNull Stream<Arguments> negativeWeightProvider() {
        return Stream.of(
                Arguments.of(-50),
                Arguments.of(-100)
        );
    }

    /**
     * Tests the getWeight method of the Moon class with positive cases.
     * <p/>
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
    void testGetWeight(final double weightOnEarth, final double expectedWeightOnMoon) {
        double actual = moon.getWeight(weightOnEarth);

        assertEquals(expectedWeightOnMoon, actual);
    }

    /**
     * Tests the getWeight method of the Moon class with negative cases.
     *
     * @param weightOnEarth a double representing a negative weight on Earth
     */
    @ParameterizedTest(name = "Weight on Earth: {0}")
    @MethodSource("negativeWeightProvider")
    @DisplayName("Test getWeight method with negative cases")
    void testGetWeightNegative(final double weightOnEarth) {
        assertThrows(NegativeWeightException.class, () -> moon.getWeight(weightOnEarth));
    }
}
