package com.codegym.service.impl;

import com.codegym.model.Medical;
import com.codegym.repository.IMedicalRepository;
import com.codegym.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalServiceImpl implements IMedicalService {

    @Autowired
    private IMedicalRepository iMedicalRepository;

    @Override
    public void update(Medical medical) {
        this.iMedicalRepository.update(medical);
    }

    @Override
    public Medical getMedical() {
        return this.iMedicalRepository.getMedical();
    }
}
