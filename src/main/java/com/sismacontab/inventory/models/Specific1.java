package com.sismacontab.inventory.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.List;

@Entity
@Table(name = "specific_1", schema = "fdw_vegfarm")
public class Specific1 {
    @Id
    @Column(name = "specific_1_id")
    private Integer specific1Id;

    @Column(name = "specific_1_name")
    private String specific1Name;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    @JsonBackReference
    private Subcategory subcategory;

    @OneToMany(mappedBy = "specific1")
    @JsonManagedReference
    private List<Specific2> specifics2;

    // Getters y Setters
    public Integer getSpecific1Id() { return specific1Id; }
    public void setSpecific1Id(Integer specific1Id) { this.specific1Id = specific1Id; }
    public String getSpecific1Name() { return specific1Name; }
    public void setSpecific1Name(String specific1Name) { this.specific1Name = specific1Name; }
    public Subcategory getSubcategory() { return subcategory; }
    public void setSubcategory(Subcategory subcategory) { this.subcategory = subcategory; }
    public List<Specific2> getSpecifics2() { return specifics2; }
    public void setSpecifics2(List<Specific2> specifics2) { this.specifics2 = specifics2; }
}