package com.it.academy.gk.sc0.hw1;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains tests for the EmailValidator class.
 * It uses the JUnit 5 testing framework to define and run the tests.
 */
@DisplayName("Email Validator Test")
class EmailValidatorTest {
    /**
     * The EmailValidator object used in the tests.
     */
    private EmailValidator validator;

    /**
     * Sets up a new EmailValidator object before each test.
     */
    @BeforeEach
    void setUp() {
        validator = new EmailValidator();
    }

    /**
     * Provides the arguments for the testIsValidEmail method.
     *
     * @return a stream of arguments for the testIsValidEmail method.
     */
    @Contract(value = " -> new", pure = true)
    private static @NotNull Stream<Arguments> emailProvider() {
        return Stream.of(
                Arguments.of("test@example.com", true),
                Arguments.of("test.email+alex@leetcode.com", true),
                Arguments.of("test.email.leet+alex@code.com", true),
                Arguments.of("test.email@leetcode.com", true),
                Arguments.of("test@com", false),
                Arguments.of("test.email+alex@leetcode.c", false)
        );
    }

    /**
     * Tests the isValidEmail method of the EmailValidator class with different email addresses.
     *
     * @param email    the email address to check.
     * @param expected the expected result of the isValidEmail method.
     */
    @ParameterizedTest(name = "Email: {0}, expected: {1}")
    @MethodSource("emailProvider")
    @DisplayName("Test isValidEmail method with different email addresses")
    void testIsValidEmail(final String email, final boolean expected) {
        boolean actual = validator.isValidEmail(email);

        assertEquals(expected, actual);
    }
}
