package com.it.academy.gk.sc0.operators.task2;

import com.it.academy.gk.sc0.operators.exception.InvalidTriangleSideException;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.it.academy.gk.sc0.operators.task2.RightTriangle.calculateArea;
import static com.it.academy.gk.sc0.operators.task2.RightTriangle.calculateHypotenuse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * RightTriangleTest is a test class that performs unit tests for the {@link RightTriangle} class.
 *
 * <p>This class uses JUnit 5 for parameterized testing and exception testing to validate the behavior
 * of the {@link RightTriangle} class methods.</p>
 *
 * @author Anastasia Melnikova
 * @version 1.0
 * @since 2023-09-02
 */
class RightTriangleTest {
    private static String BOTH_SIDES_INVALID_MESSAGE;
    private static String SIDE_A_INVALID_MESSAGE;
    private static String SIDE_B_INVALID_MESSAGE;

    /**
     * Setup method executed before all tests in the class.
     */
    @SneakyThrows
    @BeforeAll
    public static void beforeAll() {
        var bothSidesInvalidMessageField = RightTriangle.class.getDeclaredField("BOTH_SIDES_INVALID_MESSAGE");
        bothSidesInvalidMessageField.setAccessible(true);
        BOTH_SIDES_INVALID_MESSAGE = (String) bothSidesInvalidMessageField.get(null);

        var sideAInvalidMessageField = RightTriangle.class.getDeclaredField("SIDE_A_INVALID_MESSAGE");
        sideAInvalidMessageField.setAccessible(true);
        SIDE_A_INVALID_MESSAGE = (String) sideAInvalidMessageField.get(null);

        var sideBInvalidMessageField = RightTriangle.class.getDeclaredField("SIDE_B_INVALID_MESSAGE");
        sideBInvalidMessageField.setAccessible(true);
        SIDE_B_INVALID_MESSAGE = (String) sideBInvalidMessageField.get(null);
    }

    /**
     * Provides valid side lengths and expected area values for parameterized testing of the
     * {@link RightTriangle#calculateArea(double, double)} method.
     *
     * @return a {@link Stream} of {@link Arguments} containing side lengths and expected area values.
     */
    static @NotNull Stream<Arguments> provideValidAreaArguments() {
        return Stream.of(
                Arguments.of(3.0, 4.0, 6.0),
                Arguments.of(5.0, 5.0, 12.5),
                Arguments.of(1.0, 1.0, 0.5)
        );
    }

    /**
     * Tests the {@link RightTriangle#calculateArea(double, double)} method with valid input side lengths
     * and expected area values.
     *
     * @param sideA    the length of side A.
     * @param sideB    the length of side B.
     * @param expected the expected area value.
     */
    @SneakyThrows
    @ParameterizedTest(name = "Calculate area with side A = {0}, side B = {1}, expected area = {2}")
    @MethodSource("provideValidAreaArguments")
    @DisplayName("Valid cases for calculateArea method")
    void testCalculateArea(final double sideA, final double sideB, final double expected) {
        var actual = calculateArea(sideA, sideB);

        assertEquals(expected, actual, 1e-9);
    }

    /**
     * Provides valid side lengths and expected hypotenuse values for parameterized testing of the
     * {@link RightTriangle#calculateHypotenuse(double, double)} method.
     *
     * @return a {@link Stream} of {@link Arguments} containing side lengths and expected hypotenuse values.
     */
    static @NotNull Stream<Arguments> provideValidHypotenuseArguments() {
        return Stream.of(
                Arguments.of(3.0, 4.0, 5.0),
                Arguments.of(5.0, 5.0, 7.0710678118654755),
                Arguments.of(1.0, 1.0, 1.4142135623730951)
        );
    }

    /**
     * Tests the {@link RightTriangle#calculateHypotenuse(double, double)} method with valid input side lengths
     * and expected hypotenuse values.
     *
     * @param sideA    the length of side A.
     * @param sideB    the length of side B.
     * @param expected the expected hypotenuse value.
     */
    @SneakyThrows
    @ParameterizedTest(name = "Calculate hypotenuse with side A = {0}, side B = {1}, expected hypotenuse = {2}")
    @MethodSource("provideValidHypotenuseArguments")
    @DisplayName("Valid cases for calculateHypotenuse method")
    void testCalculateHypotenuse(final double sideA, final double sideB, final double expected) {
        var actual = calculateHypotenuse(sideA, sideB);

        assertEquals(expected, actual, 1e-9);
    }

    /**
     * Provides executable instances for testing invalid side lengths along with the expected error message.
     *
     * @return a {@link Stream} of {@link Arguments} containing executable instances and expected error messages.
     */
    static @NotNull Stream<Arguments> provideInvalidSideArgumentsAndMessage() {
        return Stream.of(
                Arguments.of((Executable) () -> calculateArea(0.0, 4.0), SIDE_A_INVALID_MESSAGE),
                Arguments.of((Executable) () -> calculateArea(3.0, 0.0), SIDE_B_INVALID_MESSAGE),
                Arguments.of((Executable) () -> calculateArea(-1.0, 4.0), SIDE_A_INVALID_MESSAGE),
                Arguments.of((Executable) () -> calculateArea(0.0, 0.0), BOTH_SIDES_INVALID_MESSAGE),
                Arguments.of((Executable) () -> calculateHypotenuse(0.0, 4.0), SIDE_A_INVALID_MESSAGE),
                Arguments.of((Executable) () -> calculateHypotenuse(3.0, 0.0), SIDE_B_INVALID_MESSAGE),
                Arguments.of((Executable) () -> calculateHypotenuse(-1.0, 4.0), SIDE_A_INVALID_MESSAGE),
                Arguments.of((Executable) () -> calculateHypotenuse(0.0, 0.0), BOTH_SIDES_INVALID_MESSAGE)
        );
    }

    /**
     * Tests invalid side lengths for both {@link RightTriangle#calculateArea(double, double)}
     * and {@link RightTriangle#calculateHypotenuse(double, double)} methods,
     * and verifies that the expected error message is thrown.
     *
     * @param executable the executable representing the method call with invalid side lengths.
     * @param expected   the expected error message.
     */
    @ParameterizedTest(name = "Test with invalid sides A = {0}, B = {1}, method = {2}")
    @MethodSource("provideInvalidSideArgumentsAndMessage")
    @DisplayName("Invalid cases for both calculateArea and calculateHypotenuse methods with message")
    void testInvalidSidesForMethodsAndMessage(Executable executable, String expected) {
        var actual = assertThrows(InvalidTriangleSideException.class, executable).getMessage();

        assertEquals(expected, actual);
    }

    /**
     * Provides executable instances for testing invalid side lengths without specifying the expected error message.
     *
     * @return a {@link Stream} of {@link Arguments} containing executable instances.
     */
    static @NotNull Stream<Arguments> provideInvalidSideArguments() {
        return Stream.of(
                Arguments.of((Executable) () -> calculateArea(0.0, 4.0)),
                Arguments.of((Executable) () -> calculateArea(3.0, 0.0)),
                Arguments.of((Executable) () -> calculateArea(-1.0, 4.0)),
                Arguments.of((Executable) () -> calculateHypotenuse(0.0, 4.0)),
                Arguments.of((Executable) () -> calculateHypotenuse(3.0, 0.0)),
                Arguments.of((Executable) () -> calculateHypotenuse(-1.0, 4.0))
        );
    }

    /**
     * Tests invalid side lengths for both {@link RightTriangle#calculateArea(double, double)}
     * and {@link RightTriangle#calculateHypotenuse(double, double)} methods,
     * expecting {@link InvalidTriangleSideException}.
     *
     * @param expected the executable representing the method call with invalid side lengths.
     */
    @ParameterizedTest(name = "Test with invalid sides A = {0}, B = {1}, method = {2}")
    @MethodSource("provideInvalidSideArguments")
    @DisplayName("Invalid cases for both calculateArea and calculateHypotenuse methods")
    void testInvalidSidesForMethods(Executable expected) {
        assertThrows(InvalidTriangleSideException.class, expected);
    }
}
