package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * назначение класса: декорирование сообщений с операцией добавления к строке текущего времени
 *
 * @author Михайлова Алена Владимировна
 */
public class TimestampMessageDecorator {

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
    public static String decorate(String message) {
        var decoratedMessage = Instant.now() + " " + message;
        messageCount++;
        return messageCount + " " + decoratedMessage;
    }
}
