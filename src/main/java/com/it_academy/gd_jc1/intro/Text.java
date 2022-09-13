package com.it_academy.gd_jc1.intro;

import static java.lang.String.format;

/**
 * RU:
 * <p>Вводная лекция</p>
 * EN:
 * <p>Introductory lecture.</p>
 *
 * @author Anastasia Melnikova.
 */
public class Text {
    private String string;

    /**
     * RU:
     * <p>Набрать приведенный пример HelloWorld.java, откомпилировать его и запустить.</p>
     * EN:
     * <p>Type the above HelloWorld.java example, compile it, and run it.</p>
     */
    public String getHelloWorld() {
        string = "Hello World!";
        return string;
    }

    /**
     * RU:
     * <p>В набранном из задания 1 примере изменить сообщение на “Hello Belarus!”.
     * Откомпилировать пример и запустить.</p>
     * EN:
     * <p>In the example typed from task 1, change the message to “Hello Belarus!”.
     * Compile the example and run.</p>
     */
    public String getHelloBelarus() {
        string = "Hello Belarus!";
        return string;
    }

    /**
     * RU:
     * <p>В набранном из задания 2 примере добавить к основному сообщению дополнительное “I like Java!”.
     * Откомпилировать пример и запустить.</p>
     * <p>EN:</p>
     * <p>In the example typed from task 2, add an additional “I like Java!” to the main message.
     * Compile the example and run.</p>
     */
    public String getLikeJava() {
        string = format("%s%n%s", getHelloBelarus(), "I like Java!");
        return string;
    }
}
