package com.example.informationsystem.repository;

import com.example.informationsystem.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findByStatus(String status);
}
