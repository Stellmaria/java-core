package com.it.academy.gk.sc0.operators;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class tests the TriangleArea class.
 */
class TriangleAreaTest {
    /**
     * An instance of the TriangleArea class used for testing.
     */
    private TriangleArea triangleArea;

    /**
     * Provides a stream of test data for the calculateArea method.
     *
     * @return a stream of test data for the calculateArea method
     */
    private static @NotNull Stream<Arguments> testCalculateAreaProvider() {
        return Stream.of(
                Arguments.of(3, 4, 6),
                Arguments.of(5, 12, 30),
                Arguments.of(0, 0, 0),
                Arguments.of(-3, 4, -6),
                Arguments.of(3, -4, -6),
                Arguments.of(-3, -4, 6)
        );
    }

    /**
     * Sets up the test by creating a new instance of TriangleArea.
     */
    @BeforeEach
    public void setUp() {
        triangleArea = new TriangleArea();
    }

    /**
     * Tests the calculateArea method of TriangleArea.
     * <p>
     * This method is a parameterized test that uses data from the `testCalculateAreaProvider`
     * method to test the `calculateArea` method in `TriangleArea`.
     * Each run of the test checks
     * if the actual result from calling the `calculateArea` method with the provided input parameters
     * is equal to the expected result.
     *
     * @param a            the first side of the triangle
     * @param b            the second side of the triangle
     * @param expectedArea the expected area of the triangle
     */
    @ParameterizedTest(name = "{index} => a={0}, b={1}, expectedArea={2}")
    @DisplayName("Test calculateArea method with positive and negative cases")
    @MethodSource("testCalculateAreaProvider")
    void testCalculateArea(double a, double b, double expectedArea) {
        var actual = triangleArea.calculateArea(a, b);

        assertEquals(expectedArea, actual);
    }
}

