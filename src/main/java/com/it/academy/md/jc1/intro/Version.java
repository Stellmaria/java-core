package com.it.academy.md.jc1.intro;

import static java.lang.String.format;
import static java.lang.System.getProperty;
import static java.lang.System.setProperty;

/**
 * <p>RU: Вводная лекция.</p>
 * <p>EN: Introductory lecture.</p>
 *
 * @author Anastasia Melnikova.
 */
public class Version {
    static {
        setProperty("java.vm.specification.version", "11");
    }

    /**
     * <p>RU: Разработайте программу с помощью Intellij IDEA
     * и запустите с помощью Intellij IDEA.
     * Программа выводит в Standard Output (консоль) предложение:</p>
     * <p>EN: Develop a program with Intellij IDEA
     * and run it with Intellij IDEA.
     * The program prints to the standard output (console) the sentence:</p>
     * <li>Java: version: 11.</li>
     *
     * @return версия Java/Java version.
     */
    public String getJavaVersion() {
        return "Java version: "
                + getProperty("java.vm.specification.version")
                + ".";
    }

    /**
     * <p>RU: Разработайте программу, которая выводит в Standard Output
     * следующие предложения (каждое предложение в новой строке):</p>
     * <ul>
     *     <li> Java: version 11.</li>
     *     <li> JVM: HotSpot.</li>
     * </ul>
     * <p>EN: Write a program that outputs the following sentences to
     * Standard Output (each sentence on a new line):</p>
     * <ul>
     *     <li> Java: version 11.</li>
     *     <li> JVM: HotSpot.</li>
     * </ul>
     *
     * @return версия Java с описанием/Java version with description.
     */
    public String getJavaDescription() {
        return format("%s%n%s", getJavaVersion(), "JVM: HotSpot.");
    }
}
