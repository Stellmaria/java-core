package com.it.academy.gk.sc0.operators.task2;

import com.it.academy.gk.sc0.operators.exception.InvalidTriangleSideException;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * The RightTriangleTest class is a test class for the RightTriangle class.
 * It contains tests for the calculateArea and calculateHypotenuse methods of the RightTriangle class.
 */
@SuppressFBWarnings("NP_NONNULL_RETURN_VIOLATION")
class RightTriangleTest {

    /**
     * The rightTriangle field is an instance of the RightTriangle class.
     */
    private RightTriangle rightTriangle;

    /**
     * The provideValidAreaArguments method provides test data for the testCalculateArea method.
     * It returns a Stream of Arguments, where each Argument contains two sides of a right triangle and the expected area of that triangle.
     *
     * @return a Stream of Arguments for the testCalculateArea method
     */
    static @NotNull Stream<Arguments> provideValidAreaArguments() {
        return Stream.of(
                Arguments.of(3.0, 4.0, 6.0),
                Arguments.of(5.0, 5.0, 12.5),
                Arguments.of(1.0, 1.0, 0.5)
        );
    }

    /**
     * The provideValidHypotenuseArguments method provides test data for the testCalculateHypotenuse method.
     * It returns a Stream of Arguments, where each Argument contains two sides of a right triangle and the expected length of its hypotenuse.
     *
     * @return a Stream of Arguments for the testCalculateHypotenuse method
     */
    static @NotNull Stream<Arguments> provideValidHypotenuseArguments() {
        return Stream.of(
                Arguments.of(3.0, 4.0, 5.0),
                Arguments.of(5.0, 5.0, 7.0710678118654755),
                Arguments.of(1.0, 1.0, 1.4142135623730951)
        );
    }

    /**
     * The provideInvalidSideArguments method provides invalid test data for both testInvalidSidesCalculateArea and testInvalidSidesCalculateHypotenuse methods.
     * It returns a Stream of Arguments, where each Argument contains two invalid sides of a right triangle.
     *
     * @return a Stream of Arguments for both testInvalidSidesCalculateArea and testInvalidSidesCalculateHypotenuse methods
     */
    static @NotNull Stream<Arguments> provideInvalidSideArguments() {
        return Stream.of(
                Arguments.of(0.0, 4.0),
                Arguments.of(3.0, 0.0),
                Arguments.of(-1.0, 4.0),
                Arguments.of(Double.NaN, 4.0),
                Arguments.of(Double.POSITIVE_INFINITY, 4.0),
                Arguments.of(Double.NEGATIVE_INFINITY, 4.0)
        );
    }

    /**
     * The setUp method is called before each test method.
     * It initializes the rightTriangle field with a new instance of the RightTriangle class.
     */
    @BeforeEach
    void setUp() {
        rightTriangle = new RightTriangle();
    }

    /**
     * The testCalculateArea method tests the calculateArea method of the RightTriangle class with various valid inputs.
     * It is a parameterized test that uses the data provided by the provideValidAreaArguments method.
     *
     * @param sideA    one side of a right triangle
     * @param sideB    another side of a right triangle
     * @param expected the expected area of the triangle
     */
    @ParameterizedTest(name = "Calculate area with side A = {0}, side B = {1}, expected area = {2}")
    @MethodSource("provideValidAreaArguments")
    @DisplayName("Valid cases for calculateArea method")
    void testCalculateArea(final double sideA, final double sideB,
                           final double expected) throws InvalidTriangleSideException {
        var actual = rightTriangle.calculateArea(sideA, sideB);

        assertEquals(expected, actual);
    }

    /**
     * The testCalculateHypotenuse method tests the calculateHypotenuse method of the RightTriangle class with various valid inputs.
     * It is a parameterized test that uses the data provided by the provideValidHypotenuseArguments method.
     *
     * @param sideA    one side of a right triangle
     * @param sideB    another side of a right triangle
     * @param expected the expected length of the hypotenuse
     */
    @ParameterizedTest(name = "Calculate hypotenuse with side A = {0}, side B = {1}, expected hypotenuse = {2}")
    @MethodSource("provideValidHypotenuseArguments")
    @DisplayName("Valid cases for calculateHypotenuse method")
    void testCalculateHypotenuse(final double sideA, final double sideB,
                                 final double expected) throws InvalidTriangleSideException {
        var actual = rightTriangle.calculateHypotenuse(sideA, sideB);

        assertEquals(expected, actual);
    }

    /**
     * The testInvalidSidesCalculateArea method tests the calculateArea method of the RightTriangle class with various invalid inputs.
     * It is a parameterized test that uses the data provided by the provideInvalidSideArguments method.
     *
     * @param sideA one side of a right triangle
     * @param sideB another side of a right triangle
     */
    @ParameterizedTest(name = "Calculate area with invalid sides A = {0}, B = {1}")
    @MethodSource("provideInvalidSideArguments")
    @DisplayName("Invalid cases for both calculateArea and calculateHypotenuse methods")
    void testInvalidSidesCalculateArea(final double sideA, final double sideB) {
        assertThrows(InvalidTriangleSideException.class, () -> rightTriangle.calculateArea(sideA, sideB));
    }

    /**
     * The testInvalidSidesCalculateHypotenuse method tests the calculateHypotenuse method of the RightTriangle class with various invalid inputs.
     * It is a parameterized test that uses the data provided by the provideInvalidSideArguments method.
     *
     * @param sideA one side of a right triangle
     * @param sideB another side of a right triangle
     */
    @ParameterizedTest(name = "Calculate hypotenuse with invalid sides A = {0}, B = {1}")
    @MethodSource("provideInvalidSideArguments")
    @DisplayName("Invalid cases for both calculateArea and calculateHypotenuse methods")
    void testInvalidSidesCalculateHypotenuse(final double sideA, final double sideB) {
        assertThrows(InvalidTriangleSideException.class, () -> rightTriangle.calculateHypotenuse(sideA, sideB));
    }
}
