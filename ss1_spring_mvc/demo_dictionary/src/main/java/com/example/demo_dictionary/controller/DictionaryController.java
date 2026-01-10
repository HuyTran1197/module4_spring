package com.example.demo_dictionary.controller;

import com.example.demo_dictionary.model.Dictionary;
import com.example.demo_dictionary.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller

public class DictionaryController {

    @Autowired
    private IDictionaryService dictionaryService;

    @GetMapping("/form")
    public String search(@RequestParam(name = "find",required = false) String find,
                         Model model){
        if (find!=null){
            boolean isSuccess = false;
            for (Dictionary dic : dictionaryService.getList()){
                if (find.equals(dic.getViet())){
                    model.addAttribute("eng",dic.getEng());
                    isSuccess = true;
                    break;
                }
            }
            if (!isSuccess){
                model.addAttribute("eng","không tìm thấy!");
            }
        }

        return "form";
    }


}
