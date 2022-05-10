package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

//extend interface
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
}
