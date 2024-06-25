package com.example.informationsystem.service;

import com.example.informationsystem.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.informationsystem.repository.MessageRepository;
import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public Message save(Message message) {
        return messageRepository.save(message);
    }

    public Optional<Message> findById(Long id) {
        return messageRepository.findById(id);
    }

    public List<Message> findBySenderName(String senderName) {
        return messageRepository.findBySenderName(senderName);
    }

    public List<Message> findAll() {
        return messageRepository.findAll();
    }
}