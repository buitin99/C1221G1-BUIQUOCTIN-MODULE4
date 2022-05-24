package com.quoctin.service.impl.employee;

import com.quoctin.model.employee.Education;
import com.quoctin.repository.employee.IEducationRepository;
import com.quoctin.service.iemployee.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService implements IEducationService {

    @Autowired
    private IEducationRepository ieducationRepository;


    @Override
    public List<Education> findAll() {
        return ieducationRepository.findAll();
    }
}
