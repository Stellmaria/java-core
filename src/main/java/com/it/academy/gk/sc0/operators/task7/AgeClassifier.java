package com.it.academy.gk.sc0.operators.task7;

import com.it.academy.gk.sc0.operators.exception.InvalidAgeException;

/**
 * The AgeClassifier class provides a method to classify a given age into one of several categories.
 */
public class AgeClassifier {
    /**
     * The upper limit for the child age category.
     */
    private static final int CHILD_UPPER_LIMIT = 17;
    /**
     * The upper limit for the adult age category.
     */
    private static final int ADULT_UPPER_LIMIT = 69;
    /**
     * The lower limit for the long-lived age category.
     */
    private static final int LONG_LIVED_LOWER_LIMIT = 120;
    /**
     * The error message used when an invalid age is encountered.
     */
    private static final String INVALID_AGE_MESSAGE = "Age cannot be negative.";
    /**
     * The label used for the child age category.
     */
    private static final String CHILD_LABEL = "Child";
    /**
     * The label used for the adult age category.
     */
    private static final String ADULT_LABEL = "Adult";
    /**
     * The label used for the elderly age category.
     */
    private static final String ELDERLY_LABEL = "Elderly";
    /**
     * The label used for the long-lived age category.
     */
    private static final String LONG_LIVED_LABEL = "Long-lived";
    /**
     * A space character.
     */
    private static final String SPACE = " ";

    /**
     * Classifies the given age into one of several categories: Child, Adult, Elderly, or Long-lived.
     *
     * @param age the age to be classified
     * @return a string representing the age category of the given age
     * @throws InvalidAgeException if the given age is negative
     */
    public String classifyAge(final int age) throws InvalidAgeException {
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
     * Validates the given age to ensure that it is not negative.
     *
     * @param age the age to be validated
     * @throws InvalidAgeException if the given age is negative
     */
    private void validateAge(final int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException(INVALID_AGE_MESSAGE);
        }
    }
}
