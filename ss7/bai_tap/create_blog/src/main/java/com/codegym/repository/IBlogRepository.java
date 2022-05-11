package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

//extend interface
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from blog where name like :nameSearch ",nativeQuery = true)
    List<Blog> search(@Param("nameSearch") String name);

    Page<Blog> findAll(Pageable pageable);

//    @Query(value = "select * from blog where keyworkVal like :keySearch", nativeQuery = true)
//    Page<Blog> getBlogByName(@Param("keySearch") String keyworkVal, Pageable pageable);


    Page<Blog> findAllByNameContaining(String keyworkVal, Pageable pageable);


    @Query(value = "select * from blog where keyworkVal like :key ",nativeQuery = true)
    Page<Blog> getAllByName(@Param("key") String keyworkVal, Pageable pageable);
}
