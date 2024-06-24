package com.it.academy.gk.sc0.operators.task7;

import com.it.academy.gk.sc0.operators.exception.InvalidAgeException;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AgeClassifierTest {
    private static String INVALID_AGE_MESSAGE;
    private static String CHILD_LABEL;
    private static String ADULT_LABEL;
    private static String ELDERLY_LABEL;
    private static String LONG_LIVED_LABEL;

    @BeforeAll
    public static void beforeAll() throws NoSuchFieldException, IllegalAccessException {
        var invalidAgeMessageField = AgeClassifier.class.getDeclaredField("INVALID_AGE_MESSAGE");
        invalidAgeMessageField.setAccessible(true);
        INVALID_AGE_MESSAGE = (String) invalidAgeMessageField.get(null);

        var childLabelField = AgeClassifier.class.getDeclaredField("CHILD_LABEL");
        childLabelField.setAccessible(true);
        CHILD_LABEL = (String) childLabelField.get(null);

        var adultLabelField = AgeClassifier.class.getDeclaredField("ADULT_LABEL");
        adultLabelField.setAccessible(true);
        ADULT_LABEL = (String) adultLabelField.get(null);

        var elderlyLabelField = AgeClassifier.class.getDeclaredField("ELDERLY_LABEL");
        elderlyLabelField.setAccessible(true);
        ELDERLY_LABEL = (String) elderlyLabelField.get(null);

        var longLivedLabelField = AgeClassifier.class.getDeclaredField("LONG_LIVED_LABEL");
        longLivedLabelField.setAccessible(true);
        LONG_LIVED_LABEL = (String) longLivedLabelField.get(null);
    }

    @ParameterizedTest(name = "For age {0}, the classification should be {1}")
    @MethodSource("validAgeProvider")
    @DisplayName("Valid ages")
    void testClassifyAge(final int age, final String expected) throws InvalidAgeException {
        String actual = AgeClassifier.classifyAge(age);
        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> validAgeProvider() {
        return Stream.of(
                Arguments.of(0, CHILD_LABEL),
                Arguments.of(17, CHILD_LABEL),
                Arguments.of(18, ADULT_LABEL),
                Arguments.of(69, ADULT_LABEL),
                Arguments.of(70, ELDERLY_LABEL),
                Arguments.of(119, ELDERLY_LABEL),
                Arguments.of(120, ELDERLY_LABEL + " " + LONG_LIVED_LABEL),
                Arguments.of(130, ELDERLY_LABEL + " " + LONG_LIVED_LABEL)
        );
    }

    @ParameterizedTest(name = "Invalid age {0} should throw InvalidAgeException")
    @MethodSource("invalidAgeProvider")
    @DisplayName("Invalid ages")
    void testInvalidAges(final int age) {
        assertThrows(InvalidAgeException.class, () -> AgeClassifier.classifyAge(age));
    }

    static @NotNull Stream<Arguments> invalidAgeProvider() {
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(-10),
                Arguments.of(-100)
        );
    }

    @Test
    @DisplayName("Exception message for invalid ages should be correct")
    void testInvalidAgeExceptionMessage() {
        var exception = assertThrows(InvalidAgeException.class, () -> AgeClassifier.classifyAge(-1));

        assertEquals(INVALID_AGE_MESSAGE, exception.getMessage());
    }
}
