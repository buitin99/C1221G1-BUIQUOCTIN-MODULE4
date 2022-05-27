package com.quoctin.dto;

import com.quoctin.model.contract.Contract;
import com.quoctin.model.customer.CustomerType;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

public class CustomerDto implements Validator {

    private Integer customerId;
    @Pattern(regexp = "^KH-\\d{4}$",message = "Bạn đã nhập sai định dạng mã khách hàng. VD: KH-1234")
    private String customerCode;
    @NotBlank(message = "Tên không được để trống!")
    private String customerName;
    @NotBlank(message = "Ngày sinh không được để trống!")
    private String customerBirth;
    private String customerGender;
    @NotBlank(message = "CMND không được để trống!")
    @Pattern(regexp = "\\d{9}$",message = "Bạn đã nhập sai định dạng. Số CMND phải là số có 9 chữ số")
    private String customerIdCard;
    @NotBlank(message = "Số điện thoại không được để trống!")
    @Pattern(regexp = "^(090|091|(84)+90|(84)+91)\\d{7}$",message = "Bạn đã nhập sai định dạng số điện thoại!")
    private String customerPhone;
    @NotBlank(message = "Địa chỉ Email không được để trống!")
    @Email(message = "Định đạng Email sai định dạng!")
    private String customerEmail;
    @NotBlank(message = "Địa chỉ không được để trống!")
    private String customerAddress;
    private CustomerType customerType;
    private List<Contract> contractList;

    public CustomerDto() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirth() {
        return customerBirth;
    }

    public void setCustomerBirth(String customerBirth) {
        this.customerBirth = customerBirth;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
    }
}
