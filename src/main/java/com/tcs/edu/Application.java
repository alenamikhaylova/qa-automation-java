package com.tcs.edu;

import com.tcs.edu.decorator.MessageService;
import static com.tcs.edu.decorator.MessageOrder.*;
import static com.tcs.edu.decorator.Severity.*;


/**
 * Test case:
 * <br>назначение: вывод сообщений с разным уровнем важности и в разном порядке
 * * @author Михайлова Алена Владимировна
 */
class Application {
    public static void main(String[] args) {
        MessageService.log(MINOR, DESC, "1)H", "2)H", null, "3)H");
        MessageService.log(MAJOR, ASC, "4)H", "5)H", "6)H", null);
        MessageService.log(REGULAR, DESC, null, "7)H!", "8)H");
        MessageService.log(MAJOR, DESC, "9)H", "10)H", "11)H");
        MessageService.log(MINOR, ASC, "12)H", null, "13)H");
    }
}