package com.quoctin.service.ifacility;

import com.quoctin.model.service.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IFacilityService {
    Page<Facility> findAllPaging(Pageable pageable);

    Facility findById(int id);

    void save(Facility facility);

    List<Facility> findAll();
}
