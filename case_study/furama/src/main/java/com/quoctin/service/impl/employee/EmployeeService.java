package com.quoctin.service.impl.employee;

import com.quoctin.model.employee.Employees;
import com.quoctin.repository.employee.IEmployeeRepository;
import com.quoctin.service.iemployee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employees> findAllPaging(Pageable pageable) {
        return iEmployeeRepository.findAll(pageable);
    }

    @Override
    public void save(Employees employees) {
        iEmployeeRepository.save(employees);
    }

    @Override
    public Employees findById(int id) {
        return iEmployeeRepository.findById(id).orElse(null);
    }
}
