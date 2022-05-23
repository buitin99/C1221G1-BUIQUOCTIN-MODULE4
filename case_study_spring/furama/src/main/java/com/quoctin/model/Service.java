package com.quoctin.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer service_id;
    private String service_name;
    private Integer service_area;
    private Double service_cost;
    private Integer service_max_people;
    private Integer rent_type_id;
    private Integer service_type_id;
    private String standard_room;
    private String description_other_convenience;
    private Double pool_area;
    private Integer number_of_floor;

}
