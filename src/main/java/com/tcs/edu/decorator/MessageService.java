package com.tcs.edu.decorator;

import com.tcs.edu.printer.ConsolePrinter;

import static com.tcs.edu.decorator.SeverityDecorator.mapToString;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;

public class MessageService {

    /**
     * API процедуры вывода
     */
    public static void print(Severity level, String... messages) {
        for (String current : messages) {
            ConsolePrinter.print(decorate(current) + mapToString(level));
        }
        for (int current = 0; current < messages.length; current++) {
            ConsolePrinter.print(decorate(messages[current]) + mapToString(level));
        }
    }
}