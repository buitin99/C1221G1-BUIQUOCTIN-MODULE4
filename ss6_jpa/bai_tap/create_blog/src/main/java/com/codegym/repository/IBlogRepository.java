package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

//extend interface
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from blog where name like :nameSearch ",nativeQuery = true)
    List<Blog> search(@Param("nameSearch") String name);
}
