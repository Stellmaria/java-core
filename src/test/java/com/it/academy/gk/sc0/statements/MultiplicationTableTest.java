package com.it.academy.gk.sc0.statements;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class contains unit tests for the MultiplicationTable class.
 */
class MultiplicationTableTest {
    /**
     * An instance of the MultiplicationTable class, used to test its methods.
     */
    private MultiplicationTable multiplicationTable;

    /**
     * This method provides test cases for the testPrintMultiplicationTable method.
     * Each test case consists of three arguments: the multiplier, the number of rows, and the expected result.
     * The expected result is a string representing the multiplication table that should be printed
     * by the printMultiplicationTable method.
     */
    private static @NotNull Stream<Arguments> printMultiplicationTableTestCases() {
        return Stream.of(
                Arguments.of(3, 10, """
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
                Arguments.of(5, 5, """
                        1 x 5 = 5
                        2 x 5 = 10
                        3 x 5 = 15
                        4 x 5 = 20
                        5 x 5 = 25
                        """)
        );
    }

    /**
     * This method is run before each test method, ensuring that each test has a fresh instance
     * of the MultiplicationTable class to work with.
     */
    @BeforeEach
    public void setUp() {
        multiplicationTable = new MultiplicationTable();
    }

    /**
     * This method tests the printMultiplicationTable method of the MultiplicationTable class.
     * It takes three arguments: the multiplier, the number of rows, and the expected result.
     * The expected result is a string representing the multiplication table that should be printed
     * by the printMultiplicationTable method. The method calls the printMultiplicationTable method
     * with the specified multiplier and number of rows, and compares the result to the expected result.
     */
    @ParameterizedTest(name = "Test case #{index}: {arguments}")
    @DisplayName("Test printMultiplicationTable")
    @MethodSource("printMultiplicationTableTestCases")
    void testPrintMultiplicationTable(int multiplier, int rows, String expected) {
        var actual = multiplicationTable.printMultiplicationTable(multiplier, rows);

        assertEquals(expected, actual);
    }
}
