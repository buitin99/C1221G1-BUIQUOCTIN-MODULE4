package com.codegym.service.impl;

import com.codegym.repository.ILibraryRepository;
import com.codegym.service.ILibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryService implements ILibraryService {

    @Autowired
    private ILibraryRepository iLibraryRepository;


}
