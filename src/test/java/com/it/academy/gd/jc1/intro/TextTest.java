package com.it.academy.gd.jc1.intro;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Text.")
class TextTest {
    private static Text text;

    @BeforeAll
    static void init() {
        text = new Text();
    }

    @Test
    @DisplayName("Test for method getHelloWorld() from class Text.")
    void testHelloWorld() {
        var expected = "Hello World!";

        var actual = text.getHelloWorld();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test for method getHelloBelarus() from class Text.")
    void testHelloBelarus() {
        var expected = "Hello Belarus!";

        var actual = text.getHelloBelarus();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test for method getLikeJava() from class Text.")
    void testLikeJava() {
        var expected = format("Hello Belarus!%nI like Java!");

        var actual = text.getLikeJava();

        assertEquals(expected, actual);
    }
}
