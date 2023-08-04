package com.it.academy.gk.sc0.operators;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for the AppleDivider class.
 */
class AppleDividerTest {
    private AppleDivider divider;

    /**
     * This method provides positive test cases for the testGetApplesPerStudentWithPositiveTestCases method.
     *
     * @return A stream of test cases, where each test case is an array of objects.
     */
    @Contract(pure = true)
    private static @NotNull Stream<Object[]> providePositiveTestCasesForGetApplesPerStudent() {
        return Stream.of(
                new Object[]{4, 11, 2},
                new Object[]{3, 9, 3},
                new Object[]{5, 20, 4}
        );
    }

    /**
     * This method provides positive test cases for the testGetRemainingApplesWithPositiveTestCases method.
     *
     * @return A stream of test cases where each case is an array of objects
     */
    @Contract(pure = true)
    private static @NotNull Stream<Object[]> providePositiveTestCasesForGetRemainingApples() {
        return Stream.of(
                new Object[]{4, 11, 3},
                new Object[]{3, 9, 0},
                new Object[]{5, 20, 0}
        );
    }

    /**
     * This method sets up the test environment before each test.
     * It creates a new instance of the AppleDivider class.
     */
    @BeforeEach
    public void setUp() {
        divider = new AppleDivider(0, 0);
    }

    /**
     * This method tests the getApplesPerStudent method of the AppleDivider class using positive test cases.
     * The test cases are provided by the providePositiveTestCasesForGetApplesPerStudent method.
     *
     * @param n                        The number of students
     * @param k                        The number of apples
     * @param expectedApplesPerStudent The expected number of apples per student
     */
    @ParameterizedTest(name = "{index} => n={0}, k={1}, expectedApplesPerStudent={2}")
    @DisplayName("Test getApplesPerStudent method with positive test cases")
    @MethodSource("providePositiveTestCasesForGetApplesPerStudent")
    void testGetApplesPerStudentWithPositiveTestCases(int n, int k, int expectedApplesPerStudent) {
        divider = new AppleDivider(n, k);

        assertEquals(expectedApplesPerStudent, divider.getApplesPerStudent());
    }

    /**
     * This method tests the getRemainingApples method of the AppleDivider class using positive test cases.
     * The test cases are provided by the providePositiveTestCasesForGetRemainingApples method.
     *
     * @param n                       The number of students
     * @param k                       The number of apples
     * @param expectedRemainingApples The expected number of remaining apples
     */
    @ParameterizedTest(name = "{index} => n={0}, k={1}, expectedRemainingApples={2}")
    @DisplayName("Test getRemainingApples method with positive test cases")
    @MethodSource("providePositiveTestCasesForGetRemainingApples")
    void testGetRemainingApplesWithPositiveTestCases(int n, int k, int expectedRemainingApples) {
        divider = new AppleDivider(n, k);

        assertEquals(expectedRemainingApples, divider.getRemainingApples());
    }
}
