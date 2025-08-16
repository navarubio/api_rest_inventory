package com.sismacontab.inventory.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
@Table(name = "subcategories", schema = "fdw_vegfarm")
public class Subcategory {
    @Id
    @Column(name = "subcategory_id")
    private Integer subcategoryId;

    @Column(name = "subcategory_name")
    private String subcategoryName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;

    @OneToMany(mappedBy = "subcategory")
    @JsonManagedReference
    private List<Specific1> specifics1;

    // Getters y Setters
    public Integer getSubcategoryId() { return subcategoryId; }
    public void setSubcategoryId(Integer subcategoryId) { this.subcategoryId = subcategoryId; }
    public String getSubcategoryName() { return subcategoryName; }
    public void setSubcategoryName(String subcategoryName) { this.subcategoryName = subcategoryName; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public List<Specific1> getSpecifics1() { return specifics1; }
    public void setSpecifics1(List<Specific1> specifics1) { this.specifics1 = specifics1; }
}