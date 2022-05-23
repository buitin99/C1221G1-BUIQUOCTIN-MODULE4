package com.quoctin.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "contract")
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer contract_id;
    private Date contract_start_date;
    private Date contract_end_date;
    private Double contract_deposit;
    private Double contract_total_money;
    private Integer employees_id;
    private Integer customer_id;
    private Integer service_id;

}
