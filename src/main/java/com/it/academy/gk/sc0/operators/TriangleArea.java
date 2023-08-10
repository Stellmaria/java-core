package com.it.academy.gk.sc0.operators;

/**
 * Task 2.
 * Write a program that reads the lengths of two sides in a right triangle and prints its area.
 * This class contains a method to calculate the area of a right triangle.
 */
public class TriangleArea {
    /**
     * The constant used to divide the product of the two legs by two to calculate the area of a right triangle.
     */
    private static final int DIVISOR = 2;

    /**
     * Calculates the area of a right triangle given the lengths of its two legs.
     * <p/>
     * This method takes two double arguments
     * representing the lengths of the two legs of a right triangle and returns the area of the triangle.
     * The area is calculated by multiplying the lengths of the two legs together and dividing the result by 2.
     *
     * @param a the length of the first leg of the right triangle.
     * @param b the length of the second leg of the right triangle.
     * @return the area of the right triangle.
     */
    public double calculateArea(final double a, final double b) {
        return (a * b) / DIVISOR;
    }
}
