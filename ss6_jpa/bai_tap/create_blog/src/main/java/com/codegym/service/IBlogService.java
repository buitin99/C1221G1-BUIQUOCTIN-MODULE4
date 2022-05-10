package com.codegym.service;

import com.codegym.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void create(Blog blog);

    Blog findById(Integer id);

    void update(Blog blog);

    void delete(Blog blog);
}
