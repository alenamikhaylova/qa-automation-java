package com.tcs.edu.repository;

import com.tcs.edu.domain.Message;

public interface MessageRepository {
    String create(Message message);
    Message findByPRimaryKey (String key);
}