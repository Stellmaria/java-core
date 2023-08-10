package com.it.academy.gk.sc0.operators;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The AppleDividerTest class is a test class for the AppleDivider class.
 */
@DisplayName("Apple Divider Test")
class AppleDividerTest {
    /**
     * This is a private field of the AppleDividerTest class that holds an instance of the AppleDivider class.
     * It is used in the test methods of the AppleDividerTest class
     * to call the methods of the AppleDivider class and test their functionality.
     */
    private AppleDivider divider;

    /**
     * Provides a stream of positive test cases for the testGetApplesPerStudent method.
     *
     * @return a stream of positive test cases for the testGetApplesPerStudent method
     */
    @Contract(pure = true)
    private static @NotNull Stream<Arguments> providePositiveTestCasesForGetApplesPerStudent() {
        return Stream.of(
                Arguments.of(4, 11, 2),
                Arguments.of(3, 9, 3),
                Arguments.of(5, 20, 4)
        );
    }

    /**
     * Provides a stream of positive test cases for the testGetRemainingApples method.
     *
     * @return a stream of positive test cases for the testGetRemainingApples method
     */
    @Contract(pure = true)
    private static @NotNull Stream<Arguments> providePositiveTestCasesForGetRemainingApples() {
        return Stream.of(
                Arguments.of(4, 11, 3),
                Arguments.of(3, 9, 0),
                Arguments.of(5, 20, 0)
        );
    }

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    public void setUp() {
        divider = new AppleDivider(0, 0);
    }

    /**
     * Tests the getApplesPerStudent method of the AppleDivider class with positive test cases.
     *
     * @param n                        an integer representing the number of students.
     * @param k                        an integer representing the number of apples.
     * @param expectedApplesPerStudent an integer representing the expected output number of apples per student.
     */
    @ParameterizedTest(name = "{index} => n={0}, k={1}, expectedApplesPerStudent={2}")
    @DisplayName("Test getApplesPerStudent method with positive test cases")
    @MethodSource("providePositiveTestCasesForGetApplesPerStudent")
    void testGetApplesPerStudentWithPositiveTestCases(final int n, final int k, final int expectedApplesPerStudent) {
        divider = new AppleDivider(n, k);

        int actual = divider.getApplesPerStudent();

        assertEquals(expectedApplesPerStudent, actual);
    }

    /**
     * Tests the getRemainingApples method of the AppleDivider class with positive test cases.
     *
     * @param n                       an integer representing the number of students.
     * @param k                       an integer representing the number of apples.
     * @param expectedRemainingApples an integer representing the expected output number of remaining apples.
     */
    @ParameterizedTest(name = "{index} => n={0}, k={1}, expectedRemainingApples={2}")
    @DisplayName("Test getRemainingApples method with positive test cases")
    @MethodSource("providePositiveTestCasesForGetRemainingApples")
    void testGetRemainingApplesWithPositiveTestCases(final int n, final int k, final int expectedRemainingApples) {
        divider = new AppleDivider(n, k);

        int actual = divider.getRemainingApples();

        assertEquals(expectedRemainingApples, actual);
    }
}
