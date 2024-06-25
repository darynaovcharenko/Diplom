package com.example.informationsystem.controller;

import com.example.informationsystem.entity.MilitaryUnit;
import com.example.informationsystem.service.MilitaryUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/military-units")
public class MilitaryUnitController {

    @Autowired
    private MilitaryUnitService militaryUnitService;

    @PostMapping("/create")
    public ResponseEntity<MilitaryUnit> createMilitaryUnit(@RequestBody MilitaryUnit militaryUnit) {
        return ResponseEntity.ok(militaryUnitService.createMilitaryUnit(militaryUnit));
    }

    @GetMapping("/all")
    public ResponseEntity<List<MilitaryUnit>> getAllMilitaryUnits() {
        return ResponseEntity.ok(militaryUnitService.getAllMilitaryUnits());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMilitaryUnit(@PathVariable Long id) {
        militaryUnitService.deleteMilitaryUnit(id);
        return ResponseEntity.noContent().build();
    }
}