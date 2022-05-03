package com.codegym.repository.impl;
import com.codegym.repository.IConvertRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ConvertRepository implements IConvertRepository {
    @Override
    public Double convert(Double usd) {
        return usd*24000;
    }
}
