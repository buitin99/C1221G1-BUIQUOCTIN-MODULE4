package com.quoctin.model.service;

import com.quoctin.model.contract.Contract;

import javax.persistence.*;
import java.util.List;

@Entity
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;
    private String serviceName;
    @Column(columnDefinition = "INT")
    private String serviceArea;
    @Column(columnDefinition = "DOUBLE")
    private String serviceCost;
    @Column(columnDefinition = "INT")
    private String serviceMaxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    @Column(columnDefinition = "DOUBLE")
    private String poolArea;
    @Column(columnDefinition = "INT")
    private String numberOfFloor;


    @ManyToOne
    @JoinColumn(name = "rent_type_id",referencedColumnName = "rentTypeId")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id",referencedColumnName = "serviceTypeId")
    private FacilityType facilityType;

    @OneToMany(mappedBy = "facility")
    private List<Contract> contractList;

    public Facility() {
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(String serviceArea) {
        this.serviceArea = serviceArea;
    }

    public String getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(String serviceCost) {
        this.serviceCost = serviceCost;
    }

    public String getServiceMaxPeople() {
        return serviceMaxPeople;
    }

    public void setServiceMaxPeople(String serviceMaxPeople) {
        this.serviceMaxPeople = serviceMaxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(String numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

//    public FacilityType getServiceType() {
//        return serviceType;
//    }
//
//    public void setServiceType(FacilityType serviceType) {
//        this.serviceType = serviceType;
//    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }
}
