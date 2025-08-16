package com.sismacontab.inventory.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
@Table(name = "category", schema = "fdw_vegfarm")
public class Category {
    @Id
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "category_name")
    private String categoryName;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Subcategory> subcategories;

    // Getters y Setters
    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }
    public List<Subcategory> getSubcategories() { return subcategories; }
    public void setSubcategories(List<Subcategory> subcategories) { this.subcategories = subcategories; }
}