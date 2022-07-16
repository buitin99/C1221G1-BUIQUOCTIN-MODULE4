package com.codegym.service.impl;

import com.codegym.model.Category;
import com.codegym.repository.ICategoryRepository;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository ICategoryRepository;

    @Override
    public Page<Category> findAllPaging(Pageable pageable) {
        return ICategoryRepository.findAll(pageable);
    }

    @Override
    public Category findById(Integer id) {
        return ICategoryRepository.findById(id).orElse(null);
    }
}
