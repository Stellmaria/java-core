package com.it.academy.gk.sc0.statements;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * This class contains unit tests for the PhrasePrinter class.
 */
class PhrasePrinterTest {
    /**
     * An instance of the PhrasePrinter class, used to test its methods.
     */
    private PhrasePrinter phrasePrinter;

    /**
     * This method provides test cases for the printPhrases method.
     * Each test case consists of a TestCase object that contains the input values and the expected result.
     * The expected result is a string representing the phrases that should be printed by the printPhrases method.
     */
    static @NotNull Stream<TestCase> printPhrasesTestCases() {
        return Stream.of(
                new TestCase(
                        3, 1, 2, "Hello", "Hi",
                        "Hi\nHi\nHello"
                ),
                new TestCase(
                        3, 1, 3, "Hello", "Hi",
                        "Hi\nHello\nHi"
                ),
                new TestCase(
                        3, 2, 3, "Hello", "Hi",
                        "Hello\nHi\nHi"
                ),
                new TestCase(
                        1, 1, 1, "Hello", "Hi", "Hi"
                ),
                new TestCase(
                        0, 1, 2, "Hello", "Hi", ""
                ),
                new TestCase(
                        -1, 1, 2, "Hello", "Hi", ""
                ),
                new TestCase(
                        3, -1, -2, "Hello", "Hi",
                        "Hello\nHello\nHello"
                ),
                new TestCase(
                        3, 4, 5, "Hello", "Hi",
                        "Hello\nHello\nHello"
                )
        );
    }

    /**
     * This method is run before each test method, ensuring that each test has a fresh instance
     * of the PhrasePrinter class to work with.
     */
    @BeforeEach
    void setUp() {
        phrasePrinter = new PhrasePrinter();
    }

    /**
     * This method tests the printPhrases method of the PhrasePrinter class.
     * It takes a single argument: a TestCase object that contains the input values and the expected result.
     * The expected result is a string representing the phrases that should be printed by the printPhrases method.
     * The method calls the printPhrases method with the specified input values and compares the result to the expected result.
     */
    @ParameterizedTest(
            name = "{index} => phraseCount={0}, firstIndex={1}, secondIndex={2}, phrase={3}," +
                   " replacementPhrase={4}, expected={5}"
    )
    @DisplayName("printPhrases")
    @MethodSource("printPhrasesTestCases")
    void printPhrases(@NotNull TestCase testCase) {
        var result = phrasePrinter.printPhrases(
                testCase.phraseCount, testCase.firstIndex,
                testCase.secondIndex, testCase.phrase, testCase.replacementPhrase
        );

        assertEquals(testCase.expectedResult, result);
    }

    /**
     * A record class that represents a test case for the printPhrases method.
     * It contains the input values and the expected result for a single test case.
     */
    private record TestCase(int phraseCount, int firstIndex, int secondIndex,
                            String phrase, String replacementPhrase,
                            String expectedResult) {
    }
}
