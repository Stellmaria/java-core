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

import static com.it.academy.gk.sc0.operators.task2.RightTriangle.calculateArea;
import static com.it.academy.gk.sc0.operators.task2.RightTriangle.calculateHypotenuse;
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
                Arguments.of(1.0, 1.0, 0.5),
                Arguments.of(1000.0, 1000.0, 500000.0)
        );
    }

    @ParameterizedTest(name = "Calculate area with side A = {0}, side B = {1}, expected area = {2}")
    @MethodSource("provideValidAreaArguments")
    @DisplayName("Valid cases for calculateArea method")
    void testCalculateArea(final double sideA, final double sideB, final double expected) {
        var actual = calculateArea(sideA, sideB);

        assertEquals(expected, actual, 1e-9);
    }

    static @NotNull Stream<Arguments> provideValidHypotenuseArguments() {
        return Stream.of(
                Arguments.of(3.0, 4.0, 5.0),
                Arguments.of(5.0, 5.0, 7.0710678118654755),
                Arguments.of(1.0, 1.0, 1.4142135623730951),
                Arguments.of(1000.0, 1000.0, 1414.213562373095)
        );
    }

    @ParameterizedTest(name = "Calculate hypotenuse with side A = {0}, side B = {1}, expected hypotenuse = {2}")
    @MethodSource("provideValidHypotenuseArguments")
    @DisplayName("Valid cases for calculateHypotenuse method")
    void testCalculateHypotenuse(final double sideA, final double sideB, final double expected) {
        var actual = calculateHypotenuse(sideA, sideB);

        assertEquals(expected, actual, 1e-9);
    }

    static @NotNull Stream<Arguments> provideInvalidSideArgumentsAndMessages() {
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

    @ParameterizedTest(name = "Test invalid sides for both methods")
    @MethodSource("provideInvalidSideArgumentsAndMessages")
    @DisplayName("Invalid cases for both calculateArea and calculateHypotenuse methods with messages")
    void testInvalidSidesForMethodsAndMessages(Executable executable, final String expected) {
        var actual = assertThrows(InvalidTriangleSideException.class, executable).getMessage();

        assertEquals(expected, actual);
    }

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

    @ParameterizedTest(name = "Test invalid sides for both methods without messages")
    @MethodSource("provideInvalidSideArguments")
    @DisplayName("Invalid cases for both calculateArea and calculateHypotenuse methods")
    void testInvalidSidesForMethods(Executable executable) {
        assertThrows(InvalidTriangleSideException.class, executable);
    }
}
