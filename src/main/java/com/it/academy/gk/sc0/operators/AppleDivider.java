package com.it.academy.gk.sc0.operators;

/**
 * Task 3.
 * N schoolchildren divide k apples equally, the non-divisible remainder remains in the basket.
 * <ul>
 *     <li>How many apples will each student get?</li>
 *     <li>How many apples will be left in the basket?</li>
 * </ul>
 * The program receives the numbers n and k as input and should output the desired number of apples (two numbers).
 */
public record AppleDivider(int n, int k) {

    /**
     * Returns the number of apples each student will receive.
     * This value is calculated by dividing the total number of apples (k) by the number of students (n).
     *
     * @return the number of apples each student will receive
     */
    public int getApplesPerStudent() {
        return k / n;
    }

    /**
     * Returns the number of remaining apples in the basket.
     * This value is calculated by finding the remainder when the total number of apples (k)
     * is divided by the number of students (n).
     *
     * @return the number of remaining apples in the basket
     */
    public int getRemainingApples() {
        return k % n;
    }
}

