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
            throw new IllegalArgumentException("Message is empty");
        }
        if (message.getBody().isEmpty()) {
            throw new IllegalArgumentException("Message is empty");
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
            throw new IllegalArgumentException("Message from massive is null");
        }
        if (messages.length == 0) {
            throw new IllegalArgumentException("Message from massive is empty");
        }
    }

    public void isArgsValid(Object object) {
        if (object == null) {
            throw new IllegalArgumentException("someArg is null");
        }
    }
//    /**
//     * @param message входное сообщение
//     * @return если сообщение пустое -> false, иначе -> true
//     */
//    public boolean isArgsValid(String message) {
//        if (message == null) return false;
//        if (message.isEmpty()) return false;
//        return true;
//    }

//    public boolean isArgsValid(Message... messages) {
//        if (messages == null) return false;
//        if (messages.length == 0) return false;
//        return true;
//    }

//    public boolean isArgsValid(Object object) {
//        if (object == null) return false;
//        return true;
//    }

//    public boolean isArgsValid(Message message) {
//        if (message.getBody() !=null && message.getLevel() != null) return true;
//        return false;
//    }д
}
