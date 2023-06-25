package com.example.libapp.controller.calculator;

import com.example.libapp.DTO.request.CalculationAddRequest;
import com.example.libapp.DTO.request.CalculationMultiplyRequest;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
public class CalculatorController {



    @GetMapping("/add")
    public int addTwoNumbers(CalculationAddRequest request) {
        return request.getNumber1() + request.getNumber2();
    }

    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody CalculationMultiplyRequest request){
        return request.getNumber1() * request.getNumber2();
    }
}
