package com.sismacontab.inventory.models.dto;

public class SubcategoryDTO {
    private Integer subcategoryId;
    private String subcategoryName;

    public SubcategoryDTO(Integer subcategoryId, String subcategoryName) {
        this.subcategoryId = subcategoryId;
        this.subcategoryName = subcategoryName;
    }

    // Getters y Setters
    public Integer getSubcategoryId() { return subcategoryId; }
    public void setSubcategoryId(Integer subcategoryId) { this.subcategoryId = subcategoryId; }
    public String getSubcategoryName() { return subcategoryName; }
    public void setSubcategoryName(String subcategoryName) { this.subcategoryName = subcategoryName; }
}