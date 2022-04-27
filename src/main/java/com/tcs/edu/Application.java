package com.tcs.edu;

import com.tcs.edu.decorator.MessageService;

import static com.tcs.edu.decorator.Severity.*;


/**
 * Test case:
 * <br>вывод сообщений с разным уровнем важности
 */
class Application {
    public static void main(String[] args) {
        MessageService.log(MINOR, "1)Hello world!", "Hello", null, "1");
        MessageService.log(MAJOR, "2)Hello world!", "Hi", "2", null);
        MessageService.log(REGULAR, null, "world!", "3");
        MessageService.log(null, "3)Hello world!", "Hi world!", "4");
    }
}