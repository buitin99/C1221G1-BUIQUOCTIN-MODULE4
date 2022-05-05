package com.codegym.repository;

import com.codegym.model.Email;

public interface IEmailRepository {

    void update(Email email);

    Email getEmail();
}
