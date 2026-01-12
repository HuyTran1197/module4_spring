package com.example.demo_sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class SandwichController {

    @GetMapping("/sandwich")
    public String save(@RequestParam(name = "condiment") String[] condiment,
                       Model model){

        model.addAttribute("condiment",condiment);

        return "sandwich";
    }

}
