package com.quoctin.service.impl.facility;

import com.quoctin.model.service.FacilityType;
import com.quoctin.repository.facility.IFacilityRepository;
import com.quoctin.repository.facility.IFacilityTypeRepository;
import com.quoctin.service.ifacility.IFacilityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFacilityTypeService {

    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;

    @Override
    public List<FacilityType> findAll() {
        return iFacilityTypeRepository.findAll();
    }
}
