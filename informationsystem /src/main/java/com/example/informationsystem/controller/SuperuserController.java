package com.example.informationsystem.controller;

import com.example.informationsystem.dto.ItemStatistics;
import com.example.informationsystem.service.MilitaryUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/superuser")
public class SuperuserController {

    @Autowired
    private MilitaryUnitService militaryUnitService;

    @GetMapping("/item-statistics")
    public ResponseEntity<List<ItemStatistics>> getItemStatistics() {
        List<ItemStatistics> statistics = militaryUnitService.getItemStatisticsForMilitaryUnits();
        return ResponseEntity.ok(statistics);
    }
}
