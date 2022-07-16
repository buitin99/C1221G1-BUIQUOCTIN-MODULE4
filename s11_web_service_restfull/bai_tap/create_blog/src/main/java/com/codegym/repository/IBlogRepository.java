package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


//extend interface
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Page<Blog> findAll(Pageable pageable);

}
