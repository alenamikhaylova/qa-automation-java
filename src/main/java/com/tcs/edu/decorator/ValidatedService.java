package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;

/**
 * назначение класса: проверка входных параметров
 */
public abstract class ValidatedService {
    /**
     * назначение метода: проверка сообщения на null или empty
     *
     * @param message входное сообщение
     */
    public void isArgsValid(Message message) {
        if (message == null) {
            throw new IllegalArgumentException("Message is null");
        }
        if (message.getBody() == null) {
            throw new IllegalArgumentException("Body is null");
        }
        if (message.getBody().isEmpty()) {
            throw new IllegalArgumentException("Body is empty");
        }
    }

    public void isArgsValid(String message) {
        if (message == null) {
            throw new IllegalArgumentException("Message is null");
        }
        if (message.isEmpty()) {
            throw new IllegalArgumentException("Message is empty");
        }
    }

    public void isArgsValid(Message... messages) {
        if (messages == null) {
            throw new IllegalArgumentException("Vararg is null");
        }
        if (messages.length == 0) {
            throw new IllegalArgumentException("Vararg is empty");
        }
    }

    public void isArgsValid(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("SomeArg is null");
        }
    }
}
