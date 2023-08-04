package com.it.academy.gk.sc0.operators;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for the AgeCategory class.
 */
class AgeCategoryTest {
    private AgeCategory ageCategory;

    /**
     * This method provides test cases for the testGetAgeCategory method.
     *
     * @return A stream of test cases, where each test case is an array of objects.
     */
    @SuppressFBWarnings("NP_NONNULL_RETURN_VIOLATION")
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
     * This method sets up the test environment before each test.
     * It creates a new instance of the AgeCategory class.
     */
    @BeforeEach
    void setUp() {
        ageCategory = new AgeCategory();
    }

    /**
     * This method tests the getAgeCategory method of the AgeCategory class using positive and negative test cases.
     * The test cases are provided by the ageCategoryProvider method.
     *
     * @param age      The input age to getAgeCategory method
     * @param expected The expected output of the getAgeCategory method
     */
    @ParameterizedTest(name = "{index} => age={0}, expected={1}")
    @DisplayName("Test getAgeCategory method with valid and invalid ages")
    @MethodSource("ageCategoryProvider")
    void testGetAgeCategory(int age, String expected) {
        assertEquals(expected, ageCategory.getAgeCategory(age));
    }
}
