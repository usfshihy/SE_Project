package com.example.demo.controller;


import com.example.demo.domain.Author;
import com.example.demo.service.AuthorService;

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
public class AuthorController {


    private final AuthorService authorService;
    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Author> authors = authorService.getAll(0, Integer.MAX_VALUE);
        model.addAttribute("authors", authors);
        return "list1";
    }

    @RequestMapping(value = "/authors/add1", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("action1", "insert1");
        return "edit1";
    }

    @RequestMapping(value = "/authors/edit1", method = RequestMethod.GET)
    public String edit(@RequestParam(value="id") String id,
                       Model model) throws Exception {
        Author founded = authorService.findById(new Long(id));
        model.addAttribute("action1", "save1");
        model.addAttribute("author", founded);
        return "edit1";
    }

    @RequestMapping(value = "/authors/insert1", method = RequestMethod.POST)
    public String insert(@RequestParam(value="firstname") String firstname,
                         @RequestParam(value="lastname") String lastname,
                         Model model, HttpServletResponse  response) throws Exception {
        Author added = authorService.add(firstname, lastname);
        model.addAttribute("author", added);
        model.addAttribute("action1", "insert1");
        response.setStatus(SC_CREATED );
        return "edited1";
    }

    @RequestMapping(value= "/authors/save1", method = RequestMethod.POST)
    public String save(@RequestParam("id") String id,
                       @RequestParam("firstname") String firstname,
                       @RequestParam("lastname") String lastname,
                       Model model, HttpServletResponse  response) throws Exception {
        Author author = authorService.findById(new Long(id));
        Author updated = authorService.update(author.getId(), firstname, lastname);
        model.addAttribute("author", updated);
        model.addAttribute("action1", "save1");
        response.setStatus(SC_ACCEPTED );
        return "edited1";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", ex.getMessage());
        modelAndView.setStatus(HttpStatus.BAD_REQUEST);
        return modelAndView;
    }

}