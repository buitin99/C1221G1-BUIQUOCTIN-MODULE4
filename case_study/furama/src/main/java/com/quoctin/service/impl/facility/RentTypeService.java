package com.quoctin.service.impl.facility;

import com.quoctin.model.service.RentType;
import com.quoctin.repository.facility.IRentTypeRepository;
import com.quoctin.service.ifacility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService{

    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return iRentTypeRepository.findAll();
    }
}
