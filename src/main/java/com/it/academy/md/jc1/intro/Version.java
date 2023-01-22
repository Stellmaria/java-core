package com.it.academy.md.jc1.intro;

import static java.lang.String.format;

/**
 * <h3>RU: Вводная лекция.</h3>
 *
 * <h3>EN: Introductory lecture.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Version {
    static {
        System.setProperty("java.vm.specification.version", "11");
    }

    /**
     * <p>RU: Разработайте программу с помощью Intellij IDEA и запустите с помощью Intellij IDEA.
     * Программа выводит в Standard Output (консоль) предложение: Java: version: 11.
     * Программа написана с использованием предварительной настройки:<br>
     * <code>System.setProperty("java.vm.specification.version", "11")</code>.</p><br>
     *
     * <p>EN: Develop a program with Intellij IDEA and run it with Intellij IDEA.
     * The program prints to the standard output (console) the sentence: Java: version: 11.
     * The program is written using preset:<br>
     * <code>System.setProperty("java.vm.specification.version", "11")</p>.<br>
     *
     * @return версия Java/Java version.
     */
    public String getJavaVersion() {
        return String.format("Java version: %s.", System.getProperty("java.vm.specification.version"));
    }

    /**
     * <p>RU: Разработайте программу, которая выводит в Standard Output
     * следующие предложения (каждое предложение в новой строке):</p>
     * <ul>
     *     <li> Java: version 11.</li>
     *     <li> JVM: HotSpot.</li>
     * </ul>
     *
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
