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
    /**
     * <p>RU: Инициализируем переменную текстом ответа.</p>
     *
     * <p>EN: We initialize the variable with the response text.</p>
     */
    private static final String JAVA_VERSION = "Java version: ";

    /**
     * <p>RU: Инициализируем переменную текстом ответа.</p>
     *
     * <p>EN: We initialize the variable with the response text.</p>
     */
    private static final String JAVA_HOT_SPOT = "JVM: HotSpot.";

    /**
     * <p>RU: Инициализируем переменную текстом команды.</p>
     *
     * <p>EN: We initialize the variable with the text of the command.</p>
     */
    private static final String PROPERTY_VERSION = "java.vm.specification.version";

    static {
        final String javaVersion11 = "11";

        System.setProperty(PROPERTY_VERSION, javaVersion11);
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
     * <code>System.setProperty("java.vm.specification.version", "11")</code>.</p><br>
     *
     * @return версия Java / Java version.
     */
    public String getJavaVersion() {
        return format(JAVA_VERSION + "%s.", System.getProperty(PROPERTY_VERSION));
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
     * @return версия Java с описанием / Java version with description.
     */
    public String getJavaDescription() {
        return format("%s%n%s", getJavaVersion(), JAVA_HOT_SPOT);
    }
}
