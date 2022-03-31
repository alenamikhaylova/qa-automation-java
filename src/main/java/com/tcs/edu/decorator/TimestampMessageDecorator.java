package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * назначение класса: декорирование сообщений с операцией добавления к строке текущего времени
 *
 * @author Михайлова Алена Владимировна
 */
public class TimestampMessageDecorator {

    /**
     * назначение метода: вывод на экран/консоль строки сообщения, обогащенной текущим временем,
     * <br>входные параметры: данные с типом String (Строка),
     * <br>побочные эффекты: осуществление операций вывода, изменение консоли
     *
     * @param message сообщение с типом String
     */
    public static void decorate(String message) {
        String decoratedMessage = Instant.now() +" "+ message;
        System.out.println(decoratedMessage);
    }
}
