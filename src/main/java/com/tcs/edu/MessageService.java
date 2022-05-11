package com.tcs.edu;

import com.tcs.edu.decorator.Doubling;
import com.tcs.edu.decorator.MessageOrder;
import com.tcs.edu.domain.Message;

/**
 * Интерфейс обработки выводимых сообщений
 */
public interface MessageService {
    void log(Message message, Message... messages);

    void log(MessageOrder messageOrder, Message message, Message... messages);

    void log(MessageOrder order, Doubling doubling, Message message, Message... messages);
}
