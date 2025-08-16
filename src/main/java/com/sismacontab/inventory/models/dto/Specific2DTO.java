package com.sismacontab.inventory.models.dto;

public class Specific2DTO {
    private Integer specific2Id;
    private String specific2Name;

    public Specific2DTO(Integer specific2Id, String specific2Name) {
        this.specific2Id = specific2Id;
        this.specific2Name = specific2Name;
    }

    // Getters and Setters
    public Integer getSpecific2Id() { return specific2Id; }
    public void setSpecific2Id(Integer specific2Id) { this.specific2Id = specific2Id; }
    public String getSpecific2Name() { return specific2Name; }
    public void setSpecific2Name(String specific2Name) { this.specific2Name = specific2Name; }
}