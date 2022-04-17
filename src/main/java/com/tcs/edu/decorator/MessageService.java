package com.tcs.edu.decorator;

import static com.tcs.edu.decorator.SeverityDecorator.mapToString;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;
import static com.tcs.edu.printer.ConsolePrinter.print;

public class MessageService {

    /**
     * API
     */
    public static void process(Severity level, String message) {
        print(decorate(message) + mapToString(level));
    }
}