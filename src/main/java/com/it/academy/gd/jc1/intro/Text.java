package com.it.academy.gd.jc1.intro;

import static java.lang.String.format;

/**
 * <h3>RU: Вводная лекция.</h3>
 *
 * <h3>EN: Introductory lecture.</h3>
 *
 * @author Anastasia Melnikova.
 */
public class Text {
    /**
     * <p>RU: Константа со значением.</p>
     *
     * <p>EN: A constant with a value.</p>
     */
    private static final String HELLO_WORLD = "Hello World!";

    /**
     * <p>RU: Константа со значением.</p>
     *
     * <p>EN: A constant with a value.</p>
     */
    private static final String HELLO_BELARUS = "Hello Belarus!";

    /**
     * <h4>RU: Задание 1.</h4>
     * <p>Набрать приведенный пример HelloWorld.java, откомпилировать его и запустить.</p><br>
     *
     * <h4>EN: Task 1.</h4>
     * <p>Type the above HelloWorld.java example, compile it, and run it.</p><br>
     *
     * @return line with text / string with text.
     */
    public String getHelloWorld() {
        return HELLO_WORLD;
    }

    /**
     * <h4>RU: Задание 2.</h4>
     * <p>В набранном из задания 1 примере изменить сообщение на “Hello Belarus!”.
     * Откомпилировать пример и запустить.</p><br>
     *
     * <h4>EN: Task 2.</h4>
     * <p>In the example typed from task 1, change the message to “Hello Belarus!”.
     * Compile the example and run.</p><br>
     *
     * @return line with text / string with text.
     */
    public String getHelloBelarus() {
        return HELLO_BELARUS;
    }

    /**
     * <h4>RU: Задание 3.</h4>
     * <p>В набранном из задания 2 примере добавить к основному сообщению дополнительное “I like Java!”.
     * Откомпилировать пример и запустить.</p><br>
     *
     * <h4>EN: Task 3.</h4>
     * <p>In the example typed from task 2, add an additional “I like Java!” to the main message.
     * Compile the example and run.</p><br>
     *
     * @return line with text / string with text.
     */
    public String getLikeJava() {
        final var iLikeJava = "I like Java!";

        return format("%s%n%s", getHelloBelarus(), iLikeJava);
    }
}
