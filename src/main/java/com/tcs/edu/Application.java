package com.tcs.edu;

import com.tcs.edu.decorator.OrderedDistinctedMessageService;
import com.tcs.edu.decorator.TimestampMessageDecorator;
import com.tcs.edu.domain.Message;
import com.tcs.edu.printer.ConsolePrinter;

import java.sql.SQLOutput;

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

        MessageService service = new OrderedDistinctedMessageService(
                new TimestampMessageDecorator(),
                new ConsolePrinter()
        );
//        service.log(ASC, DISTINCT, messageMain, messages);
//        service.log(DESC, DISTINCT, messageMain, messages);
//        service.log(ASC, DOUBLES, messageMain, messages);
//        service.log(DESC, DOUBLES, messageMain, messages);
//        service.log(messageMain, messages);
//
//        System.out.println(messageMain);
//        System.out.println(messageMain.equals(messageMain2));
//        System.out.println(messageMain.equals(messageMain3));
//        System.out.println(messageMain.hashCode());
//
//        System.out.println(messageMain5);

        try {
            service.log(ASC, DISTINCT, messageMain, null);
        } catch (LogException e) {
            e.printStackTrace();
        }

        try {
            service.log(null, messages);
        } catch (LogException e) {
            e.printStackTrace();
        }

        try {
            service.log(messageEmpty);
        } catch (LogException e) {
            e.printStackTrace();
        }
    }
}