package com.klu.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klu.demo.service.CalsiService;

@RestController
@RequestMapping("/calculator")
public class CalsiController {

    @Autowired
    private CalsiService service;

    @RequestMapping("/add")
    public int add(@RequestParam int a, @RequestParam int b) {
        return service.add(a, b);
    }

    @RequestMapping("/subtraction/{a}/{b}")
    public int subtract(@PathVariable int a, @PathVariable int b) {
        return service.subtraction(a, b);
    }

    @RequestMapping("/multiply/{a}/{b}")
    public int multiply(@PathVariable int a, @PathVariable int b) {
        return service.multiply(a, b);
    }

    @RequestMapping("/division")
    public double division(@RequestParam int a, @RequestParam int b) {
        return service.division(a, b); // fixed spelling
    }

    @RequestMapping("/modulo")
    public int modulo(@RequestParam int a, @RequestParam int b) {
    	return service.modulo(a, b);
    }
}
