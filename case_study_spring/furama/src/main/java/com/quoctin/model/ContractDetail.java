package com.quoctin.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contract_detail")
public class ContractDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contract_detail_id;
    private Integer contract_id;
    private Integer attach_service_id;
    private Integer quantity;

}
