package com.tcs.edu;

import com.tcs.edu.decorator.MessageService;

import static com.tcs.edu.decorator.Severity.*;

/**
 * Test case
 */
class Application {
    public static void main(String[] args) {
        MessageService.process(MINOR, "Hello world!");
        MessageService.process(REGULAR, "Hello world!");
        MessageService.process(REGULAR, "Hello world!");
        MessageService.process(MAJOR, "Hello world!");
        MessageService.process(MINOR, "Hello world!");
        MessageService.process(MAJOR, "Hello world!");
    }
}