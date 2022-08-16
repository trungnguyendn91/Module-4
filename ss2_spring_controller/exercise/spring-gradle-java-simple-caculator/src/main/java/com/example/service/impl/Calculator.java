package com.example.service.impl;

import com.example.service.ICalculator;
import org.springframework.stereotype.Service;

@Service
public class Calculator implements ICalculator {

    @Override
    public double operator(double number1, double number2, String operator) {
        double result = 0;
        switch (operator) {
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 - number2;
                break;
            case "*":
                result = number1 * number2;
                break;
            case "/":
                try {result = number1 / number2;
                }catch (ArithmeticException e){
                    e.printStackTrace();
                }
                break;
        }
        return result;
    }
}
