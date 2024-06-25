package com.example.informationsystem.repository;

import com.example.informationsystem.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderName(String senderName);
}