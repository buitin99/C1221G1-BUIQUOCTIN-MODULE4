package com.codegym.repository.impl;

import com.codegym.repository.ISandwichRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SandwichRepository implements ISandwichRepository {
    @Override
    public String[] save(String[] condiment) {
        return condiment;
    }
}
