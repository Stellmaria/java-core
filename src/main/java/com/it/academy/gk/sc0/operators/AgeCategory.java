package com.it.academy.gk.sc0.operators;

/**
 * Task 7.
 * Bring out a child, adult or old man depending on age. Child from 0 to 17 years old (inclusive).
 * Adult from 18 to 69 years old (inclusive). Old man 70 and older. Long-liver, if more than 120.
 * <p>
 * The getAgeCategory method takes an integer parameter age, which represents the age of a person,
 * and returns a string indicating the age category of that person. Age categories are determined
 * using the constants CHILD_MIN_AGE, CHILD_MAX_AGE, ADULT_MIN_AGE, ADULT_MAX_AGE, SENIOR_MIN_AGE,
 * and SUPERCENTENARIAN_MIN_AGE, which are defined in the code.
 * <p>
 * The method checks if the age falls within the range of childhood using the constants CHILD_MIN_AGE
 * and CHILD_MAX_AGE. If so, the method returns the string constant CHILD. If not, the method checks
 * if the age falls within the range of adulthood using the constants ADULT_MIN_AGE and ADULT_MAX_AGE.
 * If so, the method returns the string constant ADULT. If not, the method checks if the age is greater
 * than the minimum age for seniors using the constant SENIOR_MIN_AGE. If so, the method checks if
 * the age is greater than the minimum age for super-centenarians using the constant SUPERCENTENARIAN_MIN_AGE.
 * If so, the method returns the string constant SENIOR_SUPERCENTENARIAN, otherwise it returns
 * the string constant SENIOR. If none of these conditions are met, then the method returns
 * the string constant INVALID_AGE.
 */
public class AgeCategory {
    /**
     * The minimum age for the child category.
     */
    public static final int CHILD_MIN_AGE = 0;

    /**
     * The maximum age for the child category.
     */
    public static final int CHILD_MAX_AGE = 17;

    /**
     * The minimum age for the adult category.
     */
    public static final int ADULT_MIN_AGE = 18;

    /**
     * The maximum age for the adult category.
     */
    public static final int ADULT_MAX_AGE = 69;

    /**
     * The minimum age for the senior category.
     */
    public static final int SENIOR_MIN_AGE = 70;

    /**
     * The minimum age for the supercentenarian category.
     */
    public static final int SUPERCENTENARIAN_MIN_AGE = 120;

    /**
     * The string representing the child category.
     */
    public static final String CHILD = "Child";

    /**
     * The string representing the adult category.
     */
    public static final String ADULT = "Adult";

    /**
     * The string representing the senior category.
     */
    public static final String SENIOR = "Senior";

    /**
     * The string representing the supercentenarian category.
     */
    public static final String SENIOR_SUPERCENTENARIAN = "Senior Supercentenarian";

    /**
     * The string representing an invalid age value.
     */
    public static final String INVALID_AGE = "Invalid age";

    /**
     * Returns the age category of a person based on their age.
     *
     * @param age the age of the person
     * @return the age category of the person
     */
    public String getAgeCategory(int age) {
        if (age >= CHILD_MIN_AGE && age <= CHILD_MAX_AGE) {
            return CHILD;
        } else if (age >= ADULT_MIN_AGE && age <= ADULT_MAX_AGE) {
            return ADULT;
        } else if (age >= SENIOR_MIN_AGE) {
            if (age >= SUPERCENTENARIAN_MIN_AGE) {
                return SENIOR_SUPERCENTENARIAN;
            } else {
                return SENIOR;
            }
        } else {
            return INVALID_AGE;
        }
    }
}
