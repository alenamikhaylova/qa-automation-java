package com.tcs.edu.domain;

import com.tcs.edu.decorator.Severity;

/**
 * immutable
 * Design Pattern: Data Transfer Object / Value Object
 */
public class Message {
    /**
     * Instance var = field = instance state
     */

    private Severity level;
    private String body;

    public Message(Severity level, String body) {
        this.level = level;
        this.body = body;
    }

    public Message(String body) {
        this(Severity.MINOR, body);
    }

    public Severity getLevel() {
        return level;
    }

    public String getBody() {
        return body;
    }
}
