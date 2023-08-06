package com.it.academy.gk.sc0.hw1;

import org.jetbrains.annotations.Contract;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for the EmailValidator class. It uses the JUnit 5 testing framework to define and run the tests.
 */
class EmailValidatorTest {
    /**
     * The EmailValidator object used in the tests.
     */
    private EmailValidator validator;

    /**
     * Provides the arguments for the testIsValidEmail method.
     *
     * @return an array of arrays containing the email address and the expected result of the isValidEmail method
     */
    @Contract(value = " -> new", pure = true)
    private static Object[][] emailProvider() {
        return new Object[][]{
                {"test@example.com", true},
                {"test.email+alex@leetcode.com", true},
                {"test.email.leet+alex@code.com", true},
                {"test.email@leetcode.com", true},
                {"test@com", false},
                {"test.email+alex@leetcode.c", false}
        };
    }

    /**
     * Sets up a new EmailValidator object before each test.
     */
    @BeforeEach
    void setUp() {
        validator = new EmailValidator();
    }

    /**
     * Tests the isValidEmail method of the EmailValidator class with different email addresses.
     *
     * @param email    the email address to check
     * @param expected the expected result of the isValidEmail method
     */
    @ParameterizedTest(name = "Email: {0}, expected: {1}")
    @MethodSource("emailProvider")
    void testIsValidEmail(String email, boolean expected) {
        var actual = validator.isValidEmail(email);

        assertEquals(expected, actual);
    }
}