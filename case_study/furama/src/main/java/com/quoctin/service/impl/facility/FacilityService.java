package com.quoctin.service.impl.facility;

import com.quoctin.model.service.Facility;
import com.quoctin.repository.facility.IFacilityRepository;
import com.quoctin.service.ifacility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> findAllPaging(Pageable pageable) {
        return iFacilityRepository.findAll(pageable);
    }

    @Override
    public Facility findById(int id) {
        return iFacilityRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Facility facility) {
        iFacilityRepository.save(facility);
    }
}
