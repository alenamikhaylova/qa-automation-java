package com.tcs.edu;

import com.tcs.edu.decorator.OrderedDistinctedMessageService;
import com.tcs.edu.decorator.Severity;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.domain.Message;
import com.tcs.edu.printer.ConsolePrinter;
import com.tcs.edu.repository.HashMapMessageRepository;

import java.util.Collection;
import java.util.UUID;

import static com.tcs.edu.decorator.MessageOrder.*;
import static com.tcs.edu.decorator.Severity.*;
import static com.tcs.edu.decorator.Doubling.*;


/**
 * Test case:
 * <br>назначение: вывод сообщений с разным уровнем важности и в разном порядке
 * * @author Михайлова Алена Владимировна
 */
class Application {
    public static void main(String[] args) {
        Message messageMain = new Message(REGULAR, "H1");
        Message messageMain2 = new Message(REGULAR, "H1");
        Message messageMain3 = new Message(MAJOR, "H1");
        Message messageMain4 = new Message(REGULAR, null);
        Message messageNull = null;
        Message messageEmpty = new Message("");

        Message[] messages = new Message[]{
                new Message(MAJOR, "H2"),
                new Message(MAJOR, "H2"),
                new Message(REGULAR, "H3"),
                new Message(REGULAR, "H3"),
                new Message("H4"),
                new Message("H4")
        };
        HashMapMessageRepository hashMapMessageRepository = new HashMapMessageRepository();
        MessageService service = new OrderedDistinctedMessageService(
                new TimestampMessageDecorator(), hashMapMessageRepository);
        service.log(messageMain, messages);
        System.out.println(hashMapMessageRepository);

        final UUID key = service.log(messageMain3);
        System.out.println(service.findByPrimaryKey(key));

        System.out.println("======");

        final Collection<Message> allMessages = service.findAll();
        for (Message current : allMessages) {
            System.out.println(current);
        }
        System.out.println("======");

        final Collection<Message> findMessage = service.findAllBySeverity(MAJOR);
        for (Message current : findMessage) {
            System.out.println(current);
        }
//        try {
//            service.log(ASC, DISTINCT, messageMain, null);
//        } catch (LogException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            service.log(null, messages);
//        } catch (LogException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            service.log(messageEmpty);
//        } catch (LogException e) {
//            e.printStackTrace();
//        }
    }
}