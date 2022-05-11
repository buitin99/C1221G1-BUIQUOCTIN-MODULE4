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

    List<Blog> search(String nameSearch);

    Page<Blog> getList(Pageable pageable);

    Page<Blog> getBlogByName(String keyworkVal, Pageable pageable);
}
