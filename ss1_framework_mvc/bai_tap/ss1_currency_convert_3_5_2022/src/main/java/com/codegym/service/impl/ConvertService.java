package com.codegym.service.impl;
import com.codegym.repository.IConvertRepository;
import com.codegym.service.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {

    @Autowired
    private IConvertRepository iConvertRepository;

    @Override
    public Double convert(Double usd) {
        return iConvertRepository.convert(usd);
    }
}
