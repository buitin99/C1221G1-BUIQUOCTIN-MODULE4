package com.codegym.service.impl;

import com.codegym.repository.ISandwichRepository;
import com.codegym.service.ISandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SandwichService implements ISandwichService {

    @Autowired
    private ISandwichRepository iSandwichRepository;

    @Override
    public String[] save(String[] condiment) {
        return iSandwichRepository.save(condiment);
    }
}
