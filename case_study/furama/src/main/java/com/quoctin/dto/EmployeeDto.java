package com.quoctin.dto;

import com.quoctin.model.employee.Division;
import com.quoctin.model.employee.Education;
import com.quoctin.model.employee.Position;
import com.quoctin.model.user.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class EmployeeDto implements Validator {

    private Integer employeeId;
    @NotBlank(message = "Tên không được để trống!")
    private String employeeName;
    @NotBlank(message = "Ngày sinh không được để trống!")
    private String employeeBirth;
    @NotBlank(message = "CMND không được để trống!")
    @Pattern(regexp = "\\d{9}$",message = "Bạn đã nhập sai định dạng. Số CMND phải là số có 9 chữ số")
    private String employeeIdCard;
    @Pattern(regexp = "/^\\d+$/",message = "Lương phải là số dương!")
    private String employeeSalary;
    @NotBlank(message = "Số điện thoại không được để trống!")
    @Pattern(regexp = "^(090|091|(84)+90|(84)+91)\\d{7}$",message = "Bạn đã nhập sai định dạng số điện thoại!")
    private String employeePhone;
    @NotBlank(message = "Địa chỉ Email không được để trống!")
    @Email(message = "Định đạng Email sai định dạng!")
    private String employeeEmail;
    @NotBlank(message = "Địa chỉ không được để trống!")
    private String employeeAddress;
    private Position position;
    private Education education;
    private Division division;
    private User user;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
    }

    public EmployeeDto() {
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirth() {
        return employeeBirth;
    }

    public void setEmployeeBirth(String employeeBirth) {
        this.employeeBirth = employeeBirth;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
