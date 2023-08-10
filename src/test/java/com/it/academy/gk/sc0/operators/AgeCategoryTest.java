package com.it.academy.gk.sc0.operators;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.SneakyThrows;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The AgeCategoryTest class is a test class for the AgeCategory class.
 */
@DisplayName("Age Category Test")
class AgeCategoryTest {
    /**
     * The value of the private static field CHILD in the AgeCategory class.
     */
    private static String CHILD;
    /**
     * The value of the private static field ADULT in the AgeCategory class.
     */
    private static String ADULT;
    /**
     * The value of the private static field SENIOR in the AgeCategory class.
     */
    private static String SENIOR;
    /**
     * The value of the private static field SUPERCENTENARIAN in the AgeCategory class.
     */
    private static String SUPERCENTENARIAN;
    /**
     * The value of the private static field INVALID_AGE in the AgeCategory class.
     */
    private static String INVALID_AGE;
    /**
     * The value of the private static field SEPARATOR in the AgeCategory class.
     */
    private static String SEPARATOR;
    /**
     * An instance of the AgeCategory class used for testing.
     */
    private AgeCategory ageCategory;

    /**
     * This method is called before all tests are run.
     */
    @SneakyThrows
    @BeforeAll
    static void setAll() {
        var childField = AgeCategory.class.getDeclaredField("CHILD");
        childField.setAccessible(true);
        CHILD = (String) childField.get(null);

        var adultField = AgeCategory.class.getDeclaredField("ADULT");
        adultField.setAccessible(true);
        ADULT = (String) adultField.get(null);

        var seniorField = AgeCategory.class.getDeclaredField("SENIOR");
        seniorField.setAccessible(true);
        SENIOR = (String) seniorField.get(null);

        var supercentenarianFiled = AgeCategory.class.getDeclaredField("SUPERCENTENARIAN");
        supercentenarianFiled.setAccessible(true);
        SUPERCENTENARIAN = (String) supercentenarianFiled.get(null);

        var invalidAgeFiled = AgeCategory.class.getDeclaredField("INVALID_AGE");
        invalidAgeFiled.setAccessible(true);
        INVALID_AGE = (String) invalidAgeFiled.get(null);

        var separatorFiled = AgeCategory.class.getDeclaredField("SEPARATOR");
        separatorFiled.setAccessible(true);
        SEPARATOR = (String) separatorFiled.get(null);
    }

    /**
     * Sets up the test environment before each test.
     */
    @BeforeEach
    void setUp() {
        ageCategory = new AgeCategory();
    }

    /**
     * Provides a stream of test data for the testGetAgeCategory method.
     *
     * @return a stream of test data for the testGetAgeCategory method.
     */
    @SuppressFBWarnings("NP_NONNULL_RETURN_VIOLATION")
    @Contract(pure = true)
    static @NotNull Stream<Arguments> ageCategoryProvider() {
        return Stream.of(
                Arguments.of(0, CHILD),
                Arguments.of(17, CHILD),
                Arguments.of(18, ADULT),
                Arguments.of(69, ADULT),
                Arguments.of(70, SENIOR),
                Arguments.of(119, SENIOR),
                Arguments.of(120, SENIOR + SEPARATOR + SUPERCENTENARIAN),
                Arguments.of(-1, INVALID_AGE)
        );
    }

    /**
     * Tests the getAgeCategory method of the AgeCategory class with valid and invalid ages.
     *
     * @param age      an integer representing an age.
     * @param expected a string representing the expected output age category.
     */
    @ParameterizedTest(name = "{index} => age={0}, expected={1}")
    @DisplayName("Test getAgeCategory method with valid and invalid ages")
    @MethodSource("ageCategoryProvider")
    void testGetAgeCategory(final int age, final String expected) {
        String actual = ageCategory.getAgeCategory(age);

        assertEquals(expected, actual);
    }
}
