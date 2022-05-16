package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.model.Rent;
import com.codegym.repository.ILibraryRepository;
import com.codegym.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService implements ILibraryService {

    @Autowired
    private ILibraryRepository iLibraryRepository;


    @Override
    public List<Book> getList() {
        return iLibraryRepository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return iLibraryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Book books) {
        if(books.getQuantity() > 0){
            books.setQuantity(books.getQuantity()-1);
        }
        iLibraryRepository.save(books);
    }

    @Override
    public void returnBook(Book book) {
        if(book.getId() != null){
            book.setQuantity(book.getQuantity()+1);
        }
        this.iLibraryRepository.save(book);
    }


}
