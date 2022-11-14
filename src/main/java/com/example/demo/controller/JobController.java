//package com.example.demo.controller;
//
//import com.example.demo.domain.Defect;
//import com.example.demo.domain.Job;
//import com.example.demo.service.JobService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletResponse;
//import java.util.List;
//
//import static javax.servlet.http.HttpServletResponse.SC_ACCEPTED;
//import static javax.servlet.http.HttpServletResponse.SC_CREATED;
//
//public class JobController {
//    private final JobService jobService;
//    @Autowired
//    public JobController(JobService jobService) {
//
//        this.jobService = jobService;
//    }
//
////    @RequestMapping(value = "/jobs", method = RequestMethod.GET)
////    public String getAll(Model model) {
////        List<Job> jobs = jobService.getAll(0, Integer.MAX_VALUE);
////        model.addAttribute("job", jobs);
////        return "list8";
////    }
//
//    @RequestMapping(value = "/jobs/add6", method = RequestMethod.GET)
//    public String add(Model model) {
//        model.addAttribute("action6", "insert6");
//        return "edit6";
//    }
//
//    @RequestMapping(value = "/jobs/edit6", method = RequestMethod.GET)
//    public String edit(@RequestParam(value="id") String id,
//                       Model model) throws Exception {
//        Job founded = jobService.findById(new Long(id));
//        model.addAttribute("action6", "save6");
//        model.addAttribute("defect", founded);
//        return "edit6";
//    }
//
//    @RequestMapping(value = "/jobs/insert6", method = RequestMethod.POST)
//    public String insert(@RequestParam(value="jobid") String jobid,
//                         @RequestParam(value="jobName") String jobName,
//                         @RequestParam(value="jobDesc") String jobDesc,
//                         @RequestParam(value="assignedWorkerid") String assignedWorkerid,
//                         @RequestParam(value="priority") String priority,
//                         @RequestParam(value="dueDate") String dueDate,
//                         @RequestParam(value="phaseid") String phaseid,
//                         @RequestParam(value="complete") String complete,
//                         Model model, HttpServletResponse response) throws Exception {
//        Job added = jobService.add(jobid, jobName, jobDesc, assignedWorkerid, priority, dueDate, phaseid, complete);
//        model.addAttribute("job", added);
//        model.addAttribute("action6", "insert6");
//        response.setStatus(SC_CREATED);
//        return "edited6";
//    }
//
//    @RequestMapping(value= "/jobs/save6", method = RequestMethod.POST)
//    public String save(@RequestParam("id") String id,
//                       @RequestParam(value="jobid") String jobid,
//                       @RequestParam(value="jobName") String jobName,
//                       @RequestParam(value="jobDesc") String jobDesc,
//                       @RequestParam(value="assignedWorkerid") String assignedWorkerid,
//                       @RequestParam(value="priority") String priority,
//                       @RequestParam(value="dueDate") String dueDate,
//                       @RequestParam(value="phaseid") String phaseid,
//                       @RequestParam(value="complete") String complete,
//                       Model model, HttpServletResponse  response) throws Exception {
//        Job job = jobService.findById(new Long(id));
//        Job updated = jobService.update(job.getId(), jobid, jobName, jobDesc, assignedWorkerid, priority, dueDate, phaseid, complete);
//        model.addAttribute("job", updated);
//        model.addAttribute("action6", "save6");
//        response.setStatus(SC_ACCEPTED );
//        return "edited6";
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleException(Exception ex) {
//        ModelAndView modelAndView = new ModelAndView("error");
//        modelAndView.addObject("error", ex.getMessage());
//        modelAndView.setStatus(HttpStatus.BAD_REQUEST);
//        return modelAndView;
//    }
//}
