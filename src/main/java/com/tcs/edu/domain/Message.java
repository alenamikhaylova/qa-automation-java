package com.tcs.edu.domain;

import com.tcs.edu.decorator.Severity;

import java.util.Objects;

/**
 * Назначение класса: шаблон выводимого сообщения
 * immutable
 * Design Pattern: Data Transfer Object / Value Object
 * Назначение класса: шаблон выводимого сообщения
 */
public class Message {
    /**
     * level уровень важности
     * body сообшение
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

    @Override
    public String toString() {
        return "Message{" +
                "level=" + level +
                ", body='" + body + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return getLevel() == message.getLevel() && Objects.equals(getBody(), message.getBody());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLevel(), getBody());
    }
}
