package com.example.demo_money_change.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/calculate")
public class CalculatorController{

    @GetMapping("")
    public String calculator(@RequestParam(name = "rate",required = false) Integer rate,
                             @RequestParam(name = "usd",required = false) Integer usd,
                             Model model){
        if (rate!=null && usd!=null){
            model.addAttribute("rate",rate);
            model.addAttribute("usd",usd);
            model.addAttribute("vnd",change(rate, usd));
        }
        return "calculate";
    }


    public int change(int rate,int usd){
        return rate * usd;
    }
}
