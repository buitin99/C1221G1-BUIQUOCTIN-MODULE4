package com.codegym.repository;

import com.codegym.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IRentRepository extends JpaRepository<Rent,Integer> {

}
