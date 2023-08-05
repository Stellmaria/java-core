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
 * The AgeCategoryTest class is a test class for the AgeCategory class.
 * <p>
 * This class contains several methods to test the functionality of the AgeCategory class, including a method
 * to provide test data and a method to test the getAgeCategory method of the AgeCategory class.
 */
class AgeCategoryTest {
    /**
     * This is a private field of the AgeCategoryTest class that holds an instance of the AgeCategory class.
     * It is used in the test methods of the AgeCategoryTest class to call the methods
     * of the AgeCategory class and test their functionality.
     */
    private AgeCategory ageCategory;

    /**
     * Provides a stream of test data for the testGetAgeCategory method.
     * <p>
     * This method returns a stream of arrays, where each array represents a test case with an input age and
     * an expected output age category.
     *
     * @return a stream of test data for the testGetAgeCategory method
     */
    @Contract(pure = true)
    static @NotNull Stream<Object[]> ageCategoryProvider() {
        return Stream.of(
                new Object[]{0, "Child"},
                new Object[]{17, "Child"},
                new Object[]{18, "Adult"},
                new Object[]{69, "Adult"},
                new Object[]{70, "Senior"},
                new Object[]{119, "Senior"},
                new Object[]{120, "Senior Supercentenarian"},
                new Object[]{-1, "Invalid age"}
        );
    }

    /**
     * Sets up the test environment before each test.
     * <p>
     * This method creates a new instance of the AgeCategory class and assigns it to the ageCategory field.
     */
    @BeforeEach
    void setUp() {
        ageCategory = new AgeCategory();
    }

    /**
     * Tests the getAgeCategory method of the AgeCategory class with valid and invalid ages.
     * <p>
     * This method takes an integer representing an age and a string representing the expected output
     * age category as arguments.
     * It calls the getAgeCategory method of the AgeCategory class with the provided age
     * and asserts that the result is equal to the expected output age category.
     *
     * @param age      an integer representing an age
     * @param expected a string representing the expected output age category
     */
    @ParameterizedTest(name = "{index} => age={0}, expected={1}")
    @DisplayName("Test getAgeCategory method with valid and invalid ages")
    @MethodSource("ageCategoryProvider")
    void testGetAgeCategory(int age, String expected) {
        var actual = ageCategory.getAgeCategory(age);

        assertEquals(expected, actual);
    }
}
