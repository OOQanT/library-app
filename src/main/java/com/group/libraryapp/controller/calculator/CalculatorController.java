package com.group.libraryapp.controller.calculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import com.group.libraryapp.dto.calculator.request.CalculatorMultiplyRequest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorController {

    @GetMapping("/add")
    public int addTwoNumbers(@RequestParam int number1,@RequestParam(name = "number2") int number2){
        return number1 + number2;
    }

    @GetMapping("/addV2")
    public int addTwoNumbersV2(@ModelAttribute CalculatorAddRequest param){
       return param.getNumber1() + param.getNumber2();
    }

    @PostMapping("/multiply")
    public int multiplyTwoNumbers(@RequestBody CalculatorMultiplyRequest param){
        return param.getNumber1() * param.getNumber2();
    }
}
