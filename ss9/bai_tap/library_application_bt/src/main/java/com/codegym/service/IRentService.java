package com.codegym.service;

import com.codegym.model.Rent;

import java.util.Optional;

public interface IRentService {
    void save(Rent rent);

    Rent findById(Long idRent);

    void delete(Rent rent);
}
