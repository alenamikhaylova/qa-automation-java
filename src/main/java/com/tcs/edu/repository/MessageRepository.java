package com.tcs.edu.repository;

import com.tcs.edu.decorator.Severity;
import com.tcs.edu.domain.Message;

import java.util.Collection;
import java.util.UUID;

/**
 * Интерфейс хранения сообщений
 */
public interface MessageRepository {
    UUID create(Message message);

    Message findByPrimaryKey(String key);

    Message findByPrimaryKey(UUID key);

    Collection<Message> findAll();

    Collection<Message> findAllBySeverity(Severity by);
}