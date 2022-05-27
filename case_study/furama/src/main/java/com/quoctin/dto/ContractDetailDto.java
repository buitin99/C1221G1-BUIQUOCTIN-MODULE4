package com.quoctin.dto;

import com.quoctin.model.contract.AttachService;
import com.quoctin.model.contract.Contract;
import com.quoctin.model.contract.ContractDetail;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.Positive;


public class ContractDetailDto implements Validator {

    private Integer contractDetailId;
    @Positive(message = "Số lượng phải là số dương!")
    private String quantity;
    private Contract contract;
    private AttachService attachService;

    public ContractDetailDto() {
    }

    public Integer getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Integer contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDetailDto contractDetailDto = (ContractDetailDto) target;
     }
}
