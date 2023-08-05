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
 * The AppleDividerTest class is a test class for the AppleDivider class.
 * <p>
 * This class contains several methods to test the functionality of the AppleDivider class, including methods
 * to provide test data and methods to test the getApplesPerStudent and getRemainingApples methods
 * of the AppleDivider class.
 */
class AppleDividerTest {
    /**
     * This is a private field of the AppleDividerTest class that holds an instance of the AppleDivider class.
     * It is used in the test methods of the AppleDividerTest class to call the methods
     * of the AppleDivider class and test their functionality.
     */
    private AppleDivider divider;

    /**
     * Provides a stream of positive test cases for the testGetApplesPerStudent method.
     * <p>
     * This method returns a stream of arrays, where each array represents a test case with an input number
     * of students, an input number of apples, and an expected output number of apples per student.
     *
     * @return a stream of positive test cases for the testGetApplesPerStudent method
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
     * Provides a stream of positive test cases for the testGetRemainingApples method.
     * <p>
     * This method returns a stream of arrays, where each array represents a test case with an input number
     * of students, an input number of apples, and an expected output number of remaining apples.
     *
     * @return a stream of positive test cases for the testGetRemainingApples method
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
     * Sets up the test environment before each test.
     * <p>
     * This method creates a new instance of the AppleDivider class with default arguments and assigns
     * it to the divider field.
     */
    @BeforeEach
    public void setUp() {
        divider = new AppleDivider(0, 0);
    }

    /**
     * Tests the getApplesPerStudent method of the AppleDivider class with positive test cases.
     * <p>
     * This method takes an integer representing the number of students, an integer representing the number
     * of apples, and an integer representing the expected output number of apples per student as arguments.
     * It creates a new instance of the AppleDivider class with the provided arguments and calls
     * its getApplesPerStudent method.
     * It then asserts that the result is equal to the expected output number
     * of apples per student.
     *
     * @param n                        an integer representing the number of students
     * @param k                        an integer representing the number of apples
     * @param expectedApplesPerStudent an integer representing the expected output number of apples per student
     */
    @ParameterizedTest(name = "{index} => n={0}, k={1}, expectedApplesPerStudent={2}")
    @DisplayName("Test getApplesPerStudent method with positive test cases")
    @MethodSource("providePositiveTestCasesForGetApplesPerStudent")
    void testGetApplesPerStudentWithPositiveTestCases(int n, int k, int expectedApplesPerStudent) {
        divider = new AppleDivider(n, k);

        var actual = divider.getApplesPerStudent();

        assertEquals(expectedApplesPerStudent, actual);
    }

    /**
     * Tests the getRemainingApples method of the AppleDivider class with positive test cases.
     * <p>
     * This method takes an integer representing the number of students, an integer representing the number
     * of apples, and an integer representing the expected output number of remaining apples as arguments.
     * It creates a new instance of the AppleDivider class with the provided arguments and calls
     * its getRemainingApples method.
     * It then asserts that the result is equal to the expected output number
     * of remaining apples.
     *
     * @param n                       an integer representing the number of students
     * @param k                       an integer representing the number of apples
     * @param expectedRemainingApples an integer representing the expected output number of remaining apples
     */
    @ParameterizedTest(name = "{index} => n={0}, k={1}, expectedRemainingApples={2}")
    @DisplayName("Test getRemainingApples method with positive test cases")
    @MethodSource("providePositiveTestCasesForGetRemainingApples")
    void testGetRemainingApplesWithPositiveTestCases(int n, int k, int expectedRemainingApples) {
        divider = new AppleDivider(n, k);

        var actual = divider.getRemainingApples();

        assertEquals(expectedRemainingApples, actual);
    }
}
