package com.example.informationsystem.dto;

public class ItemStatistics {
    private Long militaryUnitId;
    private String militaryUnitName;
    private Long itemCount;


    public ItemStatistics(Long militaryUnitId, String militaryUnitName, Long itemCount) {
        this.militaryUnitId = militaryUnitId;
        this.militaryUnitName = militaryUnitName;
        this.itemCount = itemCount;
    }

    public Long getMilitaryUnitId() {
        return militaryUnitId;
    }

    public void setMilitaryUnitId(Long militaryUnitId) {
        this.militaryUnitId = militaryUnitId;
    }

    public String getMilitaryUnitName() {
        return militaryUnitName;
    }

    public void setMilitaryUnitName(String militaryUnitName) {
        this.militaryUnitName = militaryUnitName;
    }

    public Long getItemCount() {
        return itemCount;
    }

    public void setItemCount(Long itemCount) {
        this.itemCount = itemCount;
    }
}
