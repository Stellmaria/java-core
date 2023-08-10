package com.it.academy.gk.sc0.statements;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * This class contains unit tests for the PhrasePrinter class.
 */
@DisplayName("Phrase Printer Test")
class PhrasePrinterTest {
    /**
     * An instance of the PhrasePrinter class, used to test its methods.
     */
    private PhrasePrinter phrasePrinter;

    /**
     * This method provides test cases for the printPhrases method.
     * Each test case consists of multiple arguments: the input values and the expected result.
     * The expected result is a string representing the phrases that should be printed by the printPhrases method.
     */
    @SuppressFBWarnings("NP_NONNULL_RETURN_VIOLATION")
    static @NotNull Stream<Arguments> printPhrasesTestCases() {
        return Stream.of(
                Arguments.of(3, 1, 2, "Hello", "Hi", "Hi\nHi\nHello"),
                Arguments.of(3, 1, 3, "Hello", "Hi", "Hi\nHello\nHi"),
                Arguments.of(3, 2, 3, "Hello", "Hi", "Hello\nHi\nHi"),
                Arguments.of(1, 1, 1, "Hello", "Hi", "Hi"),
                Arguments.of(0, 1, 2, "Hello", "Hi", ""),
                Arguments.of(-1, 1, 2, "Hello", "Hi", ""),
                Arguments.of(3, -1, -2, "Hello", "Hi", "Hello\nHello\nHello"),
                Arguments.of(3, 4, 5, "Hello", "Hi", "Hello\nHello\nHello")
        );
    }

    /**
     * This method is run before each test method,
     * ensuring that each test has a fresh instance of the PhrasePrinter class to work with.
     */
    @BeforeEach
    void setUp() {
        phrasePrinter = new PhrasePrinter();
    }

    /**
     * This method tests the printPhrases method of the PhrasePrinter class.
     * It takes multiple arguments: the input values and the expected result.
     * The expected result is a string representing the phrases that should be printed by the printPhrases method.
     * The method calls the printPhrases method with the specified input values
     * and compares the result to the expected result.
     */
    @ParameterizedTest(name = "{index} => phraseCount={0}, firstIndex={1}, secondIndex={2}, phrase={3}," +
                              " replacementPhrase={4}, expected={5}"
    )
    @DisplayName("printPhrases")
    @MethodSource("printPhrasesTestCases")
    void printPhrases(final int phraseCount, final int firstIndex, final int secondIndex,
                      final String phrase, final String replacementPhrase, final String expectedResult) {
        String result = phrasePrinter.printPhrases(phraseCount, firstIndex, secondIndex, phrase, replacementPhrase);

        assertEquals(expectedResult, result);
    }
}
