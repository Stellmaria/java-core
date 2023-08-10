package com.it.academy.gk.sc0.hw1;

/**
 * Check the e-mail entered by the user for correctness.
 */
public class EmailValidator {
    /**
     * The suffix for a valid email address.
     */
    private static final String EMAIL_SUFFIX = ".com";

    /**
     * The character used to separate the local part and the domain part of an email address.
     */
    private static final String DOG = "@";

    /**
     * Checks if the given email is valid, contains an "@" symbol, and ends with ".com".
     * <p/>
     * This method checks if the given email contains an "@" symbol and ends with ".com".
     * It returns true if the email is valid, contains an "@" symbol, and ends with ".com", and false otherwise.
     *
     * @param email the email to check.
     * @return true if the email is valid, contains an "@" symbol, and ends with ".com", false otherwise.
     */
    public boolean isValidEmail(final String email) {
        return email != null && email.contains(DOG) && email.endsWith(EMAIL_SUFFIX);
    }
}
