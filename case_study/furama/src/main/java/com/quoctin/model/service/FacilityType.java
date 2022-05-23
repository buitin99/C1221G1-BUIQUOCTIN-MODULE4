package com.quoctin.model.service;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service_type")
public class FacilityType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceTypeId;
    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType")
    private List<Facility> serviceList;

    public FacilityType() {
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public List<Facility> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Facility> serviceList) {
        this.serviceList = serviceList;
    }
}
