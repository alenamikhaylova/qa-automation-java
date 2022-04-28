package com.tcs.edu.decorator;

import com.tcs.edu.printer.ConsolePrinter;

import java.util.Objects;

import static com.tcs.edu.decorator.SeverityDecorator.mapToString;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;

/**
 * API процедуры вывода сообщений с уровнем важности
 */
public class MessageService {

    /**
     * назначение метода: присвоение выводимому сообщению уровня важности и порядка вывода
     *
     * @param level    уровень важности
     * @param order    порядок вывода сообщений
     * @param messages массив сообщений с типом String
     */
    public static void log(Severity level, MessageOrder order, String... messages) {
        if (Objects.equals(order.name(), "DESC")) {
            for (int i = messages.length - 1; i >= 0; i--) {
                if (messages[i] != null) {
                    ConsolePrinter.print(decorate(messages[i] + " " + mapToString(level)));
                }
            }
        } else for (String currentMessages : messages)
            if (currentMessages != null & level != null & order != null) {
                ConsolePrinter.print(decorate(currentMessages + " " + mapToString(level)));
            }
    }
}