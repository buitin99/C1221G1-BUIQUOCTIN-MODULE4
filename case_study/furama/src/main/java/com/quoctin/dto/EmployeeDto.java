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

public class EmployeeDto implements Validator {

    private Integer employeeId;
    private String employeeName;
    private String employeeBirth;
    private String employeeIdCard;
    private String employeeSalary;
    private String employeePhone;
    private String employeeEmail;
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

    }
}
