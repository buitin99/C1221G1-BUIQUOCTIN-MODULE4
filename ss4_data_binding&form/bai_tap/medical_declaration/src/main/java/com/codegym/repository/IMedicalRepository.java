package com.codegym.repository;

import com.codegym.model.Medical;

public interface IMedicalRepository {
    void update(Medical medical);

    Medical getMedical();
}
