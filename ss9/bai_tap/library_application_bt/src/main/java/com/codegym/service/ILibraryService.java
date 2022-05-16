package com.codegym.service;

import com.codegym.model.Book;
import com.codegym.model.Rent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ILibraryService {
    List<Book> getList();
    
    Book findById(Integer id);

    void save(Book books);

    void give(Book book);
}
