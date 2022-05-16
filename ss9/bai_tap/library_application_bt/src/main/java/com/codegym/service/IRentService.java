package com.codegym.service;

import com.codegym.model.Rent;

import java.util.Optional;

public interface IRentService {
    void save(Rent rent);

    Optional<Rent> findById(Integer id);

    void delete(Rent rent);
}
