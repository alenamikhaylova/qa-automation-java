package com.tcs.edu.printer;

import com.tcs.edu.LogException;
import com.tcs.edu.Printer;
import com.tcs.edu.decorator.ValidatedService;

/**
 * назначение класса: вывод сообщения в консоль
 *
 * @author Михайлова Алена Владимировна
 */
public class ConsolePrinter extends ValidatedService implements Printer {

    /**
     * назначение метода: вывод сообщения на экран/консоль,
     * <br>входные параметры: данные с типом String (Строка),
     * <br>Side effect: осуществление операций вывода, изменение консоли
     */
    @Override
    public void print(String decoratedMessage) throws LogException {
        try {
            ConsolePrinter.super.isArgsValid(decoratedMessage);
            System.out.println(decoratedMessage);
        } catch (IllegalArgumentException e) {
            throw new LogException("Wrong parameter description", e);
        }
    }
}
