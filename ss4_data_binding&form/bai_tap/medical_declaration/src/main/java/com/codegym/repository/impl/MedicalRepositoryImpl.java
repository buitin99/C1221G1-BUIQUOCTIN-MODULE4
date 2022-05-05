package com.codegym.repository.impl;

import com.codegym.model.Medical;
import com.codegym.repository.IMedicalRepository;
import org.springframework.stereotype.Repository;

@Repository
public class MedicalRepositoryImpl implements IMedicalRepository {
    static Medical medical = new Medical();
    @Override
    public void update(Medical medical) {
        this.medical = medical;
    }

    @Override
    public Medical getMedical() {
        return this.medical;
    }
}
