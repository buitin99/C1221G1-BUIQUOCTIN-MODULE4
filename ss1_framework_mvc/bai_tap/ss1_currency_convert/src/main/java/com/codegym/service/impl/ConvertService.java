package com.codegym.service.impl;
import com.codegym.service.IConvertService;
import org.springframework.stereotype.Service;

@Service
public class ConvertService implements IConvertService {
    @Override
    public Double convert(Double usd) {
        return usd*24000;
    }


}
