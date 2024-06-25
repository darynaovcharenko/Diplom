package com.example.informationsystem.controller;

import com.example.informationsystem.entity.Item;
import com.example.informationsystem.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/create")
    public ResponseEntity<Item> createItem(@RequestBody Item item) {
        Item savedItem = itemService.save(item);
        return ResponseEntity.ok(savedItem);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Item>> listItems() {
        List<Item> items = itemService.findAll();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/by-category/{categoryId}")
    public ResponseEntity<List<Item>> listItemsByCategory(@PathVariable Long categoryId) {
        List<Item> items = itemService.findByCategory(categoryId);
        return ResponseEntity.ok(items);
    }
}