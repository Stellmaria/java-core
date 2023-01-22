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
     * <p>RU: Строка, которая меняет свое значение в зависимости от запроса.</p><br>
     *
     * <p>EN: A string that changes its value depending on the request.</p>
     */
    private String string;

    /**
     * <p>RU: Набрать приведенный пример HelloWorld.java, откомпилировать его и запустить.</p><br>
     *
     * <p>EN: Type the above HelloWorld.java example, compile it, and run it.</p><br>
     *
     * @return line with text/string with text.
     */
    public String getHelloWorld() {
        string = "Hello World!";

        return string;
    }

    /**
     * <p>RU: В набранном из задания 1 примере изменить сообщение на “Hello Belarus!”.
     * Откомпилировать пример и запустить.</p><br>
     *
     * <p>EN: In the example typed from task 1, change the message to “Hello Belarus!”.
     * Compile the example and run.</p><br>
     *
     * @return line with text/string with text.
     */
    public String getHelloBelarus() {
        string = "Hello Belarus!";

        return string;
    }

    /**
     * <p>RU: В набранном из задания 2 примере добавить к основному сообщению дополнительное “I like Java!”.
     * Откомпилировать пример и запустить.</p><br>
     *
     * <p>EN: In the example typed from task 2, add an additional “I like Java!” to the main message.
     * Compile the example and run.</p><br>
     *
     * @return line with text/string with text.
     */
    public String getLikeJava() {
        string = format("%s%n%s", getHelloBelarus(), "I like Java!");

        return string;
    }
}
