package com.tcs.edu.domain;

import com.tcs.edu.decorator.Severity;

import java.util.Objects;
import java.util.UUID;

/**
 * Назначение класса: шаблон выводимого сообщения
 *
 * immutable
 * Design Pattern: Data Transfer Object / Value Object
 */
public class Message {

    /**
     * level уровень важности
     * <br>body сообшение
     * <br>id уникальный идентификатор
     * Instance var = field = instance state
     */
    private final Severity level;
    private final String body;
    private UUID id;

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

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "level=" + level +
                ", body='" + body + '\'' +
                ", id=" + id +
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
