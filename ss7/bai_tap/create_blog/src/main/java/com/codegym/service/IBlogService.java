package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {

    void create(Blog blog);

    Blog findById(Integer id);

    void update(Blog blog);

    void delete(Blog blog);
    

    Page<Blog> getList(Pageable pageable);

    Page<Blog> getBlogByName(String keyworkVal, Pageable pageable);

    Page<Blog> search(String name, Pageable pageable);
}
