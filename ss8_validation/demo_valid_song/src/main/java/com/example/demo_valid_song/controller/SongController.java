package com.example.demo_valid_song.controller;

import com.example.demo_valid_song.entity.Song;
import com.example.demo_valid_song.service.ISongService;
import com.example.demo_valid_song.util.Validate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {
    private ISongService songService;

    public SongController(ISongService songService) {
        this.songService = songService;
    }

    @GetMapping("")
    public String show(Model model){
        model.addAttribute("songList",songService.findAll());
        return "song/home";
    }

    @GetMapping("/add")
    public String showAdd(Model model){
        model.addAttribute("song",new Song());
        return "song/add";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute Song song,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes){
        new Validate().validate(song,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "song/add";
        }
        boolean isSuccess = songService.save(song);
        redirectAttributes.addFlashAttribute("mess",isSuccess?"tạo bài hát thành công":"tạo bài hát không thành công");

        return "redirect:/song";
    }

    @GetMapping("{id}/edit")
    public String showEdit(@PathVariable int id,
                           Model model){
        model.addAttribute("song",songService.findById(id));
        return "song/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Song song,
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes){
        new Validate().validate(song,bindingResult);
        if (bindingResult.hasFieldErrors()){
            return "song/edit";
        }
        boolean isSuccess = songService.save(song);
        redirectAttributes.addFlashAttribute("mess",isSuccess?"cập nhật bài hát thành công":"cập nhật bài hát không thành công");

        return "redirect:/song";
    }


}
