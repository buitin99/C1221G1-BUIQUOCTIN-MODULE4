package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public Integer calculate(Integer number1, Integer number2, String calculation) {
        Integer result;
        switch (calculation){
            case "addition":
                result = number1 + number2;
                break;
            case "subtraction":
                result = number1 - number2;
                break;
            case "multiplication":
                result = number1*number2;
                break;
            default:
                result = number1 / number2;
                break;
        }
        return result;
    }
}
