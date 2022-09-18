package com.it.academy.md.jc1.intro;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static java.lang.System.getProperty;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test for class Version.")
class VersionTest {
    private static Version version;

    @BeforeAll
    static void init() {
        version = new Version();
    }

    @Test
    @DisplayName("Test for method getJavaVersion() from class Version.")
    void testJavaVersion() {
        var actual = "Java version: " + getProperty("java.vm.specification.version") + ".";

        var expected = version.getJavaVersion();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test for method getJavaDescription() from class Version.")
    void testJavaDescription() {
        var actual = format("%s%n%s",
                "Java version: " + getProperty("java.vm.specification.version") + ".", "JVM: HotSpot.");

        var expected = version.getJavaDescription();

        assertEquals(expected, actual);
    }
}
