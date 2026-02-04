package com.example.demo_borrow_books.controller;

import com.example.demo_borrow_books.entity.Book;
import com.example.demo_borrow_books.service.IBookService;
import com.example.demo_borrow_books.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private IBorrowService borrowService;

    @GetMapping("")
    public String showList(Model model,
                            @RequestParam(name = "page",defaultValue = "0")int page,
                            @RequestParam(name = "searchName",defaultValue = "")String searchName){
        Sort sort = Sort.by("name").descending();
        Pageable pageable = PageRequest.of(page,3,sort);

        Page<Book> bookPage = bookService.findByNameContaining(searchName,pageable);
        model.addAttribute("bookPage",bookPage);
        model.addAttribute("searchName",searchName);
        return "book/list";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model){
        model.addAttribute("book",new Book());
        return "book/add";
    }
    @PostMapping("/add")
    public String save(@ModelAttribute Book book,

                       RedirectAttributes redirectAttributes){
        boolean isSuccess = bookService.save(book);
        redirectAttributes.addFlashAttribute("mess",isSuccess?"tạo mới thành công":"tạo mới không thành công");
        return "redirect:/book";
    }

    @GetMapping("{id}/detail")
    public String detail(@PathVariable(name = "id")int id,
                         Model model){
        model.addAttribute("book",bookService.findById(id));
        return "book/detail";
    }
    @PostMapping("{id}/delete")
    public String deleteById(@PathVariable(name = "id")int id,
                             RedirectAttributes redirectAttributes){
        boolean isSuccess = bookService.deleteById(id);
        redirectAttributes.addFlashAttribute("mess",isSuccess?"xóa thành công":"xóa không thành công");
        return "redirect:/book";
    }

    @GetMapping("{id}/borrow")
    public String borrowBook(@PathVariable(name = "id")int id,
                             Model model){

        String transferId = borrowService.borrowBook(id);
        model.addAttribute("transferId",transferId);
        return "book/borrow";
    }

    @GetMapping("/return")
    public String showFormReturn(){
        return "book/return";
    }
    @PostMapping("/return")
    public String returned(@RequestParam(name = "transferId")String transferId,
                           RedirectAttributes redirectAttributes){
        borrowService.returned(transferId);
        redirectAttributes.addFlashAttribute("mess","Trả sách thành công");
        return "redirect:/book";
    }
}
