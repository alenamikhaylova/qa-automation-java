package com.tcs.edu;

import com.tcs.edu.domain.Message;

import static com.tcs.edu.decorator.MessageOrder.*;
import static com.tcs.edu.decorator.MessageService.*;
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
        Message[] messages = new Message[]{
                new Message(MAJOR, "H2"),
                new Message(MAJOR, "H2"),
                new Message(REGULAR, "H3"),
                new Message(REGULAR, "H3"),
                new Message("H4"),
                new Message("H4")
        };

        log(ASC, DISTINCT, messageMain, messages);
        log(DESC, DISTINCT, messageMain, messages);
        log(ASC, DOUBLES, messageMain, messages);
        log(DESC, DOUBLES, messageMain, messages);
        log(messageMain, messages);

//        MessageService.log(MINOR, DESC, DOUBLES, "1)H", "1)H", "2)H", "2)H", null, "3)H", "3)H");
//        MessageService.log(MAJOR, DESC, DISTINCT, "4)H", "4)H", "5)He", "5)He", "6)He", "6)He", null);
//        MessageService.log(REGULAR, ASC, DOUBLES, "9)H", "9)H", "10)H", "10)H", null, "11)H", "11)H");
//        MessageService.log(MINOR, ASC, DISTINCT, "12)H", null, "12)H", "13)H", "13)H");
    }
}