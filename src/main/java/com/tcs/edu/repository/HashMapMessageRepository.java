package com.tcs.edu.repository;

import com.tcs.edu.decorator.Severity;
import com.tcs.edu.domain.Message;

import java.util.*;

import static java.util.stream.Collectors.*;

/**
 * Назначение класса: хранение сообщений в репозитории с уникальным номером
 */
public class HashMapMessageRepository implements MessageRepository {
    private final Map<UUID, Message> messages = new HashMap<>();

    @Override
    public UUID create(Message message) {
        final UUID key = UUID.randomUUID();
        message.setId(key);
        messages.put(key, message);
        return key;
    }

    @Override
    public Message findByPrimaryKey(String key) {
        return messages.get(key);
    }

    @Override
    public Message findByPrimaryKey(UUID key) {
        return messages.get(key);
    }

    @Override
    public Collection<Message> findAll() {
        return messages.values();
    }

    @Override
    public Collection<Message> findAllBySeverity(Severity by) {
        return messages.values().stream()
                .filter(message -> message.getLevel() == by)
                .collect(toList());
    }
}
