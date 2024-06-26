package com.example.informationsystem.repository;


import com.example.informationsystem.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByCategoryId(Long categoryId);
}
