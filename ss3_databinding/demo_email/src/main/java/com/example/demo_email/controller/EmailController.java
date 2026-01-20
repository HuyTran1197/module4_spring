package com.example.demo_email.controller;

import com.example.demo_email.model.Email;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/email")
public class EmailController {

    @GetMapping("")
    public String show(Model model){
        model.addAttribute("email",new Email());
        return "email/update";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Email email,
                         Model model){
        model.addAttribute("languages",email.getLanguages());
        model.addAttribute("pageSize",email.getPageSize());
        model.addAttribute("spamsFillter",email.getSpamsFillter());
        model.addAttribute("signature",email.getSignature());
        return "email/show";
    }

}
