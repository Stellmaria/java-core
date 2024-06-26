package com.it.academy.gk.sc0.statements.task3;

import com.it.academy.gk.sc0.statements.task3.exception.MultiplicationTableException;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.it.academy.gk.sc0.statements.task3.MultiplicationTable.printMultiplicationTable;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.params.provider.Arguments.of;

@DisplayName("Multiplication Table Test")
class MultiplicationTableTest {
    private static String CANNOT_BE_GENERATED;

    @BeforeAll
    public static void setUp() throws NoSuchFieldException, IllegalAccessException {
        var invalidDigitNumberMessageField = MultiplicationTable.class.getDeclaredField("CANNOT_BE_GENERATED");
        invalidDigitNumberMessageField.setAccessible(true);
        CANNOT_BE_GENERATED = (String) invalidDigitNumberMessageField.get(null);
    }

    private static @NotNull Stream<Arguments> printMultiplicationTableTestCases() {
        return Stream.of(
                of(3, 10, """
                        1 x 3 = 3
                        2 x 3 = 6
                        3 x 3 = 9
                        4 x 3 = 12
                        5 x 3 = 15
                        6 x 3 = 18
                        7 x 3 = 21
                        8 x 3 = 24
                        9 x 3 = 27
                        10 x 3 = 30
                        """),
                of(5, 5, """
                        1 x 5 = 5
                        2 x 5 = 10
                        3 x 5 = 15
                        4 x 5 = 20
                        5 x 5 = 25
                        """),
                of(5, 0, "")
        );
    }

    @ParameterizedTest(name = "Test Case {index}: multiplier={0}, rows={1}")
    @MethodSource("printMultiplicationTableTestCases")
    @DisplayName("Test printMultiplicationTable")
    void testPrintMultiplicationTable(final int multiplier, final int rows,
                                      final String expected) throws MultiplicationTableException {
        var actual = printMultiplicationTable(multiplier, rows);

        assertEquals(expected, actual);
    }

    static @NotNull Stream<Arguments> provideInvalidMultiplierArgumentsAndMessage() {
        return Stream.of(
                of((Executable) () -> printMultiplicationTable(0, 5), CANNOT_BE_GENERATED),
                of((Executable) () -> printMultiplicationTable(0, 0), CANNOT_BE_GENERATED)
        );
    }

    @ParameterizedTest(name = "Test printMultiplicationTable exception message")
    @MethodSource("provideInvalidMultiplierArgumentsAndMessage")
    @DisplayName("Test printMultiplicationTable exception message")
    void testPrintMultiplicationTableExceptionMessage(Executable executable, String expectedMessage) {
        var exception = assertThrows(MultiplicationTableException.class, executable);
        var actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    @DisplayName("Test printMultiplicationTable with MultiplicationTableException")
    void testPrintMultiplicationTableException() {
        assertAll(
                () -> assertThrows(MultiplicationTableException.class,
                        () -> printMultiplicationTable(0, 10)),
                () -> assertThrows(MultiplicationTableException.class,
                        () -> printMultiplicationTable(0, 0))
        );
    }

    @Test
    @DisplayName("Test printMultiplicationTable with zero rows")
    void testPrintMultiplicationTableZeroRows() throws MultiplicationTableException {
        var actual = printMultiplicationTable(5, 0);

        assertEquals("", actual);
    }
}
