package com.quoctin.model;

import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer contractId;
    private Integer attachServceId;
    private Integer quantity;

    public ContractDetail() {
    }

    public ContractDetail(Integer contractId, Integer attachServceId, Integer quantity) {
        this.contractId = contractId;
        this.attachServceId = attachServceId;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public Integer getAttachServceId() {
        return attachServceId;
    }

    public void setAttachServceId(Integer attachServceId) {
        this.attachServceId = attachServceId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
