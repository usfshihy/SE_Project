package com.example.demo.controller;

import com.example.demo.domain.Project;
import com.example.demo.service.ProjectService;
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
public class ProjectController {
    private final ProjectService projectService;
    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @RequestMapping(value = "/projects", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Project> projects = projectService.getAll(0, Integer.MAX_VALUE);
        model.addAttribute("projects", projects);
        return "list5";
    }

    @RequestMapping(value = "/projects/add5", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("action5", "insert5");
        return "edit5";
    }

    @RequestMapping(value = "/projects/edit5", method = RequestMethod.GET)
    public String edit(@RequestParam(value="id") String id,
                       Model model) throws Exception {
        Project founded = projectService.findById(new Long(id));
        model.addAttribute("action5", "save5");
        model.addAttribute("project", founded);
        return "edit5";
    }

    @RequestMapping(value = "/projects/insert5", method = RequestMethod.POST)
    public String insert(@RequestParam(value="name") String name,
                         @RequestParam(value="desc")String desc,
                         @RequestParam(value="projectleaderid")String projectleaderid,
                         @RequestParam(value="category")String category,
                         @RequestParam(value="company")String company,
                         @RequestParam(value="branch")String branch,
                         @RequestParam(value="priority")String priority,
                         @RequestParam(value="processtype")String processtype,
                         @RequestParam(value="duebydate")String duebydate,
                         @RequestParam(value="iscomplete")String iscomplete,
                         Model model, HttpServletResponse response) throws Exception {
        Project added = projectService.add(name, desc,  projectleaderid, category,
                company,branch,  priority, processtype,
                duebydate, iscomplete);
        model.addAttribute("project", added);
        model.addAttribute("action5", "insert5");
        response.setStatus(SC_CREATED );
        return "edited5";
    }

    @RequestMapping(value= "/projects/save5", method = RequestMethod.POST)
    public String save(@RequestParam("id") String id,
                       @RequestParam(value="name") String name,
                       @RequestParam(value="desc")String desc,
                       @RequestParam(value="projectleaderid")String projectleaderid,
                       @RequestParam(value="category")String category,
                       @RequestParam(value="company")String company,
                       @RequestParam(value="branch")String branch,
                       @RequestParam(value="priority")String priority,
                       @RequestParam(value="processtype")String processtype,
                       @RequestParam(value="duebydate")String duebydate,
                       @RequestParam(value="iscomplete")String iscomplete,
                       Model model, HttpServletResponse  response) throws Exception {
        Project project = projectService.findById(new Long(id));
        Project updated = projectService.update(project.getId(), name, desc,  projectleaderid, category,
                company,branch,  priority, processtype,
                duebydate, iscomplete);
        model.addAttribute("project", updated);
        model.addAttribute("action5", "save5");
        response.setStatus(SC_ACCEPTED );
        return "edited5";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("error", ex.getMessage());
        modelAndView.setStatus(HttpStatus.BAD_REQUEST);
        return modelAndView;
    }
}