package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService {

    @Override
    public String calculate(Integer number1, Integer number2, String calculation) {
        switch (calculation) {
            case "addition":
                return Integer.toString(number1 + number2);
            case "subtraction":
                return Integer.toString(number1 - number2);
            case "multiplication":
                return Integer.toString(number1 * number2);
            default:
                if (number2 != 0) {
                    return Integer.toString(number1 / number2);
                } else {
                    return "can't divition by 0";
                }
        }
    }
}


