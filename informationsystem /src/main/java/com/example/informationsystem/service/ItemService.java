package com.example.informationsystem.service;

import com.example.informationsystem.entity.Category;
import com.example.informationsystem.entity.Item;
import com.example.informationsystem.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public List<Item> findByCategory(Long categoryId) {
        return itemRepository.findByCategoryId(categoryId);
    }
}