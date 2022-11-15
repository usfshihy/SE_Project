package com.example.demo.controller;

import com.example.demo.domain.Phase;
import com.example.demo.service.PhaseService;
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
import java.util.List;

import static javax.servlet.http.HttpServletResponse.SC_ACCEPTED;
import static javax.servlet.http.HttpServletResponse.SC_CREATED;

@Controller
public class PhaseController {
    private final PhaseService phaseService;
    @Autowired
    public PhaseController(PhaseService phaseService) {
        this.phaseService = phaseService;
    }

    @RequestMapping(value = "/phases", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Phase> phases = phaseService.getAll(0, Integer.MAX_VALUE);
        model.addAttribute("phases", phases);
        return "list7";
    }

    @RequestMapping(value = "/phases/add7", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("action7", "insert7");
        return "edit7";
    }

    @RequestMapping(value = "/phases/edit7", method = RequestMethod.GET)
    public String edit(@RequestParam(value="id") String id,
                       Model model) throws Exception {
        Phase founded = phaseService.findById(new Long(id));
        model.addAttribute("action7", "save7");
        model.addAttribute("phase", founded);
        return "edit7";
    }

    @RequestMapping(value = "/phases/insert7", method = RequestMethod.POST)
    public String insert(
            @RequestParam(value="phasename") String phasename,
            @RequestParam(value="phasedesc") String phasedesc,
            @RequestParam(value="phaseleaderid") String phaseleaderid,
            @RequestParam(value="teamsize") String teamsize,
            @RequestParam(value="priority") String priority,
            @RequestParam(value="duedate") String duedate,
            @RequestParam(value = "processtype") String processtype,
            @RequestParam(value = "projectid") String projectid,
            @RequestParam(value="complete") String complete,
            Model model, HttpServletResponse response) throws Exception {
        Phase added = phaseService.add(phasename, phasedesc, phaseleaderid, teamsize, priority, duedate, processtype, projectid, complete);
        model.addAttribute("phase", added);
        model.addAttribute("action7", "insert7");
        response.setStatus(SC_CREATED );
        return "edited7";
    }

    @RequestMapping(value= "/phases/save7", method = RequestMethod.POST)
    public String save(@RequestParam("id") String id,
                       @RequestParam(value="phasename") String phasename,
                       @RequestParam(value="phasedesc") String phasedesc,
                       @RequestParam(value="phaseleaderid") String phaseleaderid,
                       @RequestParam(value="teamsize") String teamsize,
                       @RequestParam(value="priority") String priority,
                       @RequestParam(value="duedate") String duedate,
                       @RequestParam(value = "processtype") String processtype,
                       @RequestParam(value = "projectid") String projectid,
                       @RequestParam(value="complete") String complete,
                       Model model, HttpServletResponse  response) throws Exception {
        Phase phase = phaseService.findById(new Long(id));
        Phase updated = phaseService.update(phase.getId(), phasename, phasedesc, phaseleaderid, teamsize, priority, duedate, processtype, projectid, complete);
        model.addAttribute("phase", updated);
        model.addAttribute("action7", "save7");
        response.setStatus(SC_ACCEPTED );
        return "edited7";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", ex.getMessage());
        modelAndView.setStatus(HttpStatus.BAD_REQUEST);
        return modelAndView;
    }
}