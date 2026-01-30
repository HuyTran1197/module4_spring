package com.example.demo_form_validate.controller;


import com.example.demo_form_validate.entity.User;
import com.example.demo_form_validate.service.IUserService;
import com.example.demo_form_validate.util.Validate;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class FormController {

    private IUserService userService;

    public FormController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showForm(Model model){
        model.addAttribute("user",new User());
        return "user/form";
    }


    @PostMapping("/result")
    public String result(@Valid @ModelAttribute User user,
                         BindingResult bindingResult){
        new Validate().validate(user,bindingResult);

        if (bindingResult.hasFieldErrors()){
            return "user/form";
        }

        return "user/result";
    }
}
