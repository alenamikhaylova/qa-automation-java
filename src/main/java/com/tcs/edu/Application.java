package com.tcs.edu;

import com.tcs.edu.decorator.MessageService;

import static com.tcs.edu.decorator.Severity.*;


/**
 * Test case:
 * <br>вывод сообщений с разным уровнем важности
 */
class Application {
    public static void main(String[] args) {
        MessageService.print(MINOR, "Hello world!", "Hello world!");
        MessageService.print(MAJOR, "Hello world!", "Hello world!");
        MessageService.print(REGULAR, "Hello world!", "Hello world!");
    }
}