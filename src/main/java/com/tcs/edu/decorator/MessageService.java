package com.tcs.edu.decorator;

import com.tcs.edu.printer.ConsolePrinter;

import java.util.Arrays;

import static com.tcs.edu.decorator.SeverityDecorator.mapToString;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;

public class MessageService {

    /**
     * API процедуры вывода сообщений с уровнем важности
     */
    public static void log(Severity level, String message, String... messages) {
        for (String currentMessage : messages) {
            if (message != null & currentMessage != null & level != null) {
                ConsolePrinter.print(decorate(message + " " + currentMessage + " " + mapToString(level)));
            }
        }
    }
}