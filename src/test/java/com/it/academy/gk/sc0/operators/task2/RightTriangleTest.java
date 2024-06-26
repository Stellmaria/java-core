package com.it.academy.gk.sc0.operators.task2;

import com.it.academy.gk.sc0.operators.task2.exception.InvalidTriangleSideException;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RightTriangleTest {
    private static String BOTH_SIDES_INVALID_MESSAGE;
    private static String SIDE_A_INVALID_MESSAGE;
    private static String SIDE_B_INVALID_MESSAGE;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException, IllegalAccessException {
        BOTH_SIDES_INVALID_MESSAGE = getStaticFieldValue("BOTH_SIDES_INVALID_MESSAGE");
        SIDE_A_INVALID_MESSAGE = getStaticFieldValue("SIDE_A_INVALID_MESSAGE");
        SIDE_B_INVALID_MESSAGE = getStaticFieldValue("SIDE_B_INVALID_MESSAGE");
    }

    private static String getStaticFieldValue(String fieldName) throws NoSuchFieldException, IllegalAccessException {
        var field = RightTriangle.class.getDeclaredField(fieldName);
        field.setAccessible(true);

        return (String) field.get(null);
    }

    static @NotNull Stream<Arguments> provideValidAreaArguments() {
        return Stream.of(
                Arguments.of(3.0, 4.0, 6.0),
                Arguments.of(5.0, 5.0, 12.5),
                Arguments.of(1.0, 1.0, 0.5)
        );
    }

    @ParameterizedTest(name = "Calculate area with side A = {0}, side B = {1}, expected area = {2}")
    @MethodSource("provideValidAreaArguments")
    @DisplayName("Valid cases for calculateArea method")
    void testCalculateArea(final double sideA, final double sideB, final double expected) {
        var actual = RightTriangle.calculateArea(sideA, sideB);

        assertEquals(expected, actual, 1e-9);
    }

    static @NotNull Stream<Arguments> provideValidHypotenuseArguments() {
        return Stream.of(
                Arguments.of(3.0, 4.0, 5.0),
                Arguments.of(5.0, 5.0, 7.0710678118654755),
                Arguments.of(1.0, 1.0, 1.4142135623730951)
        );
    }

    @ParameterizedTest(name = "Calculate hypotenuse with side A = {0}, side B = {1}, expected hypotenuse = {2}")
    @MethodSource("provideValidHypotenuseArguments")
    @DisplayName("Valid cases for calculateHypotenuse method")
    void testCalculateHypotenuse(final double sideA, final double sideB, final double expected) {
        var actual = RightTriangle.calculateHypotenuse(sideA, sideB);

        assertEquals(expected, actual, 1e-9);
    }

    static @NotNull Stream<Arguments> provideInvalidSideArgumentsAndMessage() {
        return Stream.of(
                Arguments.of(
                        (Executable) () -> RightTriangle.calculateArea(0.0, 4.0),
                        SIDE_A_INVALID_MESSAGE
                ),
                Arguments.of(
                        (Executable) () -> RightTriangle.calculateArea(3.0, 0.0),
                        SIDE_B_INVALID_MESSAGE
                ),
                Arguments.of(
                        (Executable) () -> RightTriangle.calculateArea(-1.0, 4.0),
                        SIDE_A_INVALID_MESSAGE
                ),
                Arguments.of(
                        (Executable) () -> RightTriangle.calculateArea(0.0, 0.0),
                        BOTH_SIDES_INVALID_MESSAGE
                ),
                Arguments.of(
                        (Executable) () -> RightTriangle.calculateHypotenuse(0.0, 4.0),
                        SIDE_A_INVALID_MESSAGE
                ),
                Arguments.of(
                        (Executable) () -> RightTriangle.calculateHypotenuse(3.0, 0.0),
                        SIDE_B_INVALID_MESSAGE
                ),
                Arguments.of(
                        (Executable) () -> RightTriangle.calculateHypotenuse(-1.0, 4.0),
                        SIDE_A_INVALID_MESSAGE
                ),
                Arguments.of(
                        (Executable) () -> RightTriangle.calculateHypotenuse(0.0, 0.0),
                        BOTH_SIDES_INVALID_MESSAGE
                )
        );
    }

    @ParameterizedTest(name = "Test with invalid sides A = {0}, B = {1}, method = {2}")
    @MethodSource("provideInvalidSideArgumentsAndMessage")
    @DisplayName("Invalid cases for both calculateArea and calculateHypotenuse methods with message")
    void testInvalidSidesForMethodsAndMessage(Executable executable, final String expected) {
        var actual = assertThrows(InvalidTriangleSideException.class, executable).getMessage();

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideInvalidSideArguments() {
        return Stream.of(
                Arguments.of((Executable) () -> RightTriangle.calculateArea(0.0, 4.0)),
                Arguments.of((Executable) () -> RightTriangle.calculateArea(3.0, 0.0)),
                Arguments.of((Executable) () -> RightTriangle.calculateArea(-1.0, 4.0)),
                Arguments.of((Executable) () -> RightTriangle.calculateHypotenuse(0.0, 4.0)),
                Arguments.of((Executable) () -> RightTriangle.calculateHypotenuse(3.0, 0.0)),
                Arguments.of((Executable) () -> RightTriangle.calculateHypotenuse(-1.0, 4.0))
        );
    }

    @ParameterizedTest(name = "Test with invalid sides A = {0}, B = {1}, method = {2}")
    @MethodSource("provideInvalidSideArguments")
    @DisplayName("Invalid cases for both calculateArea and calculateHypotenuse methods")
    void testInvalidSidesForMethods(Executable expected) {
        assertThrows(InvalidTriangleSideException.class, expected);
    }
}
