package com.it.academy.gk.sc0.statements;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Task 7: Print the phrase "I am studying programming" a specified number of times in a loop. When printing,
 * make such branching in the body of the loop so that instead of the 3rd and 9th phrases in a row,
 * the phrase "I am interested in a high salary!" is displayed.
 */
public class PhrasePrinter {
    /**
     * A constant of type String that contains the newline character ("\n").
     * It is used to separate phrases when printing.
     */
    private static final String NEWLINE = "\n";

    /**
     * Prints the specified number of phrases, separated by a newline character.
     * If the index of the phrase is equal to firstIndex or secondIndex,
     * the replacementPhrase is printed instead of the phrase.
     *
     * @param phraseCount       The number of phrases to print.
     * @param firstIndex        The first index at which to print the replacementPhrase.
     * @param secondIndex       The second index at which to print the replacementPhrase.
     * @param phrase            The phrase to print.
     * @param replacementPhrase The phrase to print at firstIndex and secondIndex.
     * @return A string containing the specified number of phrases, separated by a newline character.
     */
    public String printPhrases(final int phraseCount, final int firstIndex, final int secondIndex,
                               final String phrase, final String replacementPhrase) {
        return IntStream.rangeClosed(1, phraseCount)
                .mapToObj(i -> (i == firstIndex || i == secondIndex) ? replacementPhrase : phrase)
                .collect(Collectors.joining(NEWLINE));
    }
}
