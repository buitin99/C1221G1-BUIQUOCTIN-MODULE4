package com.codegym.service;

import com.codegym.model.Rent;

import java.util.Optional;

public interface IRentService {
    void save(Rent rent);

//    Rent findById(Long idRent);

    Rent findById(Integer idRent);

    void delete(Rent rent);

    Rent findByCode(Long idRent);

    void remove(Rent rent);
}
