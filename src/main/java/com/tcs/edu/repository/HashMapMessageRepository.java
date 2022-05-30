package com.tcs.edu.repository;

import com.tcs.edu.decorator.Severity;
import com.tcs.edu.domain.Message;

import java.util.*;

public class HashMapMessageRepository implements MessageRepository {
    private Map<String, Message> messages = new HashMap<>();

    @Override
    public String create(Message message) {
        final String keyString = String.valueOf(new Random().nextInt());
        messages.put(keyString, message);
        return keyString;
    }

    @Override
    public Message findByPrimaryKey(String key) {
        return messages.get(key);
    }

    @Override
    public Collection<Message> findAll() {
        return messages.values();
    }

    @Override
    public Collection<Message> findAllBySeverity(Severity by) {
        Collection<Message> filteredMessages = new ArrayList<>();
        for (Message current : messages.values()) {
            if (current.getLevel() == by) filteredMessages.add(current);
        }
        return filteredMessages;
    }
}
