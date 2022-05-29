package com.tcs.edu.repository;

import com.tcs.edu.domain.Message;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class HashMapMessageRepository implements MessageRepository {
    private Map<String, Message> messages = new HashMap<>();

    @Override
    public String create(Message message) {
        final String keyString = String.valueOf(new Random().nextInt());
        messages.put(keyString, message);
        return keyString;
    }

    @Override
    public Message findByPRimaryKey(String key) {
        return messages.get(key);
    }
}
