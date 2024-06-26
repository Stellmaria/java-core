package com.it.academy.gk.sc0.operators.task7;

import com.it.academy.gk.sc0.operators.task7.exception.InvalidAgeException;
import lombok.experimental.UtilityClass;

/**
 * A utility class for classifying ages into categories.
 *
 * @author Anastasia Melnikova
 * @version 2.0
 * @since 2024-06-25
 */
@UtilityClass
public final class AgeClassifier {
    /**
     * The upper age limit for the category "Child".
     */
    private static final int CHILD_UPPER_LIMIT = 17;

    /**
     * The upper age limit for the category "Adult".
     */
    private static final int ADULT_UPPER_LIMIT = 69;

    /**
     * The lower age limit for the label "Long-lived".
     */
    private static final int LONG_LIVED_LOWER_LIMIT = 120;

    /**
     * A constant holding the default message for negative age.
     */
    private static final String INVALID_AGE_MESSAGE = "Age cannot be negative.";

    /**
     * A constant for the label "Child".
     */
    private static final String CHILD_LABEL = "Child";

    /**
     * A constant for the label "Adult".
     */
    private static final String ADULT_LABEL = "Adult";

    /**
     * A constant for the label "Elderly".
     */
    private static final String ELDERLY_LABEL = "Elderly";

    /**
     * A constant for the label "Long-lived".
     */
    private static final String LONG_LIVED_LABEL = "Long-lived";

    /**
     * A constant for space used in labels.
     */
    private static final String SPACE = " ";

    /**
     * Classifies the given age into a category.
     *
     * @param age The age to be classified.
     * @return A string representing the age category.
     * @throws InvalidAgeException If the age is negative.
     */
    public static String classifyAge(final int age) throws InvalidAgeException {
        String result;

        validateAge(age);

        if (age <= CHILD_UPPER_LIMIT) {
            result = CHILD_LABEL;
        } else if (age <= ADULT_UPPER_LIMIT) {
            result = ADULT_LABEL;
        } else {
            result = ELDERLY_LABEL;
            if (age >= LONG_LIVED_LOWER_LIMIT) {
                result += SPACE + LONG_LIVED_LABEL;
            }
        }

        return result;
    }

    /**
     * Validates the given age.
     *
     * @param age The age to be validated.
     * @throws InvalidAgeException If the age is negative.
     */
    public static void validateAge(final int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException(INVALID_AGE_MESSAGE);
        }
    }
}
