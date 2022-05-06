package com.codegym.service;

import com.codegym.model.Medical;

public interface IMedicalService {
    void update(Medical medical);

    Medical getMedical();
}
