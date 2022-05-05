package com.codegym.service.impl;

import com.codegym.model.Email;
import com.codegym.repository.IEmailRepository;
import com.codegym.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements IEmailService {

    @Autowired
    private IEmailRepository iEmailRepository;

    @Override
    public void update(Email email) {
        this.iEmailRepository.update(email);
    }
}
