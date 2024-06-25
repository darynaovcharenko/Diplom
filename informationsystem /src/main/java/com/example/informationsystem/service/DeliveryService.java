package com.example.informationsystem.service;

import com.example.informationsystem.entity.Delivery;
import com.example.informationsystem.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import com.example.informationsystem.repository.MilitaryUnitRepository;



@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    @Autowired
    private MilitaryUnitRepository militaryUnitRepository;

    public Delivery save(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public Delivery updateStatus(Long deliveryId, String status) {
        Delivery delivery = deliveryRepository.findById(deliveryId).orElseThrow(() -> new RuntimeException("Delivery not found"));
        delivery.setStatus(status);

        if ("Delivered".equals(status)) {
            delivery.getItems().forEach((item, quantity) -> {
                item.setQuantity(item.getQuantity() + quantity);
            });
            militaryUnitRepository.save(delivery.getMilitaryUnit());
        }

        return deliveryRepository.save(delivery);
    }

    public List<Delivery> findAll() {
        return deliveryRepository.findAll();
    }

    public List<Delivery> findByStatus(String status) {
        return deliveryRepository.findByStatus(status);
    }
}