package com.tcs.edu;

import com.tcs.edu.decorator.MessageService;

import static com.tcs.edu.decorator.Severity.*;

/**
 * Test case
 */
class Application {
    public static void main(String[] args) {
        MessageService.print(MINOR, "Hello world!");
        MessageService.print(REGULAR, "Hello world!");
        MessageService.print(REGULAR, "Hello world!");
        MessageService.print(MAJOR, "Hello world!");
        MessageService.print(MINOR, "Hello world!");
        MessageService.print(MAJOR, "Hello world!");
    }
}