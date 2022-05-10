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
        Message message1 = new Message(MAJOR, "H1");
        Message message2 = new Message(REGULAR, "H2");
        log(DESC, DOUBLES, message2, message2);
        log(null, DOUBLES, message2, message2);
        log(DESC, DISTINCT, message1, message2);
        log(ASC, DISTINCT, message1, message2);
        log(message1, message2);

//        MessageService.log(MINOR, DESC, DOUBLES, "1)H", "1)H", "2)H", "2)H", null, "3)H", "3)H");
//        MessageService.log(MAJOR, DESC, DISTINCT, "4)H", "4)H", "5)He", "5)He", "6)He", "6)He", null);
//        MessageService.log(REGULAR, ASC, DOUBLES, "9)H", "9)H", "10)H", "10)H", null, "11)H", "11)H");
//        MessageService.log(MINOR, ASC, DISTINCT, "12)H", null, "12)H", "13)H", "13)H");
    }
}