package com.tcs.edu;

import com.tcs.edu.decorator.Doubling;
import com.tcs.edu.decorator.MessageOrder;
import com.tcs.edu.decorator.Severity;
import com.tcs.edu.domain.Message;

import java.util.Collection;

/**
 * Интерфейс обработки выводимых сообщений
 */
public interface MessageService {
    String log(Message message, Message... messages) throws LogException;

    Message findByPrimaryKey(String key);

    void log(MessageOrder messageOrder, Message message, Message... messages) throws LogException;

    void log(MessageOrder order, Doubling doubling, Message message, Message... messages) throws LogException;

    Collection<Message> findAll();

    Collection<Message> findAllBySeverity(Severity by);
}
