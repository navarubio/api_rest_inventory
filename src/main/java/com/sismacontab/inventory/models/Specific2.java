package com.sismacontab.inventory.models;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "specific_2", schema = "fdw_vegfarm")
public class Specific2 {
    @Id
    @Column(name = "specific_2_id")
    private Integer specific2Id;

    @Column(name = "specific_2_name")
    private String specific2Name;

    @ManyToOne
    @JoinColumn(name = "specific_1_id")
    @JsonBackReference
    private Specific1 specific1;

    // Getters y Setters
    public Integer getSpecific2Id() { return specific2Id; }
    public void setSpecific2Id(Integer specific2Id) { this.specific2Id = specific2Id; }
    public String getSpecific2Name() { return specific2Name; }
    public void setSpecific2Name(String specific2Name) { this.specific2Name = specific2Name; }
    public Specific1 getSpecific1() { return specific1; }
    public void setSpecific1(Specific1 specific1) { this.specific1 = specific1; }
}