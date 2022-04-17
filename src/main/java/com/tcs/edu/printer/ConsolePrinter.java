package com.tcs.edu.printer;

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
     */
    public static void print(String decoratedMessage) {
        System.out.println(decoratedMessage);
    }
}
