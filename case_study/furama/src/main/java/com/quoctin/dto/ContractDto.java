package com.quoctin.dto;

import com.quoctin.model.contract.ContractDetail;
import com.quoctin.model.customer.Customer;
import com.quoctin.model.employee.Employees;
import com.quoctin.model.service.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
//import org.thymeleaf.util.Validate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.quoctin.common.Validate;

public class ContractDto implements Validator {

    private Integer contractId;
    @NotBlank(message = "Không được để trống!")
    private String contractStartDate;
    @NotBlank(message = "Không được để trống!")
    private String contractEndDate;
    @NotBlank(message = "Không được để trống!")
    @Positive(message = "Số tiền phải là số dương!")
    private String contractDeposit;
    @Positive(message = "Số tiền phải là số dương!")
    @NotBlank(message = "Không được để trống!")
    private String contractTotalMoney;
    private Employees employees;
    private Customer customer;
    private Facility facility;
    private List<ContractDetail> contractDetailList;

    public static final String DATE_TIME_REGEX = "^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$";

    public ContractDto() {
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(String contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public String getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(String contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employees getEmployees() {
        return employees;
    }

    public void setEmployees(Employees employees) {
        this.employees = employees;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public List<ContractDetail> getContractDetailList() {
        return contractDetailList;
    }

    public void setContractDetailList(List<ContractDetail> contractDetailList) {
        this.contractDetailList = contractDetailList;
    }



    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDto contractDto = (ContractDto) target;

        if ("".matches(contractDto.contractStartDate)) {
            errors.rejectValue("contractStartDate", "blank.error", "System Error");
        } else if (!contractDto.contractStartDate.matches(Validate.DATE_TIME_REGEX)) {
            errors.rejectValue("contractStartDate", "birthday.error", "System Error");
        } else {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            Date current = new Date();
            try {
                date = fmt.parse(contractDto.contractStartDate);
//                 KIEM TRA NGAY CO TRONG QUA KHU KHONG
                if (date != null && date.compareTo(new Date()) < 0) {
                    errors.rejectValue("contractStartDate", "", "Start date don't in the past");
                }
            } catch (ParseException e) {
                e.printStackTrace();
                errors.rejectValue("contractStartDate", "birthday.error", "System Error");
            }
        }


        if ("".matches(contractDto.contractEndDate)) {
            errors.rejectValue("contractEndDate", "blank.error", "System Error");
        } else if (!contractDto.contractEndDate.matches(Validate.DATE_TIME_REGEX)) {
            errors.rejectValue("contractEndDate", "birthday.error", "System Error");
        } else {
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = null;
            Date endDate = null;
            Date current = new Date();
            try {
                endDate = fmt.parse(contractDto.contractEndDate);
                startDate = fmt.parse(contractDto.contractStartDate);
//                 KIEM TRA NGAY CO TRONG QUA KHU KHONG
                if (endDate != null && endDate.compareTo(startDate) < 0) {
                    errors.rejectValue("contractEndDate", "", "End date must be after Start date");
                }
            } catch (ParseException e) {
                e.printStackTrace();
                errors.rejectValue("contractEndDate", "birthday.error", "System Error");

            }
        }
    }
}
