package com.quoctin.dto;

import com.quoctin.model.contract.Contract;
import com.quoctin.model.service.FacilityType;
import com.quoctin.model.service.RentType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public class FacilityDto implements Validator {

    private Integer serviceId;
    @Pattern(regexp = "^DV-\\d{4}$",message = "Bạn đã nhập sai định dạng mã khách hàng. VD: DV-1234")
    private String facilityCode;
    @NotBlank(message = "Tên không được để trống!")
    private String serviceName;
    @Pattern(regexp = "/^\\d+$/",message = "Diện tích phải là số dương!")
    private String serviceArea;
    @Pattern(regexp = "/^\\d+$/",message = "Giá phải là số dương!")
    private String serviceCost;
    @Pattern(regexp = "/^\\d+$/",message = "Số người phải là số dương!")
    private String serviceMaxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    @Pattern(regexp = "/^\\d+$/",message = "Diện tích hồ bơi phải là số dương!")
    private String poolArea;
    @Pattern(regexp = "/^\\d+$/",message = "Số tầng phải là số dương!")
    private String numberOfFloor;
    private RentType rentType;
    private FacilityType facilityType;
    private List<Contract> contractList;

    public FacilityDto() {
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

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public String getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(String facilityCode) {
        this.facilityCode = facilityCode;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;
    }


}
