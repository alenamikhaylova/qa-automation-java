package com.tcs.edu.decorator;

/**
 * назначение класса: строковое представление уровня важности выводимых сообщений
 */
public class SeverityDecorator {
    public static String mapToString(Severity severity) {
        String severityString = null;
        switch (severity) {
            case MAJOR:
                severityString = "(!!!)";
                break;
            case REGULAR:
                severityString = "(!)";
                break;
            case MINOR:
                severityString = "()";
                break;
        }
        return severityString;
    }
}
