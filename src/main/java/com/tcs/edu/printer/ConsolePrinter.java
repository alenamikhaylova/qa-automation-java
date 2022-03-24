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
     * <br>побочные эффекты: осуществление операций вывода
     *
     * @param message сообщение с типом String
     */
    public static void print(String message) {
        System.out.println(message);
    }
}

