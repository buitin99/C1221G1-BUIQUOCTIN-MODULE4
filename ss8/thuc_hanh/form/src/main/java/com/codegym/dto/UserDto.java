package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class UserDto implements Validator {

    private Integer id;
    @NotEmpty(message = "Name must not be null")
    @Size(min = 5, max = 45)
    private String firstName;
    @NotEmpty(message = "Name must not be null")
    @Size(min = 5, max = 45)
    private String lastName;
    @NotEmpty
    private String phone;
    private String age;
    @Email
    private String email;

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if ("admin".equals(userDto.getFirstName())) {
            errors.rejectValue("firstName", "firstName.forbidden", "errors");
        }
        if(!"".equals(userDto.getAge())) {
            LocalDate date = LocalDate.parse(userDto.getAge());
            if((LocalDate.now().minusYears(18)).isBefore(date)){
                errors.rejectValue("age","date.valid","errors");
            }
        }
       if(userDto.getPhone().length()>11 || userDto.getPhone().length()<10){
           errors.rejectValue("phone","phone.valid","errors");
       }
        if (!userDto.getPhone().startsWith("0")){
            errors.rejectValue("phone","phone.valid","errors");
        }
        if (!userDto.getPhone().matches("(^$|[0-9]*$)")){
            errors.rejectValue("phone","phone.valid","errors");
        }
    }
}
