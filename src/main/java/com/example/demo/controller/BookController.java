package com.example.demo.controller;

import com.example.demo.domain.Book;
import com.example.demo.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static javax.servlet.http.HttpServletResponse.SC_ACCEPTED;
import static javax.servlet.http.HttpServletResponse.SC_CREATED;

@Controller
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Book> books = bookService.getAll(0, Integer.MAX_VALUE);
        model.addAttribute("books", books);
        return "list2";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("action", "insert");
        return "edit2";
    }

    @RequestMapping(value = "/books/edit", method = RequestMethod.GET)
    public String edit(@RequestParam(value="id") String id,
                       Model model) throws Exception {
        Book founded = bookService.findById(new Long(id));
        model.addAttribute("action", "save");
        model.addAttribute("book", founded);
        return "edit2";
    }

    @RequestMapping(value = "/books/insert", method = RequestMethod.POST)
    public String insert(@RequestParam(value="title") String title,
                         @RequestParam(value="code") String code,
                         Model model, HttpServletResponse  response) throws Exception {
        Book added = bookService.add(title,code);
        model.addAttribute("book", added);
        model.addAttribute("action", "insert");
        response.setStatus(SC_CREATED );
        return "edited2";
    }

    @RequestMapping(value= "/books/save", method = RequestMethod.POST)
    public String save(@RequestParam("id") String id,
                       @RequestParam("title") String title,
                       @RequestParam("code") String code,
                       Model model, HttpServletResponse  response) throws Exception {
        Book book = bookService.findById(new Long(id));
        Book updated = bookService.update(book.getId(),title,code);
        model.addAttribute("book", updated);
        model.addAttribute("action", "save");
        response.setStatus(SC_ACCEPTED );
        return "edited2";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", ex.getMessage());
        modelAndView.setStatus(HttpStatus.BAD_REQUEST);
        return modelAndView;
    }
}
