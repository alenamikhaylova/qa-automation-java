package com.tcs.edu.decorator;

import com.tcs.edu.printer.ConsolePrinter;

import java.util.Objects;

import static com.tcs.edu.decorator.Doubling.*;
import static com.tcs.edu.decorator.MessageOrder.*;
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
     * @param doubling признак дублирования сообщений
     * @param messages массив сообщений с типом String
     */
    public static void log(Severity level, MessageOrder order, Doubling doubling, String message, String... messages) {
        String[] arrayOfMessages = new String[messages.length + 1];

        if (doubling == DISTINCT) {
            if (Objects.equals(order.name(), "DESC")) {
                for (int i = messages.length - 1; i >= 0; i--) {
                    if (messages[i] != null & !MessageService.insideArray(messages[i], arrayOfMessages)) {
                        ConsolePrinter.print(decorate(messages[i] + " " + mapToString(level)));
                        arrayOfMessages[i] = messages[i];
                    }
                }
                if (!MessageService.insideArray(message, arrayOfMessages)) {
                    ConsolePrinter.print(decorate(message + " " + mapToString(level)));
                }
            }
            if (order == ASC) {
                ConsolePrinter.print(decorate(message + " " + mapToString(level)));
                arrayOfMessages[messages.length] = message;

                for (int i = 0; i <= messages.length - 1; i++) {
                    if (message != null & messages[i] != null & !MessageService.insideArray(messages[i], arrayOfMessages)) {
                        ConsolePrinter.print(decorate(messages[i] + " " + mapToString(level)));
                        arrayOfMessages[i] = messages[i];
                    }
                }
            }
        } else if (doubling == DOUBLES) {
            if (Objects.equals(order.name(), "DESC")) {
                for (int i = messages.length - 1; i >= 0; i--) {
                    if (message != null & messages[i] != null) {
                        ConsolePrinter.print(decorate(messages[i] + " " + mapToString(level)));
                    }
                }
                ConsolePrinter.print(decorate(message + " " + mapToString(level)));
            }
            if (order == ASC) {
                ConsolePrinter.print(decorate(message + " " + mapToString(level)));
                arrayOfMessages[messages.length] = message;

                for (int i = 0; i <= messages.length - 1; i++) {
                    if (message != null & messages[i] != null) {
                        ConsolePrinter.print(decorate(messages[i] + " " + mapToString(level)));
                    }
                }
            }
        }
    }

    /**
     * Назначение: проверка наличия сообщения в массиве
     *
     * @param message        сообщение с типом String
     * @param messageInArray массив сообщений с типом String
     * @return возвращает булево значение
     */
    private static boolean insideArray(String message, String[] messageInArray) {
        for (String arrayOfMessagesPrint : messageInArray) {
            if (Objects.equals(message, arrayOfMessagesPrint)) {
                return true;
            }
        }
        return false;
    }
}
