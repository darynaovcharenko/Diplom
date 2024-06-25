package com.example.informationsystem.config;

import com.example.informationsystem.entity.Item;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;

import java.io.IOException;

public class ItemKeyDeserializer extends KeyDeserializer {

    @Override
    public Item deserializeKey(String key, DeserializationContext deserializationContext) throws IOException {
        Item item = new Item();
        item.setId(Long.parseLong(key));
        return item;
    }
}