package com.example.demo.controller;

import com.example.demo.domain.Phase;
import com.example.demo.service.PhaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return "list9";
    }

    @RequestMapping(value = "/phases/add9", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("action9", "insert9");
        return "edit9";
    }

    @RequestMapping(value = "/phases/edit9", method = RequestMethod.GET)
    public String edit(@RequestParam(value="id") String id,
                       Model model) throws Exception {
        Phase founded = phaseService.findById(new Long(id));
        model.addAttribute("action9", "save9");
        model.addAttribute("phase", founded);
        return "edit9";
    }

    @RequestMapping(value = "/phases/insert9", method = RequestMethod.POST)
    public String insert(@RequestParam(value="phaseid") String phaseid,
                         @RequestParam(value="phaseName") String phaseName,
                         @RequestParam(value="phaseDesc") String phaseDesc,
                         @RequestParam(value="phaseLeaderid") String phaseLeaderid,
                         @RequestParam(value="teamSize") String teamSize,
                         @RequestParam(value="priority") String priority,
                         @RequestParam(value="dueDate") String dueDate,
                         @RequestParam(value = "processType") String processType,
                         @RequestParam(value = "projectid") String projectid,
                         @RequestParam(value="complete") String complete,
                         Model model, HttpServletResponse response) throws Exception {
        Phase added = phaseService.add(phaseid, phaseName, phaseDesc, phaseLeaderid, teamSize, priority, dueDate, processType, projectid, complete);
        model.addAttribute("phase", added);
        model.addAttribute("action9", "insert9");
        response.setStatus(SC_CREATED );
        return "edited9";
    }

    @RequestMapping(value= "/phases/save9", method = RequestMethod.POST)
    public String save(@RequestParam("id") String id,
                       @RequestParam(value="phaseid") String phaseid,
                       @RequestParam(value="phaseName") String phaseName,
                       @RequestParam(value="phaseDesc") String phaseDesc,
                       @RequestParam(value="phaseLeaderid") String phaseLeaderid,
                       @RequestParam(value="teamSize") String teamSize,
                       @RequestParam(value="priority") String priority,
                       @RequestParam(value="dueDate") String dueDate,
                       @RequestParam(value = "processType") String processType,
                       @RequestParam(value = "projectid") String projectid,
                       @RequestParam(value="complete") String complete,
                       Model model, HttpServletResponse  response) throws Exception {
        Phase phase = phaseService.findById(new Long(id));
        Phase updated = phaseService.update(phase.getId(), phaseid, phaseName, phaseDesc, phaseLeaderid, teamSize, priority, dueDate, processType, projectid, complete);
        model.addAttribute("phase", updated);
        model.addAttribute("action9", "save9");
        response.setStatus(SC_ACCEPTED );
        return "edited9";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", ex.getMessage());
        modelAndView.setStatus(HttpStatus.BAD_REQUEST);
        return modelAndView;
    }
}
