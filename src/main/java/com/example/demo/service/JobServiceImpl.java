package com.example.demo.service;

import com.example.demo.domain.Job;
import com.example.demo.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.service.HandlerException.EMPTY_RESULT_BY_ID_ERROR_STRING;
import static com.example.demo.service.HandlerException.handlerException;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;


    @Override
    public Job add(String jobname, String jobdesc, String assignedworkerid, String priority, String duedate, String phaseid, String complete) throws Exception {
        Job job = new Job(jobname, jobdesc, assignedworkerid, priority, duedate, phaseid, complete);
        try {
            jobRepository.save(job);
        }
        catch (DataIntegrityViolationException exception){
            handlerException(exception, job.toString());
        }
        return job;
    }

    @Override
    public long getCount() {
        return jobRepository.count();
    }

    @Override
    public List<Job> getAll(int page, int amountByOnePage) {
        return jobRepository.findAll(PageRequest.of(page,amountByOnePage)).getContent();
    }

    @Override
    public Job findById(long id) {
        Job byId = jobRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Job.class.getSimpleName(), id)));
        return byId;
    }

    @Override
    public List<Job> find(String jobname, String jobdesc, String assignedworkerid, String priority, String duedate, String phaseid, String complete) throws Exception {
        List<Job> jobs = new ArrayList<>();
        try {
            jobRepository.findByJobnameOrJobdescOrAssignedworkeridOrPriorityOrDuedateOrPhaseidOrComplete(jobname, jobdesc, assignedworkerid,
                    priority, duedate, phaseid, complete).forEach(jobs::add);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Job.class.getSimpleName());
        }
        return jobs;
    }

    @Override
    public Job update(long id, String jobname, String jobdesc, String assignedworkerid, String priority, String duedate, String phaseid, String complete) throws Exception {
        Job job = jobRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Job.class.getSimpleName(), id)));
        if(jobname!= null)
            job.setJobname(jobname);
        if(jobdesc!= null)
            job.setJobdesc(jobdesc);
        if(assignedworkerid!= null)
            job.setAssignedworkerid(assignedworkerid);
        if(priority!= null)
            job.setPriority(priority);
        if(duedate!= null)
            job.setDuedate(duedate);
        if(phaseid!= null)
            job.setPhaseid(phaseid);
        if(complete!= null)
            job.setComplete(complete);
        try {
            jobRepository.save(job);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Job.class.getSimpleName());
        }
        return job;
    }

    @Override
    public void deleteAll() {
        jobRepository.deleteAll();
    }
}