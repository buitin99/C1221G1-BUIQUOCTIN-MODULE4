package com.quoctin.repository.employee;

import com.quoctin.model.employee.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationRepository extends JpaRepository<Education,Integer> {
}
