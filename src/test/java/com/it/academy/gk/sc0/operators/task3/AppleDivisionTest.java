package com.it.academy.gk.sc0.operators.task3;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AppleDivisionTest {
    private static String MSG_STUDENTS_GT_ZERO;
    private static String MSG_APPLES_NOT_NEGATIVE;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException, IllegalAccessException {
        MSG_STUDENTS_GT_ZERO = getStaticFieldValue("MSG_STUDENTS_GT_ZERO");
        MSG_APPLES_NOT_NEGATIVE = getStaticFieldValue("MSG_APPLES_NOT_NEGATIVE");
    }

    private static String getStaticFieldValue(String fieldName) throws NoSuchFieldException, IllegalAccessException {
        var field = AppleDivision.class.getDeclaredField(fieldName);
        field.setAccessible(true);

        return (String) field.get(null);
    }

    private static @NotNull Stream<Arguments> provideValidArgumentsForCalculateApplesPerStudent() {
        return Stream.of(
                Arguments.of(5, 15, 3),
                Arguments.of(4, 10, 2),
                Arguments.of(3, 7, 2)
        );
    }

    @DisplayName("Valid cases for calculateApplesPerStudent")
    @ParameterizedTest(name = "With students = {0}, apples = {1}, expected apples per student = {2}")
    @MethodSource("provideValidArgumentsForCalculateApplesPerStudent")
    void testValidCasesForCalculateApplesPerStudent(final int n, final int k, final int expected) {
        var actual = AppleDivision.calculateApplesPerStudent(n, k);

        assertEquals(expected, actual);
    }

    private static @NotNull Stream<Arguments> provideValidArgumentsForCalculateRemainingApples() {
        return Stream.of(
                Arguments.of(5, 15, 0),
                Arguments.of(4, 10, 2),
                Arguments.of(3, 7, 1)
        );
    }

    @DisplayName("Valid cases for calculateRemainingApples")
    @ParameterizedTest(name = "With students = {0}, apples = {1}, expected remaining apples = {2}")
    @MethodSource("provideValidArgumentsForCalculateRemainingApples")
    void testValidCasesForCalculateRemainingApples(final int n, final int k, final int expected) {
        var actual = AppleDivision.calculateRemainingApples(n, k);

        assertEquals(expected, actual);
    }

    private static @NotNull Stream<Arguments> provideValidArgumentsForCalculateTotalApples() {
        return Stream.of(
                Arguments.of(5, 15, 15),
                Arguments.of(4, 10, 8),
                Arguments.of(3, 7, 6)
        );
    }

    @DisplayName("Valid cases for calculateTotalApples")
    @ParameterizedTest(name = "With students = {0}, apples = {1}, expected total apples = {2}")
    @MethodSource("provideValidArgumentsForCalculateTotalApples")
    void testValidCasesForCalculateTotalApples(final int n, final int k, final int expected) {
        var actual = AppleDivision.calculateTotalApples(n, k);

        assertEquals(expected, actual);
    }

    private static @NotNull Stream<Arguments> provideInvalidStudentNumbers() {
        return Stream.of(
                Arguments.of(0, 10),
                Arguments.of(-1, 10)
        );
    }

    @DisplayName("Test invalid number of students")
    @ParameterizedTest(name = "For students = {0}, apples = {1}")
    @MethodSource("provideInvalidStudentNumbers")
    void testInvalidNumberOfStudents(final int n, final int k) {
        assertThrows(IllegalArgumentException.class, () -> AppleDivision.calculateApplesPerStudent(n, k));
    }

    private static @NotNull Stream<Arguments> provideInvalidAppleNumbers() {
        return Stream.of(
                Arguments.of(5, -1)
        );
    }

    @DisplayName("Test invalid number of apples")
    @ParameterizedTest(name = "For students = {0}, apples = {1}")
    @MethodSource("provideInvalidAppleNumbers")
    void testInvalidNumberOfApples(final int n, final int k) {
        assertThrows(IllegalArgumentException.class, () -> AppleDivision.calculateApplesPerStudent(n, k));
    }

    private static @NotNull Stream<Arguments> provideInvalidNumbersForExceptionMessages() {
        return Stream.of(
                Arguments.of(0, 10, IllegalArgumentException.class, MSG_STUDENTS_GT_ZERO),
                Arguments.of(-1, 10, IllegalArgumentException.class, MSG_STUDENTS_GT_ZERO),
                Arguments.of(5, -1, IllegalArgumentException.class, MSG_APPLES_NOT_NEGATIVE),
                Arguments.of(5, 0, IllegalArgumentException.class, MSG_APPLES_NOT_NEGATIVE)
        );
    }

    @DisplayName("Test exception messages")
    @ParameterizedTest(name = "For students = {0}, apples = {1}, expected exception = {2}, expected message = {3}")
    @MethodSource("provideInvalidNumbersForExceptionMessages")
    void testExceptionMessages(int n, int k, Class<? extends Exception> expectedException, String expectedMessage) {
        var exception = assertThrows(expectedException, () -> AppleDivision.calculateApplesPerStudent(n, k));

        assertEquals(expectedMessage, exception.getMessage());
    }
}
