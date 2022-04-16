package com.tcs.edu.printer;

import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;
import static com.tcs.edu.decorator.TimestampMessageDecorator.messageCount;

/**
 * назначение класса: вывод сообщения в консоль
 *
 * @author Михайлова Алена Владимировна
 */
public class ConsolePrinter {


    /**
     * назначение метода: вывод сообщения на экран/консоль,
     * <br>входные параметры: данные с типом String (Строка),
     * <br>Side effect: осуществление операций вывода, изменение консоли
     *
     * @param message сообщение с типом String
     */
    public static void print(String message) {
        messageCount++;
        System.out.println(decorate(message));
    }
}

