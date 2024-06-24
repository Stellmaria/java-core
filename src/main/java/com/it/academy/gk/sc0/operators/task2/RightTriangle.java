package com.it.academy.gk.sc0.operators.task2;

import com.it.academy.gk.sc0.operators.exception.InvalidTriangleSideException;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

/**
 * RightTriangle is a utility class
 * that provides methods for calculating the area and hypotenuse of a right-angled triangle.
 *
 * <p>Example usage:</p>
 * <pre>
 *     double area = RightTriangle.calculateArea(3, 4);  // area will be 6.0
 *     double hypotenuse = RightTriangle.calculateHypotenuse(3, 4);  // hypotenuse will be 5.0
 * </pre>
 *
 * <p>Example for invalid side (will throw InvalidTriangleSideException):</p>
 * <pre>
 *     try {
 *         double area = RightTriangle.calculateArea(-3, 4);  // will throw InvalidTriangleSideException
 *     } catch (InvalidTriangleSideException e) {
 *         System.out.println(e.getMessage());  // prints "SideA must be greater than zero."
 *     }
 * </pre>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
@UtilityClass
public final class RightTriangle {
    /**
     * Constant for the error message when both sides of the triangle are invalid.
     * Used when throwing an {@link InvalidTriangleSideException}.
     */
    public static final String BOTH_SIDES_INVALID_MESSAGE = "Both sides must be greater than zero.";

    /**
     * Constant for the error message when the first side (SideA) of the triangle is invalid.
     * Used when throwing an {@link InvalidTriangleSideException}.
     */
    public static final String SIDE_A_INVALID_MESSAGE = "SideA must be greater than zero.";

    /**
     * Constant for the error message when the second side (SideB) of the triangle is invalid.
     * Used when throwing an {@link InvalidTriangleSideException}.
     */
    public static final String SIDE_B_INVALID_MESSAGE = "SideB must be greater than zero.";

    /**
     * Calculates the area of a right triangle given its two perpendicular sides.
     *
     * <p>Example usage:</p>
     * <pre>
     *     double area = RightTriangle.calculateArea(3, 4);  // area will be 6.0
     * </pre>
     *
     * <p>Example for invalid side (will throw InvalidTriangleSideException):</p>
     * <pre>
     *     try {
     *         double area = RightTriangle.calculateArea(-3, 4);  // will throw InvalidTriangleSideException
     *     } catch (InvalidTriangleSideException e) {
     *         System.out.println(e.getMessage());  // prints "SideA must be greater than zero."
     *     }
     * </pre>
     *
     * @param sideA The length of one of the perpendicular sides.
     * @param sideB The length of the other perpendicular side.
     * @return The area of the right triangle.
     * @throws InvalidTriangleSideException if either sideA or sideB is less than or equal to zero.
     */
    @SneakyThrows
    public static double calculateArea(final double sideA, final double sideB) {
        validateSides(sideA, sideB);

        return (sideA * sideB) / 2;
    }

    /**
     * Calculates the hypotenuse of a right triangle given its two perpendicular sides.
     *
     * <p>Example usage:</p>
     * <pre>
     *     double hypotenuse = RightTriangle.calculateHypotenuse(3, 4);  // hypotenuse will be 5.0
     * </pre>
     *
     * <p>Example for invalid side (will throw InvalidTriangleSideException):</p>
     * <pre>
     *     try {
     *         double hypotenuse = RightTriangle.calculateHypotenuse(3, -4);  // will throw InvalidTriangleSideException
     *     } catch (InvalidTriangleSideException e) {
     *         System.out.println(e.getMessage());  // prints "SideB must be greater than zero."
     *     }
     * </pre>
     *
     * @param sideA The length of one of the perpendicular sides.
     * @param sideB The length of the other perpendicular side.
     * @return The length of the hypotenuse.
     * @throws InvalidTriangleSideException if either sideA or sideB is less than or equal to zero.
     */
    @SneakyThrows
    public static double calculateHypotenuse(double sideA, double sideB) {
        validateSides(sideA, sideB);

        return Math.sqrt(sideA * sideA + sideB * sideB);
    }

    /**
     * Validates a single side of a triangle.
     *
     * <p>This method takes a double value representing the length of a side of a triangle and
     * validates it. If the side is less than or equal to zero, an
     * {@link InvalidTriangleSideException} is thrown with an appropriate detail message.</p>
     *
     * <p>Example usage:</p>
     * <pre>
     *     RightTriangle.validateSide(3, "SideA must be greater than zero.");  // No exception thrown
     * </pre>
     *
     * <p>Example for invalid side (will throw InvalidTriangleSideException):</p>
     * <pre>
     *     try {
     *         RightTriangle.validateSide(-3, "SideA must be greater than zero.");  // will throw InvalidTriangleSideException
     *     } catch (InvalidTriangleSideException e) {
     *         System.out.println(e.getMessage());  // prints "SideA must be greater than zero."
     *     }
     * </pre>
     *
     * @param side         the length of the side of the triangle.
     * @param errorMessage the error message to be used in the exception.
     * @throws InvalidTriangleSideException if the side is less than or equal to zero.
     */
    private static void validateSide(double side, String errorMessage) {
        if (side <= 0) {
            throw new InvalidTriangleSideException(errorMessage);
        }
    }

    /**
     * Validates the sides of a triangle.
     *
     * <p>This method takes two double values representing the lengths of the sides of a triangle and
     * validates them. If either of the sides is less than or equal to zero, an
     * {@link InvalidTriangleSideException} is thrown with an appropriate detail message.</p>
     *
     * <p>Example usage:</p>
     * <pre>
     *     RightTriangle.validateSides(3, 4);  // No exception thrown
     * </pre>
     *
     * <p>Example for invalid sides (will throw InvalidTriangleSideException):</p>
     * <pre>
     *     try {
     *         RightTriangle.validateSides(-3, 4);  // will throw InvalidTriangleSideException
     *     } catch (InvalidTriangleSideException e) {
     *         System.out.println(e.getMessage());  // prints "SideA must be greater than zero."
     *     }
     * </pre>
     *
     * <p>Example for both invalid sides (will throw InvalidTriangleSideException):</p>
     * <pre>
     *     try {
     *         RightTriangle.validateSides(-3, -4);  // will throw InvalidTriangleSideException
     *     } catch (InvalidTriangleSideException e) {
     *         System.out.println(e.getMessage());  // prints "Both sides must be greater than zero."
     *     }
     * </pre>
     *
     * @param sideA the length of the first side of the triangle.
     * @param sideB the length of the second side of the triangle.
     * @throws InvalidTriangleSideException if either sideA or sideB is less than or equal to zero.
     */
    @SneakyThrows
    private static void validateSides(double sideA, double sideB) {
        if (sideA <= 0 && sideB <= 0) {
            throw new InvalidTriangleSideException(BOTH_SIDES_INVALID_MESSAGE);
        }

        validateSide(sideA, SIDE_A_INVALID_MESSAGE);
        validateSide(sideB, SIDE_B_INVALID_MESSAGE);
    }
}
