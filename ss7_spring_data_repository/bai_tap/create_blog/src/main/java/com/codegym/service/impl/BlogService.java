package com.codegym.service.impl;

import com.codegym.model.Blog;
import com.codegym.repository.IBlogRepository;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;



    @Override
    public void create(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public void delete(Blog blog) {
        iBlogRepository.delete(blog);
    }



    @Override
    public Page<Blog> getList(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> getBlogByName(String keyworkVal, Pageable pageable) {
        return iBlogRepository.findAllByNameContaining(keyworkVal,pageable);
//        return iBlogRepository.getAllByName("%" + keyworkVal + "%",pageable);
    }

    @Override
    public Page<Blog> search(String name, Pageable pageable) {
        return iBlogRepository.findAllByNameContaining(name,pageable);
    }


}
