package com.example.demo.controller;


import com.example.demo.domain.Defect;
import com.example.demo.service.DefectService;
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
public class DefectController {


    private final DefectService defectservice;
    @Autowired
    public DefectController(DefectService defectservice) {
        this.defectservice = defectservice;
    }

    @RequestMapping(value = "/defects", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Defect> defects = defectservice.getAll(0, Integer.MAX_VALUE);
        model.addAttribute("defects", defects);
        return "list9";
    }

    @RequestMapping(value = "/defects/add9", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("action9", "insert9");
        return "edit9";
    }

    @RequestMapping(value = "/defects/edit9", method = RequestMethod.GET)
    public String edit(@RequestParam(value="id") String id,
                       Model model) throws Exception {
        Defect founded = defectservice.findById(new Long(id));
        model.addAttribute("action9", "save9");
        model.addAttribute("defect", founded);
        return "edit9";
    }

    @RequestMapping(value = "/defects/insert9", method = RequestMethod.POST)
    public String insert(@RequestParam(value="inspectorid") String inspectorid,
                         @RequestParam(value="inspectorname") String inspectorname,
                         @RequestParam(value="defectdesc") String defectdesc,
                         @RequestParam(value="projectid") String projectid,
                         @RequestParam(value="phaseid") String phaseid,
                         @RequestParam(value="jobid") String jobid,
                         @RequestParam(value="priority") String priority,
                         @RequestParam(value="issuedate") String issuedate,
                         @RequestParam(value="fixed") String fixed,
                         Model model, HttpServletResponse  response) throws Exception {
        Defect added = defectservice.add(inspectorid, inspectorname, defectdesc, projectid, phaseid, jobid, priority, issuedate, fixed);
        model.addAttribute("defect", added);
        model.addAttribute("action9", "insert9");
        response.setStatus(SC_CREATED );
        return "edited9";
    }

    @RequestMapping(value= "/defects/save9", method = RequestMethod.POST)
    public String save(@RequestParam("id") String id,
                       @RequestParam(value="inspectorid") String inspectorid,
                       @RequestParam(value="inspectorname") String inspectorname,
                       @RequestParam(value="defectdesc") String defectdesc,
                       @RequestParam(value="projectid") String projectid,
                       @RequestParam(value="phaseid") String phaseid,
                       @RequestParam(value="jobid") String jobid,
                       @RequestParam(value="priority") String priority,
                       @RequestParam(value="issuedate") String issuedate,
                       @RequestParam(value="fixed") String fixed,
                       Model model, HttpServletResponse  response) throws Exception {
        Defect defect = defectservice.findById(new Long(id));
        Defect updated = defectservice.update(defect.getId(), inspectorid, inspectorname, defectdesc, projectid, phaseid, jobid, priority, issuedate, fixed);
        model.addAttribute("defect", updated);
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