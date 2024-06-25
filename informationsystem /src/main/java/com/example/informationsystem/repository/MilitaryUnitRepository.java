package com.example.informationsystem.repository;

import com.example.informationsystem.entity.MilitaryUnit;
import com.example.informationsystem.dto.ItemStatistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MilitaryUnitRepository extends JpaRepository<MilitaryUnit, Long> {
    @Query(value = "SELECT mu.id as militaryUnitId, mu.name as militaryUnitName, SUM(di.quantity) as itemCount " +
            "FROM military_units mu " +
            "JOIN delivery d ON mu.id = d.military_unit_id " +
            "JOIN delivery_items di ON d.id = di.delivery_id " +
            "WHERE d.status = 'Delivered' " +
            "GROUP BY mu.id, mu.name", nativeQuery = true)
    List<ItemStatistics> findItemStatisticsByMilitaryUnits();
}