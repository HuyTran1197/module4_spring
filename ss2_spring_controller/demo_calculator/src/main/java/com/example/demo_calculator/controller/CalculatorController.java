package com.example.demo_calculator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class CalculatorController {


    @GetMapping("/calculator")
    public String show(@RequestParam(name = "num1") double num1,
                       @RequestParam(name = "num2") double num2,
                       @RequestParam(name = "action") String action,
                       Model model) {

        model.addAttribute("num1", num1);
        model.addAttribute("num2", num2);
        if (action == null) action = "";

        switch (action) {
            case "sum":
                model.addAttribute("result", sum(num1, num2));
                break;
            case "sub":
                model.addAttribute("result", sub(num1, num2));
                break;
            case "multip":
                model.addAttribute("result", multip(num1, num2));
                break;
            case "division":
                if (num2 == 0) {
                    model.addAttribute("result", "!!!");
                    model.addAttribute("mess", "mẫu số phải khác 0");
                } else {
                    model.addAttribute("result", division(num1, num2));
                }
                break;
            default:
        }

        return "calculator";
    }

    private double sum(double num1, double num2) {
        return num1 + num2;
    }

    private double sub(double num1, double num2) {
        return num1 - num2;
    }

    private double multip(double num1, double num2) {
        return num1 * num2;
    }

    private double division(double num1, double num2) {
        return num1 / num2;
    }

}
