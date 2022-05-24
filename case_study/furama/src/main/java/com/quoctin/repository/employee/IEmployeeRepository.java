package com.quoctin.repository.employee;

import com.quoctin.model.employee.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employees,Integer> {
}
