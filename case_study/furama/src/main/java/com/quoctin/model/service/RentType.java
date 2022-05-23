package com.quoctin.model.service;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "rent_type")
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer rentTypeId;
    private String rentTypeName;
    @Column(columnDefinition = "DOUBLE")
    private String rentTypeCost;

    @OneToMany(mappedBy = "rentType")
    private List<Facility> facilityList;

    public RentType() {
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public String getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(String rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public List<Facility> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(List<Facility> facilityList) {
        this.facilityList = facilityList;
    }
}
