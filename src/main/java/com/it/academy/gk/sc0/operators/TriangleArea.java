package com.it.academy.gk.sc0.operators;

/**
 * Task 2.
 * Write a program that reads the lengths of two sides in a right triangle and prints its area.
 * This class contains a method to calculate the area of a right triangle.
 */
public class TriangleArea {
    /**
     * The constant used to divide the product of the two legs by 2 to calculate the area of a right triangle.
     */
    private static final int DIVISOR = 2;

    /**
     * Calculates the area of a right triangle given the lengths of its two legs.
     *
     * @param a The length of the first leg.
     * @param b The length of the second leg.
     * @return The calculated area of the right triangle.
     */
    public double calculateArea(double a, double b) {
        return (a * b) / DIVISOR;
    }
}
