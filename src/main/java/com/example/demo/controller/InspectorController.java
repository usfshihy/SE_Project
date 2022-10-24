package com.example.demo.controller;


import com.example.demo.domain.Inspector;
import com.example.demo.service.InspectorService;
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
public class InspectorController {


    private final InspectorService inspectorService;
    @Autowired
    public InspectorController(InspectorService inspectorService) {
        this.inspectorService = inspectorService;
    }

    @RequestMapping(value = "/inspectors", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Inspector> inspectors = inspectorService.getAll(0, Integer.MAX_VALUE);
        model.addAttribute("inspectors", inspectors);
        return "list8";
    }

    @RequestMapping(value = "/inspectors/add8", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("action8", "insert8");
        return "edit8";
    }

    @RequestMapping(value = "/inspectors/edit8", method = RequestMethod.GET)
    public String edit(@RequestParam(value="id") String id,
                       Model model) throws Exception {
        Inspector founded = inspectorService.findById(new Long(id));
        model.addAttribute("action8", "save8");
        model.addAttribute("inspector", founded);
        return "edit8";
    }

    @RequestMapping(value = "/inspectors/insert8", method = RequestMethod.POST)
    public String insert(@RequestParam(value="majord") String majord,
                         @RequestParam(value="minord") String minord,
                         @RequestParam(value="pdsize") String pdsize,
                         @RequestParam(value="pdtime") String pdtime,
                         @RequestParam(value="pdrate") String pdrate,
                         @RequestParam(value="estyield") String estyield,
                         Model model, HttpServletResponse  response) throws Exception {
        Inspector added = inspectorService.add(majord, minord, pdsize, pdtime, pdrate, estyield);
        model.addAttribute("inspector", added);
        model.addAttribute("action8", "insert8");
        response.setStatus(SC_CREATED );
        return "edited8";
    }

    @RequestMapping(value= "/inspectors/save8", method = RequestMethod.POST)
    public String save(@RequestParam("id") String id,
                       @RequestParam(value="majord") String majord,
                       @RequestParam(value="minord") String minord,
                       @RequestParam(value="pdsize") String pdsize,
                       @RequestParam(value="pdtime") String pdtime,
                       @RequestParam(value="pdrate") String pdrate,
                       @RequestParam(value="estyield") String estyield,
                       Model model, HttpServletResponse  response) throws Exception {
        Inspector inspector = inspectorService.findById(new Long(id));
        Inspector updated = inspectorService.update(inspector.getId(), majord, minord, pdsize, pdtime, pdrate, estyield);
        model.addAttribute("inspector", updated);
        model.addAttribute("action8", "save8");
        response.setStatus(SC_ACCEPTED );
        return "edited8";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", ex.getMessage());
        modelAndView.setStatus(HttpStatus.BAD_REQUEST);
        return modelAndView;
    }

}