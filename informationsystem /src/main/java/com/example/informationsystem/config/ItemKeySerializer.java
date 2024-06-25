package com.example.informationsystem.config;

import com.example.informationsystem.entity.Item;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;

public class ItemKeySerializer extends StdSerializer<Item> {

    public ItemKeySerializer() {
        this(null);
    }

    public ItemKeySerializer(Class<Item> t) {
        super(t);
    }

    @Override
    public void serialize(Item item, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeFieldName(String.valueOf(item.getId()));
    }
}