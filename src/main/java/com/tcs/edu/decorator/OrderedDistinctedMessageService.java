package com.tcs.edu.decorator;

import com.tcs.edu.LogException;
import com.tcs.edu.MessageDecorator;
import com.tcs.edu.MessageService;
import com.tcs.edu.domain.Message;
import com.tcs.edu.repository.HashMapMessageRepository;
import com.tcs.edu.repository.MessageRepository;

import java.util.Collection;
import java.util.UUID;


/**
 * API процедуры вывода сообщений с уровнем важности
 */
public class OrderedDistinctedMessageService extends ValidatedService implements MessageService {

    private final MessageDecorator decorator;
    private MessageRepository messageRepository = new HashMapMessageRepository();

    public OrderedDistinctedMessageService(MessageDecorator decorator, MessageRepository messageRepository) {
        this.decorator = decorator;
        this.messageRepository = messageRepository;
    }

    /**
     * назначение метода: присвоение выводимому сообщению уровня важности и порядка вывода
     *
     * @param order    порядок вывода сообщений
     * @param doubling признак дублирования сообщений
     * @param messages массив сообщений с типом String
     */
    @Override
    public void log(MessageOrder order, Doubling doubling, Message message, Message... messages) throws LogException {
        try {
            super.isArgsValid(doubling);
        } catch (IllegalArgumentException e) {
            throw new LogException("notValidArgMessage", e);
        }
        if (doubling.equals(Doubling.DOUBLES)) {
            log(order, message, messages);
        } else if (doubling.equals(Doubling.DISTINCT)) {
            log(order, message, checkDifferent(messages));
        }
    }

    public void log(MessageOrder messageOrder, Message message, Message... messages) throws LogException {
        try {
            super.isArgsValid((messageOrder));
        } catch (IllegalArgumentException e) {
            throw new LogException("notValidArgMessage", e);
        }
        if (messageOrder.equals(MessageOrder.ASC)) {
            log(message, messages);
        } else if (messageOrder.equals(MessageOrder.DESC)) {
            log(message, checkDescend(messages));
        }
    }

    @Override
    public UUID log(Message message) {
        return messageRepository.create(message);
    }

    public UUID log(Message message, Message... messages) throws LogException {
        return messageRepository.create(message);
//        try {
//            super.isArgsValid(messages);
//        } catch (IllegalArgumentException e) {
//            throw new LogException("notValidArgMessage", e);
//        }
//        for (Message currentMessage : messages) {
//            String resultMessage = String.format("%s %s %s", message.getBody(), currentMessage.getBody(), mapToString(currentMessage.getLevel()));
//            //   printer.print(decorator.decorate(resultMessage));
//        }
    }

    @Override
    public Message findByPrimaryKey(UUID key) {
        return messageRepository.findByPrimaryKey(key);
    }

    @Override
    public Collection<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Collection<Message> findAllBySeverity(Severity by) {
        return messageRepository.findAllBySeverity(by);
    }

    /**
     * Назначение: вывод неповторяющихся сообщений
     *
     * @param messages массив сообщений
     * @return возвращает массив неповторящющихся сообщений
     */
    public static Message[] checkDifferent(Message... messages) {
        Message[] messagesDifferent = new Message[messages.length];
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
    private static Message[] checkDescend(Message... messages) {
        int k = messages.length;
        Message[] messagesDescend = new Message[k];
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
    public static boolean checkInsideArray(Message message, Message[] messages) {
        if (message != null)
            for (Message m : messages) {
                if ((m != null) && m.getBody().equals(message.getBody())) {
                    return true;
                }
            }
        return false;
    }
}