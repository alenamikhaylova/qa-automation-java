package com.tcs.edu.decorator;

import com.tcs.edu.printer.ConsolePrinter;

import static com.tcs.edu.decorator.SeverityDecorator.mapToString;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;

public class MessageService {

    /**
     * API процедуры вывода сообщений с уровнем важности
     */
    public static void print(Severity level, String message, String... messages) {
        ConsolePrinter.print(decorate(message + mapToString(level)));

        for (String current : messages) {
            ConsolePrinter.print(decorate(current + mapToString(level)));
        }
    }
}