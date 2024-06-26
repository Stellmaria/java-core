package com.it.academy.gk.sc0.operators.task2;

import com.it.academy.gk.sc0.operators.task2.exception.InvalidTriangleSideException;
import lombok.experimental.UtilityClass;

/**
 * Utility class for performing operations on right triangles.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public final class RightTriangle {
    private static final String BOTH_SIDES_INVALID_MESSAGE = "Both sides must be greater than zero.";
    private static final String SIDE_A_INVALID_MESSAGE = "SideA must be greater than zero.";
    private static final String SIDE_B_INVALID_MESSAGE = "SideB must be greater than zero.";

    /**
     * Calculates the area of a right triangle.
     *
     * @param sideA The length of the first side.
     * @param sideB The length of the second side.
     * @return The area of the right triangle.
     * @throws InvalidTriangleSideException If either sideA or sideB is less than or equal to zero.
     */
    public static double calculateArea(final double sideA, final double sideB) throws InvalidTriangleSideException {
        validateSides(sideA, sideB);

        return (sideA * sideB) / 2;
    }

    /**
     * Calculates the length of the hypotenuse of a right triangle.
     *
     * @param sideA The length of the first side.
     * @param sideB The length of the second side.
     * @return The length of the hypotenuse.
     * @throws InvalidTriangleSideException If either sideA or sideB is less than or equal to zero.
     */
    public static double calculateHypotenuse(double sideA, double sideB) throws InvalidTriangleSideException {
        validateSides(sideA, sideB);

        return Math.sqrt(sideA * sideA + sideB * sideB);
    }

    /**
     * Validates the lengths of the sides of a right triangle.
     *
     * @param sideA The length of the first side.
     * @param sideB The length of the second side.
     * @throws InvalidTriangleSideException If either sideA or sideB is less than or equal to zero.
     */
    private static void validateSides(double sideA, double sideB) throws InvalidTriangleSideException {
        if (sideA <= 0 && sideB <= 0) {
            throw new InvalidTriangleSideException(BOTH_SIDES_INVALID_MESSAGE);
        }

        if (sideA <= 0) {
            throw new InvalidTriangleSideException(SIDE_A_INVALID_MESSAGE);
        }

        if (sideB <= 0) {
            throw new InvalidTriangleSideException(SIDE_B_INVALID_MESSAGE);
        }
    }
}
