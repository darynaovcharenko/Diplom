package com.example.informationsystem.service;

import com.example.informationsystem.dto.ItemStatistics;
import com.example.informationsystem.entity.MilitaryUnit;
import com.example.informationsystem.repository.MilitaryUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MilitaryUnitService {

    @Autowired
    private MilitaryUnitRepository militaryUnitRepository;

    public MilitaryUnit createMilitaryUnit(MilitaryUnit militaryUnit) {
        return militaryUnitRepository.save(militaryUnit);
    }

    public List<ItemStatistics> getItemStatisticsForMilitaryUnits() {
        return militaryUnitRepository.findItemStatisticsByMilitaryUnits();
    }

    public List<MilitaryUnit> getAllMilitaryUnits() {
        return militaryUnitRepository.findAll();
    }

    public void deleteMilitaryUnit(Long id) {
        militaryUnitRepository.deleteById(id);
    }
}