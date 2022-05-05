package com.codegym.repository.impl;

import com.codegym.model.Email;
import com.codegym.repository.IEmailRepository;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepositoryImpl implements IEmailRepository {
    static Email email = new Email();

    @Override
    public void update(Email email) {
        this.email = email;
    }

    @Override
    public Email getEmail() {
        return this.email;
    }


}
