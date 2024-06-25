package com.example.informationsystem.controller;

import com.example.informationsystem.entity.Message;
import com.example.informationsystem.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/create")
    public ResponseEntity<Message> createMessage(@RequestBody Message message, Authentication authentication) {
        String senderName = authentication.getName();
        message.setSenderName(senderName);
        message.setProcessed(false);
        Message savedMessage = messageService.save(message);
        return ResponseEntity.ok(savedMessage);
    }

    @GetMapping("/my")
    public ResponseEntity<List<Message>> getMyMessages(Authentication authentication) {
        String senderName = authentication.getName();
        List<Message> messages = messageService.findBySenderName(senderName);
        return ResponseEntity.ok(messages);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_SUPERUSER')")
    public ResponseEntity<List<Message>> getAllMessages() {
        List<Message> messages = messageService.findAll();
        return ResponseEntity.ok(messages);
    }

    @PutMapping("/process/{messageId}")
    @PreAuthorize("hasAuthority('ROLE_SUPERUSER')")
    public ResponseEntity<Message> processMessage(@PathVariable Long messageId) {
        Message message = messageService.findById(messageId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Message not found"));
        message.setProcessed(true);
        Message updatedMessage = messageService.save(message);
        return ResponseEntity.ok(updatedMessage);
    }
}