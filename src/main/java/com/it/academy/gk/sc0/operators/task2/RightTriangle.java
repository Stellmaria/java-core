package com.it.academy.gk.sc0.operators.task2;

import com.it.academy.gk.sc0.operators.exception.InvalidTriangleSideException;

/**
 * The RightTriangle class provides methods to calculate the area of a right triangle.
 */
public class RightTriangle {
    /**
     * The constant value used to divide the product of the two sides of the right triangle to calculate its area.
     */
    private static final int AREA_DIVISOR = 2;
    /**
     * The error message used when an invalid side length is encountered.
     */
    private static final String INVALID_SIDE_LENGTH_MESSAGE = "Both sides must be greater than zero.";

    /**
     * Calculates the area of a right triangle with the given side lengths.
     *
     * @param sideA the length of side A
     * @param sideB the length of side B
     * @return the area of the right triangle
     * @throws InvalidTriangleSideException if either side length is less than or equal to zero, NaN, or infinite
     */
    public double calculateArea(double sideA, double sideB) throws InvalidTriangleSideException {
        validateSides(sideA, sideB);

        return (sideA * sideB) / AREA_DIVISOR;
    }

    /**
     * Calculates the length of the hypotenuse of a right triangle with the given side lengths.
     *
     * @param sideA the length of side A
     * @param sideB the length of side B
     * @return the length of the hypotenuse
     * @throws InvalidTriangleSideException if either side length is less than or equal to zero, NaN, or infinite
     */
    public double calculateHypotenuse(double sideA, double sideB) throws InvalidTriangleSideException {
        validateSides(sideA, sideB);

        return Math.sqrt(sideA * sideA + sideB * sideB);
    }

    /**
     * Validates the side lengths of the right triangle.
     *
     * @param sideA the length of side A
     * @param sideB the length of side B
     * @throws InvalidTriangleSideException if either side length is less than or equal to zero, NaN, or infinite
     */
    private void validateSides(double sideA, double sideB) throws InvalidTriangleSideException {
        if (sideA <= 0 || sideB <= 0 || Double.isNaN(sideA) || Double.isNaN(sideB) ||
            Double.isInfinite(sideA) || Double.isInfinite(sideB)) {
            throw new InvalidTriangleSideException(INVALID_SIDE_LENGTH_MESSAGE);
        }
    }
}
