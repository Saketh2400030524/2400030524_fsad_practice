package com.klu.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CalsiService {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtraction(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double division(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division not possible");
        }
        return (double) a / b;
    }

    public int modulo(int a, int b) {
        return a % b;
    }
}
