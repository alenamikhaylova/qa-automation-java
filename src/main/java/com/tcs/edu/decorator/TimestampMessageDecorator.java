package com.tcs.edu.decorator;

import com.tcs.edu.MessageDecorator;
import java.time.Instant;

/**
 * назначение класса: декорирование сообщений с операцией добавления к строке текущего времени
 */
public class TimestampMessageDecorator implements MessageDecorator {

    /**
     * Размер страницы
     */
    public static Integer PAGE_SIZE = 2;

    /**
     * Счетчик
     */
    public static Integer messageCount = 0;

    /**
     * назначение метода: вывод на экран/консоль строки сообщения, обогащенной текущим временем,
     * <br>входные параметры: данные с типом String (Строка),
     * <br>Side effect: осуществление операций вывода, изменение консоли
     *
     * @param message сообщение с типом String
     */
    public String decorate(String message) {
        messageCount++;
        var decoratedMessage = String.format("%d %s %s", messageCount, Instant.now(), message);

        if (messageCount % PAGE_SIZE == 0) {
            decoratedMessage = String.format("%s %s %s", decoratedMessage, System.lineSeparator(), "---");
        }
        return decoratedMessage;
    }
}


