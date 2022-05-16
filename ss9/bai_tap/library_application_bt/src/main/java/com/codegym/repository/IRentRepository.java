package com.codegym.repository;

import com.codegym.model.Rent;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRentRepository extends JpaRepository<Rent,Integer> {

    Rent findFirstByIdRent(Long idRent);
}
