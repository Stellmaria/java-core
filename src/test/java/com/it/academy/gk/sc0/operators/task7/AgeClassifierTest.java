package com.it.academy.gk.sc0.operators.task7;

import com.it.academy.gk.sc0.operators.exception.InvalidAgeException;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * A test class for the AgeClassifier class.
 */
@SuppressFBWarnings("NP_NONNULL_RETURN_VIOLATION")
class AgeClassifierTest {
    /**
     * The AgeClassifier instance to be tested.
     */
    private AgeClassifier ageClassifier;

    /**
     * Provides a stream of valid ages and their corresponding classifications for testing purposes.
     *
     * @return a stream of valid ages and their corresponding classifications as arguments
     */
    static @NotNull Stream<Arguments> validAgeProvider() {
        return Stream.of(
                Arguments.of(0, "Child"),
                Arguments.of(17, "Child"),
                Arguments.of(18, "Adult"),
                Arguments.of(69, "Adult"),
                Arguments.of(70, "Elderly"),
                Arguments.of(119, "Elderly"),
                Arguments.of(120, "Elderly Long-lived"),
                Arguments.of(130, "Elderly Long-lived")
        );
    }

    /**
     * Provides a stream of invalid ages for testing purposes.
     *
     * @return a stream of invalid ages as arguments
     */
    static @NotNull Stream<Arguments> invalidAgeProvider() {
        return Stream.of(
                Arguments.of(-1),
                Arguments.of(-10),
                Arguments.of(-100)
        );
    }

    /**
     * Sets up the AgeClassifier instance before each test.
     */
    @BeforeEach
    public void setUp() {
        ageClassifier = new AgeClassifier();
    }

    /**
     * Tests the classifyAge method with valid ages.
     *
     * @param age      the age to be classified
     * @param expected the expected classification
     */
    @ParameterizedTest(name = "For age {0}, the classification should be {1}")
    @MethodSource("validAgeProvider")
    @DisplayName("Valid ages")
    void testClassifyAge(final int age, final String expected) throws InvalidAgeException {
        var actual = ageClassifier.classifyAge(age);

        assertEquals(expected, actual);
    }

    /**
     * Tests the classifyAge method with invalid ages.
     *
     * @param age an invalid age
     */
    @ParameterizedTest(name = "Invalid age {0} should throw InvalidAgeException")
    @MethodSource("invalidAgeProvider")
    @DisplayName("Invalid ages")
    void testInvalidAges(final int age) {
        assertThrows(InvalidAgeException.class, () -> ageClassifier.classifyAge(age));
    }
}
