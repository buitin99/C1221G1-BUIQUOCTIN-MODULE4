package com.quoctin.service.impl.employee;

import com.quoctin.model.employee.Division;
import com.quoctin.repository.employee.IDivisionRepository;
import com.quoctin.service.iemployee.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionService implements IDivisionService {

    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> findAll() {
        return iDivisionRepository.findAll();
    }
}
