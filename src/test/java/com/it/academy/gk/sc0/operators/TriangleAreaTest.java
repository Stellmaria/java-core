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
@DisplayName("Triangle Area Test")
class TriangleAreaTest {
    /**
     * An instance of the TriangleArea class used for testing.
     */
    private TriangleArea triangleArea;

    /**
     * Provides a stream of test data for the calculateArea method.
     *
     * @return a stream of test data for the calculateArea method.
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
     *
     * @param a            the first side of the triangle.
     * @param b            the second side of the triangle.
     * @param expectedArea the expected area of the triangle.
     */
    @ParameterizedTest(name = "{index} => a={0}, b={1}, expectedArea={2}")
    @DisplayName("Test calculateArea method with positive and negative cases")
    @MethodSource("testCalculateAreaProvider")
    void testCalculateArea(final double a, final double b, final double expectedArea) {
        double actual = triangleArea.calculateArea(a, b);

        assertEquals(expectedArea, actual);
    }
}
