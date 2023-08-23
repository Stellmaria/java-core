package com.it.academy.gk.sc0.operators;

/**
 * Task 7.
 * Bring out a child, adult or old man depending on age. Child from 0 to 17 years old (inclusive).
 * Adult from 18 to 69 years old (inclusive). Old man 70 and older. Long-liver, if more than 120.
 *
 * @author Anastasia Melnikova.
 */
public class AgeCategory {
    /**
     * The minimum age for the child category.
     */
    private static final int CHILD_MIN_AGE = 0;

    /**
     * The maximum age for the child category.
     */
    private static final int CHILD_MAX_AGE = 17;

    /**
     * The minimum age for the adult category.
     */
    private static final int ADULT_MIN_AGE = 18;

    /**
     * The maximum age for the adult category.
     */
    private static final int ADULT_MAX_AGE = 69;

    /**
     * The minimum age for the senior category.
     */
    private static final int SENIOR_MIN_AGE = 70;

    /**
     * The minimum age for the supercentenarian category.
     */
    private static final int SUPERCENTENARIAN_MIN_AGE = 120;

    /**
     * The string representing the child category.
     */
    private static final String CHILD = "Child";

    /**
     * The string representing the adult category.
     */
    private static final String ADULT = "Adult";

    /**
     * The string representing the senior category.
     */
    private static final String SENIOR = "Senior";

    /**
     * The string representing the supercentenarian category.
     */
    private static final String SUPERCENTENARIAN = "Supercentenarian";

    /**
     * The string representing an invalid age value.
     */
    private static final String INVALID_AGE = "Invalid age";

    /**
     * The separator string used to separate words in the output.
     */
    private static final String SEPARATOR = " ";

    /**
     * This method takes an integer age as input and returns a string representing the age category of the person.
     * The age categories are defined as follows:
     * - Child: age between CHILD_MIN_AGE (inclusive) and CHILD_MAX_AGE (inclusive)
     * - Adult: age between ADULT_MIN_AGE (inclusive) and ADULT_MAX_AGE (inclusive)
     * - Senior: age greater than or equal to SENIOR_MIN_AGE
     * - Supercentenarian: age greater than or equal to SUPERCENTENARIAN_MIN_AGE
     * <p/>
     * If the age is greater than or equal to SUPERCENTENARIAN_MIN_AGE,
     * the method returns a string concatenating the senior category and the supercentenarian category,
     * separated by a space.
     * <p/>
     * If the age is less than CHILD_MIN_AGE, the method returns the string INVALID_AGE.
     *
     * @param age The age of the person
     * @return A string representing the age category of the person
     */
    public String getAgeCategory(final int age) {
        if (age >= CHILD_MIN_AGE && age <= CHILD_MAX_AGE) {
            return CHILD;
        } else if (age >= ADULT_MIN_AGE && age <= ADULT_MAX_AGE) {
            return ADULT;
        } else if (age >= SENIOR_MIN_AGE) {
            if (age >= SUPERCENTENARIAN_MIN_AGE) {
                return SENIOR + SEPARATOR + SUPERCENTENARIAN;
            } else {
                return SENIOR;
            }
        } else {
            return INVALID_AGE;
        }
    }
}
