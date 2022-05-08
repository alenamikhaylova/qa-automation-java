package com.tcs.edu.decorator;

import static com.tcs.edu.decorator.SeverityDecorator.mapToString;
import static com.tcs.edu.decorator.TimestampMessageDecorator.decorate;
import static com.tcs.edu.printer.ConsolePrinter.print;

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
    public static void log(Severity level, MessageOrder order, Doubling doubling, String... messages) {
        if (doubling != null) {
            if (doubling.equals(Doubling.DOUBLES)) {
                log(level, order, messages);
            } else if (doubling.equals(Doubling.DISTINCT)) {
                log(level, order, checkDifferent(messages));
            }
        }
    }

    public static void log(Severity level, MessageOrder messageOrder, String... messages) {
        if (messageOrder != null) {
            if (messageOrder.equals(MessageOrder.ASC)) {
                log(level, messages);
            } else if (messageOrder.equals(MessageOrder.DESC)) {
                log(level, checkDescend(messages));
            }
        }
    }

    public static void log(Severity level, String... messages) {
        if (level != null && messages != null && messages.length != 0) {
            for (String currentMessage : messages) {
                if (currentMessage != null) {
                    print(decorate(String.format("%s %s", currentMessage, mapToString(level))));
                }
            }
        }
    }

    /**
     * Назначение: вывод неповторяющихся сообщений
     *
     * @param messages массив сообщений
     * @return возвращает массив неповторящющихся сообщений
     */
    public static String[] checkDifferent(String... messages) {
        String[] messagesDifferent = new String[messages.length];
        if (messages.length != 0) {
            messagesDifferent[0] = messages[0];
            int k = 1;
            for (int i = 1; i < messages.length; i++) {
                if (!checkInsideArray(messages[i], messagesDifferent)) {
                    messagesDifferent[k] = messages[i];
                    k++;
                }
            }
        }
        return messagesDifferent;
    }

    /**
     * Назначение: вывод сообщений в убывающем порядке
     *
     * @param messages массив сообщений
     * @return возвращает массив сообщений в убывающем порядке
     */
    private static String[] checkDescend(String... messages) {
        int k = messages.length;
        String[] messagesDescend = new String[k];
        for (int i = 0; i < k; i++) {
            messagesDescend[i] = messages[k - i - 1];
        }
        return messagesDescend;
    }

    /**
     * Назначение: проверка наличия сообщения в массиве
     *
     * @param message  сообщение с типом String
     * @param messages массив сообщений
     * @return возвращает булево значение: message в массиве messages -> true, иначе -> false
     */
    public static boolean checkInsideArray(String message, String[] messages) {
        for (String s : messages) {
            if (s != null && s.equals(message)) {
                return true;
            }
        }
        return false;
    }
}