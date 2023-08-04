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
 * This class contains tests for the TriangleArea class.
 */
class TriangleAreaTest {
    private TriangleArea triangleArea;

    /**
     * Provides test data for the testCalculateArea method.
     *
     * @return A stream of arguments for the testCalculateArea method.
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
     * Set up a method that creates a new instance of the TriangleArea class before each test.
     */
    @BeforeEach
    public void setUp() {
        triangleArea = new TriangleArea();
    }

    /**
     * Parameterized test that checks the calculateArea method with positive and negative cases.
     *
     * @param a            The length of the first leg.
     * @param b            The length of the second leg.
     * @param expectedArea The expected area of the right triangle.
     */
    @ParameterizedTest(name = "{index} => a={0}, b={1}, expectedArea={2}")
    @DisplayName("Test calculateArea method with positive and negative cases")
    @MethodSource("testCalculateAreaProvider")
    void testCalculateArea(double a, double b, double expectedArea) {
        assertEquals(expectedArea, triangleArea.calculateArea(a, b));
    }
}
