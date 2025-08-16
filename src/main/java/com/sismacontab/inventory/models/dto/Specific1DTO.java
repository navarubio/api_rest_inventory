package com.sismacontab.inventory.models.dto;

public class Specific1DTO {
    private Integer specific1Id;
    private String specific1Name;
    
    public Specific1DTO(Integer specific1Id, String specific1Name) {
        this.specific1Id = specific1Id;
        this.specific1Name = specific1Name;
    }
    
    public Integer getSpecific1Id() { return specific1Id; }
    public void setSpecific1Id(Integer specific1Id) { this.specific1Id = specific1Id; }
    public String getSpecific1Name() { return specific1Name; }
    public void setSpecific1Name(String specific1Name) { this.specific1Name = specific1Name; }
}