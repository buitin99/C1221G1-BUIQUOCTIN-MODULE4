package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    Page<Blog> findAllPaging(Pageable pageable);

    Blog findById(Integer id);

    Page<Blog> findByName(Pageable pageable, String name);


//    Page<Blog> findCategory(Pageable pageable);
}
