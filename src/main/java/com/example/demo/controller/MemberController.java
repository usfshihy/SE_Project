package com.example.demo.controller;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

import static javax.servlet.http.HttpServletResponse.SC_ACCEPTED;
import static javax.servlet.http.HttpServletResponse.SC_CREATED;

@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping(value = "/members", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Member> members = memberService.getAll(0, Integer.MAX_VALUE);
        model.addAttribute("members", members);
        return "list1";
    }

    @RequestMapping(value = "/members/add1", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("action1", "insert1");
        return "edit1";
    }

    @RequestMapping(value = "/members/edit1", method = RequestMethod.GET)
    public String edit(@RequestParam(value="id") String id,
                       Model model) throws Exception {
        Member founded = memberService.findById(new Long(id));
        model.addAttribute("action1", "save1");
        model.addAttribute("member", founded);
        return "edit1";
    }

    @RequestMapping(value = "/members/insert1", method = RequestMethod.POST)
    public String insert(@RequestParam(value="firstname") String firstname,
                         @RequestParam(value="lastname") String lastname,
                         @RequestParam(value="company")String company,
                         @RequestParam(value="branch")String branch,
                         @RequestParam(value="address")String address,
                         @RequestParam(value="companyPosition")String companyPosition,
                         @RequestParam(value="dateOfBirth") Date dateOfBirth,
                         @RequestParam(value="dateOfJoiningCompany")Date dateOfJoiningCompany,
                         Model model, HttpServletResponse response) throws Exception {
        Member added = memberService.add(firstname,  lastname,  company,
                branch, address,  companyPosition,
                dateOfBirth,  dateOfJoiningCompany);
        model.addAttribute("member", added);
        model.addAttribute("action1", "insert1");
        response.setStatus(SC_CREATED );
        return "edited1";
    }

    @RequestMapping(value= "/members/save1", method = RequestMethod.POST)
    public String save(@RequestParam("id") String id,
                       @RequestParam("firstname") String firstname,
                       @RequestParam("lastname") String lastname,
                       @RequestParam(value="company")String company,
                       @RequestParam(value="branch")String branch,
                       @RequestParam(value="address")String address,
                       @RequestParam(value="companyPosition")String companyPosition,
                       @RequestParam(value="dateOfBirth") Date dateOfBirth,
                       @RequestParam(value="dateOfJoiningCompany")Date dateOfJoiningCompany,
                       Model model, HttpServletResponse  response) throws Exception {
        Member member = memberService.findById(new Long(id));
        Member updated = memberService.update(member.getId(), firstname, lastname,  company,
                branch, address,  companyPosition,
                dateOfBirth,  dateOfJoiningCompany);
        model.addAttribute("member", updated);
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
