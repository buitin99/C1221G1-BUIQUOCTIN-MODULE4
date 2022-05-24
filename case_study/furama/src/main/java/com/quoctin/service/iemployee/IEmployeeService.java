package com.quoctin.service.iemployee;

import com.quoctin.model.employee.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employees> findAllPaging(Pageable pageable);

    void save(Employees employees);

    Employees findById(int id);
}
