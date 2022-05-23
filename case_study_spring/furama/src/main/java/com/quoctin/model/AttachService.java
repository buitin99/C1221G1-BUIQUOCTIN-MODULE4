package com.quoctin.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "attach_service")
public class AttachService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attach_service_id;
    private String attach_service_name;
    private Double attach_service_cost;
    private Integer attach_service_unit;
    private String attach_service_status;

}
