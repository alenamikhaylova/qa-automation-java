package com.tcs.edu.repository;

import com.tcs.edu.decorator.Severity;
import com.tcs.edu.domain.Message;

import java.util.Collection;

public interface MessageRepository {
    String create(Message message);

    Message findByPrimaryKey(String key);

    Collection<Message> findAll();

    Collection<Message> findAllBySeverity(Severity by);
}